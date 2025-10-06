/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab_5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
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
        listView.setPrefSize(150, 200);
        grid.add(listView, 1, 0);
        
        listView.getItems().addAll ("Full Decorative", "Beaded", "Pirate Design", "Fringed",
        "Leather", "Plain");
        
        Label quantity = new Label("Select Quantity:");
        grid.add(quantity, 5, 0);
        
        ComboBox<Integer> quantityBox = new ComboBox();
        quantityBox.getItems().addAll(1,2,3,4, 5, 6, 7, 8, 9, 10);
        grid.add(quantityBox, 6, 0);
        
        Label size = new Label("Select Size:");
        grid.add(size, 10, 0);
        
        ToggleGroup myToggleGroup = new ToggleGroup();
        
        RadioButton small = new RadioButton("Small");
        RadioButton medium = new RadioButton("Medium");
        RadioButton large = new RadioButton("Large");
        
        small.setToggleGroup(myToggleGroup);
        medium.setToggleGroup(myToggleGroup);
        large.setToggleGroup(myToggleGroup);
        
        VBox vbox = new VBox(small, medium, large);
        vbox.setMaxHeight(25);
        grid.add(vbox, 11, 0);
        
        Button order = new Button("Place Order");
        grid.add(order, 5, 2);
        
        Button clear = new Button("Clear Selections");
        grid.add(clear, 6, 2);
        
        Scene scene = new Scene(pane, 800, 500);
        stage.setScene(scene);
        stage.show();
    }
    
}
