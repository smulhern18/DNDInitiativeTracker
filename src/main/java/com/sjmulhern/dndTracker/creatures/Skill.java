package com.sjmulhern.dndTracker.creatures;

public enum Skill {
    Athletics(0),
    Acrobatics(1),
    AnimalHandling(2),
    Arcana(3),
    Deception(4),
    History(5),
    Insight(6),
    Investigation(7),
    Intimidation(8),
    Medicine(9),
    Nature(10),
    Perception(11),
    Persuasion(12),
    Performance(13),
    SlightOfHand(14),
    Stealth(15),
    Survival(16),
    Religion(17);

    private final int ordinal;

    Skill (int ordinal) {
        this.ordinal = ordinal;
    }

    public final int getOrdinal () {
        return ordinal;
    }

    // Get enum type from int
    public static Skill getEnum (int ordinal) {
        Skill value = null;
        for (Skill t : values()) {
            if (t.ordinal() == ordinal) {
                value = t;
            }
        }
        return value;
    }
}

