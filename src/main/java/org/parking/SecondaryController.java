package org.parking;

import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

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

    public ArrayList<Boolean> getSelected(){
        ArrayList<Boolean> buttons = new ArrayList<>();
        selected1 = (RadioButton) rGroup1.getSelectedToggle();
        selected2 = (RadioButton) rGroup2.getSelectedToggle();
        selected3 = (RadioButton) rGroup3.getSelectedToggle();
        selected4 = (RadioButton) rGroup4.getSelectedToggle();
        Collections.addAll(buttons,selected1.getText().equals("Tak"),selected2.getText().equals("Tak")
                ,selected3.getText().equals("Tak"),selected4.getText().equals("Tak"));
        return buttons;
    }

    @FXML
    private void switchToPrimary() throws Exception {

        DummyDataGenerator data = new DummyDataGenerator(4);

        var zones = data.generateZones(20,selectedCity.getText());
        var parkings = data.generateParkingLots(zones);

        var choices = getSelected();

        int cordX = 32;
        int cordY = 20;


        var satisfiable = parkings.stream()
                .filter((parkingLot -> parkingLot.isForHandicapped() == choices.get(0)))
                .filter((parkingLot -> parkingLot.isPaid() == choices.get(1)))
                .filter((parkingLot -> parkingLot.isGuarded() == choices.get(2)))
                .filter((parkingLot -> parkingLot.getFreeSpaces() > 0))
                .filter((parkingLot -> parkingLot.getFreeSpaces() >= 15 || !choices.get(3)))
                .sorted(Comparator.comparingInt(a -> a.getDistanceTo(cordX, cordY)))
                .collect(Collectors.toList());


        ResultController.initTable(satisfiable,cordX,cordY);

        App.setRoot("result");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectedCity.setText(PrimaryController.getUser().getSelectedCity());
    }
}