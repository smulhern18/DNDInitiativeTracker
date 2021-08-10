package com.sjmulhern.dndTracker.tools;

public enum DamageType {
    Slashing(0),
    Piercing(1),
    Bludgeoning(2),
    Poison(3),
    Acid(4),
    Fire(5),
    Cold(6),
    Radiant(7),
    Necrotic(8),
    Lightning(9),
    Thunder(10),
    Force(11),
    Psychic(12),
    None(13);

    private final int ordinal;

    DamageType(int ordinal) {

        this.ordinal = ordinal;
    }

    public final int getOrdinal() {

        return ordinal;
    }

    // Get enum type from int
    public static DamageType getEnum(int ordinal) {

        DamageType value = null;
        for (DamageType t : values()) {
            if (t.ordinal() == ordinal) {
                value = t;
            }
        }
        return value;
    }

    public static String[] getStringValues() {
        DamageType[] damageTypes = values();
        String[] damageTypeStrings = new String[damageTypes.length];
        for (int i = 0; i < damageTypes.length; i++) {
            damageTypeStrings[i] = damageTypes[i].toString();
        }

        return damageTypeStrings;
    }
}
