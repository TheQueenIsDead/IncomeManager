package app.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class MainWindowController {

    public StackPane mainStackPane;
    @FXML
    private Pane settingsPane;
    @FXML
    private Pane managePane;
    @FXML
    private Pane historyPane;


    @FXML
    private void manage(){
        System.out.println("Manage");
        managePane.toFront();
    }

    @FXML
    private void history(){
        System.out.println("History");
        historyPane.toFront();
    }

    @FXML
    private void settings(){
        System.out.println("Settings");
        settingsPane.toFront();
    }
}
