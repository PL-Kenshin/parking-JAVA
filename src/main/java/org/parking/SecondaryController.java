package org.parking;

import java.net.URL;
import java.util.*;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class SecondaryController implements Initializable {

    @FXML
    private Label selectedCity;

    @FXML
    private ToggleGroup rGroup1, rGroup2, rGroup3, rGroup4;

    private static RadioButton selected1, selected2, selected3, selected4;

    public ArrayList<String> getSelected(){
        ArrayList<String> buttons = new ArrayList<String>();
        selected1 = (RadioButton) rGroup1.getSelectedToggle();
        selected2 = (RadioButton) rGroup2.getSelectedToggle();
        selected3 = (RadioButton) rGroup3.getSelectedToggle();
        selected4 = (RadioButton) rGroup4.getSelectedToggle();
        Collections.addAll(buttons,selected1.getText(),selected2.getText(),selected3.getText(),selected4.getText());
        return buttons;
    }

    @FXML
    private void switchToPrimary() throws Exception {

        Zone strefa1 = new Zone(0,"Tarnów",1,2,0.2,0.4);
        Zone strefa2 = new Zone(1,"Tarnów",3,4,0.5,0.8);

        List<Zone> strefy = new ArrayList<Zone>();
        Collections.addAll(strefy,strefa1,strefa2);
        String[] choices = getSelected().toArray(new String[0]);

        Solver cos = new Solver(strefy,choices);

        App.setRoot("result");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectedCity.setText(PrimaryController.getUser().getSelectedCity());
    }
}