package neko.tablademultiplicar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class controladordelatabla {

    @FXML private TextField txtNumero;
    @FXML private TextArea txtAreaTabla;

    @FXML
    private void handleCalcular(ActionEvent event) {
        String texto = txtNumero.getText().trim();

        if (texto.isEmpty()) {
            mostrarAlerta("Campo vacío", "Por favor ingrese un número entero.");
            return;
        }

        try {
            int numero = Integer.parseInt(texto);
            

            txtAreaTabla.clear();


            for (int i = 1; i <= 10; i++) {
                int resultado = numero * i;
                txtAreaTabla.appendText(numero + "x" + i + " = " + resultado + "\n");
            }

        } catch (NumberFormatException e) {
            mostrarAlerta("Formato incorrecto", "Ingrese únicamente números enteros válidos.");
        }
    }

    @FXML
    private void handleLimpiar(ActionEvent event) {
        txtNumero.clear();
        txtAreaTabla.clear();
        txtNumero.requestFocus();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}