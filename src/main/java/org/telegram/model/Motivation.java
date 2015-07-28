package org.telegram.model;

import java.util.ArrayList;

/**
 * Created by Mart-Jan on 2015-07-15.
 */
public class Motivation {
    public Motivation() {
    }

    public Motivation(String userID, String userNicename, String action){
        this.userID = userID;
        this.userNicename = userNicename;
        this.action = action;
        this.messageCount = 0;
    }

    public String userID;
    public String userNicename;
    public String action;
    public static Integer messageCount;

    public String getAction() {
        return action;
    }

    public static Integer getMessageCount() {
        return messageCount;
    }

    public static void updateMessageCount() {
        messageCount = messageCount+1;
    }

    public void addToList(){
        MotivateList.getInstance().add(this);
    }

    public static ArrayList<Motivation> getByName(String userid){
        // foreach motivation in list
//        if motivation.name == paramname
        // return new list of motivation from person!
        ArrayList<Motivation> MotivationList = MotivateList.getInstance();
        ArrayList<Motivation> MotivationListByUser = new ArrayList<Motivation>();
        for(Motivation object: MotivationList){
            if(object.userID.equals(userid)){
                MotivationListByUser.add(object);
            }

        }

        return MotivationListByUser;
    }

}
