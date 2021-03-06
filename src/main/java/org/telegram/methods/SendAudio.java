package org.telegram.methods;

import org.telegram.api.ReplyKeyboard;

/**
 * @author Ruben Bermudez
 * @version 1.0
 * @brief Use this method to send audio files,
 * if you want Telegram clients to display the file as a playable voice message.
 * For this to work, your audio must be in an .ogg file encoded with OPUS
 * (other formats may be sent as Document). On success, the sent Message is returned.
 * @date 20 of June of 2015
 */
public class SendAudio {
    public static final String PATH = "sendaudio";

    public static final String CHATID_FIELD = "chat_id";
    private Integer chatId; ///< Unique identifier for the message recepient — User or GroupChat id
    public static final String AUDIO_FIELD = "audio";
    private String audio; ///< Audio file to send. file_id as String to resend an audio that is already on the Telegram servers
    public static final String REPLYTOMESSAGEID_FIELD = "reply_to_message_id";
    private Integer replayToMessageId; ///< Optional. If the message is a reply, ID of the original message
    public static final String REPLYMARKUP_FIELD = "reply_markup";
    private ReplyKeyboard replayMarkup; ///< Optional. JSON-serialized object for a custom reply keyboard

    public SendAudio() {
        super();
    }
}
