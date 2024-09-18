package com.jlzdev.supermarket.persistence.mapper;

import com.jlzdev.supermarket.domain.Category;
import com.jlzdev.supermarket.domain.Product;
import com.jlzdev.supermarket.persistence.entity.Categoria;
import com.jlzdev.supermarket.persistence.entity.Producto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
  @Mappings({
      @Mapping(source = "idProducto", target = "productId"),
      @Mapping(source = "nombre", target = "name"),
      @Mapping(source = "idCategoria", target = "categoryId"),
      @Mapping(source = "precioVenta", target = "price"),
      @Mapping(source = "cantidadStock", target = "stock"),
      @Mapping(source = "estado", target = "active"),
      @Mapping(source = "categoria", target = "category")
  })
  Product toProduct(Producto producto); // Recibir un solo producto
  List<Product> toProducts(List<Producto> productos); // Recibir una lista de productos

  @InheritInverseConfiguration
  @Mapping(target = "codigoBarras", ignore = true)
  Producto toProducto(Product product);
}
