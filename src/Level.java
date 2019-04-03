import java.util.ArrayList;
import java.util.HashMap;

public class Level {

    private HashMap<String, Room> nodes;

    public Level() {
        nodes = new HashMap<>();
    }

    public void addRoom(String name, String travelMessage, String description) {
        Room room = new Room(name, travelMessage, description);
        nodes.put(name, room);
    }

    public Room getRoom(String name) {
        for (String str : nodes.keySet()) {
            if (str.equals(name)) {
                return nodes.get(str);
            }
        }
        return null;
    }

    public void addDirectedEdge(String name1, String name2) {
        Room node1 = getRoom(name1);
        Room node2 = getRoom(name2);
        node1.addNeighbor(node2);
    }

    public void addUndirectedEdge(String name1, String name2) {
        Room node1 = getRoom(name1);
        Room node2 = getRoom(name2);
        node1.addNeighbor(node2);
        node2.addNeighbor(node1);
    }

    public String debugString() {
        String str = "";
        for (String name : nodes.keySet()) {
            str += name + ",";
        }
        return str;
    }

    public class Room {

        private String name;
        private String travelMessage;
        private String description;
        private HashMap<String, Room> neighbors;
        private ArrayList<Item> items;

        public Room(String name, String travelMessage, String description) {
            neighbors = new HashMap<>();
            items = new ArrayList<>();
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

        public void addNeighbor(Room neighbor) {
            neighbors.put(neighbor.getName(), neighbor);
        }

        public String getNeighborNamesAndDescriptions() {
            if (neighbors.size() <= 0) {
                return "nowhere";
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

        public Room getNeighbor(String name) {
            for (String str : neighbors.keySet()) {
                if (str.equals(name)) {
                    return neighbors.get(str);
                }
            }
            return null;
        }

        public ArrayList<Item> getItems() {
            return items;
        }

        public void displayItems() {
            System.out.println("Items in the room:");
            for (int i = 0; i < items.size(); i++) {
                System.out.println("\t" + items.get(i).getName());
            }
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

}
