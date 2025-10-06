/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package task.pkg02;

import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//GitHub link: https://github.com/wembythegoat/Lab_5Task02.git

/**
 *
 * @author sinna
 */
public class Task02 extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        double[] subtotal = {0,0};
        double TAX_RATE = 0.13;
        double[] tipPercent = {0,0};
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(15);
        grid.setHgap(15);
        
        Label beverage = new Label("Beverage:");
        ComboBox<String> beverageBox = new ComboBox();
        grid.add(beverage, 0, 0);
        
        Map<String, Double> beverages = new HashMap<>();
        beverages.put("Coffee", 2.50);
        beverages.put("Tea", 2.00);
        beverages.put("Soft Drink", 1.75);
        beverages.put("Water", 2.95);
        beverages.put("Milk", 1.5);
        beverages.put("Juice", 2.5);
        
        beverageBox.getItems().addAll(beverages.keySet());
        grid.add(beverageBox, 1, 0);
        
        Label appetizer = new Label("Appetizer:");
        ComboBox<String> appetizerBox = new ComboBox<>();
        grid.add(appetizer, 0, 5);
        
        Map<String, Double> appetizers = new HashMap<>();
        appetizers.put("Soup", 4.50);
        appetizers.put("Salad", 3.75);
        appetizers.put("Spring Rolls", 5.25);
        appetizers.put("Garlic Bread", 3.00);
        appetizers.put("Chips and Slasa", 6.95);
        
        appetizerBox.getItems().addAll(appetizers.keySet());
        grid.add(appetizerBox, 1, 5);
        
        Label main = new Label("Main Course:");
        ComboBox<String> mainBox = new ComboBox<>();
        grid.add(main, 0, 10);
        
        Map<String, Double> mains = new HashMap<>();
        mains.put("Steak", 15.00);
        mains.put("Grilled Chicken", 13.50);
        mains.put("Chicken Alfredo", 13.95);
        mains.put("Turkey Club", 11.90);
        mains.put("Shrimp Scampi", 18.99);
        mains.put("Pasta", 11.75);
        mains.put("Fish and Chips", 12.25);
        
        mainBox.getItems().addAll(mains.keySet());
        grid.add(mainBox, 1, 10);
        
        Label dessert = new Label("Dessert:");
        ComboBox<String> dessertBox = new ComboBox<>();
        grid.add(dessert, 0, 15);
        
        Map<String, Double> desserts = new HashMap<>();
        desserts.put("Apple Pie", 5.95);
        desserts.put("Carrot Cake", 4.50);
        desserts.put("Mud Pie", 4.75);
        desserts.put("Pudding", 3.25);
        desserts.put("Apple Crisp", 5.98);
        
        dessertBox.getItems().addAll(desserts.keySet());
        grid.add(dessertBox, 1, 15);
        
        Label subtotalLabel = new Label("Subtotal: $0.00");
        Label taxLabel = new Label("Tax (13%): $0.00");
        Label tipLabel = new Label("Tip: $0.00");
        Label totalLabel = new Label("Total: $0.00");
        
        Label tipTitle = new Label("Tip Percentage:");
        Slider tipSlider = new Slider(0, 20, 0);
        tipSlider.setShowTickLabels(true);
        tipSlider.setShowTickMarks(true);
        tipSlider.setMajorTickUnit(5);
        tipSlider.setMinorTickCount(4);
        tipSlider.setBlockIncrement(1);
        Label tipValueLabel = new Label("0%");
        
        Runnable updateBill = () -> {
            double tax = subtotal[0] * TAX_RATE;
            double tip = subtotal[0] * (tipPercent[0] / 100);
            double total = subtotal[0] + tax + tip;
            
            subtotalLabel.setText(String.format("Subtotal: $%.2f", subtotal[0]));
            taxLabel.setText(String.format("Tax (13%%): $%.2f", tax));
            tipLabel.setText(String.format("Tip: $%.2f", tip));
            totalLabel.setText(String.format("Total: $%.2f", total));
        };
        
        tipSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            tipPercent[0] = newVal.doubleValue();
            tipValueLabel.setText(String.format("%.0f%%", tipPercent[0]));
            updateBill.run();
        });
        
        beverageBox.setOnAction(e -> {
            String item = beverageBox.getValue();
            if (item != null) {
                subtotal[0] += beverages.get(item);
                updateBill.run();
            }
        });
        
        appetizerBox.setOnAction(e -> {
            String item = appetizerBox.getValue();
            if (item != null) {
                subtotal[0] += appetizers.get(item);
                updateBill.run();
            }
        });
        
        mainBox.setOnAction(e -> {
            String item = mainBox.getValue();
            if (item != null) {
                subtotal[0] += mains.get(item);
                updateBill.run();
            }
        });
        
        dessertBox.setOnAction(e -> {
            String item = dessertBox.getValue();
            if (item != null) {
                subtotal[0] += desserts.get(item);
                updateBill.run();
            }
        });
        
        Button clearButton = new Button("Clear");
        clearButton.setOnAction(e -> {
            beverageBox.getSelectionModel().clearSelection();
            appetizerBox.getSelectionModel().clearSelection();
            mainBox.getSelectionModel().clearSelection();
            dessertBox.getSelectionModel().clearSelection();
            tipSlider.setValue(0);
            subtotal[0] = 0.0;
            updateBill.run();
        });
        
        
        Scene scene = new Scene(grid, 420, 470);
        stage.setTitle("Restaurant Bill Calculator");
        stage.setScene(scene);
        stage.show();
    }
    
}
