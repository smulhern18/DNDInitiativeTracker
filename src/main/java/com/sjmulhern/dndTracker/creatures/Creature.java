package com.sjmulhern.dndTracker.creatures;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sjmulhern.dndTracker.tools.Ability;
import com.sjmulhern.dndTracker.tools.Tool;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
public class Creature {

    private String name = null;

    private String description = null;

    private Alignment alignment = Alignment.Unaligned;

    private Size size = Size.Medium;

    private int movementSpeed = 30;

    private int swimSpeed = 15;

    private int climbSpeed = 15;

    private int flySpeed = 0;

    private ArrayList<Ability> abilities = new ArrayList<>();

    private ArrayList<Tool> tools = new ArrayList<>();

    private ArrayList<Skill> skills = new ArrayList<>();

    private ArrayList<Language> languages = new ArrayList<>();

    private Integer strength = 0;

    private Integer dexterity = 0;

    private Integer constitution = 0;

    private Integer intelligence = 0;

    private Integer wisdom = 0;

    private Integer charisma = 0;

    private int hitPoints = 0;

    private int armorClass = 0;

    private int initiative = 0;

    private Double level = 0.0;

    private Condition currentCondition = Condition.None;

    private Spells spells = null;

    public JsonObject toJson () {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", getName());
        jsonObject.addProperty("description", getDescription());
        jsonObject.addProperty("alignment", getAlignment().getAbbreviation());
        jsonObject.addProperty("size", getSize().doubleValue());
        jsonObject.addProperty("movementSpeed", getMovementSpeed());
        jsonObject.addProperty("swimSpeed", getSwimSpeed());
        jsonObject.addProperty("climbSpeed", getClimbSpeed());
        jsonObject.addProperty("flySpeed", getFlySpeed());
        jsonObject.addProperty("level", getLevel());

        JsonArray abilitiesArray = new JsonArray();
        for (Ability ability: getAbilities()) {
            abilitiesArray.add(ability.toJson());
        }
        jsonObject.add("abilities", abilitiesArray);

        JsonArray toolsArray = new JsonArray();
        for (Tool tool: getTools()) {
            toolsArray.add(tool.toJson());
        }
        jsonObject.add("tools", toolsArray);

        JsonArray skillsArray = new JsonArray();
        for (Skill skill: getSkills()) {
            skillsArray.add(skill.getOrdinal());
        }
        jsonObject.add("skills", skillsArray);

        JsonArray languagesArray = new JsonArray();
        for (Language language: getLanguages()) {
            languagesArray.add(language.getOrdinal());
        }
        jsonObject.add("languages", languagesArray);

        jsonObject.addProperty("strength", getStrength());
        jsonObject.addProperty("dexterity", getDexterity());
        jsonObject.addProperty("constitution", getConstitution());
        jsonObject.addProperty("intelligence", getIntelligence());
        jsonObject.addProperty("wisdom", getWisdom());
        jsonObject.addProperty("charisma", getCharisma());
        jsonObject.addProperty("hitPoints", getHitPoints());
        jsonObject.addProperty("armorClass", getArmorClass());
        jsonObject.addProperty("initiative", getInitiative());
        jsonObject.addProperty("currentCondition", getCurrentCondition().getOrdinal());

        jsonObject.add("spells", getSpells().toJson());

        return jsonObject;
    }

    @Override
    public boolean equals(Object creatureObject) {

        if (creatureObject.getClass() == Creature.class) {
            Creature creature = (Creature) creatureObject;

            return creature.getName().equals(getName());
        }

        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

}
