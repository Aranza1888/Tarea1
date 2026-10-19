package neko.desglosedinero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class desglosedeldinero {

    @FXML private TextField txtDinero;
    @FXML private TextField txt500;
    @FXML private TextField txt200;
    @FXML private TextField txt100;
    @FXML private TextField txt50;
    @FXML private TextField txt20;
    @FXML private TextField txt10;
    @FXML private TextField txt5;
    @FXML private TextField txt2;
    @FXML private TextField txt1;

    @FXML
    private void handleDesglosar(ActionEvent event) {
        try {
            int dinero = Integer.parseInt(txtDinero.getText().trim());

            if (dinero < 0) {
                mostrarAlerta("Error", "Por favor ingrese una cantidad entera positiva.");
                return;
            }

            int c500 = dinero / 500;
            dinero %= 500;

            int c200 = dinero / 200;
            dinero %= 200;

            int c100 = dinero / 100;
            dinero %= 100;

            int c50 = dinero / 50;
            dinero %= 50;

            int c20 = dinero / 20;
            dinero %= 20;

            int c10 = dinero / 10;
            dinero %= 10;

            int c5 = dinero / 5;
            dinero %= 5;

            int c2 = dinero / 2;
            dinero %= 2;

            int c1 = dinero / 1;

            txt500.setText(String.valueOf(c500));
            txt200.setText(String.valueOf(c200));
            txt100.setText(String.valueOf(c100));
            txt50.setText(String.valueOf(c50));
            txt20.setText(String.valueOf(c20));
            txt10.setText(String.valueOf(c10));
            txt5.setText(String.valueOf(c5));
            txt2.setText(String.valueOf(c2));
            txt1.setText(String.valueOf(c1));

        } catch (NumberFormatException e) {
            mostrarAlerta("Formato incorrecto", "Ingrese únicamente números enteros válidos.");
        }
    }

    @FXML
    private void handleLimpiar(ActionEvent event) {
        txtDinero.clear();
        txt500.clear();
        txt200.clear();
        txt100.clear();
        txt50.clear();
        txt20.clear();
        txt10.clear();
        txt5.clear();
        txt2.clear();
        txt1.clear();
        txtDinero.requestFocus();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}