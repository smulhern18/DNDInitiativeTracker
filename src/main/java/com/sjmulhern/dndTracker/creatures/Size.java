package com.sjmulhern.dndTracker.creatures;

public enum Size {

    // All Sizes are in 1 by 1 in grid increments on one axis
    Tiny(0.25),
    Small(0.5),
    Medium(1),
    Large(2),
    Huge(3),
    Gargantuan(4),
    Colossal(5);

    private final double numHexes;

    Size(double numHexes) {
        this.numHexes = numHexes;
    }

    public final double doubleValue() {
        return numHexes;
    }

    // Get enum type from int
    public static Size getEnum(double numHexes) {
        Size value = null;
        for (Size t : values()) {
            if (t.doubleValue() == numHexes) {
                value = t;
            }
        }
        return value;
    }
}
