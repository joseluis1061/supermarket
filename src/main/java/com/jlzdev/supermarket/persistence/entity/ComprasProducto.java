package com.jlzdev.supermarket.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "compras_productos")
public class ComprasProducto {
  @EmbeddedId
  private ComprasProductoPK id;

  private Integer cantidad;
  private Double total;
  private Boolean estado;

  @ManyToOne
  @MapsId("idCompra")
  @JoinColumn(name = "id_compra", updatable = false, insertable = false)
  private Compra compra;

  @ManyToOne
  @JoinColumn(name = "id_producto", updatable = false, insertable = false)
  private Producto producto;

  public Integer getCantidad() {
    return cantidad;
  }

  public void setCantidad(Integer cantidad) {
    this.cantidad = cantidad;
  }

  public Compra getCompra() {
    return compra;
  }

  public void setCompra(Compra compra) {
    this.compra = compra;
  }

  public Boolean getEstado() {
    return estado;
  }

  public void setEstado(Boolean estado) {
    this.estado = estado;
  }

  public ComprasProductoPK getId() {
    return id;
  }

  public void setId(ComprasProductoPK id) {
    this.id = id;
  }

  public Producto getProducto() {
    return producto;
  }

  public void setProducto(Producto producto) {
    this.producto = producto;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }
}
