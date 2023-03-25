package Races;

public class DarkElf implements Race {
    public double bonusRaceStrength() {
        return 1.00;
    }
    public double bonusRaceIntelligence() {
        return 1.04;
    }
    public double bonusRaceDexterity() {
        return 1.06;
    }
    public double bonusRaceConstitution() {
        return 1.00;
    }

    public String toString() {
        return "DarkElf";
    }
}
