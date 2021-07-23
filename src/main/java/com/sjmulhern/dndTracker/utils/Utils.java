package com.sjmulhern.dndTracker.utils;

import java.util.ArrayList;
import java.util.Arrays;

public class Utils {

    public static ArrayList<String> separateIntoArray(String commaString) {
        ArrayList<String> stringArray = null;

        if (commaString != null) {
            stringArray = new ArrayList<>(Arrays.asList(commaString.split(", ")));
        }

        return stringArray;
    }

    public static String combineIntoString(ArrayList<String> stringArray) {
        String endString = "";

        for (String string: stringArray) {
            endString += (string + ", ");
        }

        return endString;
    }
}
