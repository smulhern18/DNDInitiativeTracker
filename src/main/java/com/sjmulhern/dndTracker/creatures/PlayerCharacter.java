package com.sjmulhern.dndTracker.creatures;

import com.google.gson.JsonObject;
import java.util.ArrayList;

public class PlayerCharacter extends Creature {

    public PlayerCharacter(
            String name, int armorClass, int initiative, Double level, Condition currentCondition) {

        super(
                name,
                null,
                Alignment.Unaligned,
                Size.Medium,
                30,
                15,
                15,
                0,
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>(),
                10,
                10,
                10,
                10,
                10,
                10,
                -1,
                armorClass,
                initiative,
                level,
                currentCondition,
                null);
    }

    public PlayerCharacter(JsonObject jsonObject) {
        this(
                jsonObject.get("name").getAsString(),
                jsonObject.get("armorClass").getAsInt(),
                jsonObject.get("initative").getAsInt(),
                jsonObject.get("level").getAsDouble(),
                Condition.getEnum(jsonObject.get("currentCondition").getAsInt()));
    }

    @Override
    public JsonObject toJson() {
        return super.toJson();
    }
}
