module com.example.goal {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.goal to javafx.fxml;
    opens com.example.goal.model to javafx.base;

    exports com.example.goal;
}