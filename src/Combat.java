public class Combat {


    public static void combat(Character hero, Character target) {

        System.out.println("Combat commences");

        for (int round = 1; hero.isAlive() && target.isAlive(); round++) {
            System.out.println("Round: " + round);
            hero.attack(target);
            target.attack(hero);
            Formatting.displayDivider();
        }

        if (hero.isAlive() && !target.isAlive()) {
            System.out.println(hero.getName() + " defeats " + target.getName());
            hero.levelUp();
        } else {
            System.out.println(target.getName() + " defeats " + hero.getName() + "!");
            Formatting.displayDivider();
            System.out.println(" === GAME OVER ===");
        }
    }
}
