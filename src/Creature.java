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

    public void move(Room nextRoom) {
        currentRoom = nextRoom;
    }

    public abstract void act();

    public Room randomizeRoom() {
        return currentRoom.getRandomNeighbor();
    }

}