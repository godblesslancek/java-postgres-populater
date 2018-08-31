package controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.DBManager;

import java.io.IOException;

public class MenuApp {
    public Button button;
    public Stage prevStage;
    public Scene prevScene;
    public ChoiceBox bases;
    public ChoiceBox tables;
    DBManager db = new DBManager();

    public void setPrevStage(Stage stage){
        this.prevStage=stage;
    }
    public void setPrevScene(Scene scene){
        this.prevScene=scene;
    }
    public void setBases(){
        bases.setItems(FXCollections.observableArrayList(db.arrayAllBases()));
    }

    public void setTables(){
        tables.setItems(FXCollections.observableArrayList(db.arrayAllTables()));

    }


    public void goToPopulater(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/populater.fxml"));
            prevStage.getScene().setRoot(fxmlLoader.load());
            prevStage.setTitle("deuxieme page");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
