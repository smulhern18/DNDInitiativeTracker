package com.sjmulhern.dndTracker.sceneControllers;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sjmulhern.dndTracker.App;
import com.sjmulhern.dndTracker.Encounter;
import com.sjmulhern.dndTracker.InitativeRoundRobin;
import com.sjmulhern.dndTracker.creatures.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class GetEncounterController {

    public void importFromComputer() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Encounter JSON File");
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("JSON Files", "*.json"));
        File selectedFile = fileChooser.showOpenDialog(App.getPrimaryStage());
        BufferedReader buffRead = new BufferedReader(new FileReader(selectedFile));
        String fullLine = "";
        String line;
        while ((line = buffRead.readLine()) != null) {
            fullLine += line;
        }
        JsonObject encounterJson = JsonParser.parseString(fullLine).getAsJsonObject();
        encounterJson.remove("name");
        encounterJson.addProperty(
                "name", selectedFile.getName().substring(0, selectedFile.getName().indexOf('.')));
        App.encounter = new Encounter(encounterJson);
        App.mainSceneController.switchScene("CombatTracker");
    }

    public void importFromDatabase() throws IOException {
        App.mainSceneController.switchScene("ImportFromDatabase");
    }

    public void brandNewEncounter() throws IOException {

        InitativeRoundRobin irr = new InitativeRoundRobin();
        irr.addCreature(
                new NonPlayerCharacter(
                        "A brand new Encounter!",
                        "description",
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
                        10,
                        10,
                        10,
                        1.0,
                        Condition.None,
                        null,
                        new ArrayList<>(),
                        new ArrayList<>(),
                        new ArrayList<>()));

        App.encounter = new Encounter("New Encounter!", "The description of the encounter", irr);
        App.mainSceneController.switchScene("CombatTracker");
    }
}
