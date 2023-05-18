package com.example.piedrapapeltijera;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class GanadorController {
    @FXML
    public Label resultadoLabel;
    private Stage stage;
    private Scene scene;

    @FXML
    public void initialize() {  //Se encarga de llamar al método
        setResultado(JuegoController.ganadorString);

    }

    public void setResultado(String resultado) {
        resultadoLabel.setText(resultado);
    } //Mostrara el mensaje de ganadorString de el otro controller
    @FXML
    public void IrJuegoView(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("JuegoView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void IrInicioView(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("InicioView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}