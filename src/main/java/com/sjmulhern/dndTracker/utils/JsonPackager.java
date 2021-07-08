package com.sjmulhern.dndTracker.utils;

import com.google.gson.JsonArray;
import com.sjmulhern.dndTracker.creatures.Creature;

import java.util.ArrayList;

public class JsonPackager {

    public static JsonArray packageUp(ArrayList<Creature> creatures) {
        JsonArray jsonArray = new JsonArray();
        for (Creature creature: creatures) {
            jsonArray.add(creature.toJson());
        }
        return jsonArray;
    }

    public static ArrayList<Creature> unpackage(JsonArray jsonArray) {
        return null;
    }
}
