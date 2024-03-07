/**
 * Write a description of class Boat here.
 *
 * @author (Nikolas Antoun)
 * @version (CSS143)
 */
import java.util.Scanner;
import java.util.ArrayList;
/**
 * The Boat class extends the ReservableItem abstract class. This is where
 * the differences in the reservable items are coded. Boat's purpose
 * gets its own fitness value.
 */
public class Boat extends ReservableItem{
    /*
     * Class constructor for the Boat class
     */
    public Boat(Scanner fileIn){
        super(fileIn); //invokes the ReservableItem superclass constructor
    }

    /*
     * The method first checks if the Reservation parameter 
     * passed is null or not an instance of BoatReservation. It will return 
     * -999 (a unique odd number) to indicate that the parameter is bad. If 
     * it passes the first condition, the Reservation is converted to a 
     * BoatReservation and is checked with the Reservations existing 
     * reservations. If there is a time-slot that is taken (not null), the
     * method returns -1. A String ArrayList is then created and is filled
     * of boat preferences from the person reserving. The list is traversed
     * until a prefernece returns the index of the boat prefernece.
     * @Override the getFitnessValue abstract method from the ReservableItem
     *  abstract class.
     * @param res is the Reservation object that's fitness value is good or
     *  not.
     * @return -999 if null or not an instance
     * @return -1 if the timeslot is unavailable or if the reservation is
     *  not a good fit.
     * @return fitness score (boat preference index)
     */
    @Override
    public int getFitnessValue(Reservation res){
        if(res == null || !(res instanceof BoatReservation)){
            System.out.println("Not an instance of boat reservation.");
            return -999;
        }
        //converts res to BoatReservation
        BoatReservation bRes = (BoatReservation) res;  
        Reservation[] temp = this.getReservations();
        if(temp[bRes.getTime()] != null) //if a time slot is unavailable...
            return -1;
        ArrayList<String> resStrs = //ArrayList of boat preferences
            new ArrayList<String>(bRes.getPreferences());
        for(String str : resStrs){//traverse list
            if(this.getId().equals(str)) //if id = boat preference
                return resStrs.indexOf(str);
        }
        return -1; //returns -1 if preference is not found
    }

    /*
     * toString method overrides the toString method. Modified for
     * BoatReservation.
     * @Override toString() method.
     * @return the form of the output.
     */
    @Override
    public String toString(){
        return super.toString() + "\n";
    }
}