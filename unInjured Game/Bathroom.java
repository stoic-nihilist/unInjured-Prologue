import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Bathroom {

    public static int openCabinet() throws IOException,InterruptedException {
        
        String item;
        Scanner scan = new Scanner(System.in);
        
        int pills = Integer.parseInt(Files.readAllLines(Paths.get("bathroomlog.bin")).get(0));
        boolean open = true;

        String name = Files.readAllLines(Paths.get("log.bin")).get(0);
        int health = Integer.parseInt(Files.readAllLines(Paths.get("log.bin")).get(1));
        
        System.out.println("Pick an item or close the cabinet.");
                System.out.println("Pills: "+pills);
                item = scan.nextLine();

        
        while (open == true) {
            if (pills == 0) {
                System.out.println("Cabinet empty.");
                Bathroom.main(null);;
                scan.close();
                break;
            } else {
                

                if (item.equalsIgnoreCase("pills")) {
                    if (pills == 0) {
                        System.out.println("None left.");
                    } else if (pills >= 1) {
                         if (health <= 99){
                        pills -= 1;
                        System.out.println("Pills -1: "+pills);
                        health += 20;
                        
                        if (health >= 100) {
                            FileWriter writer = new FileWriter("log.bin");
            
                                writer.write(name);
                                writer.write("\n");
                                writer.write(String.valueOf(100));
                                writer.close();
                            System.out.println("Health full.");
                            Bathroom.main(null);
                            scan.close();
                            break;
                        } 

                        System.out.println("Health +20: "+health);

                        FileWriter writer = new FileWriter("log.bin");
                        writer.write(name);
                        writer.write("\n");
                        writer.write(String.valueOf(health));
                        writer.close();

                        FileWriter writebathroom = new FileWriter("bathroomlog.bin");

                        writebathroom.write(String.valueOf(pills));
                        writebathroom.write("\n");
                        writebathroom.close();
                        }

                    } else if (health >= 100) {
                        FileWriter writer = new FileWriter("log.bin");
        
                            writer.write(name);
                            writer.write("\n");
                            writer.write(String.valueOf(100));
                            writer.close();
                        System.out.println("Health full.");
                        Bathroom.main(null);
                        scan.close();
                        break;
                    } 

                    
                } else if (item.equalsIgnoreCase("close")) {
                    Bathroom.main(null);
                    scan.close();
                    break;
                } else {
                    System.out.println("No time for bathroom breaks.");

                    System.out.println("Pick an item or close the cabinet.");
                    System.out.println("Pills: "+pills);
                    item = scan.nextLine();
                }

                    
                    System.out.println("Pick an item or close the cabinet.");
                    System.out.println("Pills: "+pills);
                    item = scan.nextLine();
            }
         }

         

         
         System.out.println(name+"'s health: "+health+"%");
         return health;

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        
        boolean bathroom = true;

        System.out.println("\nBathroom");
        System.out.println(" ----- \n");

        String name = Files.readAllLines(Paths.get("log.bin")).get(0);
        int health = Integer.parseInt(Files.readAllLines(Paths.get("log.bin")).get(1));
        System.out.println(name+"'s health: "+health+"%");

        System.out.println("Open the cabinet or leave "+name+"'s bathroom.");
        String selection = scan.nextLine();

        while (bathroom == true) {
            if ((selection.equalsIgnoreCase("cabinet")) || (selection.equalsIgnoreCase("open"))) {
                    openCabinet();
                    scan.close();
                    break;
            } else if (selection.equalsIgnoreCase("leave")) {
                    Main.main(args);                    
                    break;
            } else {
                System.out.println("You better not be trying to jack off in your condition.");

                System.out.println("Open the cabinet or leave "+name+"'s bathroom.");
                selection = scan.nextLine();

            }
        }

    }
}