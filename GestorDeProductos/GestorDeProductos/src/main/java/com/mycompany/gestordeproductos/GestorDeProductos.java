package com.mycompany.gestordeproductos;

import com.mycompany.gestordeproductos.vista.Frame;

/**
 *
 * @author pc
 */
public class GestorDeProductos {

    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setVisible(true);
        frame.inicializarDAO(); //Inicialliza el DAO
    }
}
