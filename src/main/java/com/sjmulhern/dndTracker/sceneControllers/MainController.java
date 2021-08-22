package com.sjmulhern.dndTracker.sceneControllers;

import com.sjmulhern.dndTracker.App;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class MainController {

    public Button combatTrackerButton;

    public void combatTrackerPressed(ActionEvent actionEvent) throws IOException {
        if (App.encounter == null) {
            App.mainSceneController.switchScene("GetEncounter");
        }
        App.mainSceneController.switchScene("CombatTracker");
    }
}
