/**
 * Write a description of class Reservation here.
 *
 * @author (Nikolas Antoun)
 * @version (CSS143)
 */
/**
 * Class Reservation implements the Comparable interface to eventually sort
 * the reservations by the customer's name, using the compareTo method. This
 * class makes the customer able to reserve an item.
 */
public class Reservation implements Comparable{
    private String name;
    private int time;
    public String id;
    /*
     * Constructor to create reservation
     */
    public Reservation(String customerName, int timeSlot){
        if(timeSlot < 0 || timeSlot > 9) //if the time is/or between 0 and 10
            System.out.println("No current time-slots available.");
        else{ //sets the instance variables
            this.name = customerName;
            this.time = timeSlot;
        }
    }

    /*
     * Method compares current reservation name and other reservation name to
     * sort. Returns -1 if letters in current customer's name comes before 
     * other customer's name. If the letters are after the current customer's
     * name is after the other customer's name, returns 1. Else if the
     * current letter being searched is the same, loop increments and checks
     * second letter in both customer's name. This process will continue until
     * the case of a letter's index is different from each other or if the
     * current index being checked is the last letter of one or both names. If
     * both of the customer's name length is the same and the last letters are
     * the same, the names are the same and returns 0. Else, the customer's
     * names must not be the same if one name is shorter than the other,
     * and returns -1 if current customer's name is shorter. And returns 1
     * if the current customer's name is longer. A foundation return case 
     * returns 0 if the loop is exited without returning any number for some
     * reason, which also indicates that both names are the same.
     * 
     */
    @Override
    public int compareTo(Object obj){
        Reservation res = (Reservation) obj;
        String thisCustomer = this.getCustomer(); //str var makes code simple
        String otherCustomer = res.getCustomer(); //str var makes code simple
        for(int i = 0; i < thisCustomer.length() ||
        i < otherCustomer.length(); i++){
            char customerLetter = this.getCustomer().charAt(i);
            char otherLetter = res.getCustomer().charAt(i);
            if(customerLetter > otherLetter) //if letter is after other
                return 1;
            else if(customerLetter < otherLetter) //if letter is before other
                return -1;
            else{ //if letters are the same...
                if(i == thisCustomer.length()-1 || i == 
                otherCustomer.length()-1){
                    if(thisCustomer.length() == otherCustomer.length()){
                        if(customerLetter == otherLetter)//names are same 
                            return 0;              //length and last letter
                        //names are the same
                    }else if(thisCustomer.length() > otherCustomer.length())
                        return 1; //if customer name is longer than other
                    else
                        return -1; //if customer name is before other
                }else
                    continue; //if the letters are the same...
            }
        }
        return 0;
    }

    /*
     * Method returns the customer's name.
     * @return the name instance variable.
     */
    public String getCustomer(){
        return this.name;
    }
    
    /*
     * Method returns the time requested.
     * @return time instance variable.
     */
    public int getTime(){
        return this.time;
    }
    
    /*
     * Method sets the resource id instance var
     * @param redId is the data passed in
     */
    public void setResId(String resId){
        this.id = resId;
    }
    
    /*
     * Method gets the resource id
     * @return the id insvar
     */
    public String getResId(){
        return this.id;
    }

    /*
     * Method returns the contents of the reservation.
     * @return String for the reservation containing inst. vars name and time.
     */
    public String toString(){
        return "Reservation Name: " + name + " Time: " + time + ":00 " + 
        "Id: " + this.getResId() + "\n";
    }
}