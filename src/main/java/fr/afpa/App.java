package fr.afpa;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

public class App extends Application {

    public final String MESSAGE_DELETION = "Entrée effacer!";
    public final String MESSAGE_COPY = "Entrée copier!";

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
        Label messageLabel = new Label("Entrée effacer!");
        messageLabel.setVisible(false);

        TextField userInputField = new TextField(); // Instanciation d'un texte avec la Class TextField.
        userInputField.setPromptText("Entrée utilisateur.");
        TextField copyField = new TextField();
        copyField.setPromptText("En attente de copie.");

        // ------> Création des "PANES"
        // Création de la VBox "root"
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);

        // création de la VBox contenant les boutons
        VBox vbox = new VBox(copyButton, clearButton, quitButton);
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);
        
        GridPane grid = new GridPane();

        grid.setAlignment(Pos.CENTER);
        // Montre le grid dans la scene.
        grid.setGridLinesVisible(true);
        grid.setHgap(10);
        grid.setVgap(10);

        RowConstraints rowConstraint1 = new RowConstraints(80);
        // rowConstraint1.setVgrow(Priority.ALWAYS);
        // rowConstraint1.setPercentHeight(50);
        grid.getRowConstraints().addAll(rowConstraint1, rowConstraint1);

        copyButton.setMaxSize(100, 100);
        clearButton.setMaxSize(100, 100);
        quitButton.setMaxSize(100, 100); 

        grid.add(inputUserLabel, 0, 0, 1, 1);
        grid.add(inputUserCopyLabel, 0, 1, 1, 1);
        grid.add(userInputField, 1, 0, 1, 1);
        grid.add(copyField, 1, 1, 1, 1);

        // POsitionnement de la VBox : 3ème colonne, span sur 2 lignes
        grid.add(vbox, 2, 0, 1, 2);

        // Ajout de la grid dans la VBox "root"
        root.getChildren().add(grid);
        // ajout des messages dans la VBox "root"
        root.getChildren().add(messageLabel);

        copyButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                // test si présence de texte dans le field
                if (!userInputField.getText().isEmpty()) {
                    copyField.setText(userInputField.getText());
                    messageLabel.setVisible(true);
                    messageLabel.setText(MESSAGE_COPY);
                }
            }
        });

        clearButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                System.out.println("Entrée utilisateur effacer!");
                copyField.clear();
                              // Objectif : ajouter un label (afficher un truc)
                // 1 créer un label
                messageLabel.setVisible(true);
                messageLabel.setText(MESSAGE_DELETION);
                // 2 l'ajouter quelque part
                // vbox.getChildren().add(messageLabelCopied);
                // vbox.getChildren().add(messageLabelDeleted);
            }
        });

        quitButton.setOnAction(new QuitEventHandler());

        // ------------- FIN GESTION DES EVENEMENTS ----------
        Scene scene = new Scene(root); // root instancier avec toute les instanciations pour créer le Stage.
        stage.setMinHeight(300);
        stage.setMinWidth(440);
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
 * 
 * https://stackoverflow.com/questions/28516654/javafx-how-to-clear-textfield-
 * when-mouse-is-clicked-on-it
 * Delete button fonction.
 */