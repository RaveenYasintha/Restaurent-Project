module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
    opens com.example.demo.model to javafx.fxml;
    exports com.example.demo.TM;
    opens com.example.demo.TM to javafx.fxml;
    opens com.example.demo.controller to javafx.fxml;
    exports com.example.demo.TO;
    opens com.example.demo.TO to javafx.fxml;
}