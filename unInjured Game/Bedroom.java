import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Bedroom {
    public static String prologueEnd() throws IOException, InterruptedException{
        

        String name = Files.readAllLines(Paths.get("log.bin")).get(0);
        int pills = Integer.parseInt(Files.readAllLines(Paths.get("bathroomlog.bin")).get(0));
        int beers = Integer.parseInt(Files.readAllLines(Paths.get("kitchenlog.bin")).get(3));
       


        System.out.println("\n"+name+" had already made the most of his already bad evening, \nrecuperating from the mess he'd found himself in, \nusing whatever he'd found the time to buy that week.\n");
        Thread.sleep(3000);
        if (pills < 2) {
        System.out.println(" 'Those painkillers were a life-saver.' \n");
        } else if (beers > 2) {
            System.out.println(" 'Shouldn't have taken too many cold ones.' \n");
        } else if ((beers > 1) && (pills < 2)) {
            System.out.println(" 'Fantastic combination, chasing them down with that.' \n");
        }
        Thread.sleep(2000);
        System.out.println(name+" would have enough time to put together whether or not someone had a hit out on him the following morning.");
        Thread.sleep(2000);
        System.out.println("Provided they didn't know where he lived, broke in and killed him in his sleep.");
        Thread.sleep(2000);
        System.out.println("For now, he would lay in bed and let a good night's rest do it's job.\n");
        Thread.sleep(2000);


        Bedroom.main(null);

        

        return name;
}

    public static void main (String[] args) throws IOException, InterruptedException {
        String name = Files.readAllLines(Paths.get("log.bin")).get(0);
        int health = Integer.parseInt(Files.readAllLines(Paths.get("log.bin")).get(1));
        System.out.println(name+"'s health: "+health+"%");


        System.out.println("\n\n\n ------- ");
        System.out.println("unInjured.");
        System.out.println(" ------- \n\n\n");
        
        File file = new File("unInjured-Prologue.bin");

        if ((file.createNewFile()) || (file.exists())) {
                System.out.println("Save file created.");
                System.out.println("Saving progress.");
                Thread.sleep(3000);
        }

        FileWriter writer = new FileWriter("unInjured-Prologue.bin");
        writer.write(name);
        writer.write("\n");
        writer.write(String.valueOf(health));
        writer.close();
        System.out.println("Save successful.");
 }}
