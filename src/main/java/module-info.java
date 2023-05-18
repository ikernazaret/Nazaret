module com.example.piedrapapeltijera {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.piedrapapeltijera to javafx.fxml;
    exports com.example.piedrapapeltijera;
}