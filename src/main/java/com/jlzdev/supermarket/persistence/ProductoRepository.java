package com.jlzdev.supermarket.persistence;

import com.jlzdev.supermarket.domain.Product;
import com.jlzdev.supermarket.domain.repository.ProductRepository;
import com.jlzdev.supermarket.persistence.crud.ProductoCurdRepository;
import com.jlzdev.supermarket.persistence.entity.Producto;
import com.jlzdev.supermarket.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
  private ProductoCurdRepository productoCurdRepository;
  private ProductMapper productMapper;

  @Override
  public List<Product> getAll(){
    List<Producto> productos = (List<Producto>) productoCurdRepository.findAll();
    return productMapper.toProducts(productos);
  }

  @Override
  public Optional<List<Product>> getByCategory(int categoryId) {
    List<Producto> productos = (List<Producto>) productoCurdRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
    return Optional.of(productMapper.toProducts(productos));
  }

  @Override
  public Optional<List<Product>> getScarse(int quantity) {
    Optional<List<Producto>> productos = productoCurdRepository.findByCantidadStockLessThanAndEstado(quantity, true);
    // Convierte cada producto/optional en un Product
    return productos.map(producto -> productMapper.toProducts(producto));
  }

  @Override
  public Optional<Product> getProduct(int productId) {
    Optional<Producto> producto = productoCurdRepository.findById(productId);
    return producto.map(prod -> productMapper.toProduct(prod));
  }

  @Override
  public Product save(Product product) {
    Producto producto = productMapper.toProducto(product);
    return productMapper.toProduct(productoCurdRepository.save(producto));
  }

  @Override
  public void delete(int productId) {
    productoCurdRepository.deleteById(productId);
  }
}
