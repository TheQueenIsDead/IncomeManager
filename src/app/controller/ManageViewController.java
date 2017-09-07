package app.controller;

import app.DivisionXMLReader;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class ManageViewController {

    @FXML
    TextField txtValue;

    DivisionXMLReader reader;

    @FXML
    private void load(){
        //TODO - Auto loads the test one,need to make it dynamically load
        System.out.println("Load the Divisions here!");
        try {
            reader = new DivisionXMLReader("resource/TestDivisions.xml");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void calculate(){
        reader.getDivision();
    }
}
