package Classes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Races.*;

public class Character implements Serializable {
    protected Race race;
    protected Character klasse;
    protected String name;
    protected int level;
    protected int experience;
    protected double strength;
    protected double intelligence;
    protected double dexterity;
    protected double constitution;

    static Scanner sc = new Scanner(System.in);
    static Random rnd = new Random();
    
    public Character(Race race, Character klasse, String name, int level, int experience, double strength,
            double intelligence, double dexterity, double constitution) {
        this.race = race;
        this.klasse = klasse;
        this.name = name;
        this.level = level;
        this.experience = experience;
        this.strength = strength;
        this.intelligence = intelligence;
        this.dexterity = dexterity;
        this.constitution = constitution;
    }

    public Character() {
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Character getKlasse() {
        return klasse;
    }

    public void setKlasse(Character klasse) {
        this.klasse = klasse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public double getStrength() {
        return strength*race.bonusRaceStrength();
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public double getIntelligence() {
        return intelligence*race.bonusRaceIntelligence();
    }

    public void setIntelligence(double intelligence) {
        this.intelligence = intelligence;
    }

    public double getDexterity() {
        return dexterity*race.bonusRaceDexterity();
    }

    public void setDexterity(double dexterity) {
        this.dexterity = dexterity;
    }

    public double getConstitution() {
        return constitution*race.bonusRaceConstitution();
    }

    public void setConstitution(double constitution) {
        this.constitution = constitution;
    }

    public int getHealth() {
        return level*10;
    }

    public void levelUp() {
        while(experience >= 100*level) {
            experience -= 100*level;
            level++;

            int spendSelect = 0;
            int points = 3;

            do {
                System.out.println("\n1 - Strength ("+strength+")");
                System.out.println("2 - Intelligence ("+intelligence+")");
                System.out.println("3 - Dexterity ("+dexterity+")");
                System.out.println("4 - Constitution ("+constitution+")");
                System.out.print("("+points+" left) "+"Add points to: ");

                int pointSelect = sc.nextInt();

                String YCUMPTYCH = "You can't use more points then you currently have!";
                String YCRAAP = "You can't remove already assigned points!";
    
                switch(pointSelect) {
                    case(1):
                    System.out.print("Strength - Add points: ");
                    spendSelect = sc.nextInt();
                    if(spendSelect > points) {System.out.println(YCUMPTYCH); break;}
                    if(spendSelect < 0) {System.out.println(YCRAAP); break;}
                    strength = strength + spendSelect;
                    points -= spendSelect;
                    break;
                    case(2):
                    System.out.print("Intelligence - Add points: ");
                    spendSelect = sc.nextInt();
                    if(spendSelect > points) {System.out.println(YCUMPTYCH); break;}
                    if(spendSelect < 0) {System.out.println(YCRAAP); break;}
                    intelligence = intelligence + spendSelect;
                    points -= spendSelect;
                    break;
                    case(3):
                    System.out.print("Dexterity - Add points: ");
                    spendSelect = sc.nextInt();
                    if(spendSelect > points) {System.out.println(YCUMPTYCH); break;}
                    if(spendSelect < 0) {System.out.println(YCRAAP); break;}
                    dexterity = dexterity + spendSelect;
                    points -= spendSelect;
                    break;
                    case(4):
                    System.out.print("Constitution - Add points: ");
                    spendSelect = sc.nextInt();
                    if(spendSelect > points) {System.out.println(YCUMPTYCH); break;}
                    if(spendSelect < 0) {System.out.println(YCRAAP); break;}
                    constitution = constitution + spendSelect;
                    points -= spendSelect;
                    break;
                }
            }while(points > 0);
        }
    }

    public static Character createCharacter() {
        System.out.println("\nSelect your characters race.");
        System.out.println("1 - Human");
        System.out.println("2 - Elf");
        System.out.println("3 - Dwarf");
        System.out.println("4 - Orc");
        System.out.println("5 - DarkElf");
        System.out.println("6 - Demon");
        System.out.print("Selection: ");

        int raceSelect = sc.nextInt();
        Race selectedRace = null;
        switch(raceSelect) {
            case 1:
            selectedRace = new Human();
            break;
            case 2:
            selectedRace = new Elf();
            break;
            case 3:
            selectedRace = new Dwarf();
            break;
            case 4:
            selectedRace = new Orc();
            break;
            case 5:
            selectedRace = new DarkElf();
            break;
            case 6:
            selectedRace = new Demon();
            break;
        }
        
        System.out.println("\nSelect your characters class.");
        System.out.println("1 - Warrior");
        System.out.println("2 - Mage");
        System.out.println("3 - Hunter");
        System.out.print("Selection: ");

        double xStrength = 1;
        double xIntelligence = 1;
        double xDexterity = 1;
        double xConstitution = 1;

        int klasseSelect = sc.nextInt();
        Character selectedKlasse = null;
        switch(klasseSelect) {
            case 1:
            selectedKlasse = new Warrior();
            xStrength += 3;
            break;
            case 2:
            selectedKlasse = new Mage();
            xIntelligence += 3;
            break;
            case 3:
            selectedKlasse = new Hunter();
            xDexterity += 3;
            break;
        }

        sc.nextLine();
        System.out.println();

        System.out.print("Enter your characters name: ");
        String selectedName = sc.nextLine();

        int startPoints = 5;
        int spendSelect = 0;

        do {
            System.out.println("\n1 - Strength ("+xStrength+")");
            System.out.println("2 - Intelligence ("+xIntelligence+")");
            System.out.println("3 - Dexterity ("+xDexterity+")");
            System.out.println("4 - Constitution ("+xConstitution+")");
            System.out.print("("+startPoints+" left) "+"Add points to: ");
            int pointSelect = sc.nextInt();
            
            String YCUMPTYCH = "You can't use more points then you currently have!";
            String YCRAAP = "You can't remove already assigned points!";

            switch(pointSelect) {
                case(1):
                System.out.print("Strength - Add points: ");
                spendSelect = sc.nextInt();
                if(spendSelect > startPoints) {System.out.println(YCUMPTYCH); break;}
                if(spendSelect < 0) {System.out.println(YCRAAP); break;}
                xStrength = xStrength + spendSelect;
                startPoints -= spendSelect;
                break;
                case(2):
                System.out.print("Intelligence - Add points: ");
                spendSelect = sc.nextInt();
                if(spendSelect > startPoints) {System.out.println(YCUMPTYCH); break;}
                if(spendSelect < 0) {System.out.println(YCRAAP); break;}
                xIntelligence = xIntelligence + spendSelect;
                startPoints -= spendSelect;
                break;
                case(3):
                System.out.print("Dexterity - Add points: ");
                spendSelect = sc.nextInt();
                if(spendSelect > startPoints) {System.out.println(YCUMPTYCH); break;}
                if(spendSelect < 0) {System.out.println(YCRAAP); break;}
                xDexterity = xDexterity + spendSelect;
                startPoints -= spendSelect;
                break;
                case(4):
                System.out.print("Constitution - Add points: ");
                spendSelect = sc.nextInt();
                if(spendSelect > startPoints) {System.out.println(YCUMPTYCH); break;}
                if(spendSelect < 0) {System.out.println(YCRAAP); break;}
                xConstitution = xConstitution + spendSelect;
                startPoints -= spendSelect;
                break;
            }
        }while(startPoints > 0);

        xStrength *= selectedRace.bonusRaceStrength();
        xIntelligence *= selectedRace.bonusRaceIntelligence();
        xDexterity *= selectedRace.bonusRaceDexterity();
        xConstitution *= selectedRace.bonusRaceConstitution();

        Character c = new Character(selectedRace, selectedKlasse, selectedName, 1, 0, xStrength, xIntelligence, xDexterity, xConstitution);
        return c;
    }

    public static Character rndEnemyCharacter(Character player) throws Exception {
        ArrayList<Race> races = new ArrayList<>();
        races.add(new Human());
        races.add(new Elf());
        races.add(new Dwarf());
        races.add(new Orc());
        races.add(new DarkElf());
        races.add(new Demon());
        ArrayList<Character> klasses = new ArrayList<>();
        klasses.add(new Warrior());
        klasses.add(new Mage());
        klasses.add(new Hunter());

        Race rndRace = races.get(rnd.nextInt(races.size()));
        Character rndKlasse = klasses.get(rnd.nextInt(klasses.size()));
        String oppName = "Opponent";
        int playerLevel = player.getLevel();

        int firstStat=1, secondStat=1, thirdStat=2;
        int rndPoints = 5+(3*playerLevel);
        int x = 0;

        do {
            x = rnd.nextInt(rndPoints)+1;
            firstStat += x;
            rndPoints -= x;
            if(rndPoints == 0){break;}

            x = rnd.nextInt(rndPoints)+1;
            secondStat += x;
            rndPoints -= x;
            if(rndPoints == 0){break;}

            x = rnd.nextInt(rndPoints)+1;
            thirdStat += x;
            rndPoints -= x;
            if(rndPoints == 0){break;}
        } while (rndPoints>0);

        Character opponent = new Character();
         try {
            if(rndKlasse == klasses.get(0)) { //Warrior
                opponent = new Character(rndRace, rndKlasse, oppName, playerLevel, 0, firstStat, thirdStat/2, thirdStat/2, secondStat);
            }
            else if(rndKlasse == klasses.get(1)) { //Mage
                opponent = new Character(rndRace, rndKlasse, oppName, playerLevel, 0, thirdStat/2, firstStat, thirdStat/2, secondStat);
            }
            else if(rndKlasse == klasses.get(2)) {  //Hunter
                opponent = new Character(rndRace, rndKlasse, oppName, playerLevel, 0, thirdStat/2, thirdStat/2, firstStat, secondStat);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return opponent;
    }

    public static void fight(Character player, Character opponent) {
        ArrayList<Character> klasses = new ArrayList<>();
        klasses.add(new Warrior());
        klasses.add(new Mage());
        klasses.add(new Hunter());

        double playerHp = player.getLevel()*50;
        double oppHp = opponent.getLevel()*50;

        Character playerKlasse = player.getKlasse();
        Character oppKlasse = opponent.getKlasse();

        double playerAttack = 0, playerDefence = 0;
        double oppAttack = 0, oppDefence = 0;

        if(playerKlasse.toString() == klasses.get(0).toString()) {
            playerAttack = player.getStrength()*3;
            oppDefence = opponent.getStrength()+opponent.getConstitution();
        } else if(playerKlasse.toString() == klasses.get(1).toString()) {
            playerAttack = player.getIntelligence()*3;
            oppDefence = opponent.getIntelligence()+opponent.getConstitution();
        } else if(playerKlasse.toString() == klasses.get(2).toString()) {
            playerAttack = player.getDexterity()*3;
            oppDefence = opponent.getDexterity()+opponent.getConstitution();
        } else {
            System.out.println("Player Klasse Unmatched");
        }

        if(oppKlasse.toString() == klasses.get(0).toString()) {
            oppAttack = opponent.getStrength()*3;
            playerDefence = player.getStrength()+player.getConstitution();
        } else if(oppKlasse.toString() == klasses.get(1).toString()) {
            oppAttack = opponent.getIntelligence()*3;
            playerDefence = player.getIntelligence()+player.getConstitution();
        } else if(oppKlasse.toString() == klasses.get(2).toString()) {
            oppAttack = opponent.getDexterity()*3;
            playerDefence = player.getDexterity()+player.getConstitution();
        } else {
            System.out.println("Opponent Klasse Unmatched");
        }

        double playerHit = playerAttack - oppDefence;
        double oppHit = oppAttack - playerDefence;

        if(playerHit < 0){playerHit = 0;}
        if(oppHit < 0){oppHit = 0;}
        
        int firstMove = rnd.nextInt(2)+1;

        System.out.println("Fight!\nYour hp: "+String.format("%.1f", playerHp)+"\nEnemy hp: "+String.format("%.1f", oppHp)+"\n");
        switch(firstMove) {
            case(1):
            do {
                oppHp -= playerHit;
                if(oppHp < 0){oppHp = 0;break;}
                playerHp -= oppHit;
                if(playerHp <= 0){playerHp = 0;break;}

                System.out.println("Enemy hp: "+String.format("%.1f", oppHp)+"\nYour hp: "+String.format("%.1f", playerHp));
            } while (playerHp > 0 && oppHp > 0);
            System.out.println("Enemy hp: "+String.format("%.1f", oppHp)+"\nYour hp: "+String.format("%.1f", playerHp));
            break;
            case(2):
            do {
                playerHp -= oppHit;
                if(playerHp <= 0){playerHp = 0;break;}
                oppHp -= playerHit;
                if(oppHp < 0){oppHp = 0;break;}

                System.out.println("Your hp: "+String.format("%.1f", playerHp)+"\nEnemy hp: "+String.format("%.1f", oppHp));
            } while (playerHp > 0 && oppHp > 0);
            System.out.println("\nYour hp: "+String.format("%.1f", playerHp)+"\nEnemy hp: "+String.format("%.1f", oppHp));
            break;
        }

        if(playerHp <= 0) {
            int plusExp = player.getLevel()*10 + opponent.getExperience();
            opponent.setExperience(plusExp);
            System.out.println("You have been defeated.");
        }else if(oppHp <= 0) {
            int plusExp = opponent.getLevel()*10 + player.getExperience();
            player.setExperience(plusExp);
            System.out.println("You have won!");
        } 
    }

    public void serialize() throws IOException {
        FileOutputStream fos = new FileOutputStream("Char.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        fos.close();
    }

    public Character deserialize() throws IOException, ClassNotFoundException {
        Character c;
        FileInputStream fis = new FileInputStream("Char.txt");
        ObjectInputStream ois = new ObjectInputStream(fis); 

        c = (Character) ois.readObject();

        fis.close();
        ois.close();

        return c;
    }

    @Override
    public String toString() {
        return "\n"+"Character: "+name+"\n"+
        "Race and class: "+race+" "+klasse+"\n"+
        "Level: "+level+" ("+experience+"/"+100*level+")\n"+
        "Strength: "+String.format("%.1f", this.getStrength())+" Constitution: "+String.format("%.1f", this.getConstitution())+"\n"+
        "Intelligence: "+String.format("%.1f", this.getIntelligence())+" Dexterity: "+String.format("%.1f", this.getDexterity())+"\n";
    }

}