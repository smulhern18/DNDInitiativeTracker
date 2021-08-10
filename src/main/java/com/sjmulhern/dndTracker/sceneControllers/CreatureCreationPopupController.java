package com.sjmulhern.dndTracker.sceneControllers;

import com.sjmulhern.dndTracker.App;
import com.sjmulhern.dndTracker.creatures.Creature;
import com.sjmulhern.dndTracker.creatures.Monster;
import com.sjmulhern.dndTracker.creatures.NonPlayerCharacter;
import com.sjmulhern.dndTracker.creatures.PlayerCharacter;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.util.ArrayList;

public class CreatureCreationPopupController {

    Creature currentCreature = App.currentCreature;

    public void nothingPressed () {

    }

    public void currentCreaturePressed () {
        if (App.initativeRoundRobin.getCreatures().size() == 0) {
            nothingPressed();
        }
    }

    public void selectedCreaturePressed () {
        if (App.initativeRoundRobin.getCreatures().size() == 0) {
            nothingPressed();
        }
    }

    public void initialize() {

        // Initialize Combobox
        ArrayList<String> names = new ArrayList<>();
        for (Creature creature: App.initativeRoundRobin.getCreatures()) {
            names.add(creature.getName());
        }
        creatureNameComboBox.getItems().addAll(names);
        creatureNameComboBox.setValue(currentCreature.getName());

        // Initialize RadioButtons
        if (Monster.class.equals(currentCreature.getClass())) {
            monsterRadio.setSelected(true);
        } else if (NonPlayerCharacter.class.equals(currentCreature.getClass())) {
            npcRadio.setSelected(true);
        } else if (PlayerCharacter.class.equals(currentCreature.getClass())) {
            playerRadio.setSelected(true);
        }
    }


    public ToggleGroup creatureType;

    public RadioButton monsterRadio;

    public RadioButton playerRadio;

    public RadioButton npcRadio;

    public ComboBox<String> creatureNameComboBox;

}
