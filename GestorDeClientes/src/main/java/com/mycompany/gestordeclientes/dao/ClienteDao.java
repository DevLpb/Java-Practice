/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestordeclientes.dao;

import com.mycompany.gestordeclientes.model.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class ClienteDao {

    public Connection conectar() {
        String baseDeDatos = "gestion_clientes"; //Nombre de base de datos
        String usuario = "root";
        String password = "";
        String host = "localhost";
        String puerto = "3306";
        String driver = "com.mysql.cj.jdbc.Driver"; // Driver actualizado

        String conexionUrl = "jdbc:mysql://" + host + ":" + puerto + "/" + baseDeDatos + "?useSSL=false&allowPublicKeyRetrieval=true"; // Actualizado

        Connection conexion = null;
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(conexionUrl, usuario, password);

        } catch (Exception ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }

    public void agregar(Cliente cliente) {
        try {
            Connection conexion = conectar();

            String sql = "INSERT INTO clientes (nombre, apellido, email, telefono) VALUES ('" + cliente.getNombre() + "', '" + cliente.getApellido()
                    + "', '" + cliente.getEmail() + "', '" + cliente.getTelefono() + "');";
            Statement statement = conexion.createStatement();
            statement.execute(sql);

        } catch (Exception ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Cliente> listar() {
        List<Cliente> listado = new ArrayList<>();
        try {
            Connection conexion = conectar();

            String sql = "SELECT * FROM clientes;";
            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery(sql);

            while (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(resultado.getInt("id"));
                cliente.setNombre(resultado.getString("nombre"));
                cliente.setApellido(resultado.getString("apellido"));
                cliente.setEmail(resultado.getString("email"));
                cliente.setTelefono(resultado.getString("telefono"));

                listado.add(cliente);
            }
        } catch (Exception ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listado;
    }

    public void eliminar(int id) {
        try {
            Connection conexion = conectar();

            String sql = "DELETE FROM clientes WHERE id = " + id;
            Statement statement = conexion.createStatement();
            statement.execute(sql);

        } catch (Exception ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void actualizar(Cliente cliente) {
        try {
            Connection conexion = conectar();

            String sql = "UPDATE clientes SET nombre = '" + cliente.getNombre() + "' , apellido = '" + cliente.getApellido()
                    + "' , email = '" + cliente.getEmail() + "', telefono = '" + cliente.getTelefono() + "' WHERE id = " + cliente.getId() + ";";
            Statement statement = conexion.createStatement();
            statement.execute(sql);

        } catch (Exception ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void guardar(Cliente cliente) {
        if (cliente.getId() == 0) {
            agregar(cliente);
        } else {
            actualizar(cliente);
        }
    }
}
