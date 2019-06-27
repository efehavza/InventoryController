/* Assign2Controller.java is the program that controls the GUI and its button and contains
   the logic for checking input variables and adding them as an arrayList
   Author: Mert Havza
   Date Created: 16 June, 2019
 */

package havzam;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import java.util.Optional;
import static java.lang.Integer.parseInt;

public class Controller {
    //button field variables
    @FXML private Button addButton;
    @FXML private Button saveButton;
    @FXML private Button ordersButton;
    @FXML private Button exitButton;
    //textArea field variable
    @FXML private TextArea textArea;
    //textField field variables
    @FXML private TextField idText;
    @FXML private TextField nameText;
    @FXML private TextField qohText;
    @FXML private TextField ropText;
    @FXML private TextField priceText;
    //text field variable
    @FXML private Text messageText;

    InventoryList<Inventory> list = new InventoryList<>(); //Object of an arraylist
    Inventory product = new Inventory(); //object of the Inventory

    @FXML private void initialize() {
        //button initialization
        addButton.setOnAction(e -> onAddClicked());
        saveButton.setOnAction(e -> onSaveClicked());
        ordersButton.setOnAction(e -> onOrderClicked());
        exitButton.setOnAction(e -> onExitClicked());

        //on initialize all of the fields are set to null
        idText.setText(null);
        nameText.setText(null);
        qohText.setText(null);
        ropText.setText(null);
        priceText.setText(null);
        messageText.setText(null);
        textArea.setText(null);

    }
    //when add button is clicked all of the text fields will be emptied.
    private void onAddClicked() {

        idText.setText(null);
        nameText.setText(null);
        qohText.setText(null);
        ropText.setText(null);
        priceText.setText(null);
        messageText.setText(null);
        textArea.setText(null); //when save button is clicked textArea clears

    }

    //this method is activated when the save button is clicked.
    private void onSaveClicked() {

        //verification values are preset to false.
        boolean idVerification = false;
        boolean nameVerification = false;
        boolean qohVerification = false;
        boolean ropVerification = false;
        boolean priceVerification = false;

        try { //this try-catch activates when user try to save an empty form

            textArea.setText(null); //when save button is clicked textArea clears

            messageText.setText(null);

            product = new Inventory(); //when save button is clicked new Inventory object is created.

            String id = idText.getText(); //this gets the ID from the textField
            product.setID(id); //this sets the value from the textField to id in Inventory

            if (product.compareString(id)) { //abc-1234 format is controlled
                idVerification = true; //if correct verification for id returns true
            }

            if(idVerification == false) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Item ID must be in the form of ABC-1234");
                alert.show();
            }

            String name = nameText.getText(); //this gets the name from the textField
            product.setName(name); //this sets the value from the textField to name in Inventory

            boolean check = !name.isEmpty(); //this checks if the name field is empty

            if (check) { //if is not empty verification for name returns true
                nameVerification = true;
            }

            if(nameVerification == false) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("You Have To Enter a Name");
                alert.show();

            }

            try { //this try-catch checks the Q-O-H value if user enters a string instead of int

                int qoh = Integer.parseInt(qohText.getText()); //this gets the int value from textField
                product.setQoh(qoh); //this sets the value from the textField to qoh in Inventory

                if (qoh > 0) { //if qoh is greater than 0 verification for qoh returns true.
                    qohVerification = true;
                }

            }catch (Exception e) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Q-O-H cannot be smaller than 0 and Q-O-H needs to be a whole number");
                alert.show();

            } //end of qoh try-catch block

            try { //this try-catch checks the R-O-P value if user enters a string instead of int

                int rop = Integer.parseInt(ropText.getText()); //this gets the int value from textField
                product.setRop(rop); //this sets the value from the textField to rop in Inventory

                if (rop > 0) { //if rop is greater than 0 verification for rop returns true
                    ropVerification = true;
                }

            }catch (Exception e) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("R-O-P cannot be smaller than 0 and R-O-P needs to be a whole number");
                alert.show();

            } //end of rop try-catch block

            try { //this try-catch checks the Price value if user enters a string instead of int

                double price = Double.parseDouble(priceText.getText()); //this gets the int value from textField
                product.setSellPrice(price); //this sets the value from the textField to price in Inventory

                if (price > 0) { //if price greater than 0 verification for price returns true
                    priceVerification = true;
                }

            }catch (Exception e) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Price cannot be smaller than 0 and Price needs to be a number");
                alert.show();

            } //end of price try-catch block

            /*if all of the verifications true the objects is added to InventoryList.
              if not, whichever verification is false, that returns a related error to the textArea
              and the objects will not be added to InventoryList unless all of the verifications are true.
             */
            if (idVerification && nameVerification && nameVerification
                    && qohVerification && ropVerification && priceVerification) {

                list.add(product);

            }

        } catch (Exception e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("You cannot send an empty form");
            alert.show();

        }

    }

    //This method activates when the Exit button is clicked.
    private void onExitClicked() {
        //new dialog box is created when the exit button is activated.
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Warning");
        alert.setContentText("Are you sure ?");

        Optional<ButtonType> result = alert.showAndWait();
        ButtonType button = result.orElse(ButtonType.CANCEL);

        if (button == ButtonType.OK) {
            Platform.exit();
        }

    }

    //This method activates when the order button is clicked.
    private void onOrderClicked() {

        boolean ropItem = false; //this variable checks if there is a rop item to be ordered.
        //when oder button is clicked textArea and the message area need to be cleared.
        textArea.setText(null);
        messageText.setText(null);

       
        System.out.println(list.length());
        //this for loop loops inside the created Inventory objects.
        for(int i=0; i<list.length(); i++) {
            //if qoh is less then equal to rop this item's name appears in textArea
            if(list.get(i).getQoh() == list.get(i).getRop() || list.get(i).getQoh() < list.get(i).getRop() ) {

                textArea.appendText(list.get(i).getName()+" needs to be reordered.\n");
                //if there is even a one element needs to be ordered, rop item turns true.
                ropItem = true;

            }

            else {

                continue;

            }

        }
        //if rop item is still true that means there no item to be ordered.
        
        if(list.length() == 0) {

            messageText.setText("No items to list. Add some.");

        }
        
        else if(ropItem == false) {

            messageText.setText("No items to re-order.");

        }

    } //end of onOrderClicked method.

}
