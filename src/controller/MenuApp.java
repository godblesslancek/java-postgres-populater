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
import java.sql.ResultSet;

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

  /*  public void setTables(){
        tables.setItems(FXCollections.observableArrayList(db.arrayAllTables()));

    }*/

    public void tablesFromBase(){
        try {String base = bases.getSelectionModel().getSelectedItem().toString();
        tables.setItems(FXCollections.observableArrayList(db.arraySpecTables(base)));}
        catch (Exception e){
            e.printStackTrace();
        }
    }


    public void goToPopulater(ActionEvent event){
        try {
            if (!(bases.getValue() == null) && !(tables.getValue() == null)){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/populater.fxml"));
            prevStage.getScene().setRoot(fxmlLoader.load());
            //prevStage.setTitle("deuxieme page");
            Populater controllerPopulater = fxmlLoader.getController();
            controllerPopulater.setBase(bases.getValue().toString());
            controllerPopulater.setTable(tables.getValue().toString());
            controllerPopulater.setGridName();
            ResultSet rs = db.arrayCertainTable(bases.getValue().toString(),tables.getValue().toString());
            controllerPopulater.setTableView(rs);
            }
            else{
                System.out.println("Choisissez une base et une table");
            }
        }
        catch (Exception e) {
            e.printStackTrace();}
    }
}
