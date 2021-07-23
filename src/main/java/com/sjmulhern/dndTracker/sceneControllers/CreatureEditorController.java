package com.sjmulhern.dndTracker.sceneControllers;

import com.sjmulhern.dndTracker.App;
import com.sjmulhern.dndTracker.creatures.Alignment;
import com.sjmulhern.dndTracker.creatures.Creature;
import com.sjmulhern.dndTracker.creatures.Monster;
import com.sjmulhern.dndTracker.creatures.NonPlayerCharacter;
import com.sjmulhern.dndTracker.creatures.PlayerCharacter;
import com.sjmulhern.dndTracker.creatures.Size;
import com.sjmulhern.dndTracker.creatures.Type;
import com.sjmulhern.dndTracker.tools.Ability;
import com.sjmulhern.dndTracker.tools.Tool;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.Set;

public class CreatureEditorController {

    private Creature creatureEditing = null;

    public void initialize(){

        addToComboBox(App.initativeRoundRobin.getCreatures().toArray());

        ArrayList<String> alignmentStrings = new ArrayList<>();
        for (Alignment value: Alignment.values()) {
            alignmentStrings.add(value.toString());
        }

        ArrayList<String> sizeStrings = new ArrayList<>();
        for (Size value: Size.values()) {
            sizeStrings.add(value.toString());
        }

        ArrayList<String> typeStrings = new ArrayList<>();
        for (Type value: Type.values()) {
            typeStrings.add(value.toString());
        }
        addToComboBox(alignmentField, alignmentStrings);
        addToComboBox(sizeField, sizeStrings);
        addToComboBox(creatureTypeField, typeStrings);


        creatureEditing = App.initativeRoundRobin.getCurrent();
        reset();
    }

    public void addToComboBox(Object[] creatures) {

        ArrayList<String> names = new ArrayList<>();

        for (Object creature: creatures) {
            names.add(((Creature)creature).getName());
        }

        creatureNames.getItems().addAll(names);
    }

    public void addToComboBox(ComboBox<String> comboBox, ArrayList<String> values) {
        comboBox.getItems().addAll(values);
    }

    public void saveCreatureButtonPressed () {
        Creature editedCreature = null;

        // grab all values and create the creature

        String creatureType = ((RadioButton) types.getSelectedToggle()).getText();
        switch(creatureType){
            case "Creature":
//                editedCreature = new Creature(
//                    nameField.getText(),
//                    descriptionField.getText(),
//                    Alignment.valueOf(alignmentField.getValue()),
//                    Size.valueOf(sizeField.getValue()),
//                    Integer.parseInt(movementSpeedField.getText()),
//                    Integer.parseInt(swimmingSpeedField.getText()),
//                    Integer.parseInt(climbingSpeedField.getText()),
//                    Integer.parseInt(flyingSpeedField.getText()),
//
//
//                );
                break;
            case "Monster":

                break;
            case "Player":

                break;
            case "NPC":

                break;
        }


    }

    public void openButtonPressed () {
        String creatureName = creatureNames.getValue();

        Set<Creature> creatures = App.initativeRoundRobin.getCreatures();

        Creature wantedCreature = null;
        for (Creature creature: creatures) {
            if (creature.getName().equals(creatureName)) {
                wantedCreature = creature;
            }
        }

        if (wantedCreature != null) {
            creatureEditing = wantedCreature;
            reset();
        }
    }

    public void reset() {
        nameField.setText(creatureEditing.getName());
        descriptionField.setText(creatureEditing.getDescription());
        alignmentField.setValue(creatureEditing.getAlignment().toString());
        sizeField.setValue(creatureEditing.getSize().toString());
        movementSpeedField.setText(creatureEditing.getMovementSpeed()+"");
        swimmingSpeedField.setText(creatureEditing.getSwimSpeed()+"");
        climbingSpeedField.setText(creatureEditing.getClimbSpeed()+"");
        flyingSpeedField.setText(creatureEditing.getFlySpeed()+"");
        SpinnerValueFactory<Integer> strFactory =
            new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 30, creatureEditing.getStrength());
        SpinnerValueFactory<Integer> dexFactory =
            new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 30, creatureEditing.getDexterity());
        SpinnerValueFactory<Integer> contFactory =
            new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 30, creatureEditing.getConstitution());
        SpinnerValueFactory<Integer> intFactory =
            new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 30, creatureEditing.getIntelligence());
        SpinnerValueFactory<Integer> wisFactory =
            new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 30, creatureEditing.getWisdom());
        SpinnerValueFactory<Integer> chaFactory =
            new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 30, creatureEditing.getCharisma());
        SpinnerValueFactory<Integer> hitPointsFactory =
            new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Integer.MAX_VALUE, creatureEditing.getHitPoints());
        strField.setValueFactory(strFactory);
        dexField.setValueFactory(dexFactory);
        contField.setValueFactory(contFactory);
        intField.setValueFactory(intFactory);
        wisField.setValueFactory(wisFactory);
        chaField.setValueFactory(chaFactory);
        hitPointsField.setValueFactory(hitPointsFactory);
        if (creatureEditing.getClass() == Monster.class) {
            creatureTypeField.setValue(((Monster)creatureEditing).getType().toString());
        } else {
            creatureTypeField.setValue(Type.None.toString());
        }
        creatureNames.setValue(creatureEditing.getName());

        if (Creature.class.equals(creatureEditing.getClass())) {
            creatureRadioButton.setSelected(true);
        } else if (Monster.class.equals(creatureEditing.getClass())) {
            monsterRadioButton.setSelected(true);
        } else if (PlayerCharacter.class.equals(creatureEditing.getClass())) {
            playerRadioButton.setSelected(true);
        } else if (NonPlayerCharacter.class.equals(creatureEditing.getClass())) {
            npcRadioButton.setSelected(true);
        }

        ObservableList<Ability> abilitesObservable =  FXCollections.observableArrayList();
        abilitesObservable.addAll(creatureEditing.getAbilities());
        abilitiesNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        abilitiesDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        abilityTable.setItems(abilitesObservable);
        abilityTable.getColumns().add(abilitiesNameColumn);
        abilityTable.getColumns().add(abilitiesDescriptionColumn);



        ObservableList<Tool> toolsObservable = FXCollections.observableArrayList();
        toolsObservable.addAll(creatureEditing.getTools());
        toolsNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        toolsDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        toolsToHitColumn.setCellValueFactory(new PropertyValueFactory<>("toHit"));
        toolsDamageColumn.setCellValueFactory(new PropertyValueFactory<>("damage"));
        toolsDamageTypeColumn.setCellValueFactory(new PropertyValueFactory<>("damageType"));
        weaponsTable.setItems(toolsObservable);
        weaponsTable.getColumns().add(toolsNameColumn);
        weaponsTable.getColumns().add(toolsToHitColumn);
        weaponsTable.getColumns().add(toolsDamageColumn);
        weaponsTable.getColumns().add(toolsDamageTypeColumn);
        weaponsTable.getColumns().add(toolsDescriptionColumn);
    }

    @FXML
    public TextField nameField;
    @FXML
    public ComboBox<String> creatureTypeField;
    @FXML
    public ComboBox<String> alignmentField;
    @FXML
    public ComboBox<String> sizeField;
    @FXML
    public TextField movementSpeedField;
    @FXML
    public TextField climbingSpeedField;
    @FXML
    public TableView<Ability> abilityTable;
    @FXML
    public TextField swimmingSpeedField;
    @FXML
    public TextField flyingSpeedField;
    @FXML
    public TextField skillsField;
    @FXML
    public TextField descriptionField;
    @FXML
    public TableView<Tool> weaponsTable;
    @FXML
    public Spinner<Integer> strField;
    @FXML
    public Spinner<Integer> dexField;
    @FXML
    public Spinner<Integer> contField;
    @FXML
    public Spinner<Integer> intField;
    @FXML
    public Spinner<Integer> wisField;
    @FXML
    public Spinner<Integer> chaField;
    @FXML
    public Spinner<Integer> hitPointsField;
    @FXML
    public TextField languagesField;
    @FXML
    public Button saveCreatureButton;
    @FXML
    public ComboBox<String> creatureNames;
    @FXML
    public Button openButton;
    @FXML
    public RadioButton creatureRadioButton;
    @FXML
    public RadioButton monsterRadioButton;
    @FXML
    public RadioButton playerRadioButton;
    @FXML
    public RadioButton npcRadioButton;
    @FXML
    public ToggleGroup types;
    @FXML
    public TableColumn<Ability, String> abilitiesNameColumn;
    @FXML
    public TableColumn<Ability, String> abilitiesDescriptionColumn;
    @FXML
    public TableColumn<Tool, String> toolsNameColumn;
    @FXML
    public TableColumn<Tool, String> toolsToHitColumn;
    @FXML
    public TableColumn<Tool, String> toolsDamageColumn;
    @FXML
    public TableColumn<Tool, String> toolsDescriptionColumn;
    @FXML
    public TableColumn<Tool, String> toolsDamageTypeColumn;

}
