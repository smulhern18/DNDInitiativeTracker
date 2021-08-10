package com.sjmulhern.dndTracker.sceneControllers;

import com.sjmulhern.dndTracker.App;
import com.sjmulhern.dndTracker.creatures.Creature;
import com.sjmulhern.dndTracker.creatures.Spells;
import com.sjmulhern.dndTracker.tools.Shape;
import com.sjmulhern.dndTracker.tools.Spell;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SpellViewController {

    Creature creature = App.currentCreature;

    public void reset(Spells spells) {
        if (spells == null) {
            tabPane.setVisible(false);
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

        ArrayList<Tab> tabsToRemove = new ArrayList<>();

        if (cantrips != null && cantrips.size() != 0) {
            cantripTable.getItems().addAll(cantrips);
            cantripName.setCellValueFactory(new PropertyValueFactory<>("name"));
            cantripEffect.setCellValueFactory(new PropertyValueFactory<>("effect"));
            cantripSize.setCellValueFactory(new PropertyValueFactory<>("size"));
            cantripShape.setCellValueFactory(new PropertyValueFactory<>("shape"));
            cantripRequirements.setCellValueFactory(new PropertyValueFactory<>("requirements"));
        } else {
            tabsToRemove.add(this.cantrips);
        }

        if (firstLevel != null && firstLevel.size() != 0) {
            firstTable.getItems().addAll(firstLevel);
            firstName.setCellValueFactory(new PropertyValueFactory<>("name"));
            firstEffect.setCellValueFactory(new PropertyValueFactory<>("effect"));
            firstSize.setCellValueFactory(new PropertyValueFactory<>("size"));
            firstShape.setCellValueFactory(new PropertyValueFactory<>("shape"));
            firstRequirements.setCellValueFactory(new PropertyValueFactory<>("requirements"));
            firstSlots.setText(spells.getSlots().get(1) + "");
            firstSlotsExpended.setText(spells.getSlotsUsed().get(1) + "");
        } else {
            tabsToRemove.add(this.firstLevel);
        }

        if (secondLevel != null && secondLevel.size() != 0) {
            secondTable.getItems().addAll(secondLevel);
            secondName.setCellValueFactory(new PropertyValueFactory<>("name"));
            secondEffect.setCellValueFactory(new PropertyValueFactory<>("effect"));
            secondSize.setCellValueFactory(new PropertyValueFactory<>("size"));
            secondShape.setCellValueFactory(new PropertyValueFactory<>("shape"));
            secondRequirements.setCellValueFactory(new PropertyValueFactory<>("requirements"));
            secondSlots.setText(spells.getSlots().get(2) + "");
            secondSlotsExpended.setText(spells.getSlotsUsed().get(2) + "");
        } else {
            tabsToRemove.add(this.secondLevel);
        }

        if (thirdLevel != null && thirdLevel.size() != 0) {
            thirdTable.getItems().addAll(thirdLevel);
            thirdName.setCellValueFactory(new PropertyValueFactory<>("name"));
            thirdEffect.setCellValueFactory(new PropertyValueFactory<>("effect"));
            thirdSize.setCellValueFactory(new PropertyValueFactory<>("size"));
            thirdShape.setCellValueFactory(new PropertyValueFactory<>("shape"));
            thirdRequirements.setCellValueFactory(new PropertyValueFactory<>("requirements"));
            thirdSlots.setText(spells.getSlots().get(3) + "");
            thirdSlotsExpended.setText(spells.getSlotsUsed().get(3) + "");
        } else {
            tabsToRemove.add(this.thirdLevel);
        }

        if (forthLevel != null && forthLevel.size() != 0) {
            forthTable.getItems().addAll(forthLevel);
            forthName.setCellValueFactory(new PropertyValueFactory<>("name"));
            forthEffect.setCellValueFactory(new PropertyValueFactory<>("effect"));
            forthSize.setCellValueFactory(new PropertyValueFactory<>("size"));
            forthShape.setCellValueFactory(new PropertyValueFactory<>("shape"));
            forthRequirements.setCellValueFactory(new PropertyValueFactory<>("requirements"));
            forthSlots.setText(spells.getSlots().get(4) + "");
            forthSlotsExpended.setText(spells.getSlotsUsed().get(4) + "");
        } else {
            tabsToRemove.add(this.forthLevel);
        }

        if (fifthLevel != null && fifthLevel.size() != 0) {
            fifthTable.getItems().addAll(fifthLevel);
            fifthName.setCellValueFactory(new PropertyValueFactory<>("name"));
            fifthEffect.setCellValueFactory(new PropertyValueFactory<>("effect"));
            fifthSize.setCellValueFactory(new PropertyValueFactory<>("size"));
            fifthShape.setCellValueFactory(new PropertyValueFactory<>("shape"));
            fifthRequirements.setCellValueFactory(new PropertyValueFactory<>("requirements"));
            fifthSlots.setText(spells.getSlots().get(5) + "");
            fifthSlotsExpended.setText(spells.getSlotsUsed().get(5) + "");
        } else {
            tabsToRemove.add(this.fifthLevel);
        }

        if (sixthLevel != null && sixthLevel.size() != 0) {
            sixthTable.getItems().addAll(sixthLevel);
            sixthName.setCellValueFactory(new PropertyValueFactory<>("name"));
            sixthEffect.setCellValueFactory(new PropertyValueFactory<>("effect"));
            sixthSize.setCellValueFactory(new PropertyValueFactory<>("size"));
            sixthShape.setCellValueFactory(new PropertyValueFactory<>("shape"));
            sixthRequirements.setCellValueFactory(new PropertyValueFactory<>("requirements"));
            sixthSlots.setText(spells.getSlots().get(6) + "");
            sixthSlotsExpended.setText(spells.getSlotsUsed().get(6) + "");
        } else {
            tabsToRemove.add(this.sixthLevel);
        }

        if (seventhLevel != null && seventhLevel.size() != 0) {
            seventhTable.getItems().addAll(seventhLevel);
            seventhName.setCellValueFactory(new PropertyValueFactory<>("name"));
            seventhEffect.setCellValueFactory(new PropertyValueFactory<>("effect"));
            seventhSize.setCellValueFactory(new PropertyValueFactory<>("size"));
            seventhShape.setCellValueFactory(new PropertyValueFactory<>("shape"));
            seventhRequirements.setCellValueFactory(new PropertyValueFactory<>("requirements"));
            seventhSlots.setText(spells.getSlots().get(7) + "");
            seventhSlotsExpended.setText(spells.getSlotsUsed().get(7) + "");
        } else {
            tabsToRemove.add(this.seventhLevel);
        }

        if (eighthLevel != null && eighthLevel.size() != 0) {
            eighthTable.getItems().addAll(eighthLevel);
            eighthName.setCellValueFactory(new PropertyValueFactory<>("name"));
            eighthEffect.setCellValueFactory(new PropertyValueFactory<>("effect"));
            eighthSize.setCellValueFactory(new PropertyValueFactory<>("size"));
            eighthShape.setCellValueFactory(new PropertyValueFactory<>("shape"));
            eighthRequirements.setCellValueFactory(new PropertyValueFactory<>("requirements"));
            eighthSlots.setText(spells.getSlots().get(8) + "");
            eighthSlotsExpended.setText(spells.getSlotsUsed().get(8) + "");
        } else {
            tabsToRemove.add(this.eighthLevel);
        }

        if (ninthLevel != null && ninthLevel.size() != 0) {
            ninthTable.getItems().addAll(ninthLevel);
            ninthName.setCellValueFactory(new PropertyValueFactory<>("name"));
            ninthEffect.setCellValueFactory(new PropertyValueFactory<>("effect"));
            ninthSize.setCellValueFactory(new PropertyValueFactory<>("size"));
            ninthShape.setCellValueFactory(new PropertyValueFactory<>("shape"));
            ninthRequirements.setCellValueFactory(new PropertyValueFactory<>("requirements"));
            ninthSlots.setText(spells.getSlots().get(9) + "");
            ninthSlotsExpended.setText(spells.getSlotsUsed().get(9) + "");
        } else {
            tabsToRemove.add(this.ninthLevel);
        }

        tabPane.getTabs().removeAll(tabsToRemove);
    }

    public void initialize() {
        if (creature != null) {
            reset(creature.getSpells());
        }
    }

    public void start(Stage stage) {
        creature = App.currentCreature;
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
    @FXML public Label firstSlotsExpended;
    @FXML public Tab secondLevel;
    @FXML public TableView<Spell> secondTable;
    @FXML public TableColumn<Spell, String> secondName;
    @FXML public TableColumn<Spell, String> secondEffect;
    @FXML public TableColumn<Spell, Integer> secondSize;
    @FXML public TableColumn<Spell, Shape> secondShape;
    @FXML public TableColumn<Spell, String> secondRequirements;
    @FXML public Label secondSlots;
    @FXML public Label secondSlotsExpended;
    @FXML public Tab thirdLevel;
    @FXML public TableView<Spell> thirdTable;
    @FXML public TableColumn<Spell, String> thirdName;
    @FXML public TableColumn<Spell, String> thirdEffect;
    @FXML public TableColumn<Spell, Integer> thirdSize;
    @FXML public TableColumn<Spell, Shape> thirdShape;
    @FXML public TableColumn<Spell, String> thirdRequirements;
    @FXML public Label thirdSlots;
    @FXML public Label thirdSlotsExpended;
    @FXML public Tab forthLevel;
    @FXML public TableView<Spell> forthTable;
    @FXML public TableColumn<Spell, String> forthName;
    @FXML public TableColumn<Spell, String> forthEffect;
    @FXML public TableColumn<Spell, Integer> forthSize;
    @FXML public TableColumn<Spell, Shape> forthShape;
    @FXML public TableColumn<Spell, String> forthRequirements;
    @FXML public Label forthSlots;
    @FXML public Label forthSlotsExpended;
    @FXML public Tab fifthLevel;
    @FXML public TableView<Spell> fifthTable;
    @FXML public TableColumn<Spell, String> fifthName;
    @FXML public TableColumn<Spell, String> fifthEffect;
    @FXML public TableColumn<Spell, Integer> fifthSize;
    @FXML public TableColumn<Spell, Shape> fifthShape;
    @FXML public TableColumn<Spell, String> fifthRequirements;
    @FXML public Label fifthSlots;
    @FXML public Label fifthSlotsExpended;
    @FXML public Tab sixthLevel;
    @FXML public TableView<Spell> sixthTable;
    @FXML public TableColumn<Spell, String> sixthName;
    @FXML public TableColumn<Spell, String> sixthEffect;
    @FXML public TableColumn<Spell, Integer> sixthSize;
    @FXML public TableColumn<Spell, Shape> sixthShape;
    @FXML public TableColumn<Spell, String> sixthRequirements;
    @FXML public Label sixthSlots;
    @FXML public Label sixthSlotsExpended;
    @FXML public Tab seventhLevel;
    @FXML public TableView<Spell> seventhTable;
    @FXML public TableColumn<Spell, String> seventhName;
    @FXML public TableColumn<Spell, String> seventhEffect;
    @FXML public TableColumn<Spell, Integer> seventhSize;
    @FXML public TableColumn<Spell, Shape> seventhShape;
    @FXML public TableColumn<Spell, String> seventhRequirements;
    @FXML public Label seventhSlots;
    @FXML public Label seventhSlotsExpended;
    @FXML public Tab eighthLevel;
    @FXML public TableView<Spell> eighthTable;
    @FXML public TableColumn<Spell, String> eighthName;
    @FXML public TableColumn<Spell, String> eighthEffect;
    @FXML public TableColumn<Spell, Integer> eighthSize;
    @FXML public TableColumn<Spell, Shape> eighthShape;
    @FXML public TableColumn<Spell, String> eighthRequirements;
    @FXML public Label eighthSlots;
    @FXML public Label eighthSlotsExpended;
    @FXML public Tab ninthLevel;
    @FXML public TableView<Spell> ninthTable;
    @FXML public TableColumn<Spell, String> ninthName;
    @FXML public TableColumn<Spell, String> ninthEffect;
    @FXML public TableColumn<Spell, Integer> ninthSize;
    @FXML public TableColumn<Spell, Shape> ninthShape;
    @FXML public TableColumn<Spell, String> ninthRequirements;
    @FXML public Label ninthSlots;
    @FXML public Label ninthSlotsExpended;
}
