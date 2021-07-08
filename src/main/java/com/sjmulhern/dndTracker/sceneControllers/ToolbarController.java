package com.sjmulhern.dndTracker.sceneControllers;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.sjmulhern.dndTracker.App;
import com.sjmulhern.dndTracker.utils.JsonPackager;
import javafx.event.ActionEvent;
import javafx.scene.control.MenuButton;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ToolbarController {

    public void addNewCreaturePressed (ActionEvent actionEvent) {

    }

    public void editCreaturePressed (ActionEvent actionEvent) throws IOException {
        App.mainSceneController.switchScene("CreatureEditor");
    }

    public void deleteCreaturePressed (ActionEvent actionEvent) {

    }

    public MenuButton encounterPropertiesMenu;

    public void changeEncounterButtonPressed (ActionEvent actionEvent) {

    }

    public void importButtonPressed (ActionEvent actionEvent)
    throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Import an Encounter JSON file!");
        fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("JSON files", "json"));
        File file = fileChooser.showOpenDialog(App.pStage);
        App.encounterArray =
            JsonPackager
                .unpackage((JsonArray) JsonParser.parseReader(new FileReader(file)));
    }

    public void exportButtonPressed (ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Export an Encounter JSON file!");
        fileChooser.setInitialFileName("encounter.json");
        File file = fileChooser.showSaveDialog(App.pStage);
        if (file != null) {
            FileWriter fileWriter = new FileWriter(file);
            if (App.encounterArray != null) {
                fileWriter.write(JsonPackager.packageUp(App.encounterArray).toString());
            } else {
                fileWriter.write("[]");
            }
            fileWriter.close();
        }
    }

    public void mainMenuPressed (ActionEvent actionEvent) throws IOException {
        App.mainSceneController.switchScene("Main");
    }

}
