import java.util.Scanner;

public class Main {

        public static void main() {

            Scanner scanner = new Scanner(System.in);

            System.out.println("What is your character's name?");
            String characterName = scanner.nextLine();
            System.out.println("Choose your class");
            Character.printClasses();
            String choice = scanner.nextLine(); //Her BURDE man nok lave en switch menu

            Character character1 = new Character(characterName, choice, 100); //opretter karakter
            character1.equipWeapon(new Weapon("Mace", 15)); //karakter 1 får et weapon
            character1.equipArmor(new Armor("Metal chestplate", 3));

            Character character2 = new Character("Goblin", "Warrior", 30);
            character2.equipWeapon(new Weapon("Sword", 16));
            character2.equipArmor(new Armor("Leather helmet", 1));

            Item item1 = new Item("Health potion", 1, 10);
            Item item2 = new Item("Mana potion", 2, 8);

            character1.getInventory().addItem(item1);
            character1.getInventory().addItem(item2);

            character1.getInventory().removeItem(item2);

            character2.getInventory().addItem(new Item("Rotten apple", 2,2)); //Problem! Man kan ikke se, hvilken inventory, det tilføjes til.
            character2.getInventory().addItem(new Item("Ripe pear", 1,5));

            character1.printCharacterSheet();        //Kalder på et objekt, som kalder på en metode, som printer info om character

            character1.printCharacterInfo();
            character2.printCharacterInfo();

            Combat.combat(character1, character2);

            Character character3 = new Character("Orc", "Hunter", 80);
            character3.equipWeapon(new Weapon("Bow", 20));
            character3.equipArmor(new Armor("Leather boots", 5));

            System.out.println("A new foe emerges!");
            character3.printCharacterInfo();

            Combat.combat(character1, character3);

            Character character4 = new Character("Bossman", "Mage", 200);
            character4.equipWeapon(new Weapon("Staff", 25));
            character4.equipArmor(new Armor("Gandalf's magic robe", 7));

            character4.setLevel(5);
            System.out.println("A stronger enemy steps forward!");
            character4.printCharacterInfo();

            Combat.combat(character1, character4);
    }
}
