package com.sjmulhern.dndTracker.tools;

import com.sjmulhern.dndTracker.creatures.Size;

public enum Shape {

    // All Sizes are in 1 by 1 in grid increments on one axis
    Line(0),
    Cone(1),
    Cube(2),
    Cylinder(3),
    Sphere(4),
    None(5);

    private final int ord;

    Shape (int ord) {
        this.ord = ord;
    }

    public final int intValue () {
        return ord;
    }

    // Get enum type from int
    public static Shape getEnum (int ord) {
        Shape value = null;
        for (Shape t : values()) {
            if (t.intValue() == ord) {
                value = t;
            }
        }
        return value;
    }

    public static String[] getStringValues() {
        Shape[] shapes = values();
        String[] shapeStrings = new String[shapes.length];
        for (int i = 0; i < shapes.length; i++) {
            shapeStrings[i] = shapes[i].toString();
        }

        return shapeStrings;
    }
}
