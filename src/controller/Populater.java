package controller;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

public class Populater {
    //fx:controller="controller.Populater"
    @FXML
    GridPane tableOutput;
    public String base;
    public String table;
    public void initialize(){
        tableOutput.setGridLinesVisible(true);
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public void setTableOutput(){



    }



}
