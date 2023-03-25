import java.io.File;
import java.util.Scanner;

import Classes.Character;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        Character c1 = new Character();
        Character c2 = new Character();
        File file = new File("Char.txt");

        int select;
        do {
            if(file.length() == 0) {
                select = 2;
            } else {
                try {
                    c1 = c1.deserialize();
                } catch (Exception e) {
                    System.out.println("Character file deleted.");
                    file.delete();
                }
                System.out.println(c1.toString());
                System.out.print("1: Continue\n2: New Character\n3: Delete Character\n4: Exit\nSelection: ");
                select = sc.nextInt();

            }

            switch(select){
                case 1:
                c2 = Character.rndEnemyCharacter(c1);
                System.out.println(c2.toString());
    
                Character.fight(c1, c2);
    
                c1.levelUp();
    
                c1.serialize();
                break;
                case 2:
                c1 = Character.createCharacter();
                c2 = Character.rndEnemyCharacter(c1);

                System.out.println(c1.toString());
                System.out.println(c2.toString());

                Character.fight(c1, c1);

                c1.levelUp();
        
                c1.serialize();
                break;
                case 3:
                file.delete();
                break;
                case 4:
                System.exit(0);
            }
        } while (select != 3);
        sc.close();
    }
}
