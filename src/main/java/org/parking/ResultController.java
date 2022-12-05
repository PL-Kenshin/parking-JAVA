package org.parking;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.TableView;

public class ResultController implements Initializable {
    @FXML
    private TableView topList;

    private ObservableList<test> items = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        test first = new test(1,10,123,321);
        test second = new test(2,9,135,330);
        test third = new test(3,7,100,300);
        items.addAll(first, second, third);
        topList.setItems(items);
    }
}
