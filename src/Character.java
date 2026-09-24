import java.util.ArrayList;

public class Character {

    private final String name; //Navn er final så det ikke ændres
    private final char classification; //Class er final da det heller ikke skal ændres senere
    private int currentHealth;
    private int healthMax = 100;
    private int level = 1;
    private int experiencePoints = 0;
    private double gold;
    // boolean isAlive;  Boolean bruges ikke længere, da vi har lavet en metode til isAlive()
    private Inventory inventory;
    private Weapon weapon;

    public Character(String name, char classification) {
        this.name = name;
        this.classification = classification;
        this.currentHealth = healthMax;
        this.inventory = new Inventory();
    }

    public String getHeroClass() {
        return switch (classification) {
            case 'P' -> classification + " (Paladin)";
            case 'W' -> classification + " (Warrior)";
            case 'M' -> classification + " (Mage)";
            case 'H' -> classification + " (Hunter)";
            case 'R' -> classification + " (Rogue)";
            default -> classification + " (Invalid class)";
        };
    }

    //Mangler stadig "Udskriv forskellige beskeder baseret på klasse (‘W’, ‘M’, ‘R’)"

    public void callHeroInfo() {
        Formatting.displayHeader();
        System.out.println("Hero name: " + name);
        System.out.print("Class: ");
        System.out.println(getHeroClass());
        Formatting.displayDivider();
        System.out.println("HP: " + currentHealth + " out of " + healthMax);
        System.out.println("Level: " + level);
        System.out.println("XP: " + experiencePoints);
        System.out.println("Gold: " + gold);
        Formatting.displayDivider();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    /*
        System.out.println("Inventory (" + inventory + " items):");
        Formatting.displayHeader();
        for (int i = 0; i < inventory.length; i++) {
            System.out.println(" - " + inventory[i]);
        }
        for (String item : inventory) {         //For each loop er mere læseligt end alm. for loop her.
            System.out.println(" - " + item);
        }
        Formatting.displayDivider();
        */

    public boolean canLevelUp() {
        return experiencePoints > 1000 * level;
    }

    public void checkLevelUp() {
        Formatting.displayHeader();
        System.out.println("Current XP: " + experiencePoints);
        int xpForLevelUp = 1000 * level;
        int xpNeeded = xpForLevelUp - experiencePoints;
        if (canLevelUp()) {
            System.out.println("Ready to level up!");
        } else {
            System.out.println("XP needed for level up: " + xpNeeded);
        }
        Formatting.displayDivider();
    }

    public void levelUp() {
        checkLevelUp();  //Kan måske laves til en separat metode for, når man ikke har brug for print på status.
        if (canLevelUp()) {
            level++;
            experiencePoints = 0;
            healthMax *= 1.1; //Ganger med 1.1 for at healthMax stiger eksponentielt for hver level.
        } else {
            System.out.println("Cannot level up yet. Get more experience");
        }
    }

    public void checkStatus() {
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

    public boolean isHealthCritical() {
        if (currentHealth < (healthMax / 4)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isAlive() {
        if (currentHealth > 0) {
            return true;
        } else {
            return false;
        }
    }

    public double getHealthPercentage() {
        double healthPercentage = (double) currentHealth / healthMax * 100;
        return healthPercentage;
    }

    public void takeDamage(int amount) {
        currentHealth -= amount;
        System.out.println("Damage taken: " + amount);
        System.out.println("Current health: " + currentHealth);
        Formatting.displayHeader();
    }

    public void heal(int amount) {
        if (currentHealth + amount < healthMax) {
            currentHealth += amount;
            System.out.println("Healed: " + amount);
        } else {             //Dette if-statement gør, at man ikke kan heale, hvis man ville heale over max health.
            //Hvordan tilføjer man en mulighed for det tredje scenarie?
            System.out.println("Already full health");
        }
        System.out.println("Current health: " + currentHealth);
        Formatting.displayDivider();
    }

    public void checkGold() {
        System.out.println("Current gold: " + gold);
        Formatting.displayHeader();
    }

    public void addGold (double amount) {
        gold += amount;
        System.out.println("Gold added: " + amount);
        checkGold();
    }

    public boolean removeGold(double amount) {
        if (gold >= amount) {
            gold -= amount;
            System.out.println("Gold spent: " + amount);
            checkGold();
            return true;
        } else {
            return false;
        }
    }

    public void addXP(int amount) {
        experiencePoints += amount;
        System.out.println("XP gained: " + amount);
        checkLevelUp();
    }



}
