import java.util.ArrayList;

public class Player {

    private String name;
    private String description;
    private ArrayList<Item> items;
    private Room currentRoom;

    public Player(String name, String description) {
        this.name = name;
        this.description = description;
        items = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }
    public String getDescription() {
        return this.description;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public int getItemIndex(String name) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Item removeItem(String name) {
        int itemIndex = getItemIndex(name);
        if (itemIndex != -1) {
            return items.remove(itemIndex);
        }
        return null;
    }

    public boolean destroyItem(String name) {
        int itemIndex = getItemIndex(name);
        if (itemIndex != -1) {
            items.remove(itemIndex);
            return true;
        }
        return false;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void displayInventory() {
        System.out.println("Your items:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println("\t" + items.get(i).getName());
        }
    }

    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    public void setCurrentRoom(Room newRoom) {
        this.currentRoom = newRoom;
    }

    public boolean moveToRoom(String name) {
        if (currentRoom.getNeighbor(name) != null) {
            currentRoom = currentRoom.getNeighbor(name);
            return true;
        }
        return false;
    }

    public boolean hasItem(String name) {
        for (Item i : items) {
            if (i.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

}
