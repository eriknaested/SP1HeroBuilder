public class Hero {

    void main() {
        callHero();
        callInventory();
    }

    String name = "Bagel";
    int healthPoints = 85;
    int healthMax = 100;
    int level = 57;
    int experiencePoints = 5700;
    double gold = 256.40;
    boolean isAlive;
    String classification = "Paladin";
    String[] inventory = {"Health potion", "Mana potion", "Steel shield", "Scimitar", "Ferret"};


    void displayHeader() {
        System.out.println("=============================");
    }

    void displayDivider() {
        System.out.println("----------------------------");
    }

    void callHero() {
        displayHeader();
        System.out.println("Hero name: " + name);
        System.out.println("Class: " + classification);
        displayDivider();
        System.out.println("HP: " + healthPoints + " out of " + healthMax);
        System.out.println("Level: " + level);
        System.out.println("XP: " + experiencePoints);
        System.out.println("Gold: " + gold);
        if (healthPoints > 0) {
            System.out.println("Status: Hero alive");
        } else {
            System.out.println("Status: Hero dead");
        }
        displayDivider();


        }
    void callInventory() {
        System.out.println("Inventory (" + inventory.length + " items):");
        displayDivider();
        for (int i = 0; i < inventory.length; i++) {
            System.out.println(" - " + inventory[i]);
        }
    }


}


