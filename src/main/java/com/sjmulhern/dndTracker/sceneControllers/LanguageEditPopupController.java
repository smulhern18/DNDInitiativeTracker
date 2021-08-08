package com.sjmulhern.dndTracker.sceneControllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.sjmulhern.dndTracker.App;
import com.sjmulhern.dndTracker.creatures.Creature;
import com.sjmulhern.dndTracker.creatures.Language;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LanguageEditPopupController implements Initializable {

    private Stage stage = null;

    private ArrayList<Language> result = new ArrayList<>();

    Creature creature = App.currentCreature;

    public void initialize () {

        ArrayList<Language> languages = creature.getLanguages();

        if (languages != null && !languages.isEmpty()) {
            for (Language language : languages) {
                switch (language) {
                    case Common:
                        common.setSelected(true);
                        break;
                    case Dwarvish:
                        dwarvish.setSelected(true);
                        break;
                    case Elvish:
                        elvish.setSelected(true);
                        break;
                    case Giant:
                        giant.setSelected(true);
                        break;
                    case Gnomish:
                        gnomish.setSelected(true);
                        break;
                    case Goblin:
                        goblin.setSelected(true);
                        break;
                    case Hafling:
                        hafling.setSelected(true);
                        break;
                    case Orc:
                        orc.setSelected(true);
                        break;
                    case Abyssal:
                        abyssal.setSelected(true);
                        break;
                    case Celestial:
                        celestial.setSelected(true);
                        break;
                    case Draconic:
                        draconic.setSelected(true);
                        break;
                    case DeepSpeech:
                        deepSpeech.setSelected(true);
                        break;
                    case Infernal:
                        infernal.setSelected(true);
                        break;
                    case Primordial:
                        primordial.setSelected(true);
                        break;
                    case Sylvan:
                        sylvan.setSelected(true);
                        break;
                    case Undercommon:
                        undercommon.setSelected(true);
                        break;
                    default:
                }
            }
            result = creature.getLanguages();
        }

        common.setOnAction(event -> checkIfSelected(Language.Common));
        dwarvish.setOnAction(event -> checkIfSelected(Language.Dwarvish));
        elvish.setOnAction(event -> checkIfSelected(Language.Elvish));
        giant.setOnAction(event -> checkIfSelected(Language.Giant));
        gnomish.setOnAction(event -> checkIfSelected(Language.Gnomish));
        goblin.setOnAction(event -> checkIfSelected(Language.Goblin));
        hafling.setOnAction(event -> checkIfSelected(Language.Hafling));
        orc.setOnAction(event -> checkIfSelected(Language.Orc));
        abyssal.setOnAction(event -> checkIfSelected(Language.Abyssal));
        celestial.setOnAction(event -> checkIfSelected(Language.Celestial));
        draconic.setOnAction(event -> checkIfSelected(Language.Draconic));
        deepSpeech.setOnAction(event -> checkIfSelected(Language.DeepSpeech));
        infernal.setOnAction(event -> checkIfSelected(Language.Infernal));
        primordial.setOnAction(event -> checkIfSelected(Language.Primordial));
        sylvan.setOnAction(event -> checkIfSelected(Language.Sylvan));
        undercommon.setOnAction(event -> checkIfSelected(Language.Undercommon));

    }

    private void checkIfSelected (Language language) {
        if (creature.getLanguages().contains(language)) {
            creature.getLanguages().remove(language);
        } else {
            creature.getLanguages().add(language);
        }
    }

    public void initialize (URL location, ResourceBundle resources) {
        initialize();
    }

    @FXML
    public CheckBox common;
    public CheckBox elvish;
    public CheckBox gnomish;
    public CheckBox dwarvish;
    public CheckBox giant;
    public CheckBox goblin;
    public CheckBox hafling;
    public CheckBox abyssal;
    public CheckBox orc;
    public CheckBox celestial;
    public CheckBox draconic;
    public CheckBox deepSpeech;
    public CheckBox infernal;
    public CheckBox primordial;
    public CheckBox sylvan;
    public CheckBox undercommon;

}
