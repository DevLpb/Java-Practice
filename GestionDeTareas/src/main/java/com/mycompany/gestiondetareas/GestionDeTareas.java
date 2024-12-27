package com.mycompany.gestiondetareas;

import com.mycompany.gestiondetareas.vista.Panel;

/**
 *
 * @author Usuario
 */
public class GestionDeTareas {

    public static void main(String[] args) {   
        Panel panel = new Panel();
        panel.inicializarDAO(); //Inicializa el DAO
        panel.setVisible(true);
    }
}
