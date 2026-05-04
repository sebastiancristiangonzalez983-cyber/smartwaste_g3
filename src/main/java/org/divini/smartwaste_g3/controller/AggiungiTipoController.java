package org.divini.smartwaste_g3.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.divini.smartwaste_g3.database.CassonettoDAO;
import org.divini.smartwaste_g3.database.ConnessioneDatabase;
import org.divini.smartwaste_g3.model.*;

public class AggiungiTipoController {

    @FXML private Label lblTitolo;
    @FXML private TextField txtLat;
    @FXML private TextField txtLon;
    @FXML private TextField txtCapacita;
    @FXML private TextField txtRiempimento;
    @FXML private Button btnSalva;
    @FXML private Button btnIndietro;

    private String tipo;

    public void setTipo(String tipo) {
        this.tipo = tipo;
        lblTitolo.setText("Aggiungi " + tipo);
    }

    @FXML
    public void initialize() {

        btnSalva.setOnAction(e -> salvaCassonetto());
        btnIndietro.setOnAction(e -> tornaIndietro());
    }

    private void salvaCassonetto() {
        try {
            double lat = Double.parseDouble(txtLat.getText());
            double lon = Double.parseDouble(txtLon.getText());
            double capacita = Double.parseDouble(txtCapacita.getText());
            double valoreReale = Double.parseDouble(txtRiempimento.getText());

            Cassonetto c = switch (tipo) {
                case "Organico" -> new Organico(0, lat, lon, null, null, capacita);
                case "Vetro" -> new Vetro(0, lat, lon, null, null, (int) capacita);
                case "Carta" -> new Carta(0, lat, lon, null, null, capacita);
                case "Plastica" -> new Plastica(0, lat, lon, null, null, capacita);
                default -> new Indifferenziata(0, lat, lon, null, null, capacita);
            };

            c.aggiorna(valoreReale);

            CassonettoDAO dao = new CassonettoDAO(new ConnessioneDatabase());
            dao.inserisci(c);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Cassonetto aggiunto con successo!");
            alert.showAndWait();

            tornaIndietro();

        } catch (Exception ex) {
            ex.printStackTrace();

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Errore");
            alert.setContentText("Controlla i campi inseriti.");
            alert.showAndWait();
        }
    }

    private void tornaIndietro() {
        try {
            Stage stage = (Stage) btnIndietro.getScene().getWindow();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/aggiungi.fxml")));
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
