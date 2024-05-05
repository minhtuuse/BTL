module org.example.dic_ {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires jlayer;
    opens graphic_code to javafx.fxml;
    exports graphic_code;
}