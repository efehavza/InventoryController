/*Main.java is the program that opens the GUI and assigns its windows size
 *Author: Mert Havza
 *Date Created: June 16, 2019
 */
package havzam;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application { //Decleration of the main class

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("controller.fxml"));
        primaryStage.setTitle("Inventory Tracker");
        primaryStage.setScene(new Scene(root, 362, 581));
        primaryStage.show();
    }

    public static void main(String [] args) { //Decleration of the main method

        launch(args);

    }

}

