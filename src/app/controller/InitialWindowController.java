package app.controller;

import app.Main;
import app.SceneType;
import javafx.fxml.FXML;

public class InitialWindowController {

    @FXML
    private void login(){
        System.out.println("Login");
        Main.setScene(SceneType.MAIN);
    }
}
