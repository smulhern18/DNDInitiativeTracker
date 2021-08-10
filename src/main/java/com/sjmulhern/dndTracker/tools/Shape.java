package com.sjmulhern.dndTracker.tools;

public enum Shape {

    // All Sizes are in 1 by 1 in grid increments on one axis
    Line(0),
    Cone(1),
    Cube(2),
    Cylinder(3),
    Sphere(4),
    None(5);

    private final int ord;

    Shape(int ord) {
        this.ord = ord;
    }

    public final int intValue() {
        return ord;
    }

    // Get enum type from int
    public static Shape getEnum(int ord) {
        Shape value = null;
        for (Shape t : values()) {
            if (t.intValue() == ord) {
                value = t;
            }
        }
        return value;
    }
}
