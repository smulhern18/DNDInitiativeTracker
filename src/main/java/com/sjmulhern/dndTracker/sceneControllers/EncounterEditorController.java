package com.sjmulhern.dndTracker.sceneControllers;

import com.sjmulhern.dndTracker.App;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class EncounterEditorController {

    public void removeSelectedPressed() {
        String nameToRemove = creatureComboBox.getValue();
        if (nameToRemove != null) {
            creatureComboBox.getItems().removeIf(element -> element.equals(nameToRemove));
            creatureComboBox.setValue(null);
            App.encounter
                    .getInitativeRoundRobin()
                    .getCreatures()
                    .removeIf(element -> element.getName().equals(nameToRemove));
            App.encounter.getInitativeRoundRobin().getNext();
        }
    }

    public void initialize() {
        nameTextField.setText(App.encounter.getName());
        descriptionTextField.setText(App.encounter.getDescription());
        App.encounter
                .getInitativeRoundRobin()
                .getCreatures()
                .forEach(creature -> creatureComboBox.getItems().add(creature.getName()));

        nameTextField.setOnKeyTyped(value -> App.encounter.setName(nameTextField.getText()));
        descriptionTextField.setOnKeyTyped(
                value -> App.encounter.setDescription(descriptionTextField.getText()));
    }

    public TextField nameTextField;

    public TextField descriptionTextField;

    public ComboBox<String> creatureComboBox;
}
