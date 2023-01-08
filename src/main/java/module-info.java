module org.parking {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.sat4j.core;
    requires org.sat4j.maxsat;
    requires org.sat4j.pb;
    requires java.desktop;

    opens org.parking;
    exports org.parking;
}
