package fr.afpa;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
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

        TextField userInputField = new TextField(); // Instanciation d'un texte avec la Class TextField.
        TextField copyField = new TextField();

        // ------> Création des "PANES"
        GridPane root = new GridPane();

        // .getChildren().addAll() permet d'utiliser toute les instancations du block.
        // root.getChildren().addAll(label, label2, button1, button2, button3,
        // textField1, textField2);
        root.add(inputUserLabel, 0, 0, 1, 1);
        root.add(inputUserCopyLabel, 0, 1, 1, 1);
        root.add(userInputField, 1, 0, 1, 1);
        root.add(copyField, 1, 1, 1, 1);

        // méthode 1 : ajouter les composants graphiques directement dans le constructeur
        // à l'instanciation
        VBox vbox = new VBox(copyButton, clearButton, quitButton);

        // méthode 2 : ajouter UN à UN les composants graphiques
        // vbox.getChildren().add(copyButton);
        // vbox.getChildren().add(clearButton);
        // vbox.getChildren().add(quitButton);

        // méthode 3 : ajout de tout en bloc
        // vbox.getChildren().addAll(copyButton, clearButton, quitButton);

        root.getChildren().addAll(vbox);

        root.setHgap(10);
        root.setVgap(10);

        copyButton.setOnAction(event -> {
            inputUserCopyLabel.setText("Copié avec succès!");
        });

        // ------------- GESTION DES EVENEMENTS ----------
        // ajouter un GESTIONNAIRE D'EVENEMENT à un composant graphiques
        // Gestionnaire d'évènement = classe "EventHandler"

        // Version 1 : classe interne anonyme
        // quitButton.setOnAction(new EventHandler<ActionEvent>() {

        //     @Override
        //     public void handle(ActionEvent event) {
        //         Platform.exit();
        //     }

        // });

        // Version 2 : classe nommée indépendante
        // -> il faut créer un nouveau fichier
        quitButton.setOnAction(new QuitEventHandler());

        // quitButton.setOnAction((ActionEvent event) -> {
        // Platform.exit();
        // });

        clearButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                // Objectif : ajouter un label (afficher un truc)
                
                // 1 créer un label
                Label messageLabel = new Label("EFFACER !!!");
                messageLabel.setVisible(false);
                
                // 2 l'ajouter quelque part
                vbox.getChildren().add(messageLabel);

            }
            
        });

        // ------------- FIN GESTION DES EVENEMENTS ----------

        Scene scene = new Scene(root, 440, 200); // root instancier avec toute les instanciations pour créer le Stage.

        vbox.setAlignment(Pos.CENTER_RIGHT);
        root.setAlignment(Pos.CENTER);
        stage.setScene(scene);
        stage.show();

    } // fin de la méthode "start"

} // fin de la classe "App"

/*
 * Ressources utilisés :
 * 
 * https://www.w3resource.com/java-exercises/javafx/javafx-user-interface-
 * components-exercise-1.php Instanciation de Buttons et Label avec root.
 * 
 * https://www.javaguides.net/2020/09/javafx-quit-button-example-terminate.html
 * Exit button.
 */