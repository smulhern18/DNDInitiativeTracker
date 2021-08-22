package com.sjmulhern.dndTracker.creatures;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sjmulhern.dndTracker.tools.Ability;
import com.sjmulhern.dndTracker.tools.Tool;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Creature implements Comparable<Creature>{

    private String name;

    private String description;

    private Alignment alignment;

    private Size size;

    private Integer movementSpeed;

    private Integer swimSpeed;

    private Integer climbSpeed;

    private Integer flySpeed;

    private ArrayList<Ability> abilities;

    private ArrayList<Tool> tools;

    private ArrayList<Skill> skills;

    private ArrayList<Language> languages;

    private Integer strength;

    private Integer dexterity;

    private Integer constitution;

    private Integer intelligence;

    private Integer wisdom;

    private Integer charisma;

    private Integer hitPoints;

    private Integer armorClass;

    private Integer initiative;

    private Double level;

    private Condition currentCondition;

    private Spells spells;

    public Creature(JsonObject jsonObject) {
        this(
                jsonObject.get("name").getAsString(),
                jsonObject.get("description").getAsString(),
                Alignment.getEnum(jsonObject.get("alignment").getAsString()),
                Size.getEnum(jsonObject.get("size").getAsDouble()),
                jsonObject.get("movementSpeed").getAsInt(),
                jsonObject.get("swimSpeed").getAsInt(),
                jsonObject.get("climbSpeed").getAsInt(),
                jsonObject.get("flySpeed").getAsInt(),
                null,
                null,
                null,
                null,
                jsonObject.get("strength").getAsInt(),
                jsonObject.get("dexterity").getAsInt(),
                jsonObject.get("constitution").getAsInt(),
                jsonObject.get("intelligence").getAsInt(),
                jsonObject.get("wisdom").getAsInt(),
                jsonObject.get("charisma").getAsInt(),
                jsonObject.get("hitPoints").getAsInt(),
                jsonObject.get("armorClass").getAsInt(),
                jsonObject.get("initiative").getAsInt(),
                jsonObject.get("level").getAsDouble(),
                Condition.getEnum(jsonObject.get("currentCondition").getAsInt()),
                null);

        // Abilities
        ArrayList<Ability> abilities = new ArrayList<>();
        if (!jsonObject.getAsJsonArray("abilities").isJsonNull()) {
            jsonObject
                    .getAsJsonArray("abilities")
                    .forEach(element -> abilities.add(new Ability((JsonObject) element)));
        }
        setAbilities(abilities);

        // Tools
        ArrayList<Tool> tools = new ArrayList<>();
        if (!jsonObject.getAsJsonArray("tools").isJsonNull()) {
            jsonObject
                    .getAsJsonArray("tools")
                    .forEach(element -> tools.add(new Tool((JsonObject) element)));
        }
        setTools(tools);

        // Skills
        ArrayList<Skill> skills = new ArrayList<>();
        if (!jsonObject.getAsJsonArray("skills").isJsonNull()) {
            jsonObject
                    .getAsJsonArray("skills")
                    .forEach(element -> skills.add(Skill.getEnum(element.getAsInt())));
        }
        setSkills(skills);

        // Languages
        ArrayList<Language> languages = new ArrayList<>();
        if (!jsonObject.getAsJsonArray("languages").isJsonNull()) {
            jsonObject
                    .getAsJsonArray("languages")
                    .forEach(element -> languages.add(Language.getEnum(element.getAsInt())));
        }
        setLanguages(languages);

        JsonElement spellsJson = jsonObject.get("spells");

        if (!spellsJson.isJsonNull()) {
            setSpells(new Spells((JsonObject) spellsJson));
        }
    }

    public JsonObject toJson() {
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
        for (Ability ability : getAbilities()) {
            abilitiesArray.add(ability.toJson());
        }
        jsonObject.add("abilities", abilitiesArray);

        JsonArray toolsArray = new JsonArray();
        for (Tool tool : getTools()) {
            toolsArray.add(tool.toJson());
        }
        jsonObject.add("tools", toolsArray);

        JsonArray skillsArray = new JsonArray();
        for (Skill skill : getSkills()) {
            skillsArray.add(skill.getOrdinal());
        }
        jsonObject.add("skills", skillsArray);

        JsonArray languagesArray = new JsonArray();
        for (Language language : getLanguages()) {
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

        if (spells == null) {
            spells = new Spells();
        }

        jsonObject.add("spells", getSpells().toJson());

        return jsonObject;
    }

    @Override
    public boolean equals(Object creatureObject) {
        if (creatureObject instanceof Creature) {
            return this.getName().equals(((Creature) creatureObject).getName());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public int compareTo(Creature creature) {
        return this.getInitiative().compareTo(creature.getInitiative());
    }
}
