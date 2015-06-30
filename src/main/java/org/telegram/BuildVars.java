package org.telegram;

/**
 * @author Ruben Bermudez
 * @version 1.0
 * @brief Custom build vars FILL EVERYTHING CORRECTLY
 * @date 20 of June of 2015
 */
public class BuildVars {
    public static final Boolean debug = true;
    public static final Boolean useWebHook = false;
    public static final String BASEWEBHOOKURL = "http://YOUREXTERNALADDRES";
    public static final String INTERNALWEBHOOKURL = "http://localhost";

    public static final String OPENWEATHERAPIKEY = "<your-api-key>";

    public static final String DirectionsApiKey = "<your-api-key>";

    public static final String TRANSIFEXUSER = "<transifex-user>";
    public static final String TRANSIFEXPASSWORD = "<transifex-password>";

    public static final String pathToLogs = "./";

    public static final String linkDB = "jdbc:mysql://<your-host>:3306/<your-database-name>?useUnicode=true&characterEncoding=UTF-8";
    public static final String controllerDB = "com.mysql.jdbc.Driver";
    public static final String userDB = "<your-username>";
    public static final String password = "<your-password>";
}
