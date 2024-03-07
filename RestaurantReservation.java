/**
 * Write a description of class RestaurantReservation here.
 *
 * @author (Nikolas Antoun)
 * @version (CSS143)
 */
/**
 * The RestaurantReservation class extends the Reservation class. This 
 * implements some slight differneces to tell what is either a restaurant
 * reservation and what is a boat reservation. 
 */
public class RestaurantReservation extends Reservation{
    private int seatsNeeded; //seats needed for customer
    /*
     * Constructor for Restaurant reservation
     */
    public RestaurantReservation(int numSeatsNeeded, int startTime, String name ){
        super(name, startTime); //invokes Reservation superclass constructor
        this.seatsNeeded = numSeatsNeeded; //sets the number of seats needed
    }

    /*
     * Method to get the number of seats needed
     * @return seatsNeeded instance variable
     */
    public int getSeatsNeeded(){
        return this.seatsNeeded;
    }

    /*
     * toString method overrides the Reservation toString method. Modified for
     * RestaurantReservation.
     * @Override Reservation toString method
     * @return form the output will be.
     */
    @Override
    public String toString(){
        return super.toString() + "Customer seats needed: " 
        + this.getSeatsNeeded() + "\n";
    }
}