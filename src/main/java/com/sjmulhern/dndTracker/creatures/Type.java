package com.sjmulhern.dndTracker.creatures;

public enum Type {

    Aberration(0),
    Beast(1),
    Celestial(2),
    Construct(3),
    Dragon(4),
    Elemental(5),
    Fey(6),
    Fiend(7),
    Giant(8),
    Humanoid(9),
    Monstrosity(10),
    Ooze(11),
    Plant(12),
    Undead(13),
    Swarm(14),
    None(15);

    private final int ordinal;

    Type (int ordinal) {
        this.ordinal = ordinal;
    }

    public final int getOrdinal () {
        return ordinal;
    }

    // Get enum type from int
    public static Type getEnum (int ordinal) {
        Type value = null;
        for (Type t : values()) {
            if (t.ordinal() == ordinal) {
                value = t;
            }
        }
        return value;
    }
}
