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

        level.addDirectedEdge("The Hub", "The Ranch");
        level.addDirectedEdge("The Ranch", "Salvation");
        level.addDirectedEdge("Salvation", "The Hub");
        level.addUndirectedEdge("The Hub", "West Virginia");
        level.addUndirectedEdge("West Virginia", "Mountain Momma");

        level.getRoom("The Ranch").addItem("Pewdiepie Chair", "Only $399!");
        level.getRoom("The Ranch").addItem("Ranch Dressing", "Who knew that they turned the \"Dorito's\" flavor into an actual sauce?");
        level.getRoom("West Virginia").addItem("Well of Immortality", "Life is old there, older than the trees.");
        level.getRoom("West Virginia").addItem("The Miner's Lady", "She's a stranger to blue water.");

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
