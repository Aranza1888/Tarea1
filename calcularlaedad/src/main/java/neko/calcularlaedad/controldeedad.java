package neko.calcularlaedad;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class controldeedad {

    @FXML private TextField txtFechaNacimiento;
    @FXML private Label lblResultado;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @FXML
    private void handleCalcular (ActionEvent event) {
        String textoFecha = txtFechaNacimiento.getText().trim();

        if (textoFecha.isEmpty()) {
            mostrarAlerta("Campo vacío" , "por favor ingresa la fecha de nacimiento.");
            return;
        }

        try {
            LocalDate fechaNacimiento = LocalDate.parse(textoFecha, formatter);
            LocalDate fechaActual = LocalDate.now();

            if (fechaNacimiento.isAfter(fechaActual)) {
                mostrarAlerta("Fecha inválida", "la fecha de nacimiento no puede ser posterior a la fecha actual.");
                return;
            }

            Period periodo = Period.between(fechaNacimiento, fechaActual);

            int anios = periodo.getYears();
            int meses = periodo.getMonths();

            lblResultado.setText("Tienes " + anios + " años con " + meses + " meses");

        } catch (DateTimeParseException e) {
            mostrarAlerta("Formato incorrecto", "Ingresa la fecha con el formato dd/mm/aaaa (Ejemplo: 15/05/1990).");
        }
    }

    @FXML
    private void handleLimpiar(ActionEvent event) {
        txtFechaNacimiento.clear();
        lblResultado.setText("");
        txtFechaNacimiento.requestFocus();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}