package com.sjmulhern.dndTracker.creatures;

public enum Condition {
    Blinded(0),
    Charmed(1),
    Deafened(2),
    Frightened(3),
    Grappled(4),
    Incapacitated(5),
    Invisible(6),
    Paralyzed(7),
    Petrified(8),
    Poisoned(9),
    Prone(10),
    Restrained(11),
    Stunned(12),
    Unconscious(13),
    Exhausted(14),
    None(15);

    private final int ordinal;

    Condition(int ordinal) {
        this.ordinal = ordinal;
    }

    public final int getOrdinal() {
        return ordinal;
    }

    // Get enum type from int
    public static Condition getEnum(int ordinal) {
        Condition value = null;
        for (Condition t : values()) {
            if (t.ordinal() == ordinal) {
                value = t;
            }
        }
        return value;
    }
}
