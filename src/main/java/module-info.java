module org.parking {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.sat4j.core;
    requires org.sat4j.maxsat;
    requires org.sat4j.pb;

    opens org.parking to javafx.fxml;
    exports org.parking;
}
