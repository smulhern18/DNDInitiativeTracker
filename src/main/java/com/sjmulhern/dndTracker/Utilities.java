package com.sjmulhern.dndTracker;

import java.util.Random;

public class Utilities {

    public static int rollD4(int offset) {
        return (Math.abs(new Random().nextInt()) % 4 + 1 + offset);
    }

    public static int rollD6(int offset) {
        return (Math.abs(new Random().nextInt()) % 6 + 1 + offset);
    }

    public static int rollD8(int offset) {
        return (Math.abs(new Random().nextInt()) % 8 + 1 + offset);
    }

    public static int rollD10(int offset) {
        return (Math.abs(new Random().nextInt()) % 10 + 1 + offset);
    }

    public static int rollD12(int offset) {
        return (Math.abs(new Random().nextInt()) % 12 + 1 + offset);
    }

    public static int rollD20(int offset) {
        return (Math.abs(new Random().nextInt()) % 20 + 1 + offset);
    }

    public static int rollD100(int offset) {
        return (Math.abs(new Random().nextInt()) % 100 + 1 + offset);
    }
}
