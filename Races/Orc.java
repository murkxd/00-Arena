package Races;

import java.io.Serializable;

public class Orc implements Race, Serializable {
    public double bonusRaceStrength() {
        return 1.10;
    }
    public double bonusRaceIntelligence() {
        return 1.00;
    }
    public double bonusRaceDexterity() {
        return 1.00;
    }
    public double bonusRaceConstitution() {
        return 1.00;
    }

    public String toString() {
        return "Orc";
    }
}
