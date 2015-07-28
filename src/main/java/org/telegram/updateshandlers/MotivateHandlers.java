package org.telegram.updateshandlers;

import org.telegram.model.MotivateList;
import org.telegram.model.Motivation;
import org.telegram.*;
import org.telegram.api.Message;
import org.telegram.api.Update;
import org.telegram.methods.SendMessage;
import org.telegram.updatesreceivers.UpdatesThread;
import org.telegram.updatesreceivers.Webhook;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Created by Mart-Jan on 2015-07-15.
 */
public class MotivateHandlers implements UpdatesCallback {

    private static final String TOKEN = BotConfig.TOKENMOTIVATE;

    private Webhook webhook;
    private UpdatesThread updatesThread;

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

    public MotivateHandlers(){

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


            String outputmessage = "Motivate Bot is broken"; //this should be overwritten ofcourse

            String userID;
            String userNicename;
            String action;
            String userName = "";

            userID = ""+message.getFrom().getId();
            userNicename = message.getFrom().getFirstName() + " " + message.getFrom().getLastName();
            if(!message.getFrom().getUserName().isEmpty()){
                userName = message.getFrom().getUserName();
            }

            if(text.contains(" ")) {
                String[] parts = text.split(" ", 2);
                action = parts[1];

                if (parts[0].startsWith(Commands.motivate)) {

                    Motivation m = new Motivation(userID, userNicename, action);
                    MotivateList.getInstance().add(m);
                    m = new Motivation();
                    for (Motivation object : MotivateList.getInstance()) {
                        System.out.println("all messagecount: "+object.getMessageCount());
                        System.out.println("all action: "+object.action);
                    }

                    for (Motivation object : Motivation.getByName(userID)) {
                        System.out.println("messagecount: "+object.getMessageCount());
                        System.out.println("action: "+object.action);
                    }

                    outputmessage = "Motivation \"" + parts[1] + "\" added to list";

                } else if (parts[0].startsWith(Commands.help) ||
                        (message.getText().startsWith(Commands.startCommand))) {
                    outputmessage = CustomMessages.helpMotivate;

                }
            }
            ArrayList<Motivation> m = Motivation.getByName(userID);
            Random random = new Random();


            if(!m.isEmpty()){


                int indexMotivation = random.nextInt(m.size());

               Motivation.updateMessageCount();

                final String[] Motivate_Strings = {
                        "Hey " + userNicename + ", you told me you should do \""+m.get(indexMotivation).getAction() +"\"",
                        "@"+userName + " go do something!",
                        "Come on " + userNicename + ", go do your work! Right now!"
                };

                int indexString = random.nextInt(Motivate_Strings.length);


                if(Motivation.getMessageCount() > 5 && Motivation.getMessageCount() % 5 == 0){
                    outputmessage = Motivate_Strings[indexString];
                }
            }

            if(!outputmessage.equals("Motivate Bot is broken")) {
                SendMessage sendMessageRequest = new SendMessage();
                sendMessageRequest.setText(outputmessage);
                sendMessageRequest.setChatId(message.getChatId());
                SenderHelper.SendMessage(sendMessageRequest, TOKEN);
            }
        }
    }

}
