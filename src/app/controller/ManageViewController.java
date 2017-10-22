package app.controller;

import app.DivisionProfile;
import app.DivisionXMLReader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Pair;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ManageViewController implements Initializable{

    @FXML
    TextField txtValue;

    @FXML
    TableView divisionTableView;
    @FXML
    TableColumn columnWeight;
    @FXML
    TableColumn columnName;
    @FXML
    TableColumn columnValue;


    private DivisionXMLReader reader;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setupListeners();
        columnName.setCellFactory(new PropertyValueFactory<>("name"));
        columnWeight.setCellFactory(new PropertyValueFactory<>("weight"));
        columnValue.setCellFactory(new PropertyValueFactory<>("value"));
    }

    private void setupListeners(){
        txtValue.setOnAction(e -> calculate()); //When the value changes, recalculate
    }

    @FXML
    private void load(){
        //TODO - Auto loads the test one,need to make it dynamically load
        System.out.println("Load the Divisions here!");
        try {
            reader = new DivisionXMLReader("resource/TestDivisions.xml");
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void calculate(){
        if(reader != null){
//            System.out.println(reader.getDivision());
            DivisionProfile profile = reader.getDivision();
            profile.setValue(Double.parseDouble(txtValue.getText()));
            updateDisplayValues();
        } else {
            System.err.println("LOAD A PROFILE BUDDY");
        }

    }

    private void updateDisplayValues(){
        //TODO Tidy up, just switched to CDV
        ObservableList<Object> observableList = FXCollections.observableArrayList();

        for(CalculatedDivisionValue dv: reader.getDivision().getDivisionValues()){
            observableList.add(o);
        }

        divisionTableView.setItems(observableList);

    }
}
