package com.mycompany.gestordeproductos.dao;

import com.mycompany.gestordeproductos.modelo.Producto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ProductoDAOImpl implements ProductoDAO {

    //Conexión a base de datos mediante constructor
    private Connection connection;

    public ProductoDAOImpl() {

        //Datos de la base de datos
        String database = ""; //Nombre de la base de datos
        String username = ""; //Usuario de la base de datos
        String password = ""; //Contraseña de la base de datos
        String url = "jdbc:mysql://localhost:3306/" + database;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Métodos CRUD
    @Override
    public void addProducto(Producto producto) {
        String query = "INSERT INTO productos (nombre, precio, cantidad) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, producto.getNombre());
            ps.setDouble(2, producto.getPrecio());
            ps.setInt(3, producto.getCantidad());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                producto.setId(id); // Actualiza el ID del producto con el ID generado
                System.out.println("Producto creado: " + producto.getNombre() + " ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Producto getProducto(int id) {
        Producto producto = null;
        String query = "SELECT * FROM productos WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                producto = new Producto(rs.getString("nombre"), rs.getDouble("precio"), rs.getInt("cantidad"));
                producto.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producto;
    }

    @Override
    public List<Producto> getAllProductos() {
        List<Producto> productos = new ArrayList<>();
        String query = "SELECT * FROM productos";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto(rs.getString("nombre"), rs.getDouble("precio"), rs.getInt("cantidad"));
                producto.setId(rs.getInt("id"));
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    @Override
    public void updateProducto(Producto producto) {
        String query = "UPDATE productos SET nombre = ?, precio = ?, cantidad = ? WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, producto.getNombre());
            ps.setDouble(2, producto.getPrecio());
            ps.setInt(3, producto.getCantidad());
            ps.setInt(4, producto.getId());
            ps.executeUpdate();
            System.out.println("Producto editado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProducto(int id) {
        String query = "DELETE FROM productos WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Producto eliminado correctamente de la BD. ID: " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
