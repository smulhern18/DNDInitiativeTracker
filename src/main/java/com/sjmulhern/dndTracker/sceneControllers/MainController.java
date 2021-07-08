package com.sjmulhern.dndTracker.sceneControllers;

import com.sjmulhern.dndTracker.App;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.io.IOException;

public class MainController {

    public Button combatTrackerButton;

    public void combatTrackerPressed (ActionEvent actionEvent) throws IOException {
        App.mainSceneController.switchScene("CombatTracker");
    }

}
