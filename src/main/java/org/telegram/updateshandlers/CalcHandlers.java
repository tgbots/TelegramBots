package org.telegram.updateshandlers;

import org.telegram.*;
import org.telegram.api.Message;
import org.telegram.api.Update;
import org.telegram.methods.SendMessage;
import org.telegram.services.BotLogger;
import org.telegram.updatesreceivers.UpdatesThread;
import org.telegram.updatesreceivers.Webhook;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Mart-Jan on 2015-06-25.
 */
public class CalcHandlers implements UpdatesCallback{
    private static volatile BotLogger log = BotLogger.getLogger(WeatherHandlers.class.getName());

    private static final String TOKEN = BotConfig.TOKENCALC;

    private Webhook webhook;
    private UpdatesThread updatesThread;

    //private final Webhook webhook;
    //private final UpdatesThread updatesThread;
    private ConcurrentHashMap<Integer, Integer> listOfSentMessages = new ConcurrentHashMap<>();

    private static final int webhookPort = 9990;

    @Override
    public void onUpdateReceived(Update update) {
        anotherClass(update);
    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        for (Update update: updates) {
            anotherClass(update);
        }
    }

    public CalcHandlers(){

        if (BuildVars.useWebHook) {
            webhook = new Webhook(this, webhookPort);
            updatesThread = null;
            SenderHelper.SendWebhook(webhook.getURL(), TOKEN);
        } else {
            webhook = null;
            SenderHelper.SendWebhook("", TOKEN);
            updatesThread = new UpdatesThread(TOKEN, this);
        }
    }

    public void anotherClass(Update update){
        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            String text = message.getText();
            String[] parts = text.split(" ");
            if (parts[0].startsWith(Commands.sum)) {

                double imput;
                double output = 0;
                boolean error = false;
                String outputmessage;

                if(parts.length > 1){

                    for(int i = 1; i < parts.length; i++){
                        try {
                            imput = Double.parseDouble(parts[i]);
                            output += imput;
                        } catch (Exception e) {
                            System.out.println("Failed to parse to int " + e.getMessage());
                            error = true;
                        }
                    }
                    if (error){
                        outputmessage = "Sorry, I was not able to handle your request.\n" +
                                "Available characters: (0-9).\n" +
                                "Also negative numbers are supported.";
                    }else {
                        outputmessage = "Result: " + output;
                }
                }else{
                    outputmessage = "Please enter at least one number.";
                }

                    SendMessage sendMessageRequest = new SendMessage();
                    sendMessageRequest.setText(outputmessage);
                    sendMessageRequest.setChatId(message.getChatId());
                    SenderHelper.SendMessage(sendMessageRequest, TOKEN);

            }else if (parts[0].startsWith(Commands.help) ||
                    (message.getText().startsWith(Commands.startCommand) || !message.isGroupMessage())) {
                SendMessage sendMessageRequest = new SendMessage();
                sendMessageRequest.setText(CustomMessages.helpCalc);
                sendMessageRequest.setChatId(message.getChatId());
                SenderHelper.SendMessage(sendMessageRequest, TOKEN);
            }
        }
    }

}
