module com.example.vjezbafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.vjezbafx to javafx.fxml;
    exports com.example.vjezbafx;
}