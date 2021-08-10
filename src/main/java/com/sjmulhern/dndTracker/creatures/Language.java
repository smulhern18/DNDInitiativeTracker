package com.sjmulhern.dndTracker.creatures;

public enum Language {
    Common(0),
    Dwarvish(1),
    Elvish(2),
    Giant(3),
    Gnomish(4),
    Goblin(5),
    Hafling(6),
    Orc(7),
    Abyssal(8),
    Celestial(9),
    Draconic(10),
    DeepSpeech(11),
    Infernal(12),
    Primordial(13),
    Sylvan(14),
    Undercommon(15);

    private final int ordinal;

    Language(int ordinal) {
        this.ordinal = ordinal;
    }

    public final int getOrdinal() {
        return ordinal;
    }

    // Get enum type from int
    public static Language getEnum(int ordinal) {
        Language value = null;
        for (Language t : values()) {
            if (t.ordinal() == ordinal) {
                value = t;
            }
        }
        return value;
    }
}
