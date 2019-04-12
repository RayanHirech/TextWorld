public class Bunny extends Creature {

    private final double STAY_IN_PLACE_CHANCE = 0.5;
    private final double CAERBANNOG_CHANCE = 0.05; //Do this stuff later
    private String[] names = {"Bobby", "Delrin", "Yop", "I Can't Believe It's Not", "Butters", "Sam", "Big Chungus"};

    public Bunny(Player player) {
        super("Bunny", "They're harmless... right?", 10, player);
        setName(getRandomName());
    }

    private String getRandomName() {
        int rand = (int)(Math.random() * names.length);
        return names[rand] + "the Bunny";
    }

    public void act() {
        double chance = Math.random();
        if (chance >= STAY_IN_PLACE_CHANCE) {
            move(randomizeRoom());
        }
    }

}
