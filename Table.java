/**
 * Write a description of class Table here.
 *
 * @author (Nikolas Antoun)
 * @version (CSS143)
 */
import java.util.Scanner;
/**
 * The Table class extends the ReservableItem abstract class. This is where
 * the differences in the reservable items are coded. Table's main purpose
 * gets its own fitness value and its own numerical output through its 
 * constructor. 
 */
public class Table extends ReservableItem{
    private int requestedSeats; //customer requested seats
    private int availableSeats; //actual available seats
    public static int MAX_FITNESS_VALUE = 100; //100 is the best fit
    /*
     * Class constructor for the Table class
     */
    public Table(Scanner fileIn){
        super(fileIn); //invokes ReservableItem superclass constructor
        this.availableSeats = fileIn.nextInt(); //sets availableSeats
        this.requestedSeats = 0; //sets requested seats
    }

    /*
     * The method first checks if the Reservation parameter 
     * passed is null or not an instance of RestaurantReservation. It will
     * return -999 (a unique odd number) to indicate that the parameter is
     * bad. If it passes the first condition, the Reservation is converted to
     * a RestaurantReservation and is checked with the Reservations existing 
     * reservations. If there is a time-slot that is taken (not null), the
     * method returns -1. The fitness score is then calculated. If it is 
     * greater than the max fitness value accepted, the score is not a good
     * fit and the method returns -1. Else, it is a good fit and returns the
     * fitness score.
     * @Override the getFitnessValue abstract method from the ReservableItem
     *  abstract class.
     * @param res is the Reservation object that's fitness value is good or
     *  not.
     * @return -999 if null or not an instance
     * @return -1 if the timeslot is unavailable or if the reservation is
     *  not a good fit.
     * @return fitness score if the input is a correct way of inputting.
     */
    @Override
    public int getFitnessValue(Reservation res){
        if(res == null || !(res instanceof RestaurantReservation)){
            System.out.println("Not an instance of restaurant reservation.");
            return -999;
        }
        //converts res to a RestaurantReservation
        RestaurantReservation rRes = (RestaurantReservation) res;  
        Reservation[] temp = this.getReservations();
        if(temp[rRes.getTime()] != null) //if a time slot is unavailable...
            return -1;
        int fitScore = (MAX_FITNESS_VALUE - (this.getAvailableSeats() - 
                    rRes.getSeatsNeeded())); //fitness score
        if(fitScore > MAX_FITNESS_VALUE) //if fitscore is minused by a neg.
            return -1;
        else
            return fitScore;
    }

    /*
     * Method to return the number of available seats
     * @return availableSeats instance var.
     */
    public int getAvailableSeats(){
        return this.availableSeats;
    }

    /*
     * toString method overrides the toString method. Modified for
     * RestaurantReservation.
     * @Override toString() method.
     * @return the form of the output.
     */
    @Override
    public String toString(){
        return this.getClass().getSimpleName() + "Id: " + this.getId() + 
        " Seats: " + this.availableSeats;
    }
}