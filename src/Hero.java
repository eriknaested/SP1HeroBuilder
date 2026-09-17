public class Hero {

    void main() {
        callHeroInfo();                 //Kalder på en metode, som samler info om hero
        callInventory();                //Kalder på en metode, som samler inventory
        checkStatus();
        checkLevelUp();
        takeDamage(80);
        heal(70);
        addGold(50);
        removeGold(25);
        addXP(500);
        levelUp();
    }

    String name = "Bagle";
    int currentHealth = 100;
    int healthMax = 100;
    int level = 5;
    int experiencePoints = 5700;
    double gold = 256.40;
    // boolean isAlive;  Boolean bruges ikke længere, da vi har lavet en metode til isAlive()
    char classification = 'P';
    String[] inventory = {"Health potion", "Mana potion", "Steel shield", "Scimitar", "Ferret"};
    boolean canLevelUp;

    String getHeroClass() {
        return switch (classification) {
            case 'P' -> classification + " (Paladin)";
            case 'W' -> classification + " (Warrior)";
            case 'M' -> classification + " (Mage)";
            case 'H' -> classification + " (Hunter)";
            case 'R' -> classification + " (Rogue)";
            default -> classification + " (Invalid class)";
        };
    }

    void displayHeader() {
        System.out.println("=============================");
    }

    void displayDivider() {
        System.out.println("----------------------------");
    }

    //Mangler stadig "Udskriv forskellige beskeder baseret på klasse (‘W’, ‘M’, ‘R’)"

    void callHeroInfo() {
        displayHeader();
        System.out.println("Hero name: " + name);
        System.out.print("Class: ");
        System.out.println(getHeroClass());
        displayDivider();
        System.out.println("HP: " + currentHealth + " out of " + healthMax);
        System.out.println("Level: " + level);
        System.out.println("XP: " + experiencePoints);
        System.out.println("Gold: " + gold);
        displayDivider();
        }

    void callInventory() {
        System.out.println("Inventory (" + inventory.length + " items):");
        displayDivider();
        /*for (int i = 0; i < inventory.length; i++) {
            System.out.println(" - " + inventory[i]);
        } */
        for (String item : inventory) {         //For each loop er mere læseligt end alm. for loop her.
            System.out.println(" - " + item);
        }
        displayDivider();
    }

    void checkLevelUp() {
        displayDivider();
        System.out.println("Current XP: " + experiencePoints);
        int xpForlevelUp = 1000 * level;
        int xpNeeded = xpForlevelUp - experiencePoints;
        if (experiencePoints > xpForlevelUp) {
            System.out.println("Ready to level up!");
            canLevelUp = true;
        } else {
            System.out.println("XP needed for level up: " + xpNeeded);
            canLevelUp = false;
        }
        displayDivider();
    }

    void checkStatus() {
        if (isHealthCritical()) {
            System.out.println("WARNING: Health critical!");
        }
        if (isAlive()) {
            System.out.println(name + " alive and healthy");
        } else {
            System.out.println(name + " is dead");
        }
        getHealthPercentage();
        System.out.println("Current health: " + getHealthPercentage() + " % of max health");
        /*if (currentHealth < (healthMax / 4)) {
            System.out.println("Current health: " + currentHealth);
            System.out.println("WARNING: Health critical!");
        } else {
            System.out.println("Current health: " + currentHealth);
        }
        if (currentHealth <= 0) {
            isAlive = false;
        } else {
            isAlive = true;
        }
        System.out.println("Hero alive: " + isAlive);
        displayDivider();
         */ //Udekommenteret if-statements, da isHealthCritical og isAlive laves til egne metoder som kaldes i checkStatus
    }

    boolean isHealthCritical() {
        if (currentHealth < (healthMax / 4)) {
            return true;
        } else {
            return false;
        }
    }

    boolean isAlive() {
        if (currentHealth > 0) {
            return true;
        } else {
            return false;
        }
    }

    double getHealthPercentage() {
        double healthPercentage = (double) currentHealth / healthMax * 100;
        return healthPercentage;
    }

    void takeDamage(int amount) {
        currentHealth -= amount;
        System.out.println("Damage taken: " + amount);
        System.out.println("Current health: " + currentHealth);
        displayDivider();
    }

    void heal(int amount) {
        if (currentHealth + amount < healthMax) {
            currentHealth += amount;
            System.out.println("Healed: " + amount);
        } else {             //Dette if-statement gør, at man ikke kan heale, hvis man ville heale over max health.
                            //Hvordan tilføjer man en mulighed for det tredje scenarie?
            System.out.println("Already full health");
        }
        System.out.println("Current health: " + currentHealth);
        displayDivider();
    }

    void checkGold() {
        System.out.println("Current gold: " + gold);
        displayDivider();
    }

    void addGold (double amount) {
        gold += amount;
        System.out.println("Gold added: " + amount);
        checkGold();
    }

    boolean removeGold(double amount) {
        if (gold >= amount) {
            gold -= amount;
            System.out.println("Gold spent: " + amount);
            checkGold();
            return true;
        } else {
            return false;
        }
    }

    void addXP(int amount) {
        experiencePoints += amount;
        System.out.println("XP gained: " + amount);
        checkLevelUp();
    }

    void levelUp() {
        checkLevelUp();  //Kan måske laves til en separat metode for, når man ikke har brug for print på status.
        if (canLevelUp) {
            level++;
            experiencePoints = 0;
            healthMax *= 1.1; //Ganger med 1.1 for at healthMax stiger eksponentielt for hver level.
        } else {
            System.out.println("Cannot level up yet. Get more experience");
        }

    }


}


