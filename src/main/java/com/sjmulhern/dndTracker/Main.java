package com.sjmulhern.dndTracker;

import com.sjmulhern.dndTracker.creatures.Alignment;

public class Main {

    public static void main(String[] args){

        App.launch(App.class, args);

        System.out.println(Alignment.Unaligned.toString());
    }
}
