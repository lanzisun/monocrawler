/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lanzisun.monocrawler.fx;

import java.net.URL;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author 60334
 */
public class StartMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
//        URL location = getClass().getProtectionDomain().getCodeSource().getLocation();
//        location = new URL(location.toString() + "fxml/ContentItem.fxml");
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL location = classLoader.getResource("fxml/ContentItem.fxml");
        Parent root = FXMLLoader.load(location);
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

//        StackPane root = new StackPane();
//        root.getChildren().add(btn);
        Scene scene = new Scene(root, root.getLayoutX(), root.getLayoutY());
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
