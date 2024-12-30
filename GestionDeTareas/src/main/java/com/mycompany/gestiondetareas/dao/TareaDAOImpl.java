package com.mycompany.gestiondetareas.dao;

import com.mycompany.gestiondetareas.modelo.Tarea;
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
 * @author pc
 */
public class TareaDAOImpl implements TareaDAO {

    //Conexión a base de datos mediante constructor
    private Connection connection;

    public TareaDAOImpl() {

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
    public void addTarea(Tarea tarea) {
        String sql = "INSERT INTO tareas (nombre, descripcion) VALUES (?, ?)";
    try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        ps.setString(1, tarea.getNombre());
        ps.setString(2, tarea.getDescripcion());
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            tarea.setId(id); // Actualiza el ID de la tarea con el ID generado
            System.out.println("Tarea creada: " + tarea.getNombre() + " ID: " + id);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }

    @Override
    public Tarea getTarea(int id) {
        Tarea tarea = null;
        String sql = "SELECT * FROM tareas WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                tarea = new Tarea(rs.getString("nombre"), rs.getString("descripcion"));
                tarea.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tarea;
    }

    @Override
    public List<Tarea> getAllTareas() {
        List<Tarea> tareas = new ArrayList<>();
        String sql = "SELECT * FROM tareas";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tarea tarea = new Tarea(rs.getString("nombre"), rs.getString("descripcion"));
                tarea.setId(rs.getInt("id"));
                tareas.add(tarea);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tareas;
    }

    @Override
    public void updateTarea(Tarea tarea) {
        String sql = "UPDATE tareas SET nombre = ?, descripcion = ? WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, tarea.getNombre());
            ps.setString(2, tarea.getDescripcion());
            ps.setInt(3, tarea.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTarea(int id) {
        String sql = "DELETE FROM tareas WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Tarea eliminada correctamente de la BD. ID: " + id);
            } else {
                System.out.println("No se encontró la tarea en la BD para eliminar. ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
