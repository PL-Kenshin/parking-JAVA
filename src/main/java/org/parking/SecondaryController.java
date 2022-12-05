package org.parking;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class SecondaryController implements Initializable {

    @FXML
    private Label selectedCity;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("result");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectedCity.setText(PrimaryController.getUser().getSelectedCity());
    }
}