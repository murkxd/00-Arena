package Races;

import java.io.Serializable;

public class Elf implements Race, Serializable {
    public double bonusRaceStrength() {
        return 1.00;
    }
    public double bonusRaceIntelligence() {
        return 1.06;
    }
    public double bonusRaceDexterity() {
        return 1.04;
    }
    public double bonusRaceConstitution() {
        return 1.00;
    }

    public String toString() {
        return "Elf";
    }
}
