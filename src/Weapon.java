public class Weapon {

    private final String name;
    private final int attackPower;

    Weapon(String name, int attackPower){
        this.name = name;
        this.attackPower = attackPower;
    }

    public String getName() {
        return name;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void weaponInfo() {
        System.out.println(name + ": " + attackPower + " attack power");
        Formatting.displayDivider();
    }
}
