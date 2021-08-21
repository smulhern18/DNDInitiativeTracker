package com.sjmulhern.dndTracker.sceneControllers;

import static javafx.application.Platform.exit;

import com.sjmulhern.dndTracker.App;
import com.sjmulhern.dndTracker.creatures.Alignment;
import com.sjmulhern.dndTracker.creatures.Condition;
import com.sjmulhern.dndTracker.creatures.NonPlayerCharacter;
import com.sjmulhern.dndTracker.creatures.Size;
import com.sjmulhern.dndTracker.creatures.Spells;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.stage.FileChooser;

public class ToolbarController {

    public void addNewCreaturePressed() throws IOException {
        String name = "" + (new Random().nextInt() % 50000);
        App.initativeRoundRobin.addCreature(
                new NonPlayerCharacter(
                        name,
                        "This is a brand spanking new Creature," +
                        " please change the randomly generated name",
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

        App.initativeRoundRobin.setCurrentCreature(name);
        App.mainSceneController.switchScene("CreatureEditor");
    }

    public void editCreaturePressed() throws IOException {
        App.mainSceneController.switchScene("CreatureEditor");
    }

    public void deleteCreaturePressed() {}

    public void initiativeControllerPressed() throws IOException {
        int current = App.initativeRoundRobin.getCurrentIndex();
        App.initativeRoundRobin.setCurrentIndex(
                App.initativeRoundRobin.getCreatures().size() + current - 1);
        App.mainSceneController.switchScene("CombatTracker");
    }

    public void exitPressed() {
        exit();
    }

    public MenuButton encounterPropertiesMenu;

    public void changeEncounterButtonPressed() {}

    public void importButtonPressed() throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Import an Encounter JSON file!");
        fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("JSON files", "json"));
        File file = fileChooser.showOpenDialog(App.pStage);
    }

    public void exportButtonPressed() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Export an Encounter JSON file!");
        fileChooser.setInitialFileName("encounter.json");
        File file = fileChooser.showSaveDialog(App.pStage);
        if (file != null) {
            FileWriter fileWriter = new FileWriter(file);
            if (App.encounterArray != null) {
            } else {
                fileWriter.write("[]");
            }
            fileWriter.close();
        }
    }

    public void mainMenuPressed() throws IOException {
        App.mainSceneController.switchScene("Main");
    }

    @FXML public Button exitButton;
}
