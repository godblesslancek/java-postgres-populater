package controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.util.Callback;

import java.sql.ResultSet;

public class Populater {
    //fx:controller="controller.Populater"
    @FXML
    Text nameBase;
    @FXML
    Text nameTable;
    @FXML
    TableView tableView;
    public String base;
    public String table;

    public void initialize() {
    }

    public void setGridName() {
        nameBase.setText("Base : " + base);
        nameTable.setText("Table : " + table);
        //tableOutput.set
        //tableOutput.add(new Button(), 1, 0);
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

    public void setTableOutput() {


    }


    public void setTableView(ResultSet rs) {
        ObservableList<ObservableList> data;
        data = FXCollections.observableArrayList();
        try {
            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                //We are using non property style for making dynamic table
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                tableView.getColumns().addAll(col);
                System.out.println("Column [" + i + "] ");
                while (rs.next()) {
                    //Iterate Row
                    ObservableList<String> row = FXCollections.observableArrayList();
                    for (int k = 1; k <= rs.getMetaData().getColumnCount(); k++) {
                        //Iterate Column
                        row.add(rs.getString(k));
                    }
                    System.out.println("Row [1] added " + row);
                    data.add(row);

                }

                //FINALLY ADDED TO TableView
                tableView.setItems(data);
            }

        /*    Callback<TableColumn<Person, String>, TableCell<Person, String>> cellFactory = new Callback<TableColumn<Person, String>, TableCell<Person, String>>() {
                        @Override
                        public TableCell call(final TableColumn<Person, String> param) {
                            final TableCell<Person, String> cell = new TableCell<Person, String>() {

                                final Button btn = new Button("Just Do It");

                                @Override
                                public void updateItem(String item, boolean empty) {
                                    super.updateItem(item, empty);
                                    if (empty) {
                                        setGraphic(null);
                                        setText(null);
                                    } else {
                                        btn.setOnAction(event -> {
                                            Person person = getTableView().getItems().get(getIndex());
                                            System.out.println(person.getFirstName()
                                                    + "   " + person.getLastName());
                                        });
                                        setGraphic(btn);
                                        setText(null);
                                    }
                                }
                            };
                            return cell;
                        }
                    }*/;

            //probable que marche https://stackoverflow.com/questions/29489366/how-to-add-button-in-javafx-table-view#
            //https://stackoverflow.com/questions/20596962/adding-new-row-with-button-to-javafx-tableview
            //https://stackoverflow.com/questions/31139260/add-a-button-to-a-cells-in-a-tableview-javafx
            //sinon get nombre de colonnes, calculer les positions et rajouter des boutons et menu deroulants à ces positions


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
