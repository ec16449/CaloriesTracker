package controllers;

/* Import java, javafx, mainPackage */
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Food;

public class DietTabController implements Initializable {

	@FXML
	private TableView<Food> tableDiets;

	@FXML
	private TableColumn<Food, String> foodsColumn;

	@FXML
	private TableColumn<Food, String> amountColumn;

	@FXML
	private TableColumn<Food, String> caloriesColumn;

	@FXML
	private TableColumn<Food, String> carbsColumn;
	@FXML
	private TableColumn<Food, String> fatsColumn;
	@FXML
	private TableColumn<Food, String> protsColumn;
	
	@FXML
	private TableColumn<Food, String> quantityColumn;

	private ObservableList<Food> foodData = FXCollections.observableArrayList();

	
	private ArrayList<Food> addedFoods = new ArrayList<Food>();

	public void initialize(URL arg0, ResourceBundle arg1) {
		
		Food food1 = new Food("Whole Milk", 100, new double[] { 4.70, 3.70, 3.50 });
		food1.setQuantity(3.6);
		
		Food food2 = new Food("Protein Powder", 30, new double[] { 3.77, 0.2, 23.71 });
		food2.setQuantity(2);
		
		// add to arraylist
		addedFoods.add(food1);
		addedFoods.add(food2);
		
		// Add sample data
		for(int i=0; i<addedFoods.size(); i++) {
			foodData.add(addedFoods.get(i));
		}
		

		// Initialize the person table with the two columns.
		foodsColumn.setCellValueFactory(cellData -> cellData.getValue().getStrFood());
		
		amountColumn.setCellValueFactory(cellData -> cellData.getValue().getStrAmount());
		caloriesColumn.setCellValueFactory(cellData -> cellData.getValue().getStrCalories());
		
		carbsColumn.setCellValueFactory(cellData -> cellData.getValue().getStrCarbs());
		fatsColumn.setCellValueFactory(cellData -> cellData.getValue().getStrFats());
		protsColumn.setCellValueFactory(cellData -> cellData.getValue().getStrProts());
		
		quantityColumn.setCellValueFactory(cellData -> cellData.getValue().getStrQuantity());

		// Add observable list data to the table
		tableDiets.setItems(foodData);
	}
}