package com.jlzdev.supermarket.persistence.crud;

import com.jlzdev.supermarket.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface ProductoCurdRepository extends CrudRepository<Producto, Integer> {

  List<Producto> findByIdCategoria(int idCategoria);

  List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

  // Buscar productos en venta "activos" y que esten escasos segun un limite
  Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
