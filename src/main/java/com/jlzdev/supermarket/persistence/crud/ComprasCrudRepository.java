package com.jlzdev.supermarket.persistence.crud;

import com.jlzdev.supermarket.persistence.entity.Compra;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ComprasCrudRepository extends CrudRepository<Compra, Integer> {
  // Buscar compra por id del cliente
  Optional<List<Compra>> findByIdCliente(String idCliente);
}
