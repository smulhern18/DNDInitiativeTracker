package com.sjmulhern.dndTracker.creatures;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sjmulhern.dndTracker.tools.Ability;
import com.sjmulhern.dndTracker.tools.DamageType;
import com.sjmulhern.dndTracker.tools.Tool;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NonPlayerCharacter extends Creature {

    private ArrayList<DamageType> resistances = new ArrayList<>();

    private ArrayList<DamageType> weaknesses = new ArrayList<>();

    private ArrayList<DamageType> immunities = new ArrayList<>();

    public NonPlayerCharacter(
            String name,
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
            Double level,
            Condition currentCondition,
            Spells spells,
            ArrayList<DamageType> resistances,
            ArrayList<DamageType> weaknesses,
            ArrayList<DamageType> immunities) {

        super(
                name,
                description,
                alignment,
                size,
                movementSpeed,
                swimSpeed,
                climbSpeed,
                flySpeed,
                abilities,
                tools,
                skills,
                languages,
                strength,
                dexterity,
                constitution,
                intelligence,
                wisdom,
                charisma,
                hitPoints,
                armorClass,
                initiative,
                level,
                currentCondition,
                spells);

        setResistances(resistances);
        setWeaknesses(weaknesses);
        setImmunities(immunities);
    }

    public NonPlayerCharacter(JsonObject jsonObject) {
        super(jsonObject);

        // Resistances
        ArrayList<DamageType> resistances = new ArrayList<>();
        if (!jsonObject.getAsJsonArray("resistances").isJsonNull()) {
            jsonObject
                    .getAsJsonArray("resistances")
                    .forEach(element -> resistances.add(DamageType.getEnum(element.getAsInt())));
        }
        setResistances(resistances);

        // Weaknesses
        ArrayList<DamageType> weaknesses = new ArrayList<>();
        if (!jsonObject.getAsJsonArray("weaknesses").isJsonNull()) {
            jsonObject
                    .getAsJsonArray("weaknesses")
                    .forEach(element -> weaknesses.add(DamageType.getEnum(element.getAsInt())));
        }
        setWeaknesses(weaknesses);

        // Immunities
        ArrayList<DamageType> immunities = new ArrayList<>();
        if (!jsonObject.getAsJsonArray("immunities").isJsonNull()) {
            jsonObject
                    .getAsJsonArray("immunities")
                    .forEach(element -> immunities.add(DamageType.getEnum(element.getAsInt())));
        }
        setImmunities(immunities);
    }

    @Override
    public JsonObject toJson() {

        JsonObject jsonObject = super.toJson();

        JsonArray resistancesArray = new JsonArray();
        for (DamageType damType : getResistances()) {
            resistancesArray.add(damType.getOrdinal());
        }
        jsonObject.add("resistances", resistancesArray);

        JsonArray weaknessesArray = new JsonArray();
        for (DamageType damType : getWeaknesses()) {
            weaknessesArray.add(damType.getOrdinal());
        }
        jsonObject.add("weaknesses", weaknessesArray);

        JsonArray immunitiesArray = new JsonArray();
        for (DamageType damType : getImmunities()) {
            immunitiesArray.add(damType.getOrdinal());
        }
        jsonObject.add("immunities", immunitiesArray);

        return jsonObject;
    }
}
