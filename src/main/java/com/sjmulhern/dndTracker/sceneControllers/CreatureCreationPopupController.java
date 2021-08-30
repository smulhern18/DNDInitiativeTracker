package com.sjmulhern.dndTracker.sceneControllers;

import com.google.gson.JsonObject;
import com.sjmulhern.dndTracker.App;
import com.sjmulhern.dndTracker.creatures.Alignment;
import com.sjmulhern.dndTracker.creatures.Condition;
import com.sjmulhern.dndTracker.creatures.Creature;
import com.sjmulhern.dndTracker.creatures.Monster;
import com.sjmulhern.dndTracker.creatures.NonPlayerCharacter;
import com.sjmulhern.dndTracker.creatures.PlayerCharacter;
import com.sjmulhern.dndTracker.creatures.Size;
import com.sjmulhern.dndTracker.creatures.Spells;
import java.util.ArrayList;
import java.util.Random;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class CreatureCreationPopupController {

    Creature currentCreature = App.getInitativeRoundRobin().getCurrent();

    public void nothingPressed() {
        String name = "" + new Random().nextInt();
        App.getInitativeRoundRobin()
                .addCreature(
                        new NonPlayerCharacter(
                                name,
                                "This is a brand spanking new Creature,"
                                        + " please change the randomly generated name",
                                Alignment.Unaligned,
                                Size.Medium,
                                30,
                                15,
                                15,
                                0,
                                new ArrayList<>(),
                                new ArrayList<>(),
                                new ArrayList<>(),
                                new ArrayList<>(),
                                10,
                                10,
                                10,
                                10,
                                10,
                                10,
                                5,
                                10,
                                1,
                                1.0,
                                Condition.None,
                                new Spells(),
                                new ArrayList<>(),
                                new ArrayList<>(),
                                new ArrayList<>()));
    }

    public void currentCreaturePressed() {
        if (App.getInitativeRoundRobin().getCreatures().size() == 0) {
            nothingPressed();
            return;
        }

        String newName = currentCreature.getName() + "_copy";

        JsonObject creatureJson = currentCreature.toJson();

        creatureJson.remove("name");
        creatureJson.addProperty("name", newName);

        if (currentCreature instanceof Monster) {
            App.getInitativeRoundRobin().addCreature(new Monster(creatureJson));
        } else if (currentCreature instanceof PlayerCharacter) {
            App.getInitativeRoundRobin().addCreature(new PlayerCharacter(creatureJson));
        } else {
            App.getInitativeRoundRobin().addCreature(new NonPlayerCharacter(creatureJson));
        }

        App.getInitativeRoundRobin().setCurrentCreature(newName);
    }

    public void selectedCreaturePressed() {
        if (App.getInitativeRoundRobin().getCreatures().size() == 0) {
            nothingPressed();
            return;
        }

        App.getInitativeRoundRobin().setCurrentCreature(creatureNameComboBox.getValue());

        String newName = currentCreature.getName() + "_copy";

        JsonObject creatureJson = currentCreature.toJson();

        creatureJson.remove("name");
        creatureJson.addProperty("name", newName);

        if (currentCreature instanceof Monster) {
            App.getInitativeRoundRobin().addCreature(new Monster(creatureJson));
        } else if (currentCreature instanceof PlayerCharacter) {
            App.getInitativeRoundRobin().addCreature(new PlayerCharacter(creatureJson));
        } else {
            App.getInitativeRoundRobin().addCreature(new NonPlayerCharacter(creatureJson));
        }

        App.getInitativeRoundRobin().setCurrentCreature(newName);
    }

    public void initialize() {

        // Initialize Combobox
        ArrayList<String> names = new ArrayList<>();
        for (Creature creature : App.getInitativeRoundRobin().getCreatures()) {
            names.add(creature.getName());
        }
        creatureNameComboBox.getItems().addAll(names);
        creatureNameComboBox.setValue(currentCreature.getName());
    }

    @FXML public ComboBox<String> creatureNameComboBox;
}
