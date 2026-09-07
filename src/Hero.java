public class Hero {

    void main() {

        String name = "Bagel";
        int healthPoints = 85;
        int healthMax = 100;
        int level = 57;
        int experiencePoints = 5700;
        double gold = 256.40;
        boolean isAlive;
        if (healthPoints != 0) {
            isAlive = true;
        } else {
            isAlive = false;
        }
        String classification = "Paladin";
        String[] inventory = {"Health potion", "Mana potion", "Steel shield", "Scimitar", "Ferret"};

        System.out.println("Hero name: " + name);
        System.out.println("HP: " + healthPoints + " out of " + healthMax);
        System.out.println("Level: " + level);
        System.out.println("XP: " + experiencePoints);
        System.out.println("Gold: " + gold);
        if (isAlive) {
            System.out.println("Status: Hero alive");
        } else {
            System.out.println("Status: Hero dead");
        }
        System.out.println("Class: " + classification);

    }
}


