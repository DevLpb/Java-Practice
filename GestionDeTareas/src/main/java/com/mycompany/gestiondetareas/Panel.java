/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.gestiondetareas;

import com.mycompany.gestiondetareas.Tarea;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Usuario
 */
public class Panel extends javax.swing.JFrame {

    /**
     * Creates new form Form
     */
    public Panel() {
        initComponents();
        actualizarVisibilidadBotones(); //Muestra los botones Editar y Eliminar cuando corresponde
        agregarListSelectionListener(); //Event Listener
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGuardar = new javax.swing.JButton();
        labelTareasPendientes = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaDeTareas = new javax.swing.JList<>();
        labelDescripcion = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        btnNuevaTarea = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        labelTareasPendientes.setText("Tareas Pendientes");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(268, 130));

        listaDeTareas.setPreferredSize(new java.awt.Dimension(268, 500));
        jScrollPane1.setViewportView(listaDeTareas);
        listaDeTareas.getAccessibleContext().setAccessibleName("CuadroDeTareas");

        labelDescripcion.setText("Descripción");

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane2.setViewportView(textArea);

        btnNuevaTarea.setText("Nueva Tarea");
        btnNuevaTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaTareaActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar))
                    .addComponent(labelTareasPendientes)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(labelDescripcion)
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNuevaTarea)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar)
                        .addGap(0, 126, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTareasPendientes)
                    .addComponent(labelDescripcion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEditar)
                            .addComponent(btnEliminar))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNuevaTarea)
                            .addComponent(btnGuardar))
                        .addContainerGap(98, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Lista global
    List<Tarea> lista = new ArrayList();

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Test");
    }//GEN-LAST:event_btnGuardarActionPerformed

    //Crea una nueva tarea, el nombre es obligatorio.
    private void btnNuevaTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaTareaActionPerformed
        Tarea tarea = new Tarea();
        
        String nombre = leerEntrada("Ingrese un nombre para la tarea.");
        if (nombre == null) { return; } //Si se cancela sale del método
        tarea.setNombre(nombre);
        
        String descripcion = JOptionPane.showInputDialog(rootPane, "Ingrese una descripción para la tarea.");
        if (descripcion == null) { return; } //Si se cancela sale del método
        tarea.setDescripcion(descripcion);
        lista.add(tarea);
        actualizarLista();
        JOptionPane.showMessageDialog(rootPane, "Tarea agregada con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnNuevaTareaActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int indice = listaDeTareas.getSelectedIndex();

        try {
            if (indice != -1) {
                lista.remove(indice);
                actualizarLista();
                JOptionPane.showMessageDialog(rootPane, "La tarea se eliminó con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(rootPane, "No se pudo eliminar la tarea. Por favor, selecciona una tarea válida.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(rootPane, "No se pudo eliminar la tarea. Por favor, selecciona una tarea válida.", "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int indice = listaDeTareas.getSelectedIndex();
 
        try {
            if (indice != -1) {
                String nombre = leerEntrada("Ingrese un nuevo nombre para la tarea.");
                if (nombre == null) { return; } //Cancela la edición
                
                String descripcion = JOptionPane.showInputDialog(rootPane, "Ingrese una nueva descripción para la tarea.");
                if (descripcion == null) { return; } //Cancela la edición
                lista.get(indice).setNombre(nombre);
                lista.get(indice).setDescripcion(descripcion);
                actualizarLista();
                JOptionPane.showMessageDialog(rootPane, "La tarea fue editada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(rootPane, "No se pudo editar la tarea. Por favor, selecciona una tarea válida.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(rootPane, "No se pudo editar la tarea. Por favor, selecciona una tarea válida.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    /* Método encargado de leer las entradas de los inputs y repetir la petición si no se ingresa un valor. */
    private String leerEntrada(String mensaje) {
        String input = JOptionPane.showInputDialog(rootPane, mensaje);
        while (input != null && input.isEmpty()) {
            input = JOptionPane.showInputDialog(rootPane, "Debe ingresar un valor. " + mensaje);
        } 
        return input;
    }
    
    /*Crea el modelo de lista a partir de recorrer la lista global en un bucle for
      Luego establece ese modelo en el componente listaDeTareas y limpia el text area. */
    private void actualizarLista() {
        DefaultListModel listaModelo = new DefaultListModel();
        for (int i = 0; i < lista.size(); i++) {
            Tarea tarea = lista.get(i);
            listaModelo.addElement(tarea.getNombre());
        }
        listaDeTareas.setModel(listaModelo);
        textArea.setText("");
        actualizarVisibilidadBotones();
    }

    private void actualizarVisibilidadBotones() {
        if (lista.isEmpty()) {
            btnEditar.setVisible(false);
            btnEliminar.setVisible(false);
        } else {
            btnEditar.setVisible(true);
            btnEliminar.setVisible(true);
        }
    }

    /*Event Listener que llena el cuadro de descripción 
      con cada elemento de la lista seleccionado correspondiente. */
    private void agregarListSelectionListener() {
        listaDeTareas.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int indice = listaDeTareas.getSelectedIndex();
                    if (indice != -1) {
                        textArea.setText(lista.get(indice).getDescripcion());
                    }
                }
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Panel().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevaTarea;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelDescripcion;
    private javax.swing.JLabel labelTareasPendientes;
    private javax.swing.JList<String> listaDeTareas;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
