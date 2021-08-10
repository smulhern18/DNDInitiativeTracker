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

    public JsonObject toJson() {

        JsonObject jsonObject = new JsonObject();

        if (getCantrips() != null) {
            JsonArray cantripArray = new JsonArray();
            for (Spell cantrip : getCantrips()) {
                cantripArray.add(cantrip.toJson());
            }
            jsonObject.add("cantrip", cantripArray);
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
