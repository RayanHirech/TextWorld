public class Wumpus extends Creature {

    public Wumpus(Player player) {
        super("Wumpus", "You have an intense urge to kill the Wumpus, after it shut down your computer and made you lose several hours of progress on your Text World.", 20, player);
    }

    public void act() {
        Room nextRoom;
        int counter =0;
        do {
            nextRoom = randomizeRoom();
            counter++;
            if (counter >= 10) {
                nextRoom = currentRoom;
                break;
            }
        } while (nextRoom.equals(player.getCurrentRoom()));
        move(nextRoom);
    }

    public void runAway() {
        Room nextRoom;
        int counter = 0;
        do {
            nextRoom = randomizeRoom();
            counter++;
            if (counter >= 15) {
                nextRoom = currentRoom;
                break;
            }
        } while (nextRoom.equals(player.getCurrentRoom()) || isPlayerInNeighbors(nextRoom));
        move(nextRoom);
    }

}
