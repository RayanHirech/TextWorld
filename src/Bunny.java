public class Bunny extends Creature {

    private final double STAY_IN_PLACE_CHANCE = 0.5;
    private final double CAERBANNOG_CHANCE = 0.05; //Do this stuff later

    public Bunny(Player player) {
        super("Bunny", "They're harmless... right?", 10, player);
    }

    public void act() {
        double chance = Math.random();
        if (chance >= STAY_IN_PLACE_CHANCE) {
            move(randomizeRoom());
        }
    }

}
