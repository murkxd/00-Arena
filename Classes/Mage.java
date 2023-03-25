package Classes;

import Races.Race;

public class Mage extends Character {
    public Mage(Race race, String klasse, String name, int level, int experience, double strength,
    double intelligence, double dexterity, double constitution) {
    }
    public Mage(){
    }

    public int damage() {
        return (int)(3*this.getIntelligence());
    }

    public String toString() {
        return "Mage";
    }
}
