package org.parking;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

public class PrimaryController implements Initializable {

    ObservableList list = FXCollections.observableArrayList();
    static User kowal;

    static User getUser(){
        return kowal;
    }

    @FXML
    private ChoiceBox<String> series;

    @FXML
    private void switchToSecondary() throws IOException {
        kowal = new User(0, series.getValue(),"Jan","Kowalski");
        App.setRoot("secondary");
    }

    @FXML
    private void loadCities(){
        list.removeAll(list);
        String a = "Tarnów";
        String b = "Kraków";
        String c = "Warszawa";
        list.addAll(a,b,c);
        series.getItems().addAll(list);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadCities();
    }
}
