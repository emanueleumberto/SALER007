package org.example.esercizi.DAO;

import org.example.esercizi.DatabaseConn;
import org.example.esercizi.classes.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public void creaCliente(Cliente c) throws SQLException {
        String sql = "INSERT INTO clienti (nome, cognome, email, telefono) " +
                     "VALUES (?, ?, ?, ?)";
        PreparedStatement ps = DatabaseConn.getConnetion().prepareStatement(sql);
        ps.setString(1, c.getNome());
        ps.setString(2, c.getCognome());
        ps.setString(3, c.getEmail());
        ps.setString(4, c.getTelefono());
        ps.executeUpdate();
        System.out.println("Cliente " + c.getNome() + " " + c.getCognome() + " inserito nel DB!");
    }

    public Cliente leggiCliente(int id) throws SQLException {
        String sql = "SELECT * FROM clienti WHERE id_cliente = ?";
        PreparedStatement ps = DatabaseConn.getConnetion().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Cliente c = null;
        if(rs.next()){
            int id_cliente = rs.getInt("id_cliente");
            String nome = rs.getString("nome");
            String cognome = rs.getString("cognome");
            String email = rs.getString("email");
            String telefono = rs.getString("telefono");
            c = new Cliente(id_cliente, nome, cognome, email, telefono);
        }
        return c;
    }

    public void modificaCliente(Cliente c) throws SQLException {
        String sql = "UPDATE clienti SET nome = ?, cognome = ?, email = ?, telefono = ? " +
                     "WHERE id_cliente = ?";
        PreparedStatement ps = DatabaseConn.getConnetion().prepareStatement(sql);
        ps.setString(1, c.getNome());
        ps.setString(2, c.getCognome());
        ps.setString(3, c.getEmail());
        ps.setString(4, c.getTelefono());
        ps.setInt(5, c.getId_cliente());
        ps.executeUpdate();
        System.out.println("Cliente " + c.getNome() + " " + c.getCognome() + " modificato nel DB!");
    }

    public void eliminaCliente(Cliente c) throws SQLException {
        String sql = "DELETE FROM clienti WHERE id_cliente = ?";
        PreparedStatement ps = DatabaseConn.getConnetion().prepareStatement(sql);
        ps.setInt(1, c.getId_cliente());
        ps.executeUpdate();
        System.out.println("Cliente " + c.getNome() + " " + c.getCognome() + " eliminato dal DB!");
    }

    public List<Cliente> leggiTuttiIClienti() throws SQLException {
        String sql = "SELECT * FROM clienti";
        PreparedStatement ps = DatabaseConn.getConnetion().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Cliente> lista = new ArrayList<Cliente>();
        while(rs.next()){
            int id_cliente = rs.getInt("id_cliente");
            String nome = rs.getString("nome");
            String cognome = rs.getString("cognome");
            String email = rs.getString("email");
            String telefono = rs.getString("telefono");
            lista.add(new Cliente(id_cliente, nome, cognome, email, telefono));
        }
        return lista;
    }

}
