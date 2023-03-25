package Races;

import java.io.Serializable;

public class Dwarf implements Race, Serializable {
    public double bonusRaceStrength() {
        return 1.07;
    }
    public double bonusRaceIntelligence() {
        return 1.00;
    }
    public double bonusRaceDexterity() {
        return 1.00;
    }
    public double bonusRaceConstitution() {
        return 1.03;
    }

    public String toString() {
        return "Dwarf";
    }
}
