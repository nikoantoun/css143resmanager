/**
 * Write a description of class BoatReservation here.
 *
 * @author (Nikolas Antoun)
 * @version (CSS143)
 */
import java.util.ArrayList;
/**
 * The BoatReservation class extends the Reservation class. This implements 
 * some slight differneces to tell what is either a restaurant reservation and
 * what is a boat reservation. BoatReservation adds the customer's boat 
 * preferneces, overrides the resource id to get the customer's highest
 * prioritised boat, and adds all of the customer's preferred boats into an
 * ArrayList in case there are no more items from the customer's first
 * prioritised boat.
 */
public class BoatReservation extends Reservation{
    private ArrayList<String> preferred;
    /*
     * Constructor for BoatReservation
     */
    public BoatReservation(int timeslot, String name){
        super(name, timeslot); //invokes Reservation superclass constructor
        preferred = new ArrayList<String>(10); //sets arraylist
    }

    /*
     * Method adds the customer's boat preferneces
     * @param name is the preferred boat's name
     */
    public void addBoatPreference(String name){
        if(name.equals(null))
            System.out.println("Boat's name invalid");
        else
            preferred.add(name);
    }

    /*
     * Method gets and returns the boat preferences list
     * @return the gathered boat preferneces list
     */
    public ArrayList<String> getPreferences(){
        ArrayList<String> getPreferredList = new ArrayList<String>(preferred);
        return getPreferredList;
    }
    
    /*
     * @Override the getResId method in the Reservation class
     * This method is to output the prioritised boat name.
     * @return the preffered boat name
     */
    @Override
    public String getResId(){
        ArrayList<String> preferredList = new ArrayList<String>(preferred);
        return preferredList.get(0);
    }
}