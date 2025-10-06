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

// GitHub Link: https://github.com/wembythegoat/Lab_5Summer.git

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
        
        listView.getSelectionModel().selectedItemProperty().addListener(event ->
        {
            String listViewChoice = listView.getSelectionModel().getSelectedItem();
        });
        
        Label quantity = new Label("Select Quantity:");
        grid.add(quantity, 5, 0);
        
        ComboBox<Integer> quantityBox = new ComboBox();
        quantityBox.getItems().addAll(1,2,3,4, 5, 6, 7, 8, 9, 10);
        
        quantityBox.setValue(1);
        
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
        
        Label message = new Label();
        message.setStyle("-fx-font-size: 15px;");
        pane.setBottom(message);
        
        Button order = new Button("Place Order");
        order.setOnAction(event ->{
            String selectedBag = listView.getSelectionModel().getSelectedItem();
            Integer quantitySelected = quantityBox.getValue();
            RadioButton selectedSize = (RadioButton) myToggleGroup.getSelectedToggle();
            
            if (selectedBag == null) {
                message.setText("Select a bag type");
                return;
            }
            
            if (selectedSize == null) {
                message.setText("Select a size");
                return;
            }
            
            String sizeText = selectedSize.getText();
            message.setText("You ordered" + " " + quantitySelected + " " + sizeText + " " + selectedBag + "bag(s)");
        });
        grid.add(order, 5, 2);
        
        Button clear = new Button("Clear Selections");
        
        clear.setOnAction(event -> {
            listView.getSelectionModel().clearSelection();
            quantityBox.setValue(1);
            myToggleGroup.selectToggle(null);
            message.setText("");
        });
        
        grid.add(clear, 6, 2);
        
        Scene scene = new Scene(pane, 800, 500);
        stage.setTitle("Bag Order Form");
        stage.setScene(scene);
        stage.show();
    }
    
}
