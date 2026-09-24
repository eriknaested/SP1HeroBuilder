import java.util.Scanner;

public class Main {

        public static void main() {

            Scanner scanner = new Scanner(System.in);

            System.out.println("What is your character's name?");
            String characterName = scanner.nextLine();
            System.out.println("Choose your class");
            Character.printClasses();
            String choice = scanner.nextLine();

            Character character1 = new Character(characterName, choice, 100); //opretter karakter
            character1.equipWeapon(new Weapon("Mace", 15)); //karakter 1 får et weapon
            character1.equipArmor(new Armor("Metal chestplate", 3));

            Character character2 = new Character("Goblin", "Warrior", 30);
            character2.equipWeapon(new Weapon("Sword", 16));
            character2.equipArmor(new Armor("Leather helmet", 1));

            character1.getInventory().addItem(new Item("Health potion", 1,10));
            character1.getInventory().addItem(new Item("Mana potion", 1,8));

            character2.getInventory().addItem(new Item("Rotten apple", 2,2));
            character2.getInventory().addItem(new Item("Ripe pear", 1,5));

            character1.printCharacterSheet();        //Kalder på et objekt, som kalder på en metode, som printer info om character

            character1.printCharacterInfo();
            character2.printCharacterInfo();

            System.out.println("Fight commencing!");

            for (int round = 1; character1.isAlive() || character2.isAlive(); round++) {
                character1.attack(character2);
                character2.attack(character1);
                character1.heal();
                character2.heal();
            }


    }
}
