package com.sjmulhern.dndTracker;

import com.sjmulhern.dndTracker.creatures.Alignment;
import com.sjmulhern.dndTracker.creatures.Condition;
import com.sjmulhern.dndTracker.creatures.Creature;
import com.sjmulhern.dndTracker.creatures.Language;
import com.sjmulhern.dndTracker.creatures.Monster;
import com.sjmulhern.dndTracker.creatures.NonPlayerCharacter;
import com.sjmulhern.dndTracker.creatures.Size;
import com.sjmulhern.dndTracker.creatures.Skill;
import com.sjmulhern.dndTracker.creatures.Spells;
import com.sjmulhern.dndTracker.creatures.Type;
import com.sjmulhern.dndTracker.tools.Ability;
import com.sjmulhern.dndTracker.tools.DamageType;
import com.sjmulhern.dndTracker.tools.Shape;
import com.sjmulhern.dndTracker.tools.Spell;
import com.sjmulhern.dndTracker.tools.Tool;
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
    public static ArrayList<Creature> encounterArray = null;

    public App() {}

    public static InitativeRoundRobin initativeRoundRobin = new InitativeRoundRobin();

    static {
        initativeRoundRobin.addCreature(
                new NonPlayerCharacter(
                        "Goblin",
                        "a Goblin",
                        Alignment.Unaligned,
                        Size.Small,
                        30,
                        15,
                        15,
                        0,
                        new ArrayList<>(
                                Collections.singletonList(
                                        new Ability(
                                                "Multi-Attack", "Can " + "attack " + "twice " + "with one" + " action"))),
                        new ArrayList<>(
                                Collections.singletonList(
                                        new Tool(
                                                "ShortSword",
                                                "A tiny " + "Goblin " + "sword",
                                                DamageType.Slashing,
                                                "+1",
                                                "1d6"))),
                        new ArrayList<>(Arrays.asList(Skill.values())),
                        new ArrayList<>(Arrays.asList(Language.Common, Language.Goblin)),
                        12,
                        13,
                        14,
                        15,
                        16,
                        30,
                        69,
                        20,
                        1,
                        1.0 / 4,
                        Condition.None,
                        null,
                        null,
                        null,
                        null));
        initativeRoundRobin.addCreature(
                new Monster(
                        "Goblin 2",
                        "not a Goblin",
                        Alignment.Unaligned,
                        Size.Small,
                        30,
                        15,
                        15,
                        0,
                        new ArrayList<>(),
                        new ArrayList<>(),
                        new ArrayList<>(),
                        new ArrayList<>(),
                        12,
                        13,
                        14,
                        15,
                        16,
                        30,
                        69,
                        20,
                        1,
                        0.25,
                        Condition.None,
                        new Spells(
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                null,
                                new ArrayList<>(
                                        List.of(
                                                new Spell(
                                                        "Fireball, FIRE BALL, fireball",
                                                        "its goddamn fireball",
                                                        20,
                                                        Shape.Sphere,
                                                        "Bat piss and Brimstone"))),
                                new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 10)),
                                new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0))),
                        new ArrayList<>(Arrays.asList(DamageType.Acid, DamageType.Cold)),
                        new ArrayList<>(Arrays.asList(DamageType.Fire, DamageType.Piercing)),
                        null,
                        Type.Humanoid));
        initativeRoundRobin.getNext();
    }

    public static MainSceneController mainSceneController;

    @Override
    public void start(Stage primaryStage) throws IOException {

        pStage = primaryStage;

        Scene primaryScene = new Scene(new AnchorPane());
        Parent root =
                FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Views/MainView.fxml")));
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
