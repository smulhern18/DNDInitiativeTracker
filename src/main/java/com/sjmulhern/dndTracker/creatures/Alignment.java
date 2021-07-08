package com.sjmulhern.dndTracker.creatures;

public enum Alignment {

    Chaotic_Good("CG"),
    Neutral_Good("NG"),
    Lawful_Good("LG"),
    Chaotic_Neutral("CN"),
    True_Neutral("TN"),
    Lawful_Neutral("LN"),
    Chaotic_Evil("CE"),
    Neutral_Evil("NE"),
    Lawful_Evil("LE"),
    Unaligned("UA");

    private final String abbreviation;

    Alignment (String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public final String getAbbreviation () {
        return abbreviation;
    }

    // Get enum type from int
    public static Alignment getEnum (String abbreviation) {
        Alignment value = null;
        for (Alignment t : values()) {
            if (t.getAbbreviation().equals(abbreviation)) {
                value = t;
            }
        }
        return value;
    }
}
