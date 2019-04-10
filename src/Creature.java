import java.util.ArrayList;
import java.util.HashMap;

public abstract class Creature {

    //Fields
    protected String name;
    protected String description;
    protected Room currentRoom;
    protected int hitPoints;
    protected Player player;

    public Creature(String name, String description, int hitPoints, Player player) {
        this.name = name;
        this.description = description;
        this.hitPoints = hitPoints;
        this.player = player;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    public void move(Room nextRoom) {
        if (currentRoom != null) {
            currentRoom.removeCreature(this);
        }
        currentRoom = nextRoom;
        nextRoom.addCreature(this);
    }

    public abstract void act();

    public Room randomizeRoom() {
        return currentRoom.getRandomNeighbor();
    }

    public Room playerIsWithin2Rooms() { //TODO do this
        return null;
    }

}
