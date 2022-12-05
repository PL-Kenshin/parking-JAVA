module org.parking {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.parking to javafx.fxml;
    exports org.parking;
}
