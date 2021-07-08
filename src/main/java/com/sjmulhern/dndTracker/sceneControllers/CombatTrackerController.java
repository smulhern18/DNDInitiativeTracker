package com.sjmulhern.dndTracker.sceneControllers;

import com.sjmulhern.dndTracker.App;
import com.sjmulhern.dndTracker.creatures.Alignment;
import com.sjmulhern.dndTracker.creatures.Condition;
import com.sjmulhern.dndTracker.creatures.Creature;
import com.sjmulhern.dndTracker.creatures.Monster;
import com.sjmulhern.dndTracker.creatures.Size;
import com.sjmulhern.dndTracker.utils.InitativeRoundRobin;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class CombatTrackerController {

    public Creature getCurrentCreature () {
        return initativeRoundRobin.getCurrent();
    }

    InitativeRoundRobin initativeRoundRobin = App.initativeRoundRobin;

    public void nextInitiativeButtonPressed (ActionEvent actionEvent) {
        if (initativeRoundRobin.getCreatures().size() == 0) {
            initativeRoundRobin.addCreature(new Creature("Goblin",
                                                         "a Goblin",
                                                         Alignment.Unaligned,
                                                         Size.Small,
                                                         30,
                                                         15,
                                                         15,
                                                         0,
                                                         new ArrayList<>(),
                                                         new ArrayList<>(),
                                                         new ArrayList<>(),
                                                         new ArrayList<>(),
                                                         12,
                                                         13,
                                                         14,
                                                         15,
                                                         16,
                                                         30,
                                                         69,
                                                         20,
                                                         1,
                                                         Condition.Blinded));
            initativeRoundRobin.addCreature(new Monster("Goblin 2",
                                                        "not a Goblin",
                                                        Alignment.Unaligned,
                                                        Size.Small,
                                                        30,
                                                        15,
                                                        15,
                                                        0,
                                                        new ArrayList<>(),
                                                        new ArrayList<>(),
                                                        new ArrayList<>(),
                                                        new ArrayList<>(),
                                                        12,
                                                        13,
                                                        14,
                                                        15,
                                                        16,
                                                        30,
                                                        69,
                                                        20,
                                                        1,
                                                        Condition.Blinded));
        }

        Creature creature = initativeRoundRobin.getNext();

        nameLabel.setText(creature.getName());
        descriptionLabel.setText(creature.getDescription());
        alignmentLabel.setText(creature.getAlignment().toString());
        sizeLabel.setText(creature.getSize().toString());
        movementSpeedLabel.setText(creature.getMovementSpeed()+"");
        swimmingSpeedLabel.setText(creature.getSwimSpeed()+"");
        climbingSpeedLabel.setText(creature.getClimbSpeed()+"");
        flyingSpeedLabel.setText(creature.getFlySpeed()+"");
        strLabel.setText(creature.getStrength()+" (" + (creature.getStrength()-10)/2 + ") ");
        dexLabel.setText(creature.getDexterity()+" (" + (creature.getDexterity()-10)/2 + ") ");
        contLabel.setText(creature.getConstitution()+" (" + (creature.getConstitution()-10)/2 + ") ");
        intLabel.setText(creature.getIntelligence()+" (" + (creature.getIntelligence()-10)/2 + ") ");
        wisLabel.setText(creature.getWisdom()+" (" + (creature.getWisdom()-10)/2 + ") ");
        chaLabel.setText(creature.getCharisma()+" (" + (creature.getCharisma()-10)/2 + ") ");
        hitPointsLabel.setText(creature.getHitPoints()+"");
    }

    public Label nameLabel;
    public Label creatureTypeLabel;
    public Label descriptionLabel;
    public Label alignmentLabel;
    public Label sizeLabel;
    public Label movementSpeedLabel;
    public Label swimmingSpeedLabel;
    public Label climbingSpeedLabel;
    public Label flyingSpeedLabel;
    public Label abilitiesLabel;
    public Label weaponsLabel;
    public Label skillsLabel;
    public Label languagesLabel;
    public Label strLabel;
    public Label dexLabel;
    public Label contLabel;
    public Label intLabel;
    public Label wisLabel;
    public Label chaLabel;
    public Label hitPointsLabel;

}
