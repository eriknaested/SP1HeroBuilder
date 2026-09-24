public class Item {

    private String name;
    private double weight;
    private double value;

    public Item(String name, double weight, double value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
    }

    public String toString() { //Laver en toString til at displaye hver item
        return "Item: " + name + "\nWeight: " + weight + "\nValue: " + value + "g";
    }
}
