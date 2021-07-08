package com.sjmulhern.dndTracker;

import com.sjmulhern.dndTracker.creatures.Creature;
import com.sjmulhern.dndTracker.sceneControllers.CombatTrackerController;
import com.sjmulhern.dndTracker.sceneControllers.CreatureEditorController;
import com.sjmulhern.dndTracker.sceneControllers.MainController;
import com.sjmulhern.dndTracker.sceneControllers.ToolbarController;
import com.sjmulhern.dndTracker.utils.InitativeRoundRobin;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lombok.Getter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

@Getter
public class App extends Application {

    public static Stage pStage;
    public static FXMLLoader fxmlLoader = new FXMLLoader();
    public static ArrayList<Creature> encounterArray = null;

    public App() {}

    public static MainSceneController mainSceneController;
    private final MainController mainController = new MainController();
    public static final CombatTrackerController combatTrackerController = new CombatTrackerController();
    public static final CreatureEditorController creatureEditorController = new CreatureEditorController();
    private final ToolbarController toolbarController = new ToolbarController();

    public static InitativeRoundRobin initativeRoundRobin = new InitativeRoundRobin();

    @Override
    public void init() {}

    @Override
    public void start(Stage primaryStage) throws IOException {
        pStage = primaryStage;

        Scene primaryScene = new Scene(new AnchorPane());
        fxmlLoader.setControllerFactory(
            controllerClass -> {
                if (controllerClass.equals(MainController.class)) {
                    return mainController;
                } else if (controllerClass.equals(CombatTrackerController.class)) {
                    return combatTrackerController;
                } else if (controllerClass.equals(CreatureEditorController.class)){
                    return creatureEditorController;
                } else if (controllerClass.equals(ToolbarController.class)){
                    return toolbarController;
                }
                return null;
            });
        Parent root = FXMLLoader.load(
            Objects.requireNonNull(getClass().getResource("Views/MainView.fxml")));
        primaryScene.setRoot(root);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
        mainSceneController = new MainSceneController(primaryStage, primaryScene);
    }

    public static Stage getPrimaryStage() {
        return pStage;
    }

    public void reset() throws Exception { }

    @Override
    public void stop() {}

}
