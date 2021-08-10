package com.sjmulhern.dndTracker.utils;

import com.sjmulhern.dndTracker.creatures.Creature;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class InitativeRoundRobin {

    private Set<Creature> creatures = new HashSet<>();

    private int currentIndex = 0;

    public InitativeRoundRobin(){ }

    public void addCreature(Creature creature){

        creatures.remove(creature);
        creatures.add(creature);
    }

    public void addAllCreatures(ArrayList<Creature> newCreatures) {
        creatures.addAll(newCreatures);
    }

    public Creature getNext() {
        currentIndex++;

        Object[] creaturesArray = creatures.toArray();

        Creature creature = (Creature) creaturesArray[currentIndex % creatures.size()];

        while (creature.getHitPoints() <= 0) {
            currentIndex++;
            creature = (Creature) creaturesArray[currentIndex%creatures.size()];
        }

        return creature;
    }

    public Creature getCurrent(){
        return (Creature) creatures.toArray()[currentIndex % creatures.size()];
    }
}
