package neko.controldegastos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class controladordegastos {

    @FXML private TextField txtAlimentacion;
    @FXML private TextField txtRefrigerios;
    @FXML private TextField txtTransporte;
    @FXML private TextField txtTelefonia;
    @FXML private TextField txtOtros;
    @FXML private TextField txtTotal;
    @FXML private TextField txtMayor;

    @FXML
    private void handleCalcular(ActionEvent event) {
        try {

            double alimentacion = obtenerValor(txtAlimentacion);
            double refrigerios = obtenerValor(txtRefrigerios);
            double transporte = obtenerValor(txtTransporte);
            double telefonia = obtenerValor(txtTelefonia);
            double otros = obtenerValor(txtOtros);


            double total = alimentacion + refrigerios + transporte + telefonia + otros;
            txtTotal.setText(String.format("%.2f", total));

 
            double mayor = alimentacion;
            String categoriaMayor = "Alimentación";

            if (refrigerios > mayor) {
                mayor = refrigerios;
                categoriaMayor = "Refrigerios";
            }
            if (transporte > mayor) {
                mayor = transporte;
                categoriaMayor = "Transporte";
            }
            if (telefonia > mayor) {
                mayor = telefonia;
                categoriaMayor = "Telefonía";
            }
            if (otros > mayor) {
                mayor = otros;
                categoriaMayor = "Otros";
            }


            txtMayor.setText(categoriaMayor + " (" + String.format("%.2f", mayor) + ")");

        } catch (NumberFormatException e) {
            mostrarAlerta("Formato incorrecto", "Ingrese únicamente números válidos en los campos de gastos.");
        }
    }

    private double obtenerValor(TextField txt) {
        String texto = txt.getText().trim();
        if (texto.isEmpty()) {
            return 0.0;
        }
        return Double.parseDouble(texto);
    }

    @FXML
    private void handleLimpiar(ActionEvent event) {
        txtAlimentacion.clear();
        txtRefrigerios.clear();
        txtTransporte.clear();
        txtTelefonia.clear();
        txtOtros.clear();
        txtTotal.clear();
        txtMayor.clear();
        txtAlimentacion.requestFocus();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}