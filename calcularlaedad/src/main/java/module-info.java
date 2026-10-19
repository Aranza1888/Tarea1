module neko.calcularlaedad {
    requires javafx.controls;
    requires javafx.fxml;

    opens neko.calcularlaedad to javafx.fxml;
    exports neko.calcularlaedad;
}
