package com.sjmulhern.dndTracker.creatures;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sjmulhern.dndTracker.tools.Ability;
import com.sjmulhern.dndTracker.tools.DamageType;
import com.sjmulhern.dndTracker.tools.Tool;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Monster extends Creature {

    private Type type = Type.None;

    private ArrayList<DamageType> resistances = new ArrayList<>();

    private ArrayList<DamageType> weaknesses = new ArrayList<>();

    private ArrayList<DamageType> immunities = new ArrayList<>();

    private double challenge = 0;

    public Monster (String name, String description,
        Alignment alignment, Size size, int movementSpeed, int swimSpeed,
        int climbSpeed,
        int flySpeed,
        ArrayList<Ability> abilities,
        ArrayList<Tool> tools,
        ArrayList<Skill> skills,
        ArrayList<Language> languages, int strength, int dexterity, int constitution,
        int intelligence, int wisdom, int charisma, int hitPoints, int armorClass,
        int initiative, Double level, Condition currentCondition) {

        super(name, description, alignment, size, movementSpeed, swimSpeed,
              climbSpeed,
              flySpeed, abilities, tools, skills, languages, strength, dexterity,
              constitution, intelligence, wisdom, charisma, hitPoints, armorClass,
              initiative, level, currentCondition);
    }

    @Override
    public JsonObject toJson () {

        JsonObject jsonObject = super.toJson();

        jsonObject.addProperty("type", getType().getOrdinal());

        JsonArray resistancesArray = new JsonArray();
        for (DamageType damType: getResistances()) {
            resistancesArray.add(damType.getOrdinal());
        }
        jsonObject.add("resistances", resistancesArray);

        JsonArray weaknessesArray = new JsonArray();
        for (DamageType damType: getWeaknesses()) {
            weaknessesArray.add(damType.getOrdinal());
        }
        jsonObject.add("weaknesses", weaknessesArray);

        JsonArray immunitiesArray = new JsonArray();
        for (DamageType damType: getImmunities()) {
            immunitiesArray.add(damType.getOrdinal());
        }
        jsonObject.add("immunities", immunitiesArray);

        jsonObject.addProperty("challenge", getChallenge());


        return jsonObject;
    }

}
