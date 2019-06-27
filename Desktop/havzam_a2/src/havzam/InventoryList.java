/* InventoryList<Inventory>.java is the program that holds the objects from
   Inventory class as an arrayList
   Author: Mert Havza
   Date Created: June 16, 2019
 */

package havzam;

import java.util.ArrayList;

public class InventoryList<Inventory> {

    private ArrayList<Inventory> invList = new ArrayList<>(); //object of a arraylist

    public InventoryList() { //default constructor

    }

    public void add(Inventory inventory) { //method for adding Inventory objects to arraylist

        try {

            invList.add(inventory);

        }catch (Exception e) {

            System.out.println("This item cannot be added");

        }

    }

    public Inventory get(int index) { //method for getting Inventory objects from arraylist

        try { //this try-catch block is used for checking outofbounds error

            return invList.get(index);

        }catch (Exception e) {

            return null;

        }

    }

    public int length() { //method for getting the size of the arraylist

        return invList.size();

    }

}
