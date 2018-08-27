package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class Menu {
    public Button button;


    public void goToPopulater(ActionEvent event){

        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/view/populater.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 650, 450);
            Stage stage = new Stage();
            stage.setTitle("Populater");
            stage.setScene(scene);
            stage.show();
       //     Stage stg = (Stage) closeButton.getScene().getWindow();
      //      stg.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
