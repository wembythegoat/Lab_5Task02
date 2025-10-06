/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab_5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author sinna
 */
public class Lab_5 extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void start(Stage stage) {
        BorderPane pane = new BorderPane();
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        pane.setCenter(grid);
        grid.setHgap(10);
        grid.setVgap(10);
        
        Label label = new Label("Select bag type:");
        grid.add(label, 0, 0);
        
        ListView<String> listView = new ListView();
        grid.add(listView, 1, 0);
        
        Scene scene = new Scene(pane, 800, 500);
        stage.setScene(scene);
        stage.show();
    }
    
}
