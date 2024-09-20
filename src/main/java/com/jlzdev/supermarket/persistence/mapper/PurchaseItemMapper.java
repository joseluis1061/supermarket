package com.jlzdev.supermarket.persistence.mapper;

import com.jlzdev.supermarket.domain.PurchaseItem;
import com.jlzdev.supermarket.persistence.entity.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {
  @Mappings({
      @Mapping(source = "id.idProducto", target = "productId"),
      @Mapping(source = "cantidad", target = "quantity"),
      @Mapping(source = "total", target = "total"),
      @Mapping(source = "estado", target = "active")
  })
  PurchaseItem toPurchaseItem(ComprasProducto producto);

  @InheritInverseConfiguration
  @Mapping(target = "compra", ignore = true)
  @Mapping(target = "producto", ignore = true)
  @Mapping(target = "id.idCompra", ignore = true)
  ComprasProducto toComprasProducto(PurchaseItem item);
}
