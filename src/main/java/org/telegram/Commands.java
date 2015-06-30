package org.telegram;

/**
 * @author Ruben Bermudez
 * @version 1.0
 * @brief Command for the bots
 * @date 20 of June of 2015
 */
public class Commands {
    public static final String commandInitChar = "/";

    /// Weather forecast command
    public static final String WEATHERCOMMAND = commandInitChar + "weather";
    /// Current wether command
    public static final String CURRENTWEATHERCOMMAND = commandInitChar + "current";

    /// Transifex iOS command
    public static final String transifexiOSCommand = commandInitChar + "langios";
    /// Transifex android command
    public static final String transifexAndroidCommand = commandInitChar + "langdroid";
    /// Transifex android command
    public static final String transifexTDesktop = commandInitChar + "langdesk";
    /// Transifex android command
    public static final String transifexWebogram = commandInitChar + "langweb";
    /// Transifex android command
    public static final String transifexWP = commandInitChar + "langwp";
    /// Transifex android command
    public static final String transifexOSX = commandInitChar + "langosx";
    /// Transifex android support command
    public static final String transifexAndroidSupportCommand = commandInitChar + "langtestdroid";

    /// Help command
    public static final String help = commandInitChar + "help";

    /// Upload command
    public static final String uploadCommand = commandInitChar + "upload";
    /// Start command
    public static final String startCommand = commandInitChar + "start";
    /// Cancel command
    public static final String cancelCommand = commandInitChar + "cancel";
    /// Delete command
    public static final String deleteCommand = commandInitChar + "delete";
    /// List command
    public static final String listCommand = commandInitChar + "list";

    /// Start directions command
    public static final String startDirectionCommand = commandInitChar + "directions";

    /// Sum all of the
    public static final String sum = commandInitChar + "sum";
    /// Start directions command
    public static final String delimiter = commandInitChar + "delimiter";


}
