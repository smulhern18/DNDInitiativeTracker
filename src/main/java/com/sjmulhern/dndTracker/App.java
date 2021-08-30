package com.sjmulhern.dndTracker;

import java.io.IOException;
import java.util.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lombok.Getter;

@Getter
public class App extends Application {

    public static Stage pStage;
    public static FXMLLoader fxmlLoader = new FXMLLoader();

    public App() {}

    public static Encounter encounter = null;

    public static InitativeRoundRobin getInitativeRoundRobin() {
        return encounter.getInitativeRoundRobin();
    }

    public static MainSceneController mainSceneController;

    @Override
    public void start(Stage primaryStage) throws IOException {

        pStage = primaryStage;

        Scene primaryScene = new Scene(new AnchorPane());
        Parent root =
                FXMLLoader.load(Objects.requireNonNull(getClass().getResource("views/MainView.fxml")));
        primaryScene.setRoot(root);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
        mainSceneController = new MainSceneController(primaryStage, primaryScene);
    }

    public static Stage getPrimaryStage() {
        return pStage;
    }

    @Override
    public void stop() {}
}
