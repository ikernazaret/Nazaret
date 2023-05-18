package com.example.piedrapapeltijera;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class JuegoController {
    private static final String[] OPCIONES = {"Piedra", "Papel", "Tijera"};
    private Stage stage;
    private Scene scene;

    public static String ganadorString;  //si no static no podemos hacer la llamada desde fuera


    @FXML
    public void jugar(ActionEvent event) throws IOException {
        int opcionJugador = obtenerOpcionJugador((Button) event.getSource());
        int opcionComputadora = (int) (Math.random() * 3);

        String eleccionJugador = OPCIONES[opcionJugador];
        String eleccionComputadora = OPCIONES[opcionComputadora];

        String resultado;
        if (opcionJugador == opcionComputadora) {
            resultado = "Empate";
            ganadorString = "Elegiste: " + eleccionJugador + "\nComputadora eligió: " + eleccionComputadora +
                    "\nResultado: " + resultado;
        } else {
            if ((opcionJugador == 0 && opcionComputadora == 2) ||
                    (opcionJugador == 1 && opcionComputadora == 0) ||
                    (opcionJugador == 2 && opcionComputadora == 1)) {
                resultado = "¡Ganaste!";
            } else {
                resultado = "Perdiste";
            }

            ganadorString = "Elegiste: " + eleccionJugador + "\nComputadora eligió: " + eleccionComputadora +
                    "\nResultado: " + resultado;

        }

        toGanadorPortada(event);
    }

    private int obtenerOpcionJugador(Button boton) {
        // Obtener la opción seleccionada según el botón presionado
        if (boton.getId().equals("piedraBoton")) {
            return 0; // Piedra

        } else if (boton.getId().equals("papelBoton")) {
            return 1; // Papel
        } else  {
            return 2; // Tijera
        }
    }

    public void toGanadorPortada(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GanadorView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}




