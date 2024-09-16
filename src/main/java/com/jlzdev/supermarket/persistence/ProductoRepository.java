package com.jlzdev.supermarket.persistence;

import com.jlzdev.supermarket.persistence.crud.ProductoCurdRepository;
import com.jlzdev.supermarket.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {
  private ProductoCurdRepository productoCurdRepository;

  public List<Producto> getAll(){
    return (List<Producto>) productoCurdRepository.findAll();
  }

  public List<Producto> getByIdCategoryOrder(int idCategoria){
    return productoCurdRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
  }

  // cantidad valor que indica escases por debajo de él
  // true para seleccionar solo los activos
  public Optional<List<Producto>> getEscasosBy(int cantidad){
    return productoCurdRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
  }

  //Producto por id
  public Optional<Producto> getProductById(int id){
    return productoCurdRepository.findById(id);
  }

  //Guardar producto
  public Producto saveProduct(Producto producto){
    return productoCurdRepository.save(producto);
  }

  //Eliminar producto por id
  public void deleteProductById(int id){
    productoCurdRepository.deleteById(id);
  }

}
