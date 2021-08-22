package com.sjmulhern.dndTracker.sceneControllers;

import com.sjmulhern.dndTracker.App;
import com.sjmulhern.dndTracker.creatures.Condition;
import com.sjmulhern.dndTracker.creatures.Creature;
import com.sjmulhern.dndTracker.creatures.PlayerCharacter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class RecalculateInitiativeController {

    ArrayList<PlayerCharacter> playerCharacters = new ArrayList<>();

    public void addNewPlayer() {
        PlayerCharacter newPlayer =
                new PlayerCharacter("New Player " + new Random().nextInt(), 10, 0, 1.0, Condition.None);
        playerTableView.getItems().add(newPlayer);
        App.initativeRoundRobin.addCreature(newPlayer);
        playerNames.getItems().add(newPlayer.getName());
    }

    public void removeSelectedPressed() {
        String nameToRemove = playerNames.getValue();

        playerTableView.getItems().removeIf(element -> element.getName().equals(nameToRemove));
        playerNames.getItems().removeIf(element -> element.equals(nameToRemove));
        playerNames.setValue(null);
    }

    public void reRollPressed() throws IOException {
        App.initativeRoundRobin.recalculateInitative();
        App.mainSceneController.switchScene("CombatTracker");
    }

    public void initialize() {
        ArrayList<Creature> creatures = App.initativeRoundRobin.getCreatures();
        for (Creature creature : creatures) {
            if (creature instanceof PlayerCharacter) {
                playerCharacters.add((PlayerCharacter) creature);
            }
        }

        playerTableView.getItems().addAll(playerCharacters);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.setEditable(false);

        // Initialize the tables
        Integer[] sizeArray = {
            -10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
            16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30
        };

        initRollColumn.setCellValueFactory(new PropertyValueFactory<>("initiative"));
        initRollColumn.setCellFactory(ComboBoxTableCell.forTableColumn(sizeArray));
        initRollColumn.setOnEditCommit(
                event ->
                        (event.getTableView().getItems().get(event.getTablePosition().getRow()))
                                .setInitiative(event.getNewValue()));

        playerCharacters.forEach(character -> playerNames.getItems().add(character.getName()));
    }

    public TableColumn<PlayerCharacter, String> nameColumn;

    public TableColumn<PlayerCharacter, Integer> initRollColumn;

    public ComboBox<String> playerNames;

    public TableView<PlayerCharacter> playerTableView;
}
