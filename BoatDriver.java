//package ReservationSystem;
/*
 * Reservation System homework
 * CSS143
 * Lesley Kalmin
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Driver for Boat Reservation system
 * Reads input file and prints reservations to console
 */
public class BoatDriver {

    public static void main(String[] args) {
        ResManager<Boat, Reservation> manager = new ResManager<Boat, Reservation>();
        try {

            Scanner scanner = new Scanner(new FileInputStream("boatFile.txt"));

            while (scanner.hasNext())
            {
                manager.addReservable(new Boat(scanner));				
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            System.exit(0);
        }

        System.out.println();

        BoatReservation r1 = new BoatReservation(2,  "Chen family");
        r1.addBoatPreference("kayak");
        r1.addBoatPreference("zodiak");
        r1.addBoatPreference("canoe");
        manager.makeReservation(r1);
        BoatReservation r2 = new BoatReservation(8,  "Singh party");
        r2.addBoatPreference("speedboat");
        r2.addBoatPreference("zodiak");
        r2.addBoatPreference("submarine");
        manager.makeReservation(r2);
        r2 = new BoatReservation(8, "Kal");
        r2.addBoatPreference("yacht");
        r2.addBoatPreference("dinghy");
        r2.addBoatPreference("rowboat");
        manager.makeReservation(r2);
        r2 = new BoatReservation(8, "Party9");
        r2.addBoatPreference("zodiak");
        r2.addBoatPreference("speedboat");
        r2.addBoatPreference("submarine");
        manager.makeReservation(r2);
        r2.addBoatPreference("speedboat");
        r2.addBoatPreference("zodiak");
        r2.addBoatPreference("submarine");
        r2 = new BoatReservation(2, "Newmans");
        r2.addBoatPreference("speedboat");
        r2.addBoatPreference("zodiak");
        r2.addBoatPreference("submarine");
        manager.makeReservation(r2);

        r2 = new BoatReservation(3,  "Party2");
        r2.addBoatPreference("speedboat");
        r2.addBoatPreference("zodiak");
        r2.addBoatPreference("submarine");
        manager.makeReservation(r2);
        r2 = new BoatReservation(9,  "Party5");
        r2.addBoatPreference("speedboat");
        r2.addBoatPreference("zodiak");
        r2.addBoatPreference("submarine");
        manager.makeReservation(r2);
        r2 = new BoatReservation(1,  "Party6");
        r2.addBoatPreference("zodiak");
        r2.addBoatPreference("carrier");      
        r2.addBoatPreference("submarine");
        manager.makeReservation(r2);
        r2 = new BoatReservation(3, "Party3");
        r2.addBoatPreference("zodiak");
        r2.addBoatPreference("speedboat"); 
        r2.addBoatPreference("submarine");
        manager.makeReservation(r2);

        // Force failure
        r2 = new BoatReservation(3, "Unlucky party");
        r2.addBoatPreference("zodiak");
        manager.makeReservation(r2);

        System.out.println("\nreservations before sort by customer");
        System.out.println(manager);

        System.out.println("\nreservations after sort by customer");
        manager.sortReservations();
        System.out.println(manager);
    }

}
