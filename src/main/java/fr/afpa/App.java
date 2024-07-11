package fr.afpa;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;


/**
 * JavaFX App
 */
public class App extends Application {

    /*
     * Méthode principale.
     */
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        stage.setTitle("My First JavaFX App");

        String javaVersion = SystemInfo.javaVersion(); // Get info
        String javafxVersion = SystemInfo.javafxVersion(); // Get info
        Button button1 = new Button("Wait wait wait!"); // Instanciation d'un nouveau boutton
        Button button2 = new Button("NOW!"); // Instanciation d'un nouveau boutton avec la Class Button.

        Label label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + "."); // Instanciation d'un texte
        Label label2 = new Label("YOU SHOULD CLOSE THIS WINDOW..."); // Instanciation d'un texte avec la Class Label.
        VBox root = new VBox(10);

        button1.setOnAction(event -> {
            label2.setText("Oh you actually waited. Thanks.");
        });

        button2.setOnAction((ActionEvent event) -> {
            Platform.exit();
        });

        root.getChildren().addAll(label, label2, button1, button2); // .getChildren().addAll() permet d'utiliser toute les instancations du block.
        
        Scene scene = new Scene(root, 640, 480); // root instancier avec toute les instanciations pour créer le Stage.
        
        root.setAlignment(Pos.CENTER);
        stage.setScene(scene);
        stage.show();
    }

}



/*
 * Ressources utilisés :
 * 
 * https://www.w3resource.com/java-exercises/javafx/javafx-user-interface-components-exercise-1.php Instanciation de Buttons et Label avec root.
 * 
 * https://www.javaguides.net/2020/09/javafx-quit-button-example-terminate.html Exit button.
 */