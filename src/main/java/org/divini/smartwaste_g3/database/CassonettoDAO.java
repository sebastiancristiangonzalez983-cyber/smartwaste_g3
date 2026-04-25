package org.divini.smartwaste_g3.database;

import org.divini.smartwaste_g3.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CassonettoDAO {

    private ConnessioneDatabase conn;

    public CassonettoDAO(ConnessioneDatabase conn) {
        this.conn = conn;
    }

    // INSERT
    public boolean inserisci(Cassonetto c) {
        String sql = "INSERT INTO cassonetti_SmartWaste_G3 (codice, tipologia, capacita, valore) VALUES (?, ?, ?, ?)";

        try (Connection co = conn.getConnection();
             PreparedStatement stmt = co.prepareStatement(sql)) {

            stmt.setInt(1, c.getCodice());
            stmt.setString(2, c.getTipologia().name());
            stmt.setDouble(3, c.getCapacita());

            // valor actual (peso, volumen o botellas)
            double valoreAttuale = c.getPercentualeRiempimento() * c.getCapacita() / 100;
            stmt.setDouble(4, valoreAttuale);

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    // SELECT ALL
    public List<Cassonetto> getTutti() {
        List<Cassonetto> lista = new ArrayList<>();
        String sql = "SELECT * FROM cassonetti_SmartWaste_G3";

        try (Connection co = conn.getConnection();
             PreparedStatement stmt = co.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(creaCassonettoDaResultSet(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    //DELETE
    public boolean elimina(int codice) {
        String sql = "DELETE FROM cassonetti_SmartWaste_G3 WHERE codice = ?";

        try (Connection co = conn.getConnection();
             PreparedStatement stmt = co.prepareStatement(sql)) {

            stmt.setInt(1, codice);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // SELECT BY CODICE
    public Cassonetto cerca(int codice) {
        String sql = "SELECT * FROM cassonetti_SmartWaste_G3 WHERE codice = ?";

        try (Connection co = conn.getConnection();
             PreparedStatement stmt = co.prepareStatement(sql)) {

            stmt.setInt(1, codice);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return creaCassonettoDaResultSet(rs);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    // SELECT BY TIPOLOGIA
    public List<Cassonetto> getPerTipologia(TipologiaRifiuto   tipo) {
        List<Cassonetto> lista = new ArrayList<>();
        String sql = "SELECT * FROM cassonetti_SmartWaste_G3 WHERE tipologia = ?";

        try (Connection co = conn.getConnection();
             PreparedStatement stmt = co.prepareStatement(sql)) {

            stmt.setString(1, tipo.name());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                lista.add(creaCassonettoDaResultSet(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    // SELECT CASSOMETTI DA SVUOTARE

    public List<Cassonetto> getCassonettiDaSvuotare() {
        List<Cassonetto> lista = new ArrayList<>();
        String sql = "SELECT * FROM cassonetti_SmartWaste_G3 WHERE valore / capacita * 100 > 90";

        try (Connection co = conn.getConnection();
             PreparedStatement stmt = co.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(creaCassonettoDaResultSet(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    // RECONSTRUCTOR
    private Cassonetto creaCassonettoDaResultSet(ResultSet rs) throws SQLException {

        int codice = rs.getInt("codice");
        String tipo = rs.getString("tipologia");
        double capacita = rs.getDouble("capacita");
        double valore = rs.getDouble("valore");

        Cassonetto c = switch (TipologiaRifiuto.valueOf(tipo)) {
            case Organico -> new Organico(codice, 0, 0, null, null, capacita);
            case Vetro -> new Vetro(codice, 0, 0, null, null, (int) capacita);
            case Carta -> new Carta(codice, 0, 0, null, null, capacita);
            case Plastica -> new Plastica(codice, 0, 0, null, null, capacita);
            case Indifferenziata -> new Indifferenziata(codice, 0, 0, null, null, capacita);
        };

        c.aggiorna(valore);
        return c;
    }

}
