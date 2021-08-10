package com.sjmulhern.dndTracker.sceneControllers;

import static javafx.application.Platform.exit;

import com.sjmulhern.dndTracker.App;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.stage.FileChooser;

public class ToolbarController {

    public void addNewCreaturePressed() {}

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

    public void changeEncounterButtonPressed(ActionEvent actionEvent) {}

    public void importButtonPressed(ActionEvent actionEvent) throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Import an Encounter JSON file!");
        fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("JSON files", "json"));
        File file = fileChooser.showOpenDialog(App.pStage);
    }

    public void exportButtonPressed(ActionEvent actionEvent) throws IOException {
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

    public void mainMenuPressed(ActionEvent actionEvent) throws IOException {
        App.mainSceneController.switchScene("Main");
    }

    @FXML public Button exitButton;
}
