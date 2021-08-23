package com.sjmulhern.dndTracker.sceneControllers;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.sjmulhern.dndTracker.App;
import com.sjmulhern.dndTracker.Encounter;
import java.io.IOException;
import java.util.function.Consumer;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.Document;

public class ImportFromDatabaseController {

    Encounter encounter = null;

    public void checkDatabasePressed() {
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

            FindIterable<Document> encounters = db.getCollection(collection).find();

            encounters.forEach(
                    (Consumer<? super Document>)
                            element -> {
                                JsonObject irr =
                                        JsonParser.parseString(element.getString("initativeRoundRobin"))
                                                .getAsJsonObject();
                                JsonObject eJson = new JsonObject();
                                eJson.addProperty("name", element.getString("name"));
                                eJson.addProperty("description", element.getString("description"));
                                eJson.add("initativeRoundRobin", irr);
                                encounter = new Encounter(eJson);
                                encounterTable.getItems().add(encounter);
                                importComboBox.getItems().add(encounter.getName());
                            });

            gridPane.setVisible(false);
            gridPane.setDisable(true);
            tablePane.setVisible(true);
            tablePane.setDisable(false);
        }
    }

    public void importSelectedPressed() throws IOException {
        String eName = importComboBox.getValue();

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

            MongoCollection<Document> mongoCollection = db.getCollection(collection);

            FindIterable<Document> foundDocuments =
                    mongoCollection.find(new BsonDocument().append("name", new BsonString(eName)));

            Document document = foundDocuments.first();

            assert document != null;
            JsonObject irr =
                    JsonParser.parseString(document.getString("initativeRoundRobin")).getAsJsonObject();
            JsonObject eJson = new JsonObject();
            eJson.addProperty("name", document.getString("name"));
            eJson.addProperty("description", document.getString("description"));
            eJson.add("initativeRoundRobin", irr);
            App.encounter = new Encounter(eJson);

            App.mainSceneController.switchScene("CombatTracker");
        }
    }

    public void initialize() {
        tablePane.setVisible(false);
        tablePane.setDisable(true);

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
    }

    public ComboBox<String> importComboBox;

    public AnchorPane tablePane;

    public AnchorPane gridPane;

    public TextField locationField;

    public TextField collectionField;

    public TextField usernameField;

    public TextField passwordField;

    public TextField databaseField;

    public TableView<Encounter> encounterTable;

    public TableColumn<Encounter, String> nameColumn;

    public TableColumn<Encounter, String> descriptionColumn;
}
