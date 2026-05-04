package org.divini.smartwaste_g3.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AggiungiController {

    @FXML private Button btnOrganico;
    @FXML private Button btnVetro;
    @FXML private Button btnCarta;
    @FXML private Button btnPlastica;
    @FXML private Button btnIndifferenziata;
    @FXML private Button btnHome;

    @FXML
    public void initialize() {

        btnOrganico.setOnAction(e -> apriForm("Organico"));
        btnVetro.setOnAction(e -> apriForm("Vetro"));
        btnCarta.setOnAction(e -> apriForm("Carta"));
        btnPlastica.setOnAction(e -> apriForm("Plastica"));
        btnIndifferenziata.setOnAction(e -> apriForm("Indifferenziata"));

        btnHome.setOnAction(e -> apri("home.fxml"));
    }

    private void apriForm(String tipo) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/aggiungi_tipo.fxml"));
            Scene scene = new Scene(loader.load());

            // Passiamo il tipo al controller del form
            AggiungiTipoController controller = loader.getController();
            controller.setTipo(tipo);

            Stage stage = (Stage) btnHome.getScene().getWindow();
            stage.setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void apri(String nomeFXML) {
        try {
            Stage stage = (Stage) btnHome.getScene().getWindow();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/" + nomeFXML)));
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}