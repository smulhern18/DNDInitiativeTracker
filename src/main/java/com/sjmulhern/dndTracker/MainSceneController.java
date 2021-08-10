package com.sjmulhern.dndTracker;

import java.io.IOException;
import java.util.Objects;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainSceneController {
    private final Stage primaryStage;
    private final Scene primaryScene;

    public MainSceneController(Stage primaryStage, Scene primaryScene) {
        this.primaryScene = primaryScene;
        this.primaryStage = primaryStage;
    }

    public void switchScene(String aScene) throws IOException {
        Parent root =
                FXMLLoader.load(
                        Objects.requireNonNull(App.class.getResource("views/" + aScene + "View.fxml")));
        primaryScene.setRoot(root);
        primaryStage.hide();
        primaryStage.show();
    }
}
