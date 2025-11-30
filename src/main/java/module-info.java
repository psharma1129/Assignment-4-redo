module com.example.assignment_4_redo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.assignment_4_redo to javafx.fxml;
    exports com.example.assignment_4_redo;
}