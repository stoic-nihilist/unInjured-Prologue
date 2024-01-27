import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Kitchen {
    public static int openFridge() throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        
        
        String item;

        
        int beer = Integer.parseInt(Files.readAllLines(Paths.get("kitchenlog.bin")).get(0));
        int steak = Integer.parseInt(Files.readAllLines(Paths.get("kitchenlog.bin")).get(1));
        int soda = Integer.parseInt(Files.readAllLines(Paths.get("kitchenlog.bin")).get(2));
        int beers = Integer.parseInt(Files.readAllLines(Paths.get("kitchenlog.bin")).get(3));
        

        boolean open = true;
           

        String name = Files.readAllLines(Paths.get("log.bin")).get(0);
        int health = Integer.parseInt(Files.readAllLines(Paths.get("log.bin")).get(1));

        System.out.println("Select an item or close the fridge.");
        System.out.println("Beer: "+beer+"\nSteak: "+steak+"\nSoda: "+soda+"\n");
        item = scan.nextLine();
        while (open == true) {
            if ((beer == 0) && (steak == 0) && (soda == 0)){
                System.out.println("Fridge empty.");
                Kitchen.main(null);;
                scan.close();
                break;
            } else {
            if (item.equalsIgnoreCase("beer")) {
                if (beer == 0) {
                    System.out.println("None left.");
                } else if (health >= 100) {
                    FileWriter writer = new FileWriter("log.bin");
    
                        writer.write(name);
                        writer.write("\n");
                        writer.write(String.valueOf(100));
                        writer.close();
                    System.out.println("Health full.");
                    Kitchen.main(null);
                    scan.close();
                    break;
                } else {
                      if (health <= 99) {
                    beers += 1;
                    beer -= 1;
                    System.out.println("Beer -1: "+beer);
                    
                if (beers <= 2 ) {
                    health += 10;
                    

                    if (health >= 100) {
                        FileWriter writer = new FileWriter("log.bin");
        
                            writer.write(name);
                            writer.write("\n");
                            writer.write(String.valueOf(100));
                            writer.close();
                        System.out.println("Health full.");
                        Kitchen.main(null);
                        scan.close();
                        break;
                    }
                    System.out.println("Health +10: "+health);

                    FileWriter writer = new FileWriter("log.bin");

                    writer.write(name);
                    writer.write("\n");
                    writer.write(String.valueOf(health));
                    writer.close();
                } else if (beers > 2) {
                    System.out.println("You've had too many beers.");
                    health -= 8;
                    System.out.println("Health -8: "+health);

                    
                    FileWriter writer = new FileWriter("log.bin");

                    writer.write(name);
                    writer.write("\n");
                    writer.write(String.valueOf(health));
                    writer.close();
                }
            }
            }

            FileWriter writekitchen = new FileWriter("kitchenlog.bin");

            writekitchen.write(String.valueOf(beer));
            writekitchen.write("\n");
            writekitchen.write(String.valueOf(steak));
            writekitchen.write("\n");
            writekitchen.write(String.valueOf(soda));
            writekitchen.write("\n");
            writekitchen.write(String.valueOf(beers));
            writekitchen.close();
           
                    System.out.println("Select an item or close the fridge.");
                    System.out.println("Beer: "+beer+"\nSteak: "+steak+"\nSoda: "+soda+"\n");
                    item = scan.nextLine();                    
            } else if (item.equalsIgnoreCase("steak")) {
                if (steak == 0) {
                    System.out.println("None left.");
                } else if (health >= 100) {
                    FileWriter writer = new FileWriter("log.bin");
    
                        writer.write(name);
                        writer.write("\n");
                        writer.write(String.valueOf(100));
                        writer.close();
                    System.out.println("Health full.");
                    Kitchen.main(null);
                    scan.close();
                    break;
                } else {
                      if (health <= 99){
                    steak -= 1;
                    System.out.println("Steak -1: "+steak);
                    health += 10;
                    

                    if (health >= 100) {
                        FileWriter writer = new FileWriter("log.bin");
        
                            writer.write(name);
                            writer.write("\n");
                            writer.write(String.valueOf(100));
                            writer.close();
                        System.out.println("Health full.");
                        Kitchen.main(null);
                        scan.close();
                        break;
                    }
                    System.out.println("Health +10: "+health);

                    FileWriter writer = new FileWriter("log.bin");

                    writer.write(name);
                    writer.write("\n");
                    writer.write(String.valueOf(health));
                    writer.close();
                }
                }

                FileWriter writekitchen = new FileWriter("kitchenlog.bin");

            writekitchen.write(String.valueOf(beer));
            writekitchen.write("\n");
            writekitchen.write(String.valueOf(steak));
            writekitchen.write("\n");
            writekitchen.write(String.valueOf(soda));
            writekitchen.write("\n");
            writekitchen.write(String.valueOf(beers));
            writekitchen.close();
            
                    System.out.println("Select an item or close the fridge.");
                    System.out.println("Beer: "+beer+"\nSteak: "+steak+"\nSoda: "+soda+"\n");
                    item = scan.nextLine(); 
            } else if (item.equalsIgnoreCase("soda")) {
                if (soda == 0) {
                    System.out.println("None left.");
                } else if (health >= 100) {
                    FileWriter writer = new FileWriter("log.bin");
    
                        writer.write(name);
                        writer.write("\n");
                        writer.write(String.valueOf(100));
                        writer.close();
                    System.out.println("Health full.");
                    Kitchen.main(null);
                    scan.close();
                    break;
                } else {
                     if (health <= 99) {
                    soda -= 1;
                    System.out.println("Soda -1: "+soda);
                    health += 10;
                    
                    if (health >= 100) {
                        FileWriter writer = new FileWriter("log.bin");
        
                            writer.write(name);
                            writer.write("\n");
                            writer.write(String.valueOf(100));
                            writer.close();
                        System.out.println("Health full.");
                        Kitchen.main(null);
                        scan.close();
                        break;
                    } 
                    System.out.println("Health +10: "+health);

                    FileWriter writer = new FileWriter("log.bin");

                    writer.write(name);
                    writer.write("\n");
                    writer.write(String.valueOf(health));
                    writer.close();
                }
                }

                FileWriter writekitchen = new FileWriter("kitchenlog.bin");

            writekitchen.write(String.valueOf(beer));
            writekitchen.write("\n");
            writekitchen.write(String.valueOf(steak));
            writekitchen.write("\n");
            writekitchen.write(String.valueOf(soda));
            writekitchen.write("\n");
            writekitchen.write(String.valueOf(beers));
            writekitchen.close();
           
                    System.out.println("Select an item or close the fridge.");
                    System.out.println("Beer: "+beer+"\nSteak: "+steak+"\nSoda: "+soda+"\n");
                    item = scan.nextLine(); 
            } else if (item.equalsIgnoreCase("close")) {
                Kitchen.main(null);
                scan.close();
                break;
            } else {
                System.out.println("You weren't expecting to find a severed head, were you?");

                System.out.println("Select an item or close the fridge.");
                System.out.println("Beer: "+beer+"\nSteak: "+steak+"\nSoda: "+soda+"\n");
                item = scan.nextLine(); 
            }
                }
                
        }

    
        
         System.out.println(name+"'s health: "+health+"%");
        return health;
    }

    public static void main (String[] args) throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        
        boolean kitchen = true;

        System.out.println("\nKitchen");
        System.out.println(" ----- \n");

        String name = Files.readAllLines(Paths.get("log.bin")).get(0);
        int health = Integer.parseInt(Files.readAllLines(Paths.get("log.bin")).get(1));
        System.out.println(name+"'s health: "+health+"%");

        System.out.println("Open the fridge or leave "+name+"'s kitchen.");
        String selection = scan.nextLine();

        while (kitchen == true) {
            if ((selection.equalsIgnoreCase("fridge")) || (selection.equalsIgnoreCase("open"))) {
                    openFridge();
                    scan.close();
                    break;
            } else if (selection.equalsIgnoreCase("leave")) {
                    Main.main(args);                    
                    break;
            } else {
                System.out.println("You're too tired to cook anything.");

                System.out.println("Open the fridge or leave "+name+"'s kitchen.");
                selection = scan.nextLine();
            }
        }

            
    }
    
}
