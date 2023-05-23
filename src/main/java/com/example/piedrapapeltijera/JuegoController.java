package com.example.piedrapapeltijera;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class JuegoController {


    private static final String[] OPCIONES = {"Piedra", "Papel", "Tijera"};  //Crea una cadena con las opciones posibles
    private Stage stage;
    private Scene scene;

    public static String ganadorString;  //si no es static no podemos hacer la llamada desde fuera

    @FXML
    public void jugar(ActionEvent event) throws IOException {
        int opcionJugador = obtenerOpcionJugador((Button) event.getSource());   //Coger la información del botón pulsado
        int opcionOrdenador = (int) (Math.random() * 3);      //Hacer que la maquina eliga un numero del 0 al 2

        String eleccionJugador = OPCIONES[opcionJugador];
        String eleccionOrdenador = OPCIONES[opcionOrdenador];
        String resultado;


        if (opcionJugador == opcionOrdenador) { //Si las dos opciones son iguales, el resultado será "Empate"
            resultado = "Empate";
            ganadorString = "Has elegido: " + eleccionJugador + "\nEl ordenador ha elegido: " + eleccionOrdenador +
                    "\nResultado: " + resultado;



        } else {
            if ((opcionJugador == 0 && opcionOrdenador == 2) ||   //Si ganamos, el resultado será has ganado
                    (opcionJugador == 1 && opcionOrdenador == 0) ||
                    (opcionJugador == 2 && opcionOrdenador == 1)) {
                resultado = "¡Has ganado!";
            } else {
                resultado = "Has perdido..."; //Si no, sera has perdido
            }

            ganadorString = "Has elegido: " + eleccionJugador + "\nEl ordenador ha elegido: " + eleccionOrdenador +

                    "\nResultado: " + resultado;

        }

        toGanadorPortada(event);  //Cuando se calcule el resultado, llamara al metodo "toGanadorPortada" y  nos pasará a la siguiente pantalla
    }

    private int obtenerOpcionJugador(Button boton) {
        // Obtener la opción seleccionada según el botón seleccionado
        //Si el botón pulsado coincide con el id, hara un return o otro
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
        stage.setResizable(false); //Para que no se pueda ampliar

        stage.show();
    }
}




