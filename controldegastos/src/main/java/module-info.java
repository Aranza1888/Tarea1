module neko.controldegastos {
    requires javafx.controls;
    requires javafx.fxml;

    opens neko.controldegastos to javafx.fxml;
    exports neko.controldegastos;
}
