package com.mycompany.gestordeproductos.vista;

import com.mycompany.gestordeproductos.modelo.Producto;
import com.mycompany.gestordeproductos.dao.ProductoDAO;
import com.mycompany.gestordeproductos.dao.ProductoDAOImpl;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author pc
 */
public class Frame extends javax.swing.JFrame {

    /**
     * Creates new form Frame
     */
    public Frame() {
        initComponents();
        agregarListSelectionListener(); //Event Listener.
    }

    private ProductoDAO productoDAO;
    
    public void inicializarDAO() {
        productoDAO = new ProductoDAOImpl(); //Inicializa el DAO
        cargarDatos(); //Carga los datos de la BD a la lista visible
    }
    
    public void cargarDatos(){
        lista = productoDAO.getAllProductos();
        actualizarLista();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaDeProductos = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Productos");

        jScrollPane1.setViewportView(listaDeProductos);

        jLabel2.setText("Nombre:");

        jLabel3.setText("Precio:");
        jLabel3.setToolTipText("");

        jLabel4.setText("Cantidad:");

        btnNuevo.setText("Agregar Producto");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnNuevo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCantidad))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                                    .addComponent(txtPrecio)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar))
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(9, 9, 9)
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Lista global
    List<Producto> lista = new ArrayList();

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        Producto producto = new Producto();

        String nombre = leerEntradaString("Ingrese el nombre del producto.");
        if (nombre == null) {
            return;
        }
        producto.setNombre(nombre);
        //  JOptionPane.showMessageDialog(rootPane, "Nombre agregado.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        Double precio = leerEntradaDouble("Ingrese el precio del producto.");
        if (precio == null) {
            return;
        }
        producto.setPrecio(precio);
        //  JOptionPane.showMessageDialog(rootPane, "Precio agregado.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        Integer cantidad = leerEntradaInt("Ingrese la cantidad del producto por unidad.");
        if (cantidad == null) {
            return;
        }
        producto.setCantidad(cantidad);
        //  JOptionPane.showMessageDialog(rootPane, "Cantidad agregada.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        lista.add(producto);
        productoDAO.addProducto(producto);
        JOptionPane.showMessageDialog(rootPane, "Producto creado.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        actualizarLista();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int indice = listaDeProductos.getSelectedIndex(); //Guarda el lugar del elemento seleccionado en la variable "indice"
        Producto producto = lista.get(indice);

        try {
            if (indice != -1) {
                String nombre = leerEntradaString("Ingrese un nuevo nombre para el producto.");
                if (nombre == null) {
                    return;
                } //Cancela la edición

                Double precio = leerEntradaDouble("Ingrese un nuevo precio para el producto.");
                if (precio == null) {
                    return;
                } //Cancela la edición

                Integer cantidad = leerEntradaInt("Ingrese una nueva cantidad para el producto.");
                producto.setNombre(nombre); //Altera el elemento de la lista global usando el índice correspondiente
                producto.setPrecio(precio); //Altera el elemento de la lista global usando el índice correspondiente
                producto.setCantidad(cantidad); //Altera el elemento de la lista global usando el indice correspondiente.
                productoDAO.updateProducto(producto);
                actualizarLista();
                JOptionPane.showMessageDialog(rootPane, "El producto fue editado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(rootPane, "No se pudo editar el producto. Por favor, selecciona un producto válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(rootPane, "No se pudo editar el producto. Por favor, selecciona un producto válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int indice = listaDeProductos.getSelectedIndex(); //Guarda el lugar del elemento seleccionado en la variable "indice"
   
        try {
            if (indice != -1) {
                productoDAO.deleteProducto(lista.get(indice).getId());
                lista.remove(indice);
                actualizarLista();
                JOptionPane.showMessageDialog(rootPane, "Producto eliminado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(rootPane, "No se pudo eliminar el producto. Seleccione un elemento válido.", "Fallo", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(rootPane, "No se pudo eliminar el producto. Seleccione un elemento válido.", "Fallo", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    //Método que pide una entrada para el nombre. Si está vacía, repite la petición.
    private String leerEntradaString(String mensaje) {
        String input = JOptionPane.showInputDialog(rootPane, mensaje);
        while (input != null && input.isEmpty()) {
            input = JOptionPane.showInputDialog(rootPane, "Debe ingresar un valor. " + mensaje);
        }
        return input;
    }

    //Método que pide una entrada como String para el precio. Inicia un bucle 
    //y repite las peticiones hasta que la entrada sea válida.
    private double leerEntradaDouble(String mensaje) {
        String input = JOptionPane.showInputDialog(rootPane, mensaje);
        while (true) {
            if (input == null || input.isEmpty()) {
                input = JOptionPane.showInputDialog(rootPane, "Debe ingresar un valor. " + mensaje);
            } else {
                try {
                    double valor = Double.parseDouble(input);
                    if (valor < 0) {
                        JOptionPane.showMessageDialog(rootPane, "No puede ingresar un número menor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
                        input = JOptionPane.showInputDialog(rootPane, mensaje);
                    } else {
                        return valor; // Si la entrada es válida y mayor o igual a cero, retorna el valor y rompe el bucle.
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(rootPane, "Entrada inválida. Por favor, ingrese un número.", "Error", JOptionPane.ERROR_MESSAGE);
                    input = JOptionPane.showInputDialog(rootPane, mensaje);
                }
            }
        }
    }

    //Método que pide una entrada como String para la cantidad. Inicia un bucle 
    //y repite las peticiones hasta que la entrada sea válida.
    private int leerEntradaInt(String mensaje) {
        String input = JOptionPane.showInputDialog(rootPane, mensaje);
        while (true) {
            if (input == null || input.isEmpty()) {
                input = JOptionPane.showInputDialog(rootPane, "Debe ingresar un valor. " + mensaje);
            } else {
                try {
                    int valor = Integer.parseInt(input);
                    if (valor < 0) {
                        JOptionPane.showMessageDialog(rootPane, "No puede ingresar un número menor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
                        input = JOptionPane.showInputDialog(rootPane, mensaje);
                    } else {
                        return valor; // Si la entrada es válida y mayor o igual a cero, retorna el valor y rompe el bucle.
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(rootPane, "Entrada inválida. Por favor, ingrese un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
                    input = JOptionPane.showInputDialog(rootPane, mensaje);
                }
            }
        }
    }

    /*Crea el modelo de lista a partir de recorrer la lista global en un bucle for
      Luego establece ese modelo en el componente listaDeProductos y limpia el text area. */
    private void actualizarLista() {
        DefaultListModel listaModelo = new DefaultListModel();
        for (int i = 0; i < lista.size(); i++) {
            Producto producto = lista.get(i);
            listaModelo.addElement(producto.getNombre());

        }
        listaDeProductos.setModel(listaModelo);
        limpiarCajas();
    }

    /*Event Listener que llena los cuadros de texto con los datos de cada elemento de la lista seleccionado. */
    private void agregarListSelectionListener() {
        listaDeProductos.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int indice = listaDeProductos.getSelectedIndex();
                    if (indice != -1) {
                        txtNombre.setText(lista.get(indice).getNombre());
                        txtPrecio.setText(String.valueOf(lista.get(indice).getPrecio()));
                        txtCantidad.setText(String.valueOf(lista.get(indice).getCantidad()));
                    }
                }
            }
        });
    }

    //Limpia los cuadros de texto.
    private void limpiarCajas() {
        txtNombre.setText("");
        txtPrecio.setText("");
        txtCantidad.setText("");
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
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaDeProductos;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
