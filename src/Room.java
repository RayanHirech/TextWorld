import java.util.ArrayList;
import java.util.HashMap;

public class Room {

    private String name;
    private String travelMessage;
    private String description;
    private HashMap<String, Room> neighbors;
    private ArrayList<Item> items;
    private ArrayList<Creature> creatures;

public Room(String name, String travelMessage, String description) {
        neighbors = new HashMap<>();
        items = new ArrayList<>();
        creatures = new ArrayList<>();
        this.name = name;
        this.travelMessage = travelMessage;
        this.description = description;
        }

public String getName() {
        return this.name;
        }

public String getTravelMessage() {
        return this.travelMessage;
        }

public String getDescription() {
        return this.description;
        }

    public HashMap<String, Room> getNeighbors() {
        return this.neighbors;
    }

    public Room getRandomNeighbor() {
        ArrayList<Room> rooms = new ArrayList<>(neighbors.values());
        if (rooms.size() != 0) {
            int roomIndex = (int) (Math.random() * rooms.size());
            return rooms.get(roomIndex);
        }
        return null;
    }

public void addNeighbor(Room neighbor) {
        neighbors.put(neighbor.getName(), neighbor);
        }

public String getNeighborNamesAndDescriptions() {
        if (neighbors.size() <= 0) {
        return "no neighboring roomss";
        }
        String output = "Neighboring Rooms:\n";
        for (String name : neighbors.keySet()) {
        output += "\t" + name + ": " + neighbors.get(name).getDescription() + "\n";
        }
        return output;
        }

public String getItemNamesAndDescriptions() {
        if (items.size() <= 0) {
        return "no items";
        }
        String output = "Items in " + getName() + ":\n";
        for (int i = 0; i < items.size(); i++) {
        output += "\t" + items.get(i).getName() + ": " + items.get(i).getDescription() + "\n";
        }
        return output;
        }

    public String getCreatureNamesAndDescriptions() {
        if (items.size() <= 0) {
            return "no creatures";
        }
        String output = "Creatures in " + getName() + ":\n";
        for (int i = 0; i < creatures.size(); i++) {
            output += "\t" + creatures.get(i).getName() + ": " + creatures.get(i).getDescription() + "\n";
        }
        return output;
    }

public Room getNeighbor(String name) {
        for (String str : neighbors.keySet()) {
        if (str.equals(name)) {
        return neighbors.get(str);
        }
        }
        return null;
        }

    public ArrayList<Creature> getCreatures() {
        return creatures;
    }

    public void addCreature(Creature creature) {
        creatures.add(creature);
    }

    public void removeCreature(Creature creature) {
        creatures.remove(creature);
    }

public ArrayList<Item> getItems() {
        return items;
        }

public void addItem(String name) {
        addItem(name, "");
        }
public void addItem(String name, String description) {
        Item item = new Item(name, description);
        addItem(item);
        }
public void addItem(Item item) {
        items.add(item);
        }

public int getItemIndex(String name) {
        for (int i = 0; i < items.size(); i++) {
        if (items.get(i).getName().equals(name)) {
        return i;
        }
        }
        return -1;
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

}