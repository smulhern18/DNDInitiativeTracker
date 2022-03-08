package com.sjmulhern.dndTracker.creatures;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sjmulhern.dndTracker.tools.Spell;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Spells {

    public Spells() {}

    ArrayList<Spell> cantrips;
    ArrayList<Spell> firstLevel;
    ArrayList<Spell> secondLevel;
    ArrayList<Spell> thirdLevel;
    ArrayList<Spell> forthLevel;
    ArrayList<Spell> fifthLevel;
    ArrayList<Spell> sixthLevel;
    ArrayList<Spell> seventhLevel;
    ArrayList<Spell> eighthLevel;
    ArrayList<Spell> ninthLevel;

    ArrayList<Integer> slots;
    ArrayList<Integer> slotsUsed;

    public ArrayList<Spell> getLevelSpells(int level) {
        return switch (level) {
            case 0 -> cantrips;
            case 1 -> firstLevel;
            case 2 -> secondLevel;
            case 3 -> thirdLevel;
            case 4 -> forthLevel;
            case 5 -> fifthLevel;
            case 6 -> sixthLevel;
            case 7 -> seventhLevel;
            case 8 -> eighthLevel;
            case 9 -> ninthLevel;
            default -> null;
        };
    }

    public int[] getSpinnerLevels(int level) {
        if (1 <= level && level <= 9) {
            return new int[] {slots.get(level), slotsUsed.get(level)};
        } else {
            return null;
        }
    }

    public Spells(JsonObject jsonObject) {

        // Cantrips
        ArrayList<Spell> cantrips = new ArrayList<>();
        if (!(jsonObject.getAsJsonArray("cantrips") == null)) {
            jsonObject
                    .getAsJsonArray("cantrips")
                    .forEach(element -> cantrips.add(new Spell((JsonObject) element)));
        }
        setCantrips(cantrips);

        // FirstLevel
        ArrayList<Spell> firstLevel = new ArrayList<>();
        if (!(jsonObject.getAsJsonArray("firstLevel") == null)) {
            jsonObject
                    .getAsJsonArray("firstLevel")
                    .forEach(element -> firstLevel.add(new Spell((JsonObject) element)));
        }
        setFirstLevel(firstLevel);

        // SecondLevel
        ArrayList<Spell> secondLevel = new ArrayList<>();
        if (!(jsonObject.getAsJsonArray("secondLevel") == null)) {
            jsonObject
                    .getAsJsonArray("secondLevel")
                    .forEach(element -> secondLevel.add(new Spell((JsonObject) element)));
        }
        setSecondLevel(secondLevel);

        // ThirdLevel
        ArrayList<Spell> thirdLevel = new ArrayList<>();
        if (!(jsonObject.getAsJsonArray("thirdLevel") == null)) {
            jsonObject
                    .getAsJsonArray("thirdLevel")
                    .forEach(element -> thirdLevel.add(new Spell((JsonObject) element)));
        }
        setThirdLevel(thirdLevel);

        // ForthLevel
        ArrayList<Spell> forthLevel = new ArrayList<>();
        if (!(jsonObject.getAsJsonArray("forthLevel") == null)) {
            jsonObject
                    .getAsJsonArray("forthLevel")
                    .forEach(element -> forthLevel.add(new Spell((JsonObject) element)));
        }
        setForthLevel(forthLevel);

        // FifthLevel
        ArrayList<Spell> fifthLevel = new ArrayList<>();
        if (!(jsonObject.getAsJsonArray("fifthLevel") == null)) {
            jsonObject
                    .getAsJsonArray("fifthLevel")
                    .forEach(element -> fifthLevel.add(new Spell((JsonObject) element)));
        }
        setFifthLevel(fifthLevel);

        // SixthLevel
        ArrayList<Spell> sixthLevel = new ArrayList<>();
        if (!(jsonObject.getAsJsonArray("sixthLevel") == null)) {
            jsonObject
                    .getAsJsonArray("sixthLevel")
                    .forEach(element -> sixthLevel.add(new Spell((JsonObject) element)));
        }
        setSixthLevel(sixthLevel);

        // SeventhLevel
        ArrayList<Spell> seventhLevel = new ArrayList<>();
        if (!(jsonObject.getAsJsonArray("seventhLevel") == null)) {
            jsonObject
                    .getAsJsonArray("seventhLevel")
                    .forEach(element -> seventhLevel.add(new Spell((JsonObject) element)));
        }
        setSeventhLevel(seventhLevel);

        // EighthLevel
        ArrayList<Spell> eighthLevel = new ArrayList<>();
        if (!(jsonObject.getAsJsonArray("eighthLevel") == null)) {
            jsonObject
                    .getAsJsonArray("eighthLevel")
                    .forEach(element -> eighthLevel.add(new Spell((JsonObject) element)));
        }
        setEighthLevel(eighthLevel);

        // NinthLevel
        ArrayList<Spell> ninthLevel = new ArrayList<>();
        if (!(jsonObject.getAsJsonArray("ninthLevel") == null)) {
            jsonObject
                    .getAsJsonArray("ninthLevel")
                    .forEach(element -> ninthLevel.add(new Spell((JsonObject) element)));
        }
        setNinthLevel(ninthLevel);

        // Slots
        ArrayList<Integer> slots = new ArrayList<>();
        if (!(jsonObject.getAsJsonArray("slots") == null)) {
            jsonObject.getAsJsonArray("slots").forEach(element -> slots.add(element.getAsInt()));
        }
        setSlots(slots);

        // Slots Used
        ArrayList<Integer> slotsUsed = new ArrayList<>();
        if (!(jsonObject.getAsJsonArray("slotsUsed") == null)) {
            jsonObject.getAsJsonArray("slotsUsed").forEach(element -> slotsUsed.add(element.getAsInt()));
        }
        setSlotsUsed(slotsUsed);
    }

    public JsonObject toJson() {

        JsonObject jsonObject = new JsonObject();

        if (getCantrips() != null) {
            JsonArray cantripArray = new JsonArray();
            for (Spell cantrip : getCantrips()) {
                cantripArray.add(cantrip.toJson());
            }
            jsonObject.add("cantrips", cantripArray);
        }

        if (getFirstLevel() != null) {
            JsonArray firstLevelArray = new JsonArray();
            for (Spell firstLevel : getFirstLevel()) {
                firstLevelArray.add(firstLevel.toJson());
            }
            jsonObject.add("firstLevel", firstLevelArray);
        }

        if (getSecondLevel() != null) {
            JsonArray secondLevelArray = new JsonArray();
            for (Spell secondLevel : getSecondLevel()) {
                secondLevelArray.add(secondLevel.toJson());
            }
            jsonObject.add("secondLevel", secondLevelArray);
        }

        if (getThirdLevel() != null) {
            JsonArray thirdLevelArray = new JsonArray();
            for (Spell thirdLevel : getThirdLevel()) {
                thirdLevelArray.add(thirdLevel.toJson());
            }
            jsonObject.add("thirdLevel", thirdLevelArray);
        }

        if (getForthLevel() != null) {
            JsonArray forthLevelArray = new JsonArray();
            for (Spell forthLevel : getForthLevel()) {
                forthLevelArray.add(forthLevel.toJson());
            }
            jsonObject.add("forthLevel", forthLevelArray);
        }

        if (getFifthLevel() != null) {
            JsonArray fifthLevelArray = new JsonArray();
            for (Spell fifthLevel : getFifthLevel()) {
                fifthLevelArray.add(fifthLevel.toJson());
            }
            jsonObject.add("fifthLevel", fifthLevelArray);
        }

        if (getSixthLevel() != null) {
            JsonArray sixthLevelArray = new JsonArray();
            for (Spell sixthLevel : getSixthLevel()) {
                sixthLevelArray.add(sixthLevel.toJson());
            }
            jsonObject.add("sixthLevel", sixthLevelArray);
        }

        if (getSeventhLevel() != null) {
            JsonArray seventhLevelArray = new JsonArray();
            for (Spell seventhLevel : getSeventhLevel()) {
                seventhLevelArray.add(seventhLevel.toJson());
            }
            jsonObject.add("seventhLevel", seventhLevelArray);
        }

        if (getEighthLevel() != null) {
            JsonArray eigthLevelArray = new JsonArray();
            for (Spell eigthLevel : getEighthLevel()) {
                eigthLevelArray.add(eigthLevel.toJson());
            }
            jsonObject.add("eigthLevel", eigthLevelArray);
        }

        if (getNinthLevel() != null) {
            JsonArray ninthLevelArray = new JsonArray();
            for (Spell ninthLevel : getNinthLevel()) {
                ninthLevelArray.add(ninthLevel.toJson());
            }
            jsonObject.add("ninthLevel", ninthLevelArray);
        }

        if (getSlots() != null) {
            JsonArray slotsArray = new JsonArray();
            for (Integer slot : getSlots()) {
                slotsArray.add(slot);
            }
            jsonObject.add("slots", slotsArray);
        }

        if (getSlotsUsed() != null) {
            JsonArray slotsUsedArray = new JsonArray();
            for (Integer slotUsed : getSlotsUsed()) {
                slotsUsedArray.add(slotUsed);
            }
            jsonObject.add("slotsUsed", slotsUsedArray);
        }

        if (jsonObject.size() != 0) {
            return jsonObject;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return this.toJson().toString();
    }
}
