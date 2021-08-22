package com.sjmulhern.dndTracker.sceneControllers;

import static javafx.application.Platform.exit;

import com.sjmulhern.dndTracker.App;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ToolbarController {

    public void addNewCreaturePressed() throws IOException {
        // initializing the controller
        Parent layout;
        try {
            layout =
                    FXMLLoader.load(
                            Objects.requireNonNull(
                                    App.class.getResource("views/CreatureCreationPopupView.fxml")));
            Scene scene = new Scene(layout);
            // this is the popup stage
            Stage popupStage = new Stage();
            popupStage.initOwner(App.getPrimaryStage());
            popupStage.initModality(Modality.WINDOW_MODAL);
            popupStage.setScene(scene);
            popupStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }

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

    public void recalculateInitiativePressed() throws IOException {
        App.mainSceneController.switchScene("RecalculateInitiative");
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
            fileWriter.close();
        }
    }

    public void mainMenuPressed() throws IOException {
        App.mainSceneController.switchScene("Main");
    }

    @FXML public Button exitButton;
}
