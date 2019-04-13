public class WoodieFlowers extends Creature {

    public WoodieFlowers(Player player) {
        super("Woodie Flowers", "Beware of Woodie Flowers. If he gets too close, then he tries to suck out your gracious professionalism, for his own use.", 50, player);
    }

    public void act() {
        for (String name : currentRoom.getNeighbors().keySet()) {
            Room room = currentRoom.getNeighbor(name);
            if (player.getCurrentRoom().equals(room) || isPlayerInNeighbors(room)) {
                move(room);
                return;
            }
        }
        move(randomizeRoom());
    }

}
