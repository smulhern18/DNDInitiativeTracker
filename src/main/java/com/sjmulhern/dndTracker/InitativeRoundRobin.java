package com.sjmulhern.dndTracker;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sjmulhern.dndTracker.creatures.Creature;
import com.sjmulhern.dndTracker.creatures.Monster;
import com.sjmulhern.dndTracker.creatures.NonPlayerCharacter;
import com.sjmulhern.dndTracker.creatures.PlayerCharacter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitativeRoundRobin {

    private ArrayList<Creature> creatures = new ArrayList<>();

    private Set<String> creatureNames = new HashSet<>();

    private int currentIndex = 0;

    public InitativeRoundRobin() {}

    public InitativeRoundRobin(JsonObject jsonObject) {

        JsonArray creatureArray = jsonObject.getAsJsonArray("creatures");

        for (JsonElement jsonElement : creatureArray) {
            JsonObject creatureJson = (JsonObject) jsonElement;
            if (creatureJson.has("type")) {
                creatures.add(new Monster(creatureJson));
            } else if (creatureJson.has("resistances")) {
                creatures.add(new NonPlayerCharacter(creatureJson));
            } else {
                creatures.add(new PlayerCharacter(creatureJson));
            }

            creatureNames.add(creatureJson.get("name").getAsString());

            Collections.sort(creatures);
        }
    }

    public void addCreature(Creature creature) {
        creatureNames.add(creature.getName());
        creatures.remove(creature);
        creatures.add(creature);
    }

    public Creature getNext() {
        currentIndex++;

        Object[] creaturesArray = creatures.toArray();

        Creature creature = (Creature) creaturesArray[currentIndex % creatures.size()];

        while (creature.getHitPoints() == 0) {
            currentIndex++;
            creature = (Creature) creaturesArray[currentIndex % creatures.size()];
        }

        return creature;
    }

    public Creature getCurrent() {
        return (Creature) creatures.toArray()[currentIndex % creatures.size()];
    }

    public void setCurrentCreature(String name) {
        Object[] creatureObjects = creatures.toArray();

        currentIndex = 0;
        for (int i = 0; i < creatureObjects.length; i++) {
            if (name.equals(((Creature) creatureObjects[i]).getName())) {
                currentIndex = i;
                break;
            }
        }
    }

    public Creature getCreature(String name) {
        Creature creature;

        Object[] creatureObjects = creatures.toArray();

        currentIndex = 0;
        for (int i = 0; i < creatureObjects.length; i++) {
            if (name.equals(((Creature) creatureObjects[i]).getName())) {
                currentIndex = i;
                break;
            }
        }

        creature = getCurrent();

        return creature;
    }

    public void recalculateInitative() {
        creatures.forEach(
                creature -> {
                    if (!(creature instanceof PlayerCharacter)) {
                        creature.setInitiative(Utilities.rollD20((creature.getDexterity() - 10) / 2));
                    }
                });
        creatures.sort(Collections.reverseOrder());
        setCurrentIndex(0);
    }

    public JsonObject toJson() {
        JsonObject jsonObject = new JsonObject();

        JsonArray jsonArray = new JsonArray();
        for (Creature creature : creatures) {
            jsonArray.add(creature.toJson());
        }
        jsonObject.add("creatures", jsonArray);

        return jsonObject;
    }
}
