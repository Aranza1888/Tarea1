package neko.cifrasdivisoresnumeros;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class controladordecifras {

    @FXML private TextField txtNumero;
    @FXML private TextField txtCantCifras;
    @FXML private TextField txtSumaImpares;
    @FXML private TextField txtSumaPares;
    @FXML private TextField txtSumaTotal;
    @FXML private TextField txtCifraMayor;
    @FXML private TextField txtCifraMenor;
    @FXML private TextArea txtAreaDivisores;

    @FXML
    private void handleAnalizar(ActionEvent event) {
        try {
            String texto = txtNumero.getText().trim();
            if (texto.isEmpty()) {
                mostrarAlerta("Error", "Por favor ingrese un número.");
                return;
            }

            int nOriginal = Integer.parseInt(texto);
            int n = Math.abs(nOriginal);

            int cantCifras = 0;
            int sumaImpares = 0;
            int sumaPares = 0;
            int sumaTotal = 0;
            int cifraMayor = -1;
            int cifraMenor = 10;
            
            if (n == 0) {
                cantCifras = 1;
                sumaTotal = 0;
                sumaPares = 0;
                cifraMayor = 0;
                cifraMenor = 0;
            } else {
                int temp = n;
                while (temp > 0) {
                    int cifra = temp % 10;
                    cantCifras++;
                    sumaTotal += cifra;

                    if (cifra % 2 == 0) {
                        sumaPares += cifra;
                    } else {
                        sumaImpares += cifra;
                    }

                    if (cifra > cifraMayor) {
                        cifraMayor = cifra;
                    }
                    if (cifra < cifraMenor) {
                        cifraMenor = cifra;
                    }

                    temp /= 10;
                }
            }

            
            txtCantCifras.setText(String.valueOf(cantCifras));
            txtSumaImpares.setText(String.valueOf(sumaImpares));
            txtSumaPares.setText(String.valueOf(sumaPares));
            txtSumaTotal.setText(String.valueOf(sumaTotal));
            txtCifraMayor.setText(String.valueOf(cifraMayor));
            txtCifraMenor.setText(String.valueOf(cifraMenor));

            
            txtAreaDivisores.clear();
            int nDiv = Math.abs(nOriginal);
            if (nDiv == 0) {
                txtAreaDivisores.setText("El 0 tiene infinitos divisores.");
            } else {
                for (int i = 1; i <= nDiv; i++) {
                    if (nDiv % i == 0) {
                        txtAreaDivisores.appendText(i + "\n");
                    }
                }
            }

        } catch (NumberFormatException e) {
            mostrarAlerta("Formato incorrecto", "Ingrese únicamente números enteros válidos.");
        }
    }

    @FXML
    private void handleLimpiar(ActionEvent event) {
        txtNumero.clear();
        txtCantCifras.clear();
        txtSumaImpares.clear();
        txtSumaPares.clear();
        txtSumaTotal.clear();
        txtCifraMayor.clear();
        txtCifraMenor.clear();
        txtAreaDivisores.clear();
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