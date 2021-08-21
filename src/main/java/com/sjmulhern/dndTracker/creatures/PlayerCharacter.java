package com.sjmulhern.dndTracker.creatures;

import com.google.gson.JsonObject;

public class PlayerCharacter extends Creature {

    public PlayerCharacter(
            String name, int armorClass, int initiative, Double level, Condition currentCondition) {

        super(
                name,
                null,
                Alignment.Unaligned,
                Size.Medium,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                -1,
                armorClass,
                initiative,
                level,
                currentCondition,
                null);
    }

    public PlayerCharacter(JsonObject jsonObject) {
        this(
                jsonObject.get("name").toString(),
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
