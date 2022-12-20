package org.parking;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.TableView;

public class ResultController implements Initializable {
    @FXML
    private TableView topList;

    public static void  initTable(List<ParkingLot> parkings,int x, int y){
        for (var parking:parkings) {
            items.add(new test(parking,x,y));
        }
    }

    private static ObservableList<test> items = FXCollections.observableArrayList();

    @FXML
    private void switchToFirst() throws IOException {
        App.setRoot("primary");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        topList.setItems(items);
    }
}
