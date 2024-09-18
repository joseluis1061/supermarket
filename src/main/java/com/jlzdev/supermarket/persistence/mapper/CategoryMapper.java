package com.jlzdev.supermarket.persistence.mapper;

import com.jlzdev.supermarket.domain.Category;
import com.jlzdev.supermarket.persistence.entity.Categoria;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

  // De Categoria a Category
  @Mappings({
    @Mapping(source = "idCategoria", target = "categoryId"),
    @Mapping(source = "descripcion", target = "category"),
    @Mapping(source = "estado", target = "active"),
  })
  Category toCategory(Categoria categoria);

  // De Category a Categoria
  @InheritInverseConfiguration
  @Mapping(target = "productos", ignore = true)
  Categoria toCategoria(Category category);
}
