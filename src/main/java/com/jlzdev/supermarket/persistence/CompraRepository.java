package com.jlzdev.supermarket.persistence;

import com.jlzdev.supermarket.domain.Purchase;
import com.jlzdev.supermarket.domain.repository.PurchaseRepository;
import com.jlzdev.supermarket.persistence.crud.ComprasCrudRepository;
import com.jlzdev.supermarket.persistence.entity.Compra;
import com.jlzdev.supermarket.persistence.entity.Producto;
import com.jlzdev.supermarket.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {
  @Autowired
  private ComprasCrudRepository comprasCrudRepository;
  @Autowired
  private PurchaseMapper purchaseMapper;

  @Override
  public List<Purchase> getAll() {
    List<Compra> compras = (List<Compra>) comprasCrudRepository.findAll();
    return purchaseMapper.toPurchases(compras);
  }

  @Override
  public Optional<List<Purchase>> getByClient(String clientId) {
    return comprasCrudRepository.findByIdCliente(clientId)
        .map(listCompras -> purchaseMapper.toPurchases(listCompras));
  }

  @Override
  public Purchase save(Purchase purchase) {
    Compra compra = purchaseMapper.toCompra(purchase);
    compra.getProductos()
        .forEach(producto -> producto.setCompra(compra));
    return purchaseMapper.toPurchase(comprasCrudRepository.save(compra));
  }
}
