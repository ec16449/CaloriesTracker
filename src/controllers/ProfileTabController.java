package controllers;

import java.io.IOException;
/* Import java, javafx, mainPackage */
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import model.Person;

public class ProfileTabController implements Initializable {
	
	@FXML
	TextField tfFirstName, tfLastName, tfAge, tfHeight, tfWeight, tfBodyfat, tfWaist;
	
	// Reference to textfields above
	private ArrayList<Node> refTF = new ArrayList<Node>();
	
	@FXML
	ChoiceBox<String> cbGender;

	@FXML 
	Button btnEditProfile, btnMetric, btnImperial;
	

	// PROFILE TAB
	
	// TODO
	
	// Be able to select gender
	
	// Be able to set age of person
	
	// Be able to set weight of person
	
	// Be able to set height
	
	// Be able to set bodyfat %
	
	// Be able to set body measurements (waist, chest, neck, legs, biceps)
	
	// All this data will then be updated on the database and reflect on the calculators
	
	
	
	// Used to tell what units we are using
	private String units = "Metric";
	// Used to tell if we need to unlock textfields or not
	private boolean editMode = false;
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// Setup values
		tfFirstName.setText(Person.getInstance().getFirstName());
		tfLastName.setText(Person.getInstance().getLastName());
		tfAge.setText(Integer.toString(Person.getInstance().getAge()));
		tfWeight.setText(Double.toString(Person.getInstance().getWeight()));
		tfHeight.setText(Double.toString(Person.getInstance().getHeight()));
		tfBodyfat.setText(Double.toString(Person.getInstance().getBodyfat()));
		tfWaist.setText(Double.toString(Person.getInstance().getWaist()));
		
		cbGender.setValue(Person.getInstance().getGender());

		
		// Add textfields into a reference arraylist (so we can loop better)
		refTF.addAll(Arrays.asList(tfAge, tfFirstName, tfLastName, 
				tfAge, tfHeight, tfWeight, tfBodyfat, tfWaist,
				btnMetric, btnImperial, cbGender
				));
		
		// Set all components disabled
		disableTF(true);
		
		// Setup button underlines for units
		updateButtonUnderline();
		
		// Setup choicebox
		setupChoiceBox();
	}
	
	private void setupChoiceBox() {
		cbGender.setItems(FXCollections.observableArrayList(
			    "Male", "Female", "Other"));
		
		// Add event listener
		ChangeListener<String> changeListener = new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, //
            		String oldValue, String newValue) {
                if (newValue != null) {
                    //greetingLabel.setText(newValue.getGreeting());
                	Person.getInstance().setGender(newValue);
                }
            }
        };
        // Selected Item Changed.
        cbGender.getSelectionModel().selectedItemProperty().addListener(changeListener);
	}
	
	private void updateButtonUnderline() {
		// Setup buttons
		if(units.equals("Metric")) {
			btnMetric.setUnderline(true);
			btnImperial.setUnderline(false);
		}else {
			btnMetric.setUnderline(false);
			btnImperial.setUnderline(true);
		}
	}
	
	private void disableTF(boolean value) {
		// Activate the textfields based on value
		for(int i=0; i<refTF.size(); i++) {
			refTF.get(i).setDisable(value);
		}
	}
	
	
	@FXML
	protected void handleEditProfile(ActionEvent event) throws IOException {
		
		// Flip
		editMode = !editMode;
		
		// If we are in editmode
		if(editMode) {
			
			System.out.println("Edit mode activated");
			
			btnEditProfile.setText("Save Changes");
			
			// Activate textfields
			disableTF(false);
		}else {
			btnEditProfile.setText("Edit Profile");
			
			// Disable the textfields
			disableTF(true);
		}
	}
	
	@FXML
	protected void handleMetric(ActionEvent event) throws IOException {
		units = "Metric";
		updateButtonUnderline();
	}
	
	@FXML
	protected void handleImperial(ActionEvent event) throws IOException {
		units = "Imperial";
		updateButtonUnderline();
	}
}