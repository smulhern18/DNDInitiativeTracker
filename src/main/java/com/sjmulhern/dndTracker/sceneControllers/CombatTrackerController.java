package com.sjmulhern.dndTracker.sceneControllers;

import com.sjmulhern.dndTracker.App;
import com.sjmulhern.dndTracker.InitativeRoundRobin;
import com.sjmulhern.dndTracker.creatures.Condition;
import com.sjmulhern.dndTracker.creatures.Creature;
import com.sjmulhern.dndTracker.creatures.Language;
import com.sjmulhern.dndTracker.creatures.Monster;
import com.sjmulhern.dndTracker.creatures.PlayerCharacter;
import com.sjmulhern.dndTracker.creatures.Skill;
import com.sjmulhern.dndTracker.creatures.Type;
import com.sjmulhern.dndTracker.tools.Ability;
import com.sjmulhern.dndTracker.tools.Tool;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CombatTrackerController {

    public void viewModifiersPressed() {
        // initializing the controller
        DamageModifierController popupController = new DamageModifierController();
        Parent layout;
        try {
            layout =
                    FXMLLoader.load(
                            Objects.requireNonNull(App.class.getResource("views/DamageModifierView.fxml")));
            Scene scene = new Scene(layout);
            // this is the popup stage
            Stage popupStage = new Stage();
            // Giving the popup controller access to the popup stage (to allow the
            // controller to close the
            // stage)
            popupController.setStage(popupStage);
            popupStage.initOwner(App.getPrimaryStage());
            popupStage.initModality(Modality.WINDOW_MODAL);
            popupStage.setScene(scene);
            popupStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Creature creature = null;

    public void openButtonPressed() {
        String creatureName = creatureNames.getValue();

        ArrayList<Creature> creatures = App.initativeRoundRobin.getCreatures();

        Creature wantedCreature = null;
        for (Creature creature : creatures) {
            if (creature.getName().equals(creatureName)) {
                wantedCreature = creature;
            }
        }

        if (wantedCreature != null) {
            creature = wantedCreature;
            reset();
        }
    }

    InitativeRoundRobin initativeRoundRobin = App.initativeRoundRobin;

    public void nextInitiativeButtonPressed() {
        creature = initativeRoundRobin.getNext();
        reset();
    }

    public void reset() {
        creatureNames.setValue(creature.getName());
        nameLabel.setText(creature.getName());
        descriptionLabel.setText(creature.getDescription());
        alignmentLabel.setText(creature.getAlignment().toString());
        sizeLabel.setText(creature.getSize().toString());
        if (!(creature instanceof PlayerCharacter)) {
            movementSpeedLabel.setText(creature.getMovementSpeed() + "");
            swimmingSpeedLabel.setText(creature.getSwimSpeed() + "");
            climbingSpeedLabel.setText(creature.getClimbSpeed() + "");
            flyingSpeedLabel.setText(creature.getFlySpeed() + "");

            strLabel.setText(creature.getStrength() + " (" + (creature.getStrength() - 10) / 2 + ") ");
            dexLabel.setText(creature.getDexterity() + " (" + (creature.getDexterity() - 10) / 2 + ") ");
            contLabel.setText(
                    creature.getConstitution() + " (" + (creature.getConstitution() - 10) / 2 + ") ");
            intLabel.setText(
                    creature.getIntelligence() + " (" + (creature.getIntelligence() - 10) / 2 + ") ");
            wisLabel.setText(creature.getWisdom() + " (" + (creature.getWisdom() - 10) / 2 + ") ");
            chaLabel.setText(creature.getCharisma() + " (" + (creature.getCharisma() - 10) / 2 + ") ");

            ObservableList<Ability> abilitiesObservable = FXCollections.observableArrayList();
            abilitiesObservable.addAll(creature.getAbilities());
            abilitiesNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            abilitiesDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
            abilityTable.setItems(abilitiesObservable);

            ObservableList<Tool> toolsObservable = FXCollections.observableArrayList();
            toolsObservable.addAll(creature.getTools());
            toolsNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            toolsDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
            toolsToHitColumn.setCellValueFactory(new PropertyValueFactory<>("toHit"));
            toolsDamageColumn.setCellValueFactory(new PropertyValueFactory<>("damage"));
            toolsDamageTypeColumn.setCellValueFactory(
                    cellData -> new SimpleStringProperty(cellData.getValue().getDamageType().toString()));
            weaponsTable.setItems(toolsObservable);

            String languagesString = "";
            for (Language language : creature.getLanguages()) {
                if (language == Language.DeepSpeech) {
                    languagesString += "Deep Speech, ";
                } else {
                    languagesString += (language.toString() + ", ");
                }
            }
            if (languagesString.length() > 5) {
                languagesString.trim();
                languagesString = languagesString.substring(0, (languagesString.length() - 2));
            } else {
                languagesString = "None";
            }
            languagesLabel.setText(languagesString);

            String skillsString = "";
            for (Skill skill : creature.getSkills()) {
                if (skill == Skill.AnimalHandling) {
                    skillsString += "Animal Handling, ";
                } else if (skill == Skill.SlightOfHand) {
                    skillsString += "Slight of Hand, ";
                } else {
                    skillsString += (skill.toString() + ", ");
                }
            }
            if (skillsString.length() > 5) {
                skillsString.trim();
                skillsString = skillsString.substring(0, (skillsString.length() - 2));
            } else {
                skillsString = "None";
            }
            skillsLabel.setText(skillsString);
        } else {
            descriptionLabel.setText("Player Character, Ask for stats");

            movementSpeedLabel.setText("");
            swimmingSpeedLabel.setText("");
            climbingSpeedLabel.setText("");
            flyingSpeedLabel.setText("");

            strLabel.setText("");
            dexLabel.setText("");
            contLabel.setText("");
            intLabel.setText("");
            wisLabel.setText("");
            chaLabel.setText("");

            languagesLabel.setText("");
            skillsLabel.setText("");
        }

        if (creature instanceof Monster) {
            creatureTypeLabel.setText(((Monster) creature).getType().toString());
            levelDescriptor.setText("DC:");
        } else {
            creatureTypeLabel.setText(Type.None.toString());
            levelDescriptor.setText("Level:");
        }

        if (creature instanceof PlayerCharacter) {
            viewModifiersButton.setDisable(true);
            viewModifiersButton.setVisible(false);
        } else {
            viewModifiersButton.setDisable(false);
            viewModifiersButton.setVisible(true);
        }

        if (hitPointsSpinner.getValueFactory() != null) {
            hitPointsSpinner.getValueFactory().setValue(creature.getHitPoints());
        } else {
            SpinnerValueFactory<Integer> hitPointsFactory =
                    new SpinnerValueFactory.IntegerSpinnerValueFactory(
                            0, Integer.MAX_VALUE, initativeRoundRobin.getCurrent().getHitPoints());
            hitPointsSpinner.setValueFactory(hitPointsFactory);
            hitPointsFactory
                    .valueProperty()
                    .addListener(
                            ((observable, oldValue, newValue) ->
                                    initativeRoundRobin.getCurrent().setHitPoints(newValue)));
        }

        levelLabel.setText(creature.getLevel() + "");

        acLabel.setText(creature.getArmorClass() + "");

        currentConditionComboBox.setValue(creature.getCurrentCondition().toString());

        if (creature.getSpells() == null) {
            spellView.setVisible(false);
            spellView.setDisable(true);
        } else {
            spellView.setVisible(true);
            spellView.setDisable(false);
        }
    }

    public void initialize() {
        nextInitiativeButtonPressed();
        // App.spellViewController.reset(creature.getSpells());
        addToComboBox(App.initativeRoundRobin.getCreatures().toArray());
        ArrayList<String> conditions = new ArrayList<>();
        for (Condition condition : Condition.values()) {
            conditions.add(condition.toString());
        }
        currentConditionComboBox.getItems().addAll(conditions);
        currentConditionComboBox.setValue(creature.getCurrentCondition().toString());
        currentConditionComboBox.setOnAction(
                event ->
                        creature.setCurrentCondition(Condition.valueOf(currentConditionComboBox.getValue())));
    }

    public void addToComboBox(Object[] creatures) {

        ArrayList<String> names = new ArrayList<>();

        for (Object creature : creatures) {
            names.add(((Creature) creature).getName());
        }

        creatureNames.getItems().addAll(names);
    }

    @FXML public Label nameLabel;
    public Label creatureTypeLabel;
    public Label descriptionLabel;
    public Label alignmentLabel;
    public Label sizeLabel;
    public Label movementSpeedLabel;
    public Label swimmingSpeedLabel;
    public Label climbingSpeedLabel;
    public Label flyingSpeedLabel;
    public Label skillsLabel;
    public Label languagesLabel;
    public Label strLabel;
    public Label dexLabel;
    public Label contLabel;
    public Label intLabel;
    public Label wisLabel;
    public Label chaLabel;
    public AnchorPane rootPane;
    public Spinner<Integer> hitPointsSpinner;
    public Label levelLabel;
    public ComboBox<String> creatureNames;
    public Button openButton;
    public TableView<Ability> abilityTable;
    public TableColumn<Ability, String> abilitiesNameColumn;
    public TableColumn<Ability, String> abilitiesDescriptionColumn;
    public TableView<Tool> weaponsTable;
    public TableColumn<Tool, String> toolsNameColumn;
    public TableColumn<Tool, String> toolsToHitColumn;
    public TableColumn<Tool, String> toolsDamageColumn;
    public TableColumn<Tool, String> toolsDamageTypeColumn;
    public TableColumn<Tool, String> toolsDescriptionColumn;
    public Label levelDescriptor;
    public ComboBox<String> currentConditionComboBox;
    public AnchorPane spellView;
    public Label acLabel;
    public Button viewModifiersButton;
}
