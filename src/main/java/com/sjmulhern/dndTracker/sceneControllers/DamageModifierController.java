package com.sjmulhern.dndTracker.sceneControllers;

import com.sjmulhern.dndTracker.App;
import com.sjmulhern.dndTracker.creatures.Creature;
import com.sjmulhern.dndTracker.creatures.Monster;
import com.sjmulhern.dndTracker.creatures.NonPlayerCharacter;
import com.sjmulhern.dndTracker.tools.DamageType;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class DamageModifierController {

    Stage stage = null;

    NonPlayerCharacter currentCreature = (NonPlayerCharacter) App.currentCreature;

    public void initialize() {
        String weaknessString = "";
        String resistanceString = "";
        String immunityString = "";

        ArrayList<DamageType> weaknesses = currentCreature.getWeaknesses();
        ArrayList<DamageType> resistances = currentCreature.getResistances();
        ArrayList<DamageType> immunities = currentCreature.getImmunities();

        if (weaknesses != null) {
            for (DamageType weakness: weaknesses) {
                weaknessString += (weakness.toString() + "\n");
            }
        } else {
            weaknessString += "None";
        }

        if (resistances != null && resistances.size() != 0) {
            for (DamageType resistance: resistances) {
                resistanceString += (resistance.toString() + "\n");
            }
        } else {
            resistanceString += "None";
        }

        if (immunities != null && immunities.size() != 0) {
            for (DamageType immunity: immunities) {
                immunityString += (immunity.toString() + "\n");
            }
        } else {
            immunityString += "None";
        }

        weaknessesTextArea.setText(weaknessString);
        resistancesTextArea.setText(resistanceString);
        immunitiesTextArea.setText(immunityString);
    }


    @FXML
    public TextArea weaknessesTextArea;
    @FXML
    public TextArea resistancesTextArea;
    @FXML
    public TextArea immunitiesTextArea;

}
