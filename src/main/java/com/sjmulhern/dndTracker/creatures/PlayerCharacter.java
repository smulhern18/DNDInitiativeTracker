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
        String description,
        Alignment alignment,
        Size size,
        int movementSpeed,
        int swimSpeed,
        int climbSpeed,
        int flySpeed,
        ArrayList<Ability> abilities,
        ArrayList<Tool> tools,
        ArrayList<Skill> skills,
        ArrayList<Language> languages,
        int strength,
        int dexterity,
        int constitution,
        int intelligence,
        int wisdom,
        int charisma,
        int hitPoints,
        int armorClass,
        int initiative,
        Condition currentCondition) {

        super(name, description, alignment, size, movementSpeed, swimSpeed,
              climbSpeed,
              flySpeed, abilities, tools, skills, languages, strength, dexterity,
              constitution, intelligence, wisdom, charisma, hitPoints, armorClass,
              initiative, currentCondition);
    }

    @Override
    public JsonObject toJson () {
        return super.toJson();
    }
}
