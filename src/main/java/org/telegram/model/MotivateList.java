package org.telegram.model;

import java.util.ArrayList;

/**
 * Created by Jeroen on 2015-07-15.
 */
public class MotivateList extends ArrayList<Motivation>{
    private static MotivateList instance = null;

    public static MotivateList getInstance() {
        if(instance == null) {
            instance = new MotivateList();
        }
        return instance;
    }
}
