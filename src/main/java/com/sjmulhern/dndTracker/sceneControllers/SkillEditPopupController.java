package com.sjmulhern.dndTracker.sceneControllers;

import com.sjmulhern.dndTracker.App;
import com.sjmulhern.dndTracker.creatures.Creature;
import com.sjmulhern.dndTracker.creatures.Skill;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SkillEditPopupController implements Initializable {

    private Stage stage = null;

    private ArrayList<Skill> result = new ArrayList<>();

    Creature creature = App.getInitativeRoundRobin().getCurrent();

    public void initialize() {

        ArrayList<Skill> skills = creature.getSkills();

        if (skills != null && !skills.isEmpty()) {
            for (Skill skill : skills) {
                switch (skill) {
                    case Athletics:
                        athletics.setSelected(true);
                        break;
                    case Acrobatics:
                        acrobatics.setSelected(true);
                        break;
                    case AnimalHandling:
                        animalHandling.setSelected(true);
                        break;
                    case Arcana:
                        arcana.setSelected(true);
                        break;
                    case Deception:
                        deception.setSelected(true);
                        break;
                    case History:
                        history.setSelected(true);
                        break;
                    case Insight:
                        insight.setSelected(true);
                        break;
                    case Investigation:
                        investigation.setSelected(true);
                        break;
                    case Intimidation:
                        intimidation.setSelected(true);
                        break;
                    case Medicine:
                        medicine.setSelected(true);
                        break;
                    case Nature:
                        nature.setSelected(true);
                        break;
                    case Perception:
                        perception.setSelected(true);
                        break;
                    case Persuasion:
                        persuasion.setSelected(true);
                        break;
                    case Performance:
                        performance.setSelected(true);
                        break;
                    case SlightOfHand:
                        slightOfHand.setSelected(true);
                        break;
                    case Stealth:
                        stealth.setSelected(true);
                        break;
                    case Survival:
                        survival.setSelected(true);
                        break;
                    case Religion:
                        religion.setSelected(true);
                        break;
                    default:
                }
            }
            result = creature.getSkills();
        }

        athletics.setOnAction(event -> checkIfSelected(Skill.Athletics));
        acrobatics.setOnAction(event -> checkIfSelected(Skill.Acrobatics));
        animalHandling.setOnAction(event -> checkIfSelected(Skill.AnimalHandling));
        arcana.setOnAction(event -> checkIfSelected(Skill.Arcana));
        deception.setOnAction(event -> checkIfSelected(Skill.Deception));
        history.setOnAction(event -> checkIfSelected(Skill.History));
        insight.setOnAction(event -> checkIfSelected(Skill.Insight));
        investigation.setOnAction(event -> checkIfSelected(Skill.Investigation));
        intimidation.setOnAction(event -> checkIfSelected(Skill.Intimidation));
        medicine.setOnAction(event -> checkIfSelected(Skill.Medicine));
        nature.setOnAction(event -> checkIfSelected(Skill.Nature));
        perception.setOnAction(event -> checkIfSelected(Skill.Perception));
        persuasion.setOnAction(event -> checkIfSelected(Skill.Persuasion));
        performance.setOnAction(event -> checkIfSelected(Skill.Performance));
        slightOfHand.setOnAction(event -> checkIfSelected(Skill.SlightOfHand));
        stealth.setOnAction(event -> checkIfSelected(Skill.Stealth));
        survival.setOnAction(event -> checkIfSelected(Skill.Survival));
        religion.setOnAction(event -> checkIfSelected(Skill.Religion));
    }

    private void checkIfSelected(Skill skill) {
        if (creature.getSkills().contains(skill)) {
            creature.getSkills().remove(skill);
        } else {
            creature.getSkills().add(skill);
        }
    }

    public void initialize(URL location, ResourceBundle resources) {
        initialize();
    }

    @FXML public CheckBox athletics;
    public CheckBox animalHandling;
    public CheckBox deception;
    public CheckBox acrobatics;
    public CheckBox religion;
    public CheckBox survival;
    public CheckBox stealth;
    public CheckBox slightOfHand;
    public CheckBox performance;
    public CheckBox persuasion;
    public CheckBox perception;
    public CheckBox nature;
    public CheckBox medicine;
    public CheckBox investigation;
    public CheckBox intimidation;
    public CheckBox insight;
    public CheckBox history;
    public CheckBox arcana;
}
