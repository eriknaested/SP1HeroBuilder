import java.util.ArrayList;

public class Inventory {

    private static final int MAX_ITEMS = 10; //Alle karakterer har samme max items
    private static final int STARTING_ITEMS = 0; //Alle karakterer starter med 0 items
    private int currentItems = STARTING_ITEMS;
    private ArrayList<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        if(currentItems < MAX_ITEMS) {
            items.add(item);
            currentItems++;
        } else {
            System.out.println("Inventory is full");
        }
    }

    public void removeItem(Item item) {
        if(currentItems > 0){
            items.remove(item);
            currentItems--;
        } else {
            System.out.println("Inventory is empty. No items to remove");
        }
    }

    public void printInventory() {
        System.out.println(" === INVENTORY ===");
        for (Item item : items) {
            System.out.println(item.toString());
            Formatting.displayDivider();
        }
    }

    public ArrayList<Item> getItems() {
        return items;
    }


}
