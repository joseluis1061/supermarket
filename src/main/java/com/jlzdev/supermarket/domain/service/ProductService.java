package com.jlzdev.supermarket.domain.service;

import com.jlzdev.supermarket.domain.Product;
import com.jlzdev.supermarket.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
  @Autowired
  private ProductRepository productRepository;

  public List<Product> getAll(){
    return productRepository.getAll();
  }

  public Optional<List<Product>> getByCategory(int categoryId){
    return productRepository.getByCategory(categoryId);
  }

  public Optional<Product> getProduct(int productId){
   return productRepository.getProduct(productId);
  }

  public Product save(Product product){
   return productRepository.save(product);
  }

  public boolean delete(int productId){
    // Get product retorna un opcional por eso podemos aplicar
    // un map sobre el y hacer una operación si tiene un valor
    // o retornar un orElse false en caso que no sea así
    return getProduct(productId).map(product -> {
     productRepository.delete(productId);
     return true;
   }).orElse(false);
  }

}
