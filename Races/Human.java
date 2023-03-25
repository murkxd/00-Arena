package Races;

import java.io.Serializable;

public class Human implements Race, Serializable {
    public double bonusRaceStrength() {
        return 1.03;
    }
    public double bonusRaceIntelligence() {
        return 1.03;
    }
    public double bonusRaceDexterity() {
        return 1.04;
    }
    public double bonusRaceConstitution() {
        return 1.00;
    }

    public String toString() {
        return "Human";
    }
}