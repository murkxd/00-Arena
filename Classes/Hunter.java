package Classes;

import Races.Race;

public class Hunter extends Character {
    public Hunter(Race race, String klasse, String name, int level, int experience, double strength,
    double intelligence, double dexterity, double constitution) {
    }
    public Hunter() {
    }

    public int damage() {
        return (int)(3*this.getDexterity());
    }
    
    public String toString() {
        return "Hunter";
    }
}
