package com.sjmulhern.dndTracker;

import java.util.Random;

public class Utilities {

    public static int rollD4(int offset) {
        return (Math.abs(new Random().nextInt()) % 4 + 1 + offset);
    }

    public static int rollD20(int offset) {
        return (Math.abs(new Random().nextInt()) % 20 + 1 + offset);
    }
}
