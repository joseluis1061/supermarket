package com.jlzdev.supermarket.persistence;

import com.jlzdev.supermarket.domain.Purchase;
import com.jlzdev.supermarket.domain.repository.PurchaseRepository;
import com.jlzdev.supermarket.persistence.crud.ComprasCrudRepository;
import com.jlzdev.supermarket.persistence.entity.Compra;
import com.jlzdev.supermarket.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {
  @Autowired
  private ComprasCrudRepository compraCrudRepository;

  @Autowired
  private PurchaseMapper mapper;

  @Override
  public List<Purchase> getAll() {
    return mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
  }

  @Override
  public Optional<List<Purchase>> getByClient(String clientId) {
    return compraCrudRepository.findByIdCliente(clientId)
        .map(compras -> mapper.toPurchases(compras));
  }

  @Override
  public Purchase save(Purchase purchase) {
    Compra compra = mapper.toCompra(purchase);
    compra.getProductos().forEach(producto -> producto.setCompra(compra));

    return mapper.toPurchase(compraCrudRepository.save(compra));
  }


}
