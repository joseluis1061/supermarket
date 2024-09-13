package com.jlzdev.supermarket.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "compras_productos")
public class ComprasProducto {
  @EmbeddedId
  private ComprasProductoPK id;

  @ManyToOne
  @JoinColumn(name = "id_compra", updatable = false, insertable = false)
  private Compra compra;

  @ManyToOne
  @JoinColumn(name = "id_producto", updatable = false, insertable = false)
  private Producto producto;

  private Integer cantidad;
  private double total;
  private Boolean estado;

  public Integer getCantidad() {
    return cantidad;
  }

  public void setCantidad(Integer cantidad) {
    this.cantidad = cantidad;
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

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }

  @Override
  public String toString() {
    return "ComprasProducto{" +
        "cantidad=" + cantidad +
        ", id=" + id +
        ", total=" + total +
        ", estado=" + estado +
        '}';
  }
}
