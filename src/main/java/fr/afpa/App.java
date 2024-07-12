package fr.afpa;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    /*
     * Méthode principale.
     */
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Formulaire");

        // -----> Instanciation des composants graphiques
        Button copyButton = new Button("Recopier"); // Instanciation d'un nouveau boutton avec la Class Button.
        Button clearButton = new Button("Effacer");
        Button quitButton = new Button("Quitter");

        Label inputUserLabel = new Label("Entrée Utilisateur : "); // Instanciation d'un texte avec la Class Label.
        Label inputUserCopyLabel = new Label("Copie de l'entrée : ");
        Label messageLabelDeleted = new Label("Entrée effacer!");
        Label messageLabelCopied = new Label("Entrée copier!");
        messageLabelCopied.setVisible(false);
        messageLabelDeleted.setVisible(false);

        TextField userInputField = new TextField(); // Instanciation d'un texte avec la Class TextField.
        TextField copyField = new TextField();

        VBox vbox = new VBox(copyButton, clearButton, quitButton);
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);

        // ------> Création des "PANES"
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        // Montre le grid dans la scene.
        root.setGridLinesVisible(true);
        root.setHgap(10);
        root.setVgap(5);

        // RowConstraints rowConstraint1 = new RowConstraints();
        // rowConstraint1.setPercentHeight(50);
        // root.getRowConstraints().addAll(rowConstraint1, rowConstraint1);

        copyButton.setMaxSize(100, 100);
        clearButton.setMaxSize(100, 100);
        quitButton.setMaxSize(100, 100);

        root.add(inputUserLabel, 0, 0, 1, 1);
        root.add(inputUserCopyLabel, 0, 1, 1, 1);
        root.add(userInputField, 1, 0, 1, 1);
        root.add(copyField, 1, 1, 1, 1);
        root.add(vbox, 2,0,1,3);

        root.add(messageLabelCopied, 0, 2, 3, 1);
        root.add(messageLabelDeleted, 0, 2, 3, 1);
        // root.add(copyButton,2,0,1,1);
        // root.add(clearButton,2,1,1,1);
        // root.add(quitButton, 2, 2, 1, 1);
        
        copyButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {

                messageLabelCopied.setVisible(true);
                messageLabelDeleted.setVisible(false);
                // vbox.getChildren().add(messageLabelCopied);
                // vbox.getChildren().add(messageLabelDeleted);
            }
        });

        quitButton.setOnAction(new QuitEventHandler());

        clearButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                // Objectif : ajouter un label (afficher un truc)
                // 1 créer un label
                messageLabelCopied.setVisible(false);
                messageLabelDeleted.setVisible(true);
                // 2 l'ajouter quelque part
                // vbox.getChildren().add(messageLabelCopied);
                // vbox.getChildren().add(messageLabelDeleted);
            }
        });

        // ------------- FIN GESTION DES EVENEMENTS ----------

        Scene scene = new Scene(root, 440, 150); // root instancier avec toute les instanciations pour créer le Stage.

        stage.setScene(scene);
        stage.show();

    } // fin de la méthode "start"

} // fin de la classe "App"

/*
 * Ressources utilisés :
 * 
 * Code de Ludo sur GitHub branche :
 * https://github.com/Blossom87/JavaFX/tree/ajout-code-ludovic
 * 
 * https://www.w3resource.com/java-exercises/javafx/javafx-user-interface-
 * components-exercise-1.php Instanciation de Buttons et Label avec root.
 * 
 * https://www.javaguides.net/2020/09/javafx-quit-button-example-terminate.html
 * Exit button.
 */