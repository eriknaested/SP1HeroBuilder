public class Main {

        public static void main() {

            Character character1 = new Character("Bagle", 'P'); //opretter karakter
            character1.getWeapon().equipWeapon(new Weapon("Gorehowl", 5)); //karakter 1 får et weapon


            character1.callHeroInfo();        //Kalder på et objekt, som kalder på en metode, som printer info om hero
            character1.getInventory().printInventory();    //Kalder på et objekt, som kalder på en getter-metode, som printer inventory fra en anden klasse.


            /*
            callHeroInfo();
            callInventory();                //Kalder på en metode, som samler inventory
            checkStatus();
            checkLevelUp();
            takeDamage(80);
            heal(70);
            addGold(50);
            removeGold(25);
            addXP(500);
            levelUp();

             */
    }
}
