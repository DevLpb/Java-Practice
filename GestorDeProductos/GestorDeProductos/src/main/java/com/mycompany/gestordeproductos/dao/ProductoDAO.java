package com.mycompany.gestordeproductos.dao;

import com.mycompany.gestordeproductos.modelo.Producto;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface ProductoDAO {
   void addProducto(Producto producto); //Crear
   Producto getProducto(int id); //Leer
   List<Producto> getAllProductos(); //Leer todos
   void updateProducto(Producto producto); //Actualizar
   void deleteProducto(int id); //Borrar
}
