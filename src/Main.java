import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String gamemode = ""; //Set default gamemode here
        Level level = new Level();

        level.addRoom("The Hub", "You are going to the Hub.", "The center of the universe.");
        level.addRoom("The Ranch", "You have been sent to the ranch.", "The perfect place to store disrespectful teenagers.");
        level.addRoom("Salvation", "Your time in the ranch has led you to salvation.", "Your life is now better because of Dr. Phil. Your welcome.");
        level.addRoom("West Virginia", "You have been taken home, to the place you belong: West Virginia.", "One of the states in the US.");
        level.addRoom("Mountain Momma", "You take the country roads to Mountain Momma.", "West Virginia, but the redneck version.");
        level.addRoom("McDonald's", "You decide to spite your health and go to McDonald's.", "I'm lovin' it.");
        level.addRoom("Texas", "You took a wrong turn, and now you're in Texas.", "Everything is bigger in Texas.");
        level.addRoom("Glue Factory", "You find a glue factory next to the ranch.", "So that's where the horses went...");
        level.addRoom("Flex World", "Phil Swift grabs you by the hand and takes you to Flex World.", "A glue lover's wet dream.");
        level.addRoom("NASA", "You go to NASA.", "Isn't NASA that government space thingy?");
        level.addRoom("Florida", "For some reason, you decide to go to Florida. It was probably an accident, because there is no reason that anyone would want to go there.", "Home of the weird Americans.");
        level.addRoom("California", "You get in a cramped car and head to California in hopes for a better life. Or maybe even some gold.", "The best state in the US. (Totally not biased.)"); //Tesla ==> Mars
        level.addRoom("The Moon", "You find a space shuttle and take it to the moon.", "I think that stealing a space shuttle is a felony.");
        level.addRoom("Boeing", "You decide to visit Boeing headquarters.", "Boeing HQ is in Florida, right?");
        level.addRoom("FRC", "Congratulations! You made it to travel team! You are now going to the robotics competition.", "Destination:Deep Space was brought to you by the Boeing Company.");
        level.addRoom("Awards Ceremony", "You can't leave competition until all of the trash is picked up.", "We're tired. We just wanna go back to the hotel.");
        level.addRoom("Tesla", "You go to Tesla Headquarters in the hopes of meeting Elon Musk himself.", "Tesla HQ is in California, right?");
        level.addRoom("Mars", "You find a car, and you drive it to Mars.", "I hope you know how to get back.");
        level.addRoom("India", "You go to India.", "India is probably cool.");
        level.addRoom("T-Series", "You go to the headquarters of the most vile company on the planet, T-Series.", "T-Series ain't nothin' but a beach lasagna!");


        level.addDirectedEdge("The Hub", "The Ranch");
        level.addDirectedEdge("The Ranch", "Salvation");
        level.addDirectedEdge("Salvation", "The Hub");
        level.addUndirectedEdge("The Hub", "West Virginia");
        level.addUndirectedEdge("West Virginia", "Mountain Momma");
        level.addUndirectedEdge("McDonald's", "West Virginia");
        level.addUndirectedEdge("The Ranch", "Glue Factory");
        level.addDirectedEdge("Glue Factory", "Flex World");
        level.addUndirectedEdge("Texas", "NASA");
        level.addUndirectedEdge("The Hub", "Texas");
        level.addDirectedEdge("NASA", "The Moon");
        level.addUndirectedEdge("The Hub", "California");
        level.addUndirectedEdge("The Hub", "Florida");
        level.addUndirectedEdge("Florida", "Boeing");
        level.addDirectedEdge("Boeing", "FRC");
        level.addDirectedEdge("FRC", "Awards Ceremony");
        level.addDirectedEdge("Awards Ceremony", "Boeing");
        level.addUndirectedEdge("California", "Tesla");
        level.addDirectedEdge("Tesla", "Mars");
        level.addUndirectedEdge("The Hub", "India");
        level.addUndirectedEdge("India", "T-Series");

        level.getRoom("The Ranch").addItem("Pewdiepie Chair", "Only $399!");
        level.getRoom("The Ranch").addItem("Ranch Dressing", "Who knew that they turned the \"Dorito's\" flavor into an actual sauce?");
        level.getRoom("West Virginia").addItem("Well of Immortality", "Life is old there, older than the trees.");
        level.getRoom("West Virginia").addItem("The Miner's Lady", "She's a stranger to blue water.");
        level.getRoom("McDonald's").addItem("The Biggest Mac", "You should probably talk to your doctor before eating this.");
        level.getRoom("Texas").addItem("Redneck Repellent", "Are you tired of racist country truck-lovers chasing you? Well, you don't have to worry about that anymore with the new Redneck Repellent™!");
        level.getRoom("Glue Factory").addItem("Glue", "Please do not sniff me.");
        level.getRoom("Flex World").addItem("Flex Seal", "It gets the tough stains out!");
        level.getRoom("NASA").addItem("Jet Feul", "Jet feul can't melt steel beams.");
        level.getRoom("FRC").addItem("Gracious Professionalism", "You better not do the finger circle!");
        level.getRoom("FRC").addItem("Pins", "You can never have enough pins.");
        level.getRoom("Tesla").addItem("Bottle of Gasoline", "Whoever brought this into Tesla HQ is getting fired for sure.");
        level.getRoom("Awards Ceremony").addItem("Empty Water Bottles", "Did I pick up enough water bottles yet?");
        level.getRoom("Mars").addItem("Opportunity Rover", "If only you had some batteries...");
        level.getRoom("T-Series").addItem("Cease And Desist", "Why did they send one to Pewdiepie? (It's because they're idiots.)");

        Player player = new Player("Crayon", "Why does a player need a description?");
        player.setCurrentRoom(level.getRoom("The Hub"));

        String response = "";
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("You are currently in " + player.getCurrentRoom().getName() + ".");
            System.out.print("What do you want to do? >\t");
            response = in.nextLine();
            System.out.println();
            String[] words = response.split(" ");

            if (words[0].equals("gamemode")) {
                gamemode = words[1];
            } else if (words[0].equals("go")) {
                String name = "";
                int firstQuote = response.indexOf("\"");
                int secondQuote = response.indexOf("\"", firstQuote + 1);
                name += response.substring(firstQuote + 1, secondQuote);
                Room nextRoom = player.getCurrentRoom().getNeighbor(name);
                if (nextRoom == null) {
                    System.out.println("That room does not exist. Please try again.");
                } else {
                    System.out.println(nextRoom.getTravelMessage());

                    player.setCurrentRoom(nextRoom);
                }
            } else if (words[0].equals("look")) {
                System.out.println(player.getCurrentRoom().getNeighborNamesAndDescriptions());
                System.out.println(player.getCurrentRoom().getItemNamesAndDescriptions());
            } else if (words[0].equals("add")) {
                String name = "";
                int firstQuote = response.indexOf("\"");
                int secondQuote = response.indexOf("\"", firstQuote + 1);
                name += response.substring(firstQuote + 1, secondQuote);
                String travelMessage = "";
                firstQuote = response.indexOf("\"", secondQuote + 1);
                secondQuote = response.indexOf("\"", firstQuote + 1);
                travelMessage += response.substring(firstQuote + 1, secondQuote);
                String description = "";
                firstQuote = response.indexOf("\"", secondQuote + 1);
                secondQuote = response.indexOf("\"", firstQuote + 1);
                description += response.substring(firstQuote + 1, secondQuote);
                if (words[1].equals("directedRoom")) {
                    level.addRoom(name, travelMessage, description);
                    level.addDirectedEdge(player.getCurrentRoom().getName(), words[2]);
                } else if (words[1].equals("undirectedRoom")) {
                    level.addRoom(name, travelMessage, description);
                    level.addUndirectedEdge(player.getCurrentRoom().getName(), words[2]);
                } else {
                    System.out.println("I'm sorry, I don't recognize that command.");
                }
            } else if (words[0].equals("take")) {
                String itemName = "";
                int firstQuote = response.indexOf("\"");
                int secondQuote = response.indexOf("\"", firstQuote + 1);
                itemName += response.substring(firstQuote + 1, secondQuote);
                if (player.getCurrentRoom().getItemIndex(itemName) != -1) {
                    player.addItem(player.getCurrentRoom().removeItem(itemName));
                    System.out.println("You have taken the " + itemName + ".");
                } else {
                    System.out.println("That item does not exist in this room.");
                }
            } else if (words[0].equals("drop")) {
                String itemName = "";
                int firstQuote = response.indexOf("\"");
                int secondQuote = response.indexOf("\"", firstQuote + 1);
                itemName += response.substring(firstQuote + 1, secondQuote);
                if (player.getItemIndex(itemName) != -1) {
                    player.getCurrentRoom().addItem(player.removeItem(itemName));
                    System.out.println("You have dropped the " + itemName + ".");
                } else {
                    System.out.println("You do not have this item.");
                }
            } else if (words[0].equals("trade")) {
                String itemName;
                int firstQuote = response.indexOf("\"");
                int secondQuote = response.indexOf("\"", firstQuote + 1);
                itemName = response.substring(firstQuote + 1, secondQuote);
                String currencyName = "";
                firstQuote = response.indexOf("\"", secondQuote + 1);
                secondQuote = response.indexOf("\"", firstQuote + 1);
                currencyName += response.substring(firstQuote + 1, secondQuote);
                if (player.hasItem(currencyName)) {
                    player.addItem(player.getCurrentRoom().removeItem(itemName));
                    player.destroyItem(currencyName);
                    System.out.println("You have taken the " + itemName + " in exchange for " + currencyName + ".");
                } else if (player.getCurrentRoom().getItemIndex(itemName) == -1) {
                    System.out.println(itemName + " does not exist in this room.");
                } else {
                    System.out.println("To get " + itemName + ", you need " + currencyName + ".");
                }
            } else if (words[0].equals("unlock")) {
                // Implement this at some point
            } else if (!response.equals("quit")) {
                System.out.println("Commands:");
                System.out.println("\t\"gamemode <gamemode>\": Switch between creative and adventure modes.");
                System.out.println("\t\"go <roomname(in quotes)>\": Travel to an existing room.");
                System.out.println("\t\"look\": Display all neighboring rooms and items in your current room.");
                System.out.println("\t\"add directedRoom <roomname(in quotes)> <travelmessage(in quotes)> <description{in quotes)>\": Create new room with a directed edge from your current room.");
                System.out.println("\t\"add undirectedRoom <roomname(in quotes)> <travelmessage(in quotes)> <description{in quotes)>\": Create new room with an undirected edge from your current room.");
                System.out.println("\t\"take <itemname(in quotes)>\": Take item from your current room.");
                System.out.println("\t\"drop <itemname(in quotes)>\": Drop item from your inventory to the current room.");
                System.out.println("\t\"trade <itemname(in quotes)> <currencyname(in quotes)>\": Trade one of your items for another in your current room.");
                System.out.println("\t\"unlock <roomname(in quotes)> <unlockitemname(in quotes)>\": Unlock a locked room using an item as a key.");
                System.out.println("\t\"craft ");
                System.out.println("\t\"quit\": Quit game.");
            }

            System.out.println();

        } while (!response.equals("quit"));

    }

}
