package fr.afpa;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class QuitEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        System.out.println("On quitte l'aopplication !");
        Platform.exit();
    }

    public static void whoAmI() {
        System.out.println("Je suis une méthode static contenue dans la classe \"QuitEventHandler\"");
    }

}
