import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    
    public static void main (String[] args) throws IOException, InterruptedException {
        Player player = new Player();
        Inventory inventory = new Inventory();
        Scanner scan = new Scanner(System.in);
        
        int i = 1;
        boolean start = false;

        System.out.println("Play the intro?\ny/n");
        String intro = scan.nextLine();

            while (start == false) {
        if ((intro.equalsIgnoreCase("yes")) || (intro.equalsIgnoreCase("y"))) {    
            PrologueIntro.main(args);
           break;
        } else if ((intro.equalsIgnoreCase("no")) || (intro.equalsIgnoreCase("n"))){
        

        System.out.println("Enter protagonist's name or type 'skip' if already entered.");
        player.name = scan.nextLine();

        if (!(player.name.equalsIgnoreCase("skip"))) {
            File file = new File("log.bin");
        if ((!file.createNewFile()) && (!file.exists())) {
            scan.close();
            
            return;
        } 

            String name = player.name;
            int health = player.health;    
            System.out.println("Name: "+name+" - "+health+"%.\n");

            FileWriter writer = new FileWriter("log.bin");
            writer.write(name);
            writer.write("\n");
            writer.write(String.valueOf(health));
            writer.close();

            int beer = inventory.beer;
            int steak = inventory.steak;
            int soda = inventory.soda;
            int beers = player.beers;
            
            FileWriter writekitchen = new FileWriter("kitchenlog.bin");

            writekitchen.write(String.valueOf(beer));
            writekitchen.write("\n");
            writekitchen.write(String.valueOf(steak));
            writekitchen.write("\n");
            writekitchen.write(String.valueOf(soda));
            writekitchen.write("\n");
            writekitchen.write(String.valueOf(beers));
            writekitchen.close();

            int pills = inventory.pills;

            FileWriter writebathroom = new FileWriter("bathroomlog.bin");

            writebathroom.write(String.valueOf(pills));
            writebathroom.write("\n");
            writebathroom.close();

        }

        System.out.println("\nCorridor.");
        System.out.println(" ------ \n");
        System.out.println("Choose a room to enter.");
        System.out.println("Kitchen\nBathroom\nBedroom\nLiving room\n");

        String selection = scan.nextLine();

        boolean corridor = true;

        while (corridor == true) {
            if (selection.equalsIgnoreCase("living room")) {
                        
                if (i == 1){
                    System.out.println("The sound from your T.V. would blur out the noise in your aching head.\n");
                    i++;
                    

                    System.out.println("Choose a room to enter: ");
                    System.out.println("Living room\nKitchen\nBedroom\nBathroom");
                    selection = scan.nextLine();
                    

                } else if (i == 2){
                    System.out.println("The radio your girlfriend bought you was probaly playing a good song.\nWouldn't hurt to check.\n");
                    i ++ ;
                    
                    System.out.println("Choose a room to enter: ");
                    System.out.println("Living room\nKitchen\nBedroom\nBathroom");
                    selection = scan.nextLine();
                   


                } else if (i == 3) {
                    System.out.println("The couch you and your girlfriend spent your evenings together on was expectedly cold, after a long day away from home.\n");
                    i ++;
                    

                    System.out.println("Choose a room to enter: ");
                    System.out.println("Living room\nKitchen\nBedroom\nBathroom");
                    selection = scan.nextLine();
                    
                } else if (i > 3) {
                    i = 1;
                    
                    System.out.println("\nChoose a room to enter: ");
                    System.out.println("Living room\nKitchen\nBedroom\nBathroom");
                    selection = scan.nextLine();
                    
                }

                } else if (selection.equalsIgnoreCase("kitchen")){
                    Kitchen.main(args);
                    scan.close();
                    break;
            }   else if (selection.equalsIgnoreCase("bedroom")) {                
                int health = Integer.parseInt(Files.readAllLines(Paths.get("log.bin")).get(1));
                
                if (health < 86) {
                    System.out.println("\nNot much to do here yet.\n");

                    System.out.println("Choose a room to enter: ");
                    System.out.println("Living room\nKitchen\nBedroom\nBathroom");
                    selection = scan.nextLine();
                } else if (health >= 86) {
                    Bedroom.prologueEnd();
                    break;
                }
                } else if (selection.equalsIgnoreCase("bathroom")) {
                    Bathroom.main(args);
                    scan.close();
                    break;
                } else {
                System.out.println("Stop making rooms up.");

                System.out.println("Choose a room to enter: ");
                System.out.println("Living room\nKitchen\nBedroom\nBathroom");
                selection = scan.nextLine();
            }     
    }
    
break;
} else {
    System.out.println("Invalid choice.");

    System.out.println("Play the intro?\ny/n");
    intro = scan.nextLine();
}
    }
    }
}
