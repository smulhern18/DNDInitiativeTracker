package com.sjmulhern.dndTracker.sceneControllers;

import com.sjmulhern.dndTracker.App;
import com.sjmulhern.dndTracker.creatures.Creature;
import com.sjmulhern.dndTracker.creatures.Spells;
import com.sjmulhern.dndTracker.tools.Shape;
import com.sjmulhern.dndTracker.tools.Spell;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpellEditorController {

    private Stage stage = null;

    public void saveButtonPressed(ActionEvent actionEvent) {
        App.initativeRoundRobin
                .getCurrent()
                .setSpells(
                        new Spells(
                                new ArrayList<>(cantripTable.getItems()),
                                new ArrayList<>(firstTable.getItems()),
                                new ArrayList<>(secondTable.getItems()),
                                new ArrayList<>(thirdTable.getItems()),
                                new ArrayList<>(forthTable.getItems()),
                                new ArrayList<>(fifthTable.getItems()),
                                new ArrayList<>(sixthTable.getItems()),
                                new ArrayList<>(seventhTable.getItems()),
                                new ArrayList<>(eighthTable.getItems()),
                                new ArrayList<>(ninthTable.getItems()),
                                App.currentCreature.getSpells().getSlots(),
                                App.currentCreature.getSpells().getSlotsUsed()));
    }

    Creature creature = App.currentCreature;

    private Spells result =
            new Spells(
                    new ArrayList<>(),
                    new ArrayList<>(),
                    new ArrayList<>(),
                    new ArrayList<>(),
                    new ArrayList<>(),
                    new ArrayList<>(),
                    new ArrayList<>(),
                    new ArrayList<>(),
                    new ArrayList<>(),
                    new ArrayList<>(),
                    new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)),
                    new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)));

    public void addSpell() {
        Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();
        ObservableList<Spell> spellsToUpdate = getSpellsBasedOnTabName(selectedTab);

        spellsToUpdate.add(new Spell("Just added", "", 0, Shape.None, ""));

        ObservableList<String> spellNames = FXCollections.observableArrayList();
        spellsToUpdate.forEach(element -> spellNames.add(element.getName()));

        spellNameComboBox.setItems(spellNames);
    }

    public void removeSpell() {

        String nameToRemove = spellNameComboBox.getValue();
        if (nameToRemove != null) {
            ObservableList<Spell> spellsToUpdate;

            switch (tabPane.getSelectionModel().getSelectedItem().getText()) {
                case "Cantrips":
                    spellsToUpdate = cantripTable.getItems();
                    break;
                case "First Level":
                    spellsToUpdate = firstTable.getItems();
                    break;
                case "Second":
                    spellsToUpdate = secondTable.getItems();
                    break;
                case "Third":
                    spellsToUpdate = thirdTable.getItems();
                    break;
                case "Forth":
                    spellsToUpdate = forthTable.getItems();
                    break;
                case "Fifth":
                    spellsToUpdate = fifthTable.getItems();
                    break;
                case "Sixth":
                    spellsToUpdate = sixthTable.getItems();
                    break;
                case "Seventh":
                    spellsToUpdate = seventhTable.getItems();
                    break;
                case "Eighth":
                    spellsToUpdate = eighthTable.getItems();
                    break;
                case "Ninth":
                    spellsToUpdate = ninthTable.getItems();
                    break;
                default:
                    spellsToUpdate = FXCollections.observableArrayList();
                    break;
            }

            spellsToUpdate.removeIf(element -> element.getName().equals(nameToRemove));
            spellNameComboBox.getItems().removeIf(element -> element.equals(nameToRemove));
            spellNameComboBox.setValue(null);
        }
    }

    public void initialize() {
        tabPane.getSelectionModel().selectedItemProperty().addListener(this::handleChangeTab);

        Spells spells = creature.getSpells();
        if (spells == null) {
            creature.setSpells(result);
            spells = result;
        } else {
            System.out.println(spells.toString());
        }

        // Initialize the spinners
        ArrayList<Integer> slots = spells.getSlots();
        ArrayList<Integer> slotsExpended = spells.getSlotsUsed();
        initializeSpinner(firstSlots, slots.get(1));
        Spells finalResult = spells;
        firstSlots
                .getValueFactory()
                .valueProperty()
                .addListener(((observable, oldValue, newValue) -> finalResult.getSlots().add(1, newValue)));
        initializeSpinner(secondSlots, slots.get(2));
        secondSlots
                .getValueFactory()
                .valueProperty()
                .addListener(((observable, oldValue, newValue) -> finalResult.getSlots().add(2, newValue)));
        initializeSpinner(thirdSlots, slots.get(3));
        thirdSlots
                .getValueFactory()
                .valueProperty()
                .addListener(((observable, oldValue, newValue) -> finalResult.getSlots().add(3, newValue)));
        initializeSpinner(forthSlots, slots.get(4));
        forthSlots
                .getValueFactory()
                .valueProperty()
                .addListener(((observable, oldValue, newValue) -> finalResult.getSlots().add(4, newValue)));
        initializeSpinner(fifthSlots, slots.get(5));
        fifthSlots
                .getValueFactory()
                .valueProperty()
                .addListener(((observable, oldValue, newValue) -> finalResult.getSlots().add(5, newValue)));
        initializeSpinner(sixthSlots, slots.get(6));
        sixthSlots
                .getValueFactory()
                .valueProperty()
                .addListener(((observable, oldValue, newValue) -> finalResult.getSlots().add(6, newValue)));
        initializeSpinner(seventhSlots, slots.get(7));
        seventhSlots
                .getValueFactory()
                .valueProperty()
                .addListener(((observable, oldValue, newValue) -> finalResult.getSlots().add(7, newValue)));
        initializeSpinner(eighthSlots, slots.get(8));
        eighthSlots
                .getValueFactory()
                .valueProperty()
                .addListener(((observable, oldValue, newValue) -> finalResult.getSlots().add(8, newValue)));
        initializeSpinner(ninthSlots, slots.get(9));
        ninthSlots
                .getValueFactory()
                .valueProperty()
                .addListener(((observable, oldValue, newValue) -> finalResult.getSlots().add(9, newValue)));
        initializeSpinner(firstSlotsExpended, slotsExpended.get(1));
        firstSlotsExpended
                .getValueFactory()
                .valueProperty()
                .addListener(
                        ((observable, oldValue, newValue) -> finalResult.getSlotsUsed().add(1, newValue)));
        initializeSpinner(secondSlotsExpended, slotsExpended.get(2));
        secondSlotsExpended
                .getValueFactory()
                .valueProperty()
                .addListener(
                        ((observable, oldValue, newValue) -> finalResult.getSlotsUsed().add(2, newValue)));
        initializeSpinner(thirdSlotsExpended, slotsExpended.get(3));
        thirdSlotsExpended
                .getValueFactory()
                .valueProperty()
                .addListener(
                        ((observable, oldValue, newValue) -> finalResult.getSlotsUsed().add(3, newValue)));
        initializeSpinner(forthSlotsExpended, slotsExpended.get(4));
        forthSlotsExpended
                .getValueFactory()
                .valueProperty()
                .addListener(
                        ((observable, oldValue, newValue) -> finalResult.getSlotsUsed().add(4, newValue)));
        initializeSpinner(fifthSlotsExpended, slotsExpended.get(5));
        fifthSlotsExpended
                .getValueFactory()
                .valueProperty()
                .addListener(
                        ((observable, oldValue, newValue) -> finalResult.getSlotsUsed().add(5, newValue)));
        initializeSpinner(sixthSlotsExpended, slotsExpended.get(6));
        sixthSlotsExpended
                .getValueFactory()
                .valueProperty()
                .addListener(
                        ((observable, oldValue, newValue) -> finalResult.getSlotsUsed().add(6, newValue)));
        initializeSpinner(seventhSlotsExpended, slotsExpended.get(7));
        seventhSlotsExpended
                .getValueFactory()
                .valueProperty()
                .addListener(
                        ((observable, oldValue, newValue) -> finalResult.getSlotsUsed().add(7, newValue)));
        initializeSpinner(eighthSlotsExpended, slotsExpended.get(8));
        eighthSlotsExpended
                .getValueFactory()
                .valueProperty()
                .addListener(
                        ((observable, oldValue, newValue) -> finalResult.getSlotsUsed().add(8, newValue)));
        initializeSpinner(ninthSlotsExpended, slotsExpended.get(9));
        ninthSlotsExpended
                .getValueFactory()
                .valueProperty()
                .addListener(
                        ((observable, oldValue, newValue) -> finalResult.getSlotsUsed().add(9, newValue)));

        // Initialize the tables
        Integer[] sizeArray = {0, 5, 10, 15, 20, 30, 40, 50, 60, 100, 150, 200};

        if (spells.getCantrips() == null) {
            spells.setCantrips(new ArrayList<>());
        }

        if (spells.getFirstLevel() == null) {
            spells.setFirstLevel(new ArrayList<>());
        }

        if (spells.getSecondLevel() == null) {
            spells.setSecondLevel(new ArrayList<>());
        }

        if (spells.getThirdLevel() == null) {
            spells.setThirdLevel(new ArrayList<>());
        }

        if (spells.getForthLevel() == null) {
            spells.setForthLevel(new ArrayList<>());
        }

        if (spells.getFifthLevel() == null) {
            spells.setFifthLevel(new ArrayList<>());
        }

        if (spells.getSixthLevel() == null) {
            spells.setSixthLevel(new ArrayList<>());
        }

        if (spells.getSeventhLevel() == null) {
            spells.setSeventhLevel(new ArrayList<>());
        }

        if (spells.getEighthLevel() == null) {
            spells.setEighthLevel(new ArrayList<>());
        }

        if (spells.getNinthLevel() == null) {
            spells.setNinthLevel(new ArrayList<>());
        }

        App.currentCreature.setSpells(spells);

        cantripTable.getItems().addAll(App.currentCreature.getSpells().getCantrips());
        cantripName.setCellValueFactory(new PropertyValueFactory<>("name"));
        cantripName.setCellFactory(TextFieldTableCell.forTableColumn());
        cantripName.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setName(event.getNewValue()));
        cantripEffect.setCellValueFactory(new PropertyValueFactory<>("effect"));
        cantripEffect.setCellFactory(TextFieldTableCell.forTableColumn());
        cantripEffect.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setEffect(event.getNewValue()));
        cantripSize.setCellValueFactory(new PropertyValueFactory<>("size"));
        cantripSize.setCellFactory(ComboBoxTableCell.forTableColumn(sizeArray));
        cantripSize.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setSize(event.getNewValue()));
        cantripShape.setCellValueFactory(new PropertyValueFactory<>("shape"));
        cantripShape.setCellFactory(ComboBoxTableCell.forTableColumn(Shape.values()));
        cantripShape.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setShape(event.getNewValue()));
        cantripRequirements.setCellValueFactory(new PropertyValueFactory<>("requirements"));
        cantripRequirements.setCellFactory(TextFieldTableCell.forTableColumn());
        cantripRequirements.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setRequirements(event.getNewValue()));
        cantripTable.setEditable(true);

        firstTable.getItems().addAll(App.currentCreature.getSpells().getFirstLevel());
        firstName.setCellValueFactory(new PropertyValueFactory<>("name"));
        firstName.setCellFactory(TextFieldTableCell.forTableColumn());
        firstName.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setName(event.getNewValue()));
        firstEffect.setCellValueFactory(new PropertyValueFactory<>("effect"));
        firstEffect.setCellFactory(TextFieldTableCell.forTableColumn());
        firstEffect.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setEffect(event.getNewValue()));
        firstSize.setCellValueFactory(new PropertyValueFactory<>("size"));
        firstSize.setCellFactory(ComboBoxTableCell.forTableColumn(sizeArray));
        firstSize.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setSize(event.getNewValue()));
        firstShape.setCellValueFactory(new PropertyValueFactory<>("shape"));
        firstShape.setCellFactory(ComboBoxTableCell.forTableColumn(Shape.values()));
        firstShape.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setShape(event.getNewValue()));
        firstRequirements.setCellValueFactory(new PropertyValueFactory<>("requirements"));
        firstRequirements.setCellFactory(TextFieldTableCell.forTableColumn());
        firstRequirements.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setRequirements(event.getNewValue()));
        firstTable.setEditable(true);

        secondTable.getItems().addAll(App.currentCreature.getSpells().getSecondLevel());
        secondName.setCellValueFactory(new PropertyValueFactory<>("name"));
        secondName.setCellFactory(TextFieldTableCell.forTableColumn());
        secondName.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setName(event.getNewValue()));
        secondEffect.setCellValueFactory(new PropertyValueFactory<>("effect"));
        secondEffect.setCellFactory(TextFieldTableCell.forTableColumn());
        secondEffect.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setEffect(event.getNewValue()));
        secondSize.setCellValueFactory(new PropertyValueFactory<>("size"));
        secondSize.setCellFactory(ComboBoxTableCell.forTableColumn(sizeArray));
        secondSize.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setSize(event.getNewValue()));
        secondShape.setCellValueFactory(new PropertyValueFactory<>("shape"));
        secondShape.setCellFactory(ComboBoxTableCell.forTableColumn(Shape.values()));
        secondShape.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setShape(event.getNewValue()));
        secondRequirements.setCellValueFactory(new PropertyValueFactory<>("requirements"));
        secondRequirements.setCellFactory(TextFieldTableCell.forTableColumn());
        secondRequirements.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setRequirements(event.getNewValue()));
        secondTable.setEditable(true);

        thirdTable.getItems().addAll(App.currentCreature.getSpells().getThirdLevel());
        thirdName.setCellValueFactory(new PropertyValueFactory<>("name"));
        thirdName.setCellFactory(TextFieldTableCell.forTableColumn());
        thirdName.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setName(event.getNewValue()));
        thirdEffect.setCellValueFactory(new PropertyValueFactory<>("size"));
        thirdEffect.setCellFactory(TextFieldTableCell.forTableColumn());
        thirdEffect.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setEffect(event.getNewValue()));
        thirdSize.setCellValueFactory(new PropertyValueFactory<>("effect"));
        thirdSize.setCellFactory(ComboBoxTableCell.forTableColumn(sizeArray));
        thirdSize.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setSize(event.getNewValue()));
        thirdShape.setCellValueFactory(new PropertyValueFactory<>("shape"));
        thirdShape.setCellFactory(ComboBoxTableCell.forTableColumn(Shape.values()));
        thirdShape.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setShape(event.getNewValue()));
        thirdRequirements.setCellValueFactory(new PropertyValueFactory<>("requirements"));
        thirdRequirements.setCellFactory(TextFieldTableCell.forTableColumn());
        thirdRequirements.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setRequirements(event.getNewValue()));
        thirdTable.setEditable(true);

        forthTable.getItems().addAll(App.currentCreature.getSpells().getForthLevel());
        forthName.setCellValueFactory(new PropertyValueFactory<>("name"));
        forthName.setCellFactory(TextFieldTableCell.forTableColumn());
        forthName.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setName(event.getNewValue()));
        forthEffect.setCellValueFactory(new PropertyValueFactory<>("effect"));
        forthEffect.setCellFactory(TextFieldTableCell.forTableColumn());
        forthEffect.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setEffect(event.getNewValue()));
        forthSize.setCellValueFactory(new PropertyValueFactory<>("size"));
        forthSize.setCellFactory(ComboBoxTableCell.forTableColumn(sizeArray));
        forthSize.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setSize(event.getNewValue()));
        forthShape.setCellValueFactory(new PropertyValueFactory<>("shape"));
        forthShape.setCellFactory(ComboBoxTableCell.forTableColumn(Shape.values()));
        forthShape.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setShape(event.getNewValue()));
        forthRequirements.setCellValueFactory(new PropertyValueFactory<>("requirements"));
        forthRequirements.setCellFactory(TextFieldTableCell.forTableColumn());
        forthRequirements.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setRequirements(event.getNewValue()));
        forthTable.setEditable(true);

        fifthTable.getItems().addAll(App.currentCreature.getSpells().getFifthLevel());
        fifthName.setCellValueFactory(new PropertyValueFactory<>("name"));
        fifthName.setCellFactory(TextFieldTableCell.forTableColumn());
        fifthName.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setName(event.getNewValue()));
        fifthEffect.setCellValueFactory(new PropertyValueFactory<>("effect"));
        fifthEffect.setCellFactory(TextFieldTableCell.forTableColumn());
        fifthEffect.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setEffect(event.getNewValue()));
        fifthSize.setCellValueFactory(new PropertyValueFactory<>("size"));
        fifthSize.setCellFactory(ComboBoxTableCell.forTableColumn(sizeArray));
        fifthSize.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setSize(event.getNewValue()));
        fifthShape.setCellValueFactory(new PropertyValueFactory<>("shape"));
        fifthShape.setCellFactory(ComboBoxTableCell.forTableColumn(Shape.values()));
        fifthShape.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setShape(event.getNewValue()));
        fifthRequirements.setCellValueFactory(new PropertyValueFactory<>("requirements"));
        fifthRequirements.setCellFactory(TextFieldTableCell.forTableColumn());
        fifthRequirements.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setRequirements(event.getNewValue()));
        fifthTable.setEditable(true);

        sixthTable.getItems().addAll(App.currentCreature.getSpells().getSixthLevel());
        sixthName.setCellValueFactory(new PropertyValueFactory<>("name"));
        sixthName.setCellFactory(TextFieldTableCell.forTableColumn());
        sixthName.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setName(event.getNewValue()));
        sixthEffect.setCellValueFactory(new PropertyValueFactory<>("effect"));
        sixthEffect.setCellFactory(TextFieldTableCell.forTableColumn());
        sixthEffect.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setEffect(event.getNewValue()));
        sixthSize.setCellValueFactory(new PropertyValueFactory<>("size"));
        sixthSize.setCellFactory(ComboBoxTableCell.forTableColumn(sizeArray));
        sixthSize.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setSize(event.getNewValue()));
        sixthShape.setCellValueFactory(new PropertyValueFactory<>("shape"));
        sixthShape.setCellFactory(ComboBoxTableCell.forTableColumn(Shape.values()));
        sixthShape.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setShape(event.getNewValue()));
        sixthRequirements.setCellValueFactory(new PropertyValueFactory<>("requirements"));
        sixthRequirements.setCellFactory(TextFieldTableCell.forTableColumn());
        sixthRequirements.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setRequirements(event.getNewValue()));
        sixthTable.setEditable(true);

        seventhTable.getItems().addAll(App.currentCreature.getSpells().getSeventhLevel());
        seventhName.setCellValueFactory(new PropertyValueFactory<>("name"));
        seventhName.setCellFactory(TextFieldTableCell.forTableColumn());
        seventhName.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setName(event.getNewValue()));
        seventhEffect.setCellValueFactory(new PropertyValueFactory<>("effect"));
        seventhEffect.setCellFactory(TextFieldTableCell.forTableColumn());
        seventhEffect.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setEffect(event.getNewValue()));
        seventhSize.setCellValueFactory(new PropertyValueFactory<>("size"));
        seventhSize.setCellFactory(ComboBoxTableCell.forTableColumn(sizeArray));
        seventhSize.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setSize(event.getNewValue()));
        seventhShape.setCellValueFactory(new PropertyValueFactory<>("shape"));
        seventhShape.setCellFactory(ComboBoxTableCell.forTableColumn(Shape.values()));
        seventhShape.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setShape(event.getNewValue()));
        seventhRequirements.setCellValueFactory(new PropertyValueFactory<>("requirements"));
        seventhRequirements.setCellFactory(TextFieldTableCell.forTableColumn());
        seventhRequirements.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setRequirements(event.getNewValue()));
        seventhTable.setEditable(true);

        eighthTable.getItems().addAll(App.currentCreature.getSpells().getEighthLevel());
        eighthName.setCellValueFactory(new PropertyValueFactory<>("name"));
        eighthName.setCellFactory(TextFieldTableCell.forTableColumn());
        eighthName.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setName(event.getNewValue()));
        eighthEffect.setCellValueFactory(new PropertyValueFactory<>("effect"));
        eighthEffect.setCellFactory(TextFieldTableCell.forTableColumn());
        eighthEffect.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setEffect(event.getNewValue()));
        eighthSize.setCellValueFactory(new PropertyValueFactory<>("size"));
        eighthSize.setCellFactory(ComboBoxTableCell.forTableColumn(sizeArray));
        eighthSize.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setSize(event.getNewValue()));
        eighthShape.setCellValueFactory(new PropertyValueFactory<>("shape"));
        eighthShape.setCellFactory(ComboBoxTableCell.forTableColumn(Shape.values()));
        eighthShape.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setShape(event.getNewValue()));
        eighthRequirements.setCellValueFactory(new PropertyValueFactory<>("requirements"));
        eighthRequirements.setCellFactory(TextFieldTableCell.forTableColumn());
        eighthRequirements.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setRequirements(event.getNewValue()));
        eighthTable.setEditable(true);

        ninthTable.getItems().addAll(App.currentCreature.getSpells().getNinthLevel());
        ninthName.setCellValueFactory(new PropertyValueFactory<>("name"));
        ninthName.setCellFactory(TextFieldTableCell.forTableColumn());
        ninthName.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setName(event.getNewValue()));
        ninthEffect.setCellValueFactory(new PropertyValueFactory<>("effect"));
        ninthEffect.setCellFactory(TextFieldTableCell.forTableColumn());
        ninthEffect.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setEffect(event.getNewValue()));
        ninthSize.setCellValueFactory(new PropertyValueFactory<>("size"));
        ninthSize.setCellFactory(ComboBoxTableCell.forTableColumn(sizeArray));
        ninthSize.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setSize(event.getNewValue()));
        ninthShape.setCellValueFactory(new PropertyValueFactory<>("shape"));
        ninthShape.setCellFactory(ComboBoxTableCell.forTableColumn(Shape.values()));
        ninthShape.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setShape(event.getNewValue()));
        ninthRequirements.setCellValueFactory(new PropertyValueFactory<>("requirements"));
        ninthRequirements.setCellFactory(TextFieldTableCell.forTableColumn());
        ninthRequirements.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setRequirements(event.getNewValue()));
        ninthTable.setEditable(true);

        result = creature.getSpells();
    }

    public void initializeSpinner(Spinner<Integer> spinner, Integer initialValue) {
        SpinnerValueFactory<Integer> spinnerFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 30, initialValue);
        spinner.setValueFactory(spinnerFactory);
    }

    public void handleChangeTab(ObservableValue<? extends Tab> ov, Tab oldTab, Tab newTab) {

        ObservableList<Spell> spellsToUpdate = getSpellsBasedOnTabName(newTab);

        ObservableList<String> spellNames = FXCollections.observableArrayList();
        spellsToUpdate.forEach(element -> spellNames.add(element.getName()));

        spellNameComboBox.setItems(spellNames);
        spellNameComboBox.setValue(null);
    }

    private ObservableList<Spell> getSpellsBasedOnTabName(Tab newTab) {

        ObservableList<Spell> spellsToUpdate;

        switch (newTab.getText()) {
            case "Cantrips":
                spellsToUpdate = cantripTable.getItems();
                break;
            case "First Level":
                spellsToUpdate = firstTable.getItems();
                break;
            case "Second":
                spellsToUpdate = secondTable.getItems();
                break;
            case "Third":
                spellsToUpdate = thirdTable.getItems();
                break;
            case "Forth":
                spellsToUpdate = forthTable.getItems();
                break;
            case "Fifth":
                spellsToUpdate = fifthTable.getItems();
                break;
            case "Sixth":
                spellsToUpdate = sixthTable.getItems();
                break;
            case "Seventh":
                spellsToUpdate = seventhTable.getItems();
                break;
            case "Eighth":
                spellsToUpdate = eighthTable.getItems();
                break;
            case "Ninth":
                spellsToUpdate = ninthTable.getItems();
                break;
            default:
                spellsToUpdate = FXCollections.observableArrayList();
                break;
        }

        return spellsToUpdate;
    }

    @FXML public AnchorPane basePane;
    @FXML public TabPane tabPane;
    @FXML public Tab cantrips;
    @FXML public TableView<Spell> cantripTable;
    @FXML public TableColumn<Spell, String> cantripName;
    @FXML public TableColumn<Spell, String> cantripEffect;
    @FXML public TableColumn<Spell, Integer> cantripSize;
    @FXML public TableColumn<Spell, Shape> cantripShape;
    @FXML public TableColumn<Spell, String> cantripRequirements;
    @FXML public Tab firstLevel;
    @FXML public TableView<Spell> firstTable;
    @FXML public TableColumn<Spell, String> firstName;
    @FXML public TableColumn<Spell, String> firstEffect;
    @FXML public TableColumn<Spell, Integer> firstSize;
    @FXML public TableColumn<Spell, Shape> firstShape;
    @FXML public TableColumn<Spell, String> firstRequirements;
    @FXML public Spinner<Integer> firstSlots;
    @FXML public Spinner<Integer> firstSlotsExpended;
    @FXML public Tab secondLevel;
    @FXML public TableView<Spell> secondTable;
    @FXML public TableColumn<Spell, String> secondName;
    @FXML public TableColumn<Spell, String> secondEffect;
    @FXML public TableColumn<Spell, Integer> secondSize;
    @FXML public TableColumn<Spell, Shape> secondShape;
    @FXML public TableColumn<Spell, String> secondRequirements;
    @FXML public Spinner<Integer> secondSlots;
    @FXML public Spinner<Integer> secondSlotsExpended;
    @FXML public Tab thirdLevel;
    @FXML public TableView<Spell> thirdTable;
    @FXML public TableColumn<Spell, String> thirdName;
    @FXML public TableColumn<Spell, String> thirdEffect;
    @FXML public TableColumn<Spell, Integer> thirdSize;
    @FXML public TableColumn<Spell, Shape> thirdShape;
    @FXML public TableColumn<Spell, String> thirdRequirements;
    @FXML public Spinner<Integer> thirdSlots;
    @FXML public Spinner<Integer> thirdSlotsExpended;
    @FXML public Tab forthLevel;
    @FXML public TableView<Spell> forthTable;
    @FXML public TableColumn<Spell, String> forthName;
    @FXML public TableColumn<Spell, String> forthEffect;
    @FXML public TableColumn<Spell, Integer> forthSize;
    @FXML public TableColumn<Spell, Shape> forthShape;
    @FXML public TableColumn<Spell, String> forthRequirements;
    @FXML public Spinner<Integer> forthSlots;
    @FXML public Spinner<Integer> forthSlotsExpended;
    @FXML public Tab fifthLevel;
    @FXML public TableView<Spell> fifthTable;
    @FXML public TableColumn<Spell, String> fifthName;
    @FXML public TableColumn<Spell, String> fifthEffect;
    @FXML public TableColumn<Spell, Integer> fifthSize;
    @FXML public TableColumn<Spell, Shape> fifthShape;
    @FXML public TableColumn<Spell, String> fifthRequirements;
    @FXML public Spinner<Integer> fifthSlots;
    @FXML public Spinner<Integer> fifthSlotsExpended;
    @FXML public Tab sixthLevel;
    @FXML public TableView<Spell> sixthTable;
    @FXML public TableColumn<Spell, String> sixthName;
    @FXML public TableColumn<Spell, String> sixthEffect;
    @FXML public TableColumn<Spell, Integer> sixthSize;
    @FXML public TableColumn<Spell, Shape> sixthShape;
    @FXML public TableColumn<Spell, String> sixthRequirements;
    @FXML public Spinner<Integer> sixthSlots;
    @FXML public Spinner<Integer> sixthSlotsExpended;
    @FXML public Tab seventhLevel;
    @FXML public TableView<Spell> seventhTable;
    @FXML public TableColumn<Spell, String> seventhName;
    @FXML public TableColumn<Spell, String> seventhEffect;
    @FXML public TableColumn<Spell, Integer> seventhSize;
    @FXML public TableColumn<Spell, Shape> seventhShape;
    @FXML public TableColumn<Spell, String> seventhRequirements;
    @FXML public Spinner<Integer> seventhSlots;
    @FXML public Spinner<Integer> seventhSlotsExpended;
    @FXML public Tab eighthLevel;
    @FXML public TableView<Spell> eighthTable;
    @FXML public TableColumn<Spell, String> eighthName;
    @FXML public TableColumn<Spell, String> eighthEffect;
    @FXML public TableColumn<Spell, Integer> eighthSize;
    @FXML public TableColumn<Spell, Shape> eighthShape;
    @FXML public TableColumn<Spell, String> eighthRequirements;
    @FXML public Spinner<Integer> eighthSlots;
    @FXML public Spinner<Integer> eighthSlotsExpended;
    @FXML public Tab ninthLevel;
    @FXML public TableView<Spell> ninthTable;
    @FXML public TableColumn<Spell, String> ninthName;
    @FXML public TableColumn<Spell, String> ninthEffect;
    @FXML public TableColumn<Spell, Integer> ninthSize;
    @FXML public TableColumn<Spell, Shape> ninthShape;
    @FXML public TableColumn<Spell, String> ninthRequirements;
    @FXML public Spinner<Integer> ninthSlots;
    @FXML public Spinner<Integer> ninthSlotsExpended;
    @FXML public Button addSpellButton;
    @FXML public Button removeSelected;
    @FXML public ComboBox<String> spellNameComboBox;
}
