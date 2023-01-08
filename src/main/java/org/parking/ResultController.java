package org.parking;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.TableView;

public class ResultController implements Initializable {
    @FXML
    private TableView topList;

    public static void  initTable(List<ParkingLot> parkings,List<ParkingLot> allParkings ,List<Zone> zones, int x, int y){
        for (var parking:parkings) {
            items.add(new test(parking,x,y));
        }
        MapGenerator.main(parkings,allParkings, zones, x,y);
    }

    private static ObservableList<test> items = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        topList.setItems(items);


    }

    public void switchToPrimary() throws IOException {
        MapGenerator.closeWindow();
        App.setRoot("secondary");
    }
}
