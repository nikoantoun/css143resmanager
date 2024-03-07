/**
 * Abstract class ReservableItem - write a description of the class here
 *
 * @author (Nikolas Antoun)
 * @version (CSS143)
 */
import java.util.Scanner;
import java.util.*;
/**
 * Abstract class ReservableItem is the structure to get the fitness value
 * and is the main class that holds the reservation schedules. The ten time
 * slots are represented in the timeSchedule array. Any spot in the array that
 * is null indicates that there is an open slot at the specific time (index).
 */
public abstract class ReservableItem{
    private Reservation item;
    private String resId;
    private int count = 0;
    public static final int MAX_AVAIL = 10;
    private Reservation[] timeSchedule = new Reservation[MAX_AVAIL];
    /*
     * Reads the next item in file and stores item in String. If the String 
     * has a number after (should be a table reservation), captures the number
     * for the table in an int variable.
     * @param fileIn is the Scanner object that will be passed in.
     */
    public ReservableItem(Scanner fileIn){
        if(count < 10){
            resId = fileIn.next();
        }else
            System.out.println("Cannot reserve more than ten items.");
    }

    /*
     * Method gets the item's name and returns it.
     * @return String item
     */
    public String getId(){
        return this.resId;
    }

    /*
     * Helper method to add reservations into Array in ResManager
     */
    public void add(int index, Reservation resBook){
        timeSchedule[index] = resBook;
    }

    /*
     * 
     */
    public boolean isAvailable(int index){
        if(timeSchedule[index].equals(null))
            return true;
        else
            return false;
    }

    /*
     * Abstract method to return a number between 0 and 100 based on the
     * fitness value.
     * @return from 0 if not at all to 100 if best fit
     */
    public abstract int getFitnessValue(Reservation res);

    /*
     * Method to return an array of current reservations made
     * @return reservation array
     */
    public Reservation[] getReservations(){
        Reservation[] retRes = new Reservation[MAX_AVAIL];
        for(int i = 0; i < timeSchedule.length; i++)
            retRes[i] = timeSchedule[i];
        return retRes;
    }
    
    /*
     * toString method to print out the item properly
     * @return resId instance var.
     */
    @Override
    public String toString(){
        return resId;
    }
}