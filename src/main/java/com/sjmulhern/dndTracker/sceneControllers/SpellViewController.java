package com.sjmulhern.dndTracker.sceneControllers;

import com.sjmulhern.dndTracker.App;
import com.sjmulhern.dndTracker.creatures.Creature;
import com.sjmulhern.dndTracker.creatures.Spells;
import com.sjmulhern.dndTracker.tools.Shape;
import com.sjmulhern.dndTracker.tools.Spell;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class SpellViewController {

    ArrayList<Tab> tabsToRemove = new ArrayList<>();

    Creature creature = App.getInitativeRoundRobin().getCurrent();

    public void reset(Spells spells) {
        if (spells == null) {
            return;
        }

        ArrayList<Spell> cantrips = spells.getCantrips();
        ArrayList<Spell> firstLevel = spells.getFirstLevel();
        ArrayList<Spell> secondLevel = spells.getSecondLevel();
        ArrayList<Spell> thirdLevel = spells.getThirdLevel();
        ArrayList<Spell> forthLevel = spells.getForthLevel();
        ArrayList<Spell> fifthLevel = spells.getFifthLevel();
        ArrayList<Spell> sixthLevel = spells.getSixthLevel();
        ArrayList<Spell> seventhLevel = spells.getSeventhLevel();
        ArrayList<Spell> eighthLevel = spells.getEighthLevel();
        ArrayList<Spell> ninthLevel = spells.getNinthLevel();

        if (cantrips != null && cantrips.size() != 0) {
            cantripTable.getItems().setAll(cantrips);
            cantripName.setCellValueFactory(new PropertyValueFactory<>("name"));
            cantripEffect.setCellValueFactory(new PropertyValueFactory<>("effect"));
            cantripSize.setCellValueFactory(new PropertyValueFactory<>("size"));
            cantripShape.setCellValueFactory(new PropertyValueFactory<>("shape"));
            cantripRequirements.setCellValueFactory(new PropertyValueFactory<>("requirements"));
        } else {
            tabsToRemove.add(this.cantrips);
        }

        if (firstLevel != null && firstLevel.size() != 0) {
            firstTable.getItems().setAll(firstLevel);
            firstName.setCellValueFactory(new PropertyValueFactory<>("name"));
            firstEffect.setCellValueFactory(new PropertyValueFactory<>("effect"));
            firstSize.setCellValueFactory(new PropertyValueFactory<>("size"));
            firstShape.setCellValueFactory(new PropertyValueFactory<>("shape"));
            firstRequirements.setCellValueFactory(new PropertyValueFactory<>("requirements"));
            firstSlots.setText(spells.getSlots().get(1) + "");

            SpinnerValueFactory<Integer> firstSlotsFactory =
                    new SpinnerValueFactory.IntegerSpinnerValueFactory(
                            0, spells.getSlots().get(1), spells.getSlotsUsed().get(1));
            firstSlotsExpended.setValueFactory(firstSlotsFactory);
            firstSlotsFactory
                    .valueProperty()
                    .addListener(
                            ((observable, oldValue, newValue) -> {
                                ArrayList<Integer> slotsUsed = spells.getSlotsUsed();
                                slotsUsed.set(1, newValue);
                                spells.setSlotsUsed(slotsUsed);
                            }));
        } else {
            tabsToRemove.add(this.firstLevel);
        }

        if (secondLevel != null && secondLevel.size() != 0) {
            secondTable.getItems().setAll(secondLevel);
            secondName.setCellValueFactory(new PropertyValueFactory<>("name"));
            secondEffect.setCellValueFactory(new PropertyValueFactory<>("effect"));
            secondSize.setCellValueFactory(new PropertyValueFactory<>("size"));
            secondShape.setCellValueFactory(new PropertyValueFactory<>("shape"));
            secondRequirements.setCellValueFactory(new PropertyValueFactory<>("requirements"));
            secondSlots.setText(spells.getSlots().get(2) + "");

            SpinnerValueFactory<Integer> secondSlotsFactory =
                    new SpinnerValueFactory.IntegerSpinnerValueFactory(
                            0, spells.getSlots().get(2), spells.getSlotsUsed().get(2));
            secondSlotsExpended.setValueFactory(secondSlotsFactory);
            secondSlotsFactory
                    .valueProperty()
                    .addListener(
                            ((observable, oldValue, newValue) -> {
                                ArrayList<Integer> slotsUsed = spells.getSlotsUsed();
                                slotsUsed.set(2, newValue);
                                spells.setSlotsUsed(slotsUsed);
                            }));
        } else {
            tabsToRemove.add(this.secondLevel);
        }

        if (thirdLevel != null && thirdLevel.size() != 0) {
            thirdTable.getItems().setAll(thirdLevel);
            thirdName.setCellValueFactory(new PropertyValueFactory<>("name"));
            thirdEffect.setCellValueFactory(new PropertyValueFactory<>("effect"));
            thirdSize.setCellValueFactory(new PropertyValueFactory<>("size"));
            thirdShape.setCellValueFactory(new PropertyValueFactory<>("shape"));
            thirdRequirements.setCellValueFactory(new PropertyValueFactory<>("requirements"));
            thirdSlots.setText(spells.getSlots().get(3) + "");

            SpinnerValueFactory<Integer> thirdSlotsFactory =
                    new SpinnerValueFactory.IntegerSpinnerValueFactory(
                            0, spells.getSlots().get(3), spells.getSlotsUsed().get(3));
            thirdSlotsExpended.setValueFactory(thirdSlotsFactory);
            thirdSlotsFactory
                    .valueProperty()
                    .addListener(
                            ((observable, oldValue, newValue) -> {
                                ArrayList<Integer> slotsUsed = spells.getSlotsUsed();
                                slotsUsed.set(3, newValue);
                                spells.setSlotsUsed(slotsUsed);
                            }));
        } else {
            tabsToRemove.add(this.thirdLevel);
        }

        if (forthLevel != null && forthLevel.size() != 0) {
            forthTable.getItems().setAll(forthLevel);
            forthName.setCellValueFactory(new PropertyValueFactory<>("name"));
            forthEffect.setCellValueFactory(new PropertyValueFactory<>("effect"));
            forthSize.setCellValueFactory(new PropertyValueFactory<>("size"));
            forthShape.setCellValueFactory(new PropertyValueFactory<>("shape"));
            forthRequirements.setCellValueFactory(new PropertyValueFactory<>("requirements"));
            forthSlots.setText(spells.getSlots().get(4) + "");

            SpinnerValueFactory<Integer> forthSlotsFactory =
                    new SpinnerValueFactory.IntegerSpinnerValueFactory(
                            0, spells.getSlots().get(4), spells.getSlotsUsed().get(4));
            forthSlotsExpended.setValueFactory(forthSlotsFactory);
            forthSlotsFactory
                    .valueProperty()
                    .addListener(
                            ((observable, oldValue, newValue) -> {
                                ArrayList<Integer> slotsUsed = spells.getSlotsUsed();
                                slotsUsed.set(4, newValue);
                                spells.setSlotsUsed(slotsUsed);
                            }));
        } else {
            tabsToRemove.add(this.forthLevel);
        }

        if (fifthLevel != null && fifthLevel.size() != 0) {
            fifthTable.getItems().setAll(fifthLevel);
            fifthName.setCellValueFactory(new PropertyValueFactory<>("name"));
            fifthEffect.setCellValueFactory(new PropertyValueFactory<>("effect"));
            fifthSize.setCellValueFactory(new PropertyValueFactory<>("size"));
            fifthShape.setCellValueFactory(new PropertyValueFactory<>("shape"));
            fifthRequirements.setCellValueFactory(new PropertyValueFactory<>("requirements"));
            fifthSlots.setText(spells.getSlots().get(5) + "");

            SpinnerValueFactory<Integer> fifthSlotsFactory =
                    new SpinnerValueFactory.IntegerSpinnerValueFactory(
                            0, spells.getSlots().get(5), spells.getSlotsUsed().get(5));
            fifthSlotsExpended.setValueFactory(fifthSlotsFactory);
            fifthSlotsFactory
                    .valueProperty()
                    .addListener(
                            ((observable, oldValue, newValue) -> {
                                ArrayList<Integer> slotsUsed = spells.getSlotsUsed();
                                slotsUsed.set(5, newValue);
                                spells.setSlotsUsed(slotsUsed);
                            }));
        } else {
            tabsToRemove.add(this.fifthLevel);
        }

        if (sixthLevel != null && sixthLevel.size() != 0) {
            sixthTable.getItems().setAll(sixthLevel);
            sixthName.setCellValueFactory(new PropertyValueFactory<>("name"));
            sixthEffect.setCellValueFactory(new PropertyValueFactory<>("effect"));
            sixthSize.setCellValueFactory(new PropertyValueFactory<>("size"));
            sixthShape.setCellValueFactory(new PropertyValueFactory<>("shape"));
            sixthRequirements.setCellValueFactory(new PropertyValueFactory<>("requirements"));
            sixthSlots.setText(spells.getSlots().get(6) + "");

            SpinnerValueFactory<Integer> sixthSlotsFactory =
                    new SpinnerValueFactory.IntegerSpinnerValueFactory(
                            0, spells.getSlots().get(6), spells.getSlotsUsed().get(6));
            sixthSlotsExpended.setValueFactory(sixthSlotsFactory);
            sixthSlotsFactory
                    .valueProperty()
                    .addListener(
                            ((observable, oldValue, newValue) -> {
                                ArrayList<Integer> slotsUsed = spells.getSlotsUsed();
                                slotsUsed.set(6, newValue);
                                spells.setSlotsUsed(slotsUsed);
                            }));
        } else {
            tabsToRemove.add(this.sixthLevel);
        }

        if (seventhLevel != null && seventhLevel.size() != 0) {
            seventhTable.getItems().setAll(seventhLevel);
            seventhName.setCellValueFactory(new PropertyValueFactory<>("name"));
            seventhEffect.setCellValueFactory(new PropertyValueFactory<>("effect"));
            seventhSize.setCellValueFactory(new PropertyValueFactory<>("size"));
            seventhShape.setCellValueFactory(new PropertyValueFactory<>("shape"));
            seventhRequirements.setCellValueFactory(new PropertyValueFactory<>("requirements"));
            seventhSlots.setText(spells.getSlots().get(7) + "");

            SpinnerValueFactory<Integer> seventhSlotsFactory =
                    new SpinnerValueFactory.IntegerSpinnerValueFactory(
                            0, spells.getSlots().get(7), spells.getSlotsUsed().get(7));
            seventhSlotsExpended.setValueFactory(seventhSlotsFactory);
            seventhSlotsFactory
                    .valueProperty()
                    .addListener(
                            ((observable, oldValue, newValue) -> {
                                ArrayList<Integer> slotsUsed = spells.getSlotsUsed();
                                slotsUsed.set(7, newValue);
                                spells.setSlotsUsed(slotsUsed);
                            }));
        } else {
            tabsToRemove.add(this.seventhLevel);
        }

        if (eighthLevel != null && eighthLevel.size() != 0) {
            eighthTable.getItems().setAll(eighthLevel);
            eighthName.setCellValueFactory(new PropertyValueFactory<>("name"));
            eighthEffect.setCellValueFactory(new PropertyValueFactory<>("effect"));
            eighthSize.setCellValueFactory(new PropertyValueFactory<>("size"));
            eighthShape.setCellValueFactory(new PropertyValueFactory<>("shape"));
            eighthRequirements.setCellValueFactory(new PropertyValueFactory<>("requirements"));
            eighthSlots.setText(spells.getSlots().get(8) + "");

            SpinnerValueFactory<Integer> eighthSlotsFactory =
                    new SpinnerValueFactory.IntegerSpinnerValueFactory(
                            0, spells.getSlots().get(8), spells.getSlotsUsed().get(8));
            eighthSlotsExpended.setValueFactory(eighthSlotsFactory);
            eighthSlotsFactory
                    .valueProperty()
                    .addListener(
                            ((observable, oldValue, newValue) -> {
                                ArrayList<Integer> slotsUsed = spells.getSlotsUsed();
                                slotsUsed.set(8, newValue);
                                spells.setSlotsUsed(slotsUsed);
                            }));
        } else {
            tabsToRemove.add(this.eighthLevel);
        }

        if (ninthLevel != null && ninthLevel.size() != 0 && ninthTable != null) {
            ninthTable.getItems().setAll(ninthLevel);
            ninthName.setCellValueFactory(new PropertyValueFactory<>("name"));
            ninthEffect.setCellValueFactory(new PropertyValueFactory<>("effect"));
            ninthSize.setCellValueFactory(new PropertyValueFactory<>("size"));
            ninthShape.setCellValueFactory(new PropertyValueFactory<>("shape"));
            ninthRequirements.setCellValueFactory(new PropertyValueFactory<>("requirements"));
            ninthSlots.setText(spells.getSlots().get(9) + "");

            SpinnerValueFactory<Integer> ninthSlotsFactory =
                    new SpinnerValueFactory.IntegerSpinnerValueFactory(
                            0, spells.getSlots().get(9), spells.getSlotsUsed().get(9));
            ninthSlotsExpended.setValueFactory(ninthSlotsFactory);
            ninthSlotsFactory
                    .valueProperty()
                    .addListener(
                            ((observable, oldValue, newValue) -> {
                                ArrayList<Integer> slotsUsed = spells.getSlotsUsed();
                                slotsUsed.set(9, newValue);
                                spells.setSlotsUsed(slotsUsed);
                            }));
        } else {
            tabsToRemove.add(this.ninthLevel);
        }

        if (tabPane != null) {
            tabPane.getTabs().removeAll(tabsToRemove);
        }
    }

    public void initialize() {
        creature = App.getInitativeRoundRobin().getCurrent();
        reset(creature.getSpells());
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
    @FXML public Label firstSlots;
    @FXML public Spinner<Integer> firstSlotsExpended;
    @FXML public Tab secondLevel;
    @FXML public TableView<Spell> secondTable;
    @FXML public TableColumn<Spell, String> secondName;
    @FXML public TableColumn<Spell, String> secondEffect;
    @FXML public TableColumn<Spell, Integer> secondSize;
    @FXML public TableColumn<Spell, Shape> secondShape;
    @FXML public TableColumn<Spell, String> secondRequirements;
    @FXML public Label secondSlots;
    @FXML public Spinner<Integer> secondSlotsExpended;
    @FXML public Tab thirdLevel;
    @FXML public TableView<Spell> thirdTable;
    @FXML public TableColumn<Spell, String> thirdName;
    @FXML public TableColumn<Spell, String> thirdEffect;
    @FXML public TableColumn<Spell, Integer> thirdSize;
    @FXML public TableColumn<Spell, Shape> thirdShape;
    @FXML public TableColumn<Spell, String> thirdRequirements;
    @FXML public Label thirdSlots;
    @FXML public Spinner<Integer> thirdSlotsExpended;
    @FXML public Tab forthLevel;
    @FXML public TableView<Spell> forthTable;
    @FXML public TableColumn<Spell, String> forthName;
    @FXML public TableColumn<Spell, String> forthEffect;
    @FXML public TableColumn<Spell, Integer> forthSize;
    @FXML public TableColumn<Spell, Shape> forthShape;
    @FXML public TableColumn<Spell, String> forthRequirements;
    @FXML public Label forthSlots;
    @FXML public Spinner<Integer> forthSlotsExpended;
    @FXML public Tab fifthLevel;
    @FXML public TableView<Spell> fifthTable;
    @FXML public TableColumn<Spell, String> fifthName;
    @FXML public TableColumn<Spell, String> fifthEffect;
    @FXML public TableColumn<Spell, Integer> fifthSize;
    @FXML public TableColumn<Spell, Shape> fifthShape;
    @FXML public TableColumn<Spell, String> fifthRequirements;
    @FXML public Label fifthSlots;
    @FXML public Spinner<Integer> fifthSlotsExpended;
    @FXML public Tab sixthLevel;
    @FXML public TableView<Spell> sixthTable;
    @FXML public TableColumn<Spell, String> sixthName;
    @FXML public TableColumn<Spell, String> sixthEffect;
    @FXML public TableColumn<Spell, Integer> sixthSize;
    @FXML public TableColumn<Spell, Shape> sixthShape;
    @FXML public TableColumn<Spell, String> sixthRequirements;
    @FXML public Label sixthSlots;
    @FXML public Spinner<Integer> sixthSlotsExpended;
    @FXML public Tab seventhLevel;
    @FXML public TableView<Spell> seventhTable;
    @FXML public TableColumn<Spell, String> seventhName;
    @FXML public TableColumn<Spell, String> seventhEffect;
    @FXML public TableColumn<Spell, Integer> seventhSize;
    @FXML public TableColumn<Spell, Shape> seventhShape;
    @FXML public TableColumn<Spell, String> seventhRequirements;
    @FXML public Label seventhSlots;
    @FXML public Spinner<Integer> seventhSlotsExpended;
    @FXML public Tab eighthLevel;
    @FXML public TableView<Spell> eighthTable;
    @FXML public TableColumn<Spell, String> eighthName;
    @FXML public TableColumn<Spell, String> eighthEffect;
    @FXML public TableColumn<Spell, Integer> eighthSize;
    @FXML public TableColumn<Spell, Shape> eighthShape;
    @FXML public TableColumn<Spell, String> eighthRequirements;
    @FXML public Label eighthSlots;
    @FXML public Spinner<Integer> eighthSlotsExpended;
    @FXML public Tab ninthLevel;
    @FXML public TableView<Spell> ninthTable;
    @FXML public TableColumn<Spell, String> ninthName;
    @FXML public TableColumn<Spell, String> ninthEffect;
    @FXML public TableColumn<Spell, Integer> ninthSize;
    @FXML public TableColumn<Spell, Shape> ninthShape;
    @FXML public TableColumn<Spell, String> ninthRequirements;
    @FXML public Label ninthSlots;
    @FXML public Spinner<Integer> ninthSlotsExpended;
}
