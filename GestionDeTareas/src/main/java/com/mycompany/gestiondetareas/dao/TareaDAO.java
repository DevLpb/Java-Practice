package com.mycompany.gestiondetareas.dao;

import com.mycompany.gestiondetareas.modelo.Tarea;
import java.util.List;

/**
 *
 * @author pc
 */
public interface TareaDAO {
    void addTarea(Tarea tarea); //Crear
    Tarea getTarea(int id); //Leer
    List<Tarea> getAllTareas(); //Leer todas
    void updateTarea(Tarea tarea); //Actualizar
    void deleteTarea(int id); //Borrar
}
