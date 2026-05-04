package org.divini.smartwaste_g3.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.divini.smartwaste_g3.database.CassonettoDAO;
import org.divini.smartwaste_g3.database.ConnessioneDatabase;
import org.divini.smartwaste_g3.model.Cassonetto;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class VisualizzaController {

    @FXML private TableView<Cassonetto> tabellaCassonetti;

    @FXML private TableColumn<Cassonetto, Integer> colCodice;
    @FXML private TableColumn<Cassonetto, Double> colLat;
    @FXML private TableColumn<Cassonetto, Double> colLon;
    @FXML private TableColumn<Cassonetto, String> colTipo;
    @FXML private TableColumn<Cassonetto, Double> colValore;
    @FXML private TableColumn<Cassonetto, Double> colCapacita;
    @FXML private TableColumn<Cassonetto, Double> colPercentuale;

    @FXML private Button btnHome;

    private CassonettoDAO dao;

    @FXML
    public void initialize() {

        dao = new CassonettoDAO(new ConnessioneDatabase());

        // Colonne
        colCodice.setCellValueFactory(c -> new javafx.beans.property.SimpleIntegerProperty(c.getValue().getCodice()).asObject());
        colLat.setCellValueFactory(c -> new javafx.beans.property.SimpleDoubleProperty(c.getValue().getLatitudine()).asObject());
        colLon.setCellValueFactory(c -> new javafx.beans.property.SimpleDoubleProperty(c.getValue().getLongitudine()).asObject());
        colTipo.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getTipologia().name()));

        colValore.setCellValueFactory(c ->
                new javafx.beans.property.SimpleDoubleProperty(
                        c.getValue().getPercentualeRiempimento() * c.getValue().getCapacita() / 100
                ).asObject()
        );

        colCapacita.setCellValueFactory(c -> new javafx.beans.property.SimpleDoubleProperty(c.getValue().getCapacita()).asObject());
        colPercentuale.setCellValueFactory(c -> new javafx.beans.property.SimpleDoubleProperty(c.getValue().getPercentualeRiempimento()).asObject());

        // Carica dati
        caricaTabella();

        // Torna alla home
        btnHome.setOnAction(e -> tornaHome());
    }

    private void caricaTabella() {
        ObservableList<Cassonetto> lista = FXCollections.observableArrayList(dao.getTutti());
        tabellaCassonetti.setItems(lista);
    }

    private void tornaHome() {
        try {
            Stage stage = (Stage) btnHome.getScene().getWindow();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/home.fxml")));
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}