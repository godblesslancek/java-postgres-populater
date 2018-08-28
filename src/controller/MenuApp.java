package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuApp {
    public Button button;
    public Stage prevStage;

    public void setPrevStage(Stage stage){
        this.prevStage=stage;
    }


    public void goToPopulater(ActionEvent event){
        try {
            Stage stage = new Stage();
            stage.setTitle("deuxieme page");
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/populater.fxml"));
            Pane myPane = fxmlLoader.load();
            Scene scene = new Scene(myPane);
            Populater controller = fxmlLoader.getController();
            stage.setScene(scene);
            prevStage.close();
            setPrevStage(stage);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
