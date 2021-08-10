package com.sjmulhern.dndTracker.sceneControllers;

import com.sjmulhern.dndTracker.App;
import com.sjmulhern.dndTracker.creatures.NonPlayerCharacter;
import com.sjmulhern.dndTracker.tools.DamageType;
import java.util.ArrayList;
import javafx.scene.control.CheckBox;

public class ImmunitiesEditorController {

    private ArrayList<DamageType> result;

    private NonPlayerCharacter creature = (NonPlayerCharacter) App.currentCreature;

    public void saveButtonPressed() {
        ((NonPlayerCharacter) App.initativeRoundRobin.getCurrent()).setImmunities(result);
        System.out.println(result.toString());
    }

    public void initialize() {

        result = ((NonPlayerCharacter) App.currentCreature).getImmunities();

        if (result != null && !result.isEmpty()) {
            for (DamageType damageType : result) {
                switch (damageType) {
                    case Slashing:
                        slashing.setSelected(true);
                        break;
                    case Piercing:
                        piercing.setSelected(true);
                        break;
                    case Bludgeoning:
                        bludgeoning.setSelected(true);
                        break;
                    case Poison:
                        poison.setSelected(true);
                        break;
                    case Acid:
                        acid.setSelected(true);
                        break;
                    case Fire:
                        fire.setSelected(true);
                        break;
                    case Cold:
                        cold.setSelected(true);
                        break;
                    case Radiant:
                        radiant.setSelected(true);
                        break;
                    case Necrotic:
                        necrotic.setSelected(true);
                        break;
                    case Lightning:
                        lightning.setSelected(true);
                        break;
                    case Thunder:
                        thunder.setSelected(true);
                        break;
                    case Force:
                        force.setSelected(true);
                        break;
                    case Psychic:
                        psychic.setSelected(true);
                        break;
                    case None:
                        break;
                }
            }
            creature.setImmunities(result);
        } else {
            result = new ArrayList<>();
        }

        slashing.setOnAction(event -> checkIfSelected(DamageType.Slashing));
        piercing.setOnAction(event -> checkIfSelected(DamageType.Piercing));
        bludgeoning.setOnAction(event -> checkIfSelected(DamageType.Bludgeoning));
        poison.setOnAction(event -> checkIfSelected(DamageType.Poison));
        acid.setOnAction(event -> checkIfSelected(DamageType.Acid));
        fire.setOnAction(event -> checkIfSelected(DamageType.Fire));
        cold.setOnAction(event -> checkIfSelected(DamageType.Cold));
        radiant.setOnAction(event -> checkIfSelected(DamageType.Radiant));
        necrotic.setOnAction(event -> checkIfSelected(DamageType.Necrotic));
        lightning.setOnAction(event -> checkIfSelected(DamageType.Lightning));
        thunder.setOnAction(event -> checkIfSelected(DamageType.Thunder));
        force.setOnAction(event -> checkIfSelected(DamageType.Force));
        psychic.setOnAction(event -> checkIfSelected(DamageType.Psychic));
    }

    private void checkIfSelected(DamageType damageType) {
        if (creature.getImmunities().contains(damageType)) {
            creature.getImmunities().remove(damageType);
        } else {
            creature.getImmunities().add(damageType);
        }
    }

    public CheckBox slashing;

    public CheckBox piercing;

    public CheckBox bludgeoning;

    public CheckBox poison;

    public CheckBox acid;

    public CheckBox fire;

    public CheckBox cold;

    public CheckBox radiant;

    public CheckBox necrotic;

    public CheckBox lightning;

    public CheckBox thunder;

    public CheckBox force;

    public CheckBox psychic;
}
