package com.sjmulhern.dndTracker;

import java.util.Random;

public class Utilities {

    public static int rollD20() {
        return (new Random().nextInt() % 20 + 1);
    }
}
