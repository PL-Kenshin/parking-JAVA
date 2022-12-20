package org.parking;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class SecondaryController implements Initializable {

    @FXML
    private Label selectedCity;

    @FXML
    private ToggleGroup rGroup1, rGroup2, rGroup3, rGroup4;

    @FXML
    private LimitedTextField cordX, cordY;


    public ArrayList<Boolean> getSelected(){
        ArrayList<Boolean> buttons = new ArrayList<>();
        RadioButton selected1 = (RadioButton) rGroup1.getSelectedToggle();
        RadioButton selected2 = (RadioButton) rGroup2.getSelectedToggle();
        RadioButton selected3 = (RadioButton) rGroup3.getSelectedToggle();
        RadioButton selected4 = (RadioButton) rGroup4.getSelectedToggle();
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

        int cordX = Integer.parseInt(this.cordX.getText());
        int cordY = Integer.parseInt(this.cordY.getText());
        System.out.println(cordX + " " + cordY);


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
        cordX.setRestrict("[0-9]");
    }
}