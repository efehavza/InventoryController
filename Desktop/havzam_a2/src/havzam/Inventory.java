/*Inventory.java is the program that holds the getters and setters
 *for the inventory object which will be called in Assign2Controller class
 *Author: Mert Havza
 *Date Created: May 26, 2019
 */

package havzam;

import java.util.*;
import java.text.DecimalFormat;

public class Inventory { //Decleration of Inventory class

    //field variables
    private String id;
    private String name;
    private int qoh;
    private int rop;
    private double sellPrice;

    DecimalFormat decimalFormat = new DecimalFormat("0.00"); //object for formatting sellPrice with 2 decimal points.

    public Inventory() { //default constructor with initialization

        name = "New Item";
        qoh = 0;
        rop = 25;
        sellPrice = 0.0;

    }

    public Inventory(String id, String name, double sellPrice) { //constructor overload

        try {

            this.id = id;
            this.name = name;
            this.sellPrice = sellPrice;

        }catch (Exception e) {

            System.out.println("Please Check the Inputs");

        }
    }

    public Inventory(String id, String name, int qoh, int rop, double sellPrice) { //constructor overload

        try {

            this.id = id;
            this.name = name;
            this.qoh = qoh;
            this.rop = rop;
            this.sellPrice = sellPrice;

        }catch (Exception e) {

            System.out.println("Please Check the Inputs");

        }

    }

    public void setID(String id) { //mutator for ID

        try {

            this.id = id;

        }catch (Exception e) {

            System.out.println("Error: Inventory ID must be in the form ABC-1234");

        }

    }

    public String getID(String id) { //getter for ID

        return this.id;

    }

    public void setName(String name) { //mutator for Name

        try {

            this.name = name;

        }catch (Exception e) {

            System.out.println("Name cannot be empty");

        }


    }

    public String getName() { //getter for Name

        return this.name;

    }

    public void setQoh(int qoh) { //mutator for quantity on hand

        try {

            this.qoh = qoh;

        }catch (Exception e) {

            System.out.println("Q-O-H cannot be smaller than 0");

        }

    }

    public int getQoh() { //getter for quantity on hand

        return this.qoh;

    }

    public void setRop(int rop) { //mutator for re-order point

        try {

            this.rop = rop;

        }catch (Exception e) {

            System.out.println("R-O-P cannot be smaller than 0");

        }

    }

    public int getRop() { //getter for re-order point

        return this.rop;

    }

    public void setSellPrice(double sellPrice) { //mutator for sellPrice

        try {

            this.sellPrice = sellPrice;

        }catch (Exception e) {

            System.out.println("Price cannot be smaller than 0");

        }


    }

    public double getSellPrice() { //getter for sellPrice

        return this.sellPrice;

    }

    public String tostring() { //return the field variables as string.

        return "Item ID: "+this.id+"("+this.name+")"+" QOH:"+this.qoh+" Price:"+"$"+decimalFormat.format(this.sellPrice);

    }

     /*compareString method checks if the item ID is correct or not
      itemID should be in "abc-1234" format
     */
    public boolean compareString (String ID) {

        if(ID.length() != 8) { //"abc-1234 format is 8 chars if input char doesn't match 8 method will return false.
            return false;
        }

        boolean dashIsThere = false; //dash in "abc-1234" format will is checked with charAt() method.

        char dash = ID.charAt(3);

        if(dash == '-') { //this if statement changes the dashIsThere value from the false to true if dash is available

            dashIsThere = true;

        }
        //letter part of the ID format is checked by isLetter() method. if its a letter the return value will be true.
        char ch0 = ID.charAt(0);
        boolean char0 = Character.isLetter(ch0);

        char ch1 = ID.charAt(1);
        boolean char1 = Character.isLetter(ch1);

        char ch2 = ID.charAt(2);
        boolean char2 = Character.isLetter(ch2);

        //digit part of the ID format is checked by isDigit() method. if its a digit the return value will be true
        char ch4 = ID.charAt(4);
        boolean char4 = Character.isDigit(ch4);

        char ch5 = ID.charAt(5);
        boolean char5 = Character.isDigit(ch5);

        char ch6 = ID.charAt(6);
        boolean char6 = Character.isDigit(ch6);

        char ch7 = ID.charAt(7);
        boolean char7 = Character.isDigit(ch7);

        //in this return statement if every value is correct -which means they all hold true- this method will return true
        return dashIsThere & char0 & char1 & char2 & char4 & char5 & char6 & char7;

    }

} //end of the Inventory class