module neko.desglosedinero {
    requires javafx.controls;
    requires javafx.fxml;

    opens neko.desglosedinero to javafx.fxml;
    exports neko.desglosedinero;
}
