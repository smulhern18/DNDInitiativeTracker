package com.sjmulhern.dndTracker.sceneControllers;

import com.google.gson.JsonObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import com.sjmulhern.dndTracker.App;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import org.bson.Document;

public class ExportEncounterController {

    public void exportToFilePressed() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Export an Encounter JSON file!");
        fileChooser.setInitialFileName(App.encounter.getName() + ".json");
        File file = fileChooser.showSaveDialog(App.getPrimaryStage());
        if (file != null) {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(App.encounter.toString());
            fileWriter.close();
        }
        App.encounter = null;
        App.mainSceneController.switchScene("Main");
    }

    public void exportToDatabasePressed() throws IOException {
        String location = locationField.getText();
        String collection = collectionField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();
        String database = databaseField.getText();

        if (location != null
                && collection != null
                && username != null
                && password != null
                && database != null) {
            ServerAddress address = new ServerAddress(location);
            MongoCredential credential =
                    MongoCredential.createCredential(username, "admin", password.toCharArray());
            MongoClient mongo =
                    new MongoClient(address, credential, MongoClientOptions.builder().build());

            MongoDatabase db = mongo.getDatabase(database);

            Document newEncounter = new Document();
            JsonObject encounterJson = App.encounter.toJson();

            newEncounter.append("name", encounterJson.get("name").getAsString());
            newEncounter.append("description", encounterJson.get("description").getAsString());
            newEncounter.append(
                    "initativeRoundRobin", encounterJson.get("initativeRoundRobin").toString());

            db.getCollection(collection).insertOne(newEncounter);

            App.encounter = null;
            App.mainSceneController.switchScene("Main");
        }
    }

    @FXML public TextField locationField;
    @FXML public TextField collectionField;
    @FXML public TextField usernameField;
    @FXML public TextField passwordField;
    @FXML public TextField databaseField;
}
