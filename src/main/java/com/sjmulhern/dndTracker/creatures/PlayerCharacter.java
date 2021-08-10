package com.sjmulhern.dndTracker.creatures;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sjmulhern.dndTracker.tools.Ability;
import com.sjmulhern.dndTracker.tools.DamageType;
import com.sjmulhern.dndTracker.tools.Tool;
import lombok.AllArgsConstructor;

import java.util.ArrayList;

public class PlayerCharacter extends Creature {

    public PlayerCharacter (String name,
        int armorClass,
        int initiative,
        Double level,
        Condition currentCondition) {

        super(name, null, Alignment.Unaligned, Size.Medium, null, null,
              null,
              null, null, null, null, null, null, null,
              null, null, null, null, 10, armorClass,
              initiative, level, currentCondition, null);
    }

    @Override
    public JsonObject toJson () {
        return super.toJson();
    }
}
