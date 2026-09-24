public class Armor {

    private final String name;
    private final int defensePower;

    Armor(String name, int defensePower) {
        this.name = name;
        this.defensePower = defensePower;
    }

    public String getName() {
        return name;
    }

    public int getDefensePower() {
        return defensePower;
    }

    public void armorInfo() {
        System.out.println(name + ": " + defensePower + " defense power");
        Formatting.displayDivider();
    }

}
