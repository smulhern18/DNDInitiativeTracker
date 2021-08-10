package com.sjmulhern.dndTracker.creatures;

import com.google.gson.JsonObject;
import com.sjmulhern.dndTracker.tools.Ability;
import com.sjmulhern.dndTracker.tools.DamageType;
import com.sjmulhern.dndTracker.tools.Tool;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Monster extends NonPlayerCharacter {

    private Type type = Type.None;

    public Monster(
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
            Type type,
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
                spells,
                resistances,
                weaknesses,
                immunities);

        setType(type);
    }

    @Override
    public JsonObject toJson() {

        JsonObject jsonObject = super.toJson();

        jsonObject.addProperty("type", getType().getOrdinal());

        return jsonObject;
    }
}
