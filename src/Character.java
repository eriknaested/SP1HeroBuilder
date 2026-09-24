import java.util.Random;

public class Character {

    private final String name; //Navn er final så det ikke ændres
    private final String classification; //Class er final da det heller ikke skal ændres senere
    private int currentHealth;
    private int level = 1; //Alle starter i lvl 1
    private int healthMax = 100 + (level - 1) * 20 ; //Max health er ikke final, da vi ønsker mulighed for at øge den med ved level up.
    //i tillæg har vi en funktion, som øger healthMax med 20 ved hvert level up.
    private int experiencePoints = 0;
    private double gold;
    // boolean isAlive;  Boolean bruges ikke længere, da vi har lavet en metode til isAlive()
    private Inventory inventory;
    private Weapon weapon; //tilføjer weapon og armor, som har betydning for combat
    private Armor armor;
    Random random = new Random(); //Opretter en random number generator til combat

    public Character(String name, String classification) {
        this.name = name;
        this.classification = classification;
        this.currentHealth = healthMax;
        this.inventory = new Inventory();
    }

    //Mangler stadig "Udskriv forskellige beskeder baseret på klasse (‘W’, ‘M’, ‘R’)"

    public void printCharacterSheet() {
        Formatting.displayHeader();
        System.out.println("Character name: " + name);
        System.out.print("Class: " + classification);
        System.out.println();
        Formatting.displayDivider();
        System.out.println("HP: " + currentHealth + " out of " + healthMax);
        System.out.println("Level: " + level);
        System.out.println("XP: " + experiencePoints);
        System.out.println("Gold: " + gold);
        Formatting.displayDivider();
        getInventory().printInventory();
        getWeapon().weaponInfo();
        getArmor().armorInfo();
    }

    public void printCharacterInfo() {
        System.out.println(" === " + name + " === ");
        System.out.println("Level: " + level + " | " + "Health: " + currentHealth + "/" + healthMax + " | " + "Gold: " + gold);
    }

    public static void printClasses() {
        System.out.println("--- Class overview ---");
        System.out.println("1. Paladin");
        System.out.println("2. Warrior");
        System.out.println("3. Hunter");
        System.out.println("4. Mage");
        System.out.println("5. Rogue");
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void equipWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void equipArmor(Armor armor) {
        this.armor = armor;
    }

    public void attack(Character target) { //Objekt angriber andet objekt.
        int damage = weapon.getAttackPower() + (random.nextInt(6) + 1) - armor.getDefensePower();
        //Damage regnes ud fra våbens attackPower + et terningekast på 1 til 6. defensePower fra armor trækkes fra endelige damage.
        if(damage > 0) { //Target kan kun tage damage, hvis det er over 0.
            // Dette sikrer, at et angreb ikke healer target, hvis de fx. har meget defensePower.
            target.currentHealth -= damage;
        }
        if (currentHealth < 0) { //Health kan ikke komme under 0
            currentHealth = 0;
        }
        System.out.println(name + " attacked " + target.name + " for " + damage + " damage!");
    }

    public void heal() {
        int heal = random.nextInt(6) + 1;
        currentHealth += heal; //Healer ud fra et terningekast
        if (currentHealth + heal > healthMax){
            healthMax = 100 + (level - 1) * 20;
        }
        System.out.println(name + " healed for " + heal + " damage!");
    }

    public String getClassification() {
        return classification;
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
