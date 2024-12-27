package com.mycompany.gestiondetareas.modelo;

/**
 *
 * @author Usuario
 */
public class Tarea {

    private int id;
    private String nombre;
    private String descripcion;
    private String estado; //Estado de la tarea (nueva, editada o eliminada)

    //Constructor sin ID
    public Tarea(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = "nueva"; //Estado inicial para nuevas tareas
    }

    //Constructor vacío
    public Tarea() {
        this.estado = "nueva"; //Estado inicial para nuevas tareas
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        if (!"nueva".equals(this.estado)) {
            this.estado = "editada"; //Cambia estado a "editada" si no es una nueva tarea
        }
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        if (!"nueva".equals(this.estado)) {
            this.estado = "editada"; //Cambia estado a "editada" si no es una nueva tarea
        }
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
