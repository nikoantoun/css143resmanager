/**
 * Write a description of class ResManager here.
 *
 * @author (Nikolas Antoun)
 * @version (CSS143)
 */
import java.util.ArrayList;
/**
 * The ResManager class uses generics to code each type of reservation that
 * will either be RestaurantReservation or BoatReservation. This class holds
 * two java.util ArrayLists that are generic ItemType and ResType. ResManager
 * is the most important class in this project because this is where every
 * reservation is (or attempted to be) created and sorted with one another.
 */
public class ResManager<ItemType extends ReservableItem, 
ResType extends Reservation>{
    ArrayList<ItemType> reserved; //reservableitem type
    ArrayList<ResType> bookedReservations; //reservation type
    /*
     * No-arg constructor for ResManager
     */
    public ResManager(){
        reserved = new ArrayList<ItemType>();
        bookedReservations = new ArrayList<ResType>();
    }

    /*
     * Adds a new reservableItem to the available item up for reservation
     * @param item is an item that is added from the txt file
     */
    public void addReservable(ReservableItem item){
        ItemType resItem = (ItemType) item;
        if(item.equals(null))
            System.out.println("Invalid item.");
        else{
            reserved.add(resItem);
            if(resItem instanceof Boat)
                System.out.println("Added boat type: " + resItem);
            else if(resItem instanceof Table)
                System.out.println("Added table id: " + resItem);
        }
    }

    /*
     * Method to make a reservation. Tries to make a succesful reservation
     * by first checking if the size of the bookedres list is already at 10.
     * If the list is already at 10, an exception is thrown and the try block
     * fails. Else, the method gets the fitness value and the list index of 
     * the best fitness value while traversing through the itemtype list.
     * The index of the best fitness value is set to the iteration of the
     * for-loop. Afterwards, if the best fitness value is over zero, the
     * reservable item is added to the reserved list and the resource id is 
     * set. If the fitness value is below zero, the return value is set to
     * null and an exception is thrown to fail the try block. If the try block
     * fails anywhere in the method, the catch block is executed and the 
     * customer's name is printed regardless of what type the reservation is.
     * Then, if the failed reservation is an instance of 
     * RestaurantReservation, the time, id (should be customer), and the
     * number of seats. If it is a BoatReservation, only the time will be 
     * outputted. The return value will become null.
     * @param trialRes is the reservation attempting to be booked
     * @return the reservation if is a good fit and can be fit in to schedule
     * @return null if try block fails
     */
    public Reservation makeReservation(Reservation trialRes){
        Reservation retRes = trialRes;
        try{
            if(bookedReservations.size() == 10)
                throw new Exception();
            else{
                int bestFitVal = 0; //best fitness val variable
                int bestResItemIndex = -1; //index of the biggest fitnessval
                for(int i = 0; i < reserved.size(); i++){ //traverses list
                    //if the fitnessValue of any resItem greater bestfitval
                    if(reserved.get(i).getFitnessValue((ResType)trialRes) 
                    > bestFitVal){
                        //bestfitval is updated
                        bestFitVal = reserved.get(i).
                        getFitnessValue(trialRes);
                        bestResItemIndex = i; 
                        //index of resItem becomes the loop val
                    }
                }
                if(bestFitVal > 0){ //if the best val is greater than 0
                    //add reservervation to timeslot array in resitem class
                    reserved.get(bestResItemIndex).add(trialRes.getTime(), 
                        trialRes);
                    //sets the new id
                    trialRes.setResId(reserved.get(bestResItemIndex)
                        .getId());
                    bookedReservations.add((ResType)trialRes); 
                    //adds reservation to res list
                    return retRes;
                }else{ //if it isnt a good fit
                    //System.out.println("Time-slot unavailable");
                    retRes = null;
                    throw new Exception();
                }
            }
        }catch(Exception e){
            System.out.print("Unsuccessful reservation: Reservation name: "
                + trialRes.getCustomer());
            if(trialRes instanceof RestaurantReservation){
                RestaurantReservation failedRes = 
                    (RestaurantReservation) trialRes;
                System.out.print(" time: " + trialRes.getTime());
                System.out.print(" id: customer\n");
                System.out.println(" seats: " + failedRes.getSeatsNeeded());
            }else if(trialRes instanceof BoatReservation)
                System.out.print(" time: " + trialRes.getTime() + " id: ");      
            return null;
        }
    }

    /* Bubble sort method...
     * Method uses two for-loops to sort the reservations by customer's name.
     * The nested for-loop's index corresponds to the outer for-loop's index
     * and then checks one reservation with another by using the compareTo
     * method that was implemented from the Comparable interface in the
     * Reservation class. A temp ResType variable is created to hold the first
     * reservation in the bookedReservations list. This is a good example of 
     * bookkeeping. The other reservation is set to the first reservation's
     * spot in the list, and then the first reservation (held by temp) is 
     * moved to the spot where the other reservation was. These actions are
     * executed until all of the reservations have been checked and sorted.
     */
    public void sortReservations(){
        for(int i = 0; i < bookedReservations.size()-1; i++){
            for(int j = 0; j < bookedReservations.size()-i -1; j++){
                if(bookedReservations.get(j+1).compareTo(bookedReservations
                    .get(j)) < 0){
                    ResType temp = bookedReservations.get(j); //holds 1st res
                    bookedReservations.set(j, bookedReservations.get(j+1));
                    //other res is set to the first res position
                    bookedReservations.set(j+1, temp); 
                    //1st res is restored in list
                }
            }
        }
    }

    /*
     * toString method that prints out all of the results of the reservations
     * @return each and every booked reservation
     */
    public String toString(){
        String retVal = "";
        for(int i = 0; i < bookedReservations.size(); i++)
            retVal += bookedReservations.get(i).toString();
        return retVal;
    }
}