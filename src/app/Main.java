package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.HashMap;

public class Main extends Application {

    private Parent root;
    private static Stage primaryStage;
    private static Stage secondaryStage;
    private static HashMap<SceneType, Scene> scenes = new HashMap<>();

    //Trying to commit with my GitHub name

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Make the stage accessible from main
        Main.primaryStage = primaryStage;
        secondaryStage = new Stage();

        //Set window title
        primaryStage.setTitle("Income Manager");

        //Load the FXML files into a HashMap
        //Initial window
        root = FXMLLoader.load(getClass().getResource("view/InitialWindow.fxml"));
        scenes.put(SceneType.INITIAL, new Scene(root));
        //Main window
        root = FXMLLoader.load(getClass().getResource("view/MainWindow.fxml"));
        scenes.put(SceneType.MAIN, new Scene(root));


        //Put the first scene in the main window
        setScene(SceneType.INITIAL);
        //Show the application
        primaryStage.show();
    }

    public static void setScene(SceneType scene){
        primaryStage.setScene(scenes.get(scene));
    }


    public static void main(String[] args) {
        launch(args);
    }
}
