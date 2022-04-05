package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Race;
import model.Registration;

import service.Service;
import java.util.List;

public class RaceController {

    @FXML
    private TableView<Race> table;
    @FXML
    private TextField nameField, typeField, distanceField, dateField, rdateField;
    @FXML
    private Text idLabel;

    private Service service;
    private ObservableList<Race> objectsList = FXCollections.observableArrayList();

    public RaceController() {
    }

    @FXML
    public void initialize() {

        table.getSelectionModel().selectedItemProperty().addListener((observable, oldItem, newItem) -> show(newItem));
        table.setItems(objectsList);

    }

    private void show(Race newItem) {

        if (newItem == null)
            clearFields();
        else {
            idLabel.setText("" + newItem.getID());
            nameField.setText(newItem.getName());
            typeField.setText(newItem.getType());
            distanceField.setText(newItem.getDistance());
            dateField.setText("" + newItem.getDate());
        }

    }

    private void clearFields() {

        idLabel.setText("");
        nameField.setText("");
        typeField.setText("");
        distanceField.setText("");
        dateField.setText("");

    }

    public void setService(Service serv){
        this.service=serv;
        List<Race> lp=serv.getAll1();
        objectsList.addAll(lp);
    }

    @FXML
    private void add(ActionEvent e) {

        String p1= nameField.getText();
        String p2= typeField.getText();
        String p3= distanceField.getText();
        String p4= dateField.getText();
        if ("".equals(p1)||"".equals(p2)||"".equals(p3)||"".equals(p4)){
            showErrorMessage("You need to complete all the fields!");
            return;
        }
        Race c=new Race(p1,p2,p3,p4);
        for(Race object: service.getAll1())
            if( c.getName().equals(object.getName())){
                showErrorMessage("There is already this");
                return;
            }
        c=service.add1(c);
        objectsList.add(c);
        clearFields();

    }

    @FXML
    private void clear(ActionEvent e) {

        clearFields();
        table.getSelectionModel().clearSelection();

    }

    @FXML
    private void delete(ActionEvent e) {

        int selectedIndex=table.getSelectionModel().getSelectedIndex();
        if (selectedIndex<0) {
            showErrorMessage("You have to select an object from the table!");
            return;
        }else{
            objectsList.remove(selectedIndex);
        }

    }

    @FXML
    public void report(ActionEvent actionEvent) {

        String value=rdateField.getText();
        List reportResultList=service.getByParameter(value);
        StringBuilder list= new StringBuilder();
        for (Object o:reportResultList)
            list.append(o).append("\n");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Report");
        if(list.length()==0){
            alert.setContentText("There are no classes starting on the given date.");
        }
        else
            alert.setContentText(list.toString());
        alert.showAndWait();


    }


    void showErrorMessage(String text) {

        Alert message=new Alert(Alert.AlertType.ERROR);
        message.setTitle("Error message");
        message.setContentText(text);
        message.showAndWait();

    }

}
