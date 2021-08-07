package com.sjmulhern.dndTracker.sceneControllers;

import com.sjmulhern.dndTracker.App;
import com.sjmulhern.dndTracker.creatures.Alignment;
import com.sjmulhern.dndTracker.creatures.Condition;
import com.sjmulhern.dndTracker.creatures.Creature;
import com.sjmulhern.dndTracker.creatures.Monster;
import com.sjmulhern.dndTracker.creatures.NonPlayerCharacter;
import com.sjmulhern.dndTracker.creatures.PlayerCharacter;
import com.sjmulhern.dndTracker.creatures.Size;
import com.sjmulhern.dndTracker.creatures.Type;
import com.sjmulhern.dndTracker.tools.Ability;
import com.sjmulhern.dndTracker.tools.DamageType;
import com.sjmulhern.dndTracker.tools.Tool;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
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

        ArrayList<String> conditionStrings = new ArrayList<>();
        for (Condition condition: Condition.values()) {
            conditionStrings.add(condition.toString());
        }

        addToComboBox(alignmentField, alignmentStrings);
        addToComboBox(sizeField, sizeStrings);
        addToComboBox(creatureTypeField, typeStrings);
        addToComboBox(currentConditionCombobox, conditionStrings);

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

        ArrayList<Ability> abilities = new ArrayList<>(abilityTable.getItems());
        ArrayList<Tool> tools = new ArrayList<>(weaponsTable.getItems());

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
//                    abilities,
//                    tools,
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
        if (creatureEditing instanceof Monster) {
            levelDescriptor.setText("DC:");
        }
        SpinnerValueFactory<Double> dcFactory =
            new SpinnerValueFactory.DoubleSpinnerValueFactory(0, Double.MAX_VALUE, creatureEditing.getLevel());
        levelSpinner.setValueFactory(dcFactory);
        dcFactory.valueProperty().addListener(((observable, oldValue, newValue) -> creatureEditing.setLevel(newValue)));
        levelSpinner.setEditable(true);
        nameField.setText(creatureEditing.getName());
        descriptionField.setText(creatureEditing.getDescription());
        alignmentField.setValue(creatureEditing.getAlignment().toString());
        sizeField.setValue(creatureEditing.getSize().toString());
        currentConditionCombobox.setValue(creatureEditing.getCurrentCondition().toString());
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

        ObservableList<Ability> abilitiesObservable =  FXCollections.observableArrayList();
        abilitiesObservable.addAll(creatureEditing.getAbilities());
        abilitiesNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        abilitiesNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        abilitiesNameColumn.setOnEditCommit(
            event -> (event.getTableView().getItems().get(event.getTablePosition().getRow())).setName(event.getNewValue())
        );
        abilitiesDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        abilitiesDescriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        abilitiesDescriptionColumn.setOnEditCommit(
            event -> (event.getTableView().getItems().get(event.getTablePosition().getRow())).setDescription(event.getNewValue())
        );
        abilityTable.setItems(abilitiesObservable);
        abilityTable.setEditable(true);

        ObservableList<Tool> toolsObservable = FXCollections.observableArrayList();
        toolsObservable.addAll(creatureEditing.getTools());
        toolsNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        toolsNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        toolsNameColumn.setOnEditCommit(
            event -> (event.getTableView().getItems().get(event.getTablePosition().getRow())).setName(event.getNewValue())
        );
        toolsDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        toolsDescriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        toolsDescriptionColumn.setOnEditCommit(
            event -> (event.getTableView().getItems().get(event.getTablePosition().getRow())).setDescription(event.getNewValue())
        );
        toolsToHitColumn.setCellValueFactory(new PropertyValueFactory<>("toHit"));
        toolsToHitColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        toolsToHitColumn.setOnEditCommit(
            event -> (event.getTableView().getItems().get(event.getTablePosition().getRow())).setToHit(event.getNewValue())
        );
        toolsDamageColumn.setCellValueFactory(new PropertyValueFactory<>("damage"));
        toolsDamageColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        toolsDamageColumn.setOnEditCommit(
            event -> (event.getTableView().getItems().get(event.getTablePosition().getRow())).setDamage(event.getNewValue())
        );
        toolsDamageTypeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDamageType()));
        toolsDamageTypeColumn.setCellFactory(ComboBoxTableCell.forTableColumn(DamageType.getStringValues()));
        weaponsTable.setItems(toolsObservable);
        weaponsTable.setEditable(true);



    }

    public void addNewWeaponPressed () {
        weaponsTable.getItems().add(new Tool(" ", " ", DamageType.None, " ", " "));
    }

    public void addNewAbilityPressed () {
        abilityTable.getItems().add(new Ability(" ", " "));
    }

    public void editSkillsButtonPressed () {
        // initializing the controller
        App.currentCreature = creatureEditing;
        SkillEditPopupController popupController = new SkillEditPopupController();
        Parent layout;
        try {
            layout = FXMLLoader.load(Objects.requireNonNull(
                App.class.getResource("views/SkillEditPopupView.fxml")));
            Scene scene = new Scene(layout);
            // this is the popup stage
            Stage popupStage = new Stage();
            // Giving the popup controller access to the popup stage (to allow the controller to close the stage)
            popupController.setStage(popupStage);
            popupStage.initOwner(App.getPrimaryStage());
            popupStage.initModality(Modality.WINDOW_MODAL);
            popupStage.setScene(scene);
            popupStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editLanguagesButtonPressed () {
        // initializing the controller
        App.currentCreature = creatureEditing;
        LanguageEditPopupController popupController = new LanguageEditPopupController();
        Parent layout;
        try {
            layout = FXMLLoader.load(Objects.requireNonNull(
                App.class.getResource("views/LanguageEditPopupView.fxml")));
            Scene scene = new Scene(layout);
            // this is the popup stage
            Stage popupStage = new Stage();
            // Giving the popup controller access to the popup stage (to allow the controller to close the stage)
            popupController.setStage(popupStage);
            popupStage.initOwner(App.getPrimaryStage());
            popupStage.initModality(Modality.WINDOW_MODAL);
            popupStage.setScene(scene);
            popupStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    @FXML
    public Button addNewAbilityButton;
    @FXML
    public Button addNewWeaponButton;
    @FXML
    public Button editSkillsButton;
    @FXML
    public Button editLanguagesButton;
    public Spinner<Double> levelSpinner;
    public Label levelDescriptor;
    public ComboBox<String> currentConditionCombobox;

}
