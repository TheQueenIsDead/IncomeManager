package app.controller;

import app.CalculatedDivisionValue;
import app.DivisionProfile;
import app.DivisionXMLReader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Shape;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ManageViewController implements Initializable{

    @FXML
    private TextField txtValue;

    @FXML
    private TableView<CalculatedDivisionValue> divisionTableView;
    @FXML
    private TableColumn<String, Double> columnWeight;
    @FXML
    private TableColumn<String, String> columnName;
    @FXML
    private TableColumn<String, Double> columnValue;
    @FXML
    private Pane percentagePane;


    private DivisionXMLReader reader;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setupListeners();
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnWeight.setCellValueFactory(new PropertyValueFactory<>("weight"));
        columnValue.setCellValueFactory(new PropertyValueFactory<>("value"));
    }

    private void setupListeners(){
        //txtValue.setOnAction(e -> calculate()); //When the value changes, recalculate
        txtValue.setOnKeyReleased(keyEvent -> {
            System.out.println(txtValue.getText());
            if(!txtValue.getText().isEmpty()) {
                try {
                    calculate();
                } catch (NumberFormatException nfe) {
//                    nfe.printStackTrace();
                    System.out.println("Enter a valid number!");
                    divisionTableView.setItems(FXCollections.observableArrayList());    //These both reset the view if input is not correct
                }
            } else {
                divisionTableView.setItems(FXCollections.observableArrayList());
            }
        });
    }

    @FXML
    private void load(){
        //TODO - Auto loads the test one,need to make it dynamically load
        System.out.println("Loading the test divisions here!");
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
            updateTableView();
            updatePercentageView();
        } else {
            System.err.println("LOAD A PROFILE BUDDY");
        }

    }

    private void updateTableView(){

        //Updates the table

        ObservableList<CalculatedDivisionValue> observableList = FXCollections.observableArrayList();

        for(CalculatedDivisionValue dv: reader.getDivision().getDivisionValues()){
            observableList.add(dv);
            System.out.println(dv);
        }

        divisionTableView.setItems(observableList);

    }

    private void updatePercentageView(){
        //Could be moved to initialise
        System.out.println("Value on: " + reader.getDivision().value);

        double angle = 360/reader.getDivision().count();

        for(int i = 0; i < reader.getDivision().count(); i++){
            double center = percentagePane.getWidth() / 2;
            double radius = percentagePane.getHeight() / 2;
            double startAngle = i*angle;
            Arc arc = new Arc(center, center, radius, radius, startAngle, angle);
            arc.setType(ArcType.OPEN);
            if(i%2 == 0) {
                arc.setFill(Paint.valueOf("blue"));
            } else {
                arc.setFill(Paint.valueOf("yellow"));
            }
                percentagePane.getChildren().add(arc);
        }

        //
    }

}
