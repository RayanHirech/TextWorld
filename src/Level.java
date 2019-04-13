import java.util.ArrayList;
import java.util.HashMap;

public class Level {

    private HashMap<String, Room> nodes;
    private ArrayList<Creature> creatures;

    public Level() {
        nodes = new HashMap<>();
        creatures = new ArrayList<>();
    }

    public void addCreature(Creature c) {
        creatures.add(c);
    }

    public ArrayList<Creature> getCreatures() {
        return this.creatures;
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

}
