package Classes;

import Races.Race;

public class Warrior extends Character {
    public Warrior(Race race, String klasse, String name, int level, int experience, double strength,
    double intelligence, double dexterity, double constitution) {
    }
    public Warrior() {
    }

    public int damage() {
        return (int)(3*this.getStrength());
    }

    public String toString() {
        return "Warrior";
    }
}
