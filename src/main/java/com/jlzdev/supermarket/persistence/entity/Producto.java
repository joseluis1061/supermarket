package com.jlzdev.supermarket.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="productos")
public class Producto {

  //  Indicamos el id y las columnas de la tabla
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // Id generado automaticamente autoincremental
  @Column(name = "id_producto")
  private Integer idProducto;

  @ManyToOne
  @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
  private Categoria categoria;

//  @OneToMany(mappedBy = "producto")
//  private List<ComprasProducto> comprasProductos;

  @Column(name = "nombre")
  private String nombre;

  @Column(name = "id_categoria")
  private Integer idCategoria;

  @Column(name = "codigo_barras")
  private String codigoBarras;

  @Column(name = "precio_venta")
  private Double precioVenta;

  @Column(name = "cantidad_stock")
  private Integer cantidadStock;

  @Column(name = "estado")
  private Boolean estado;

  public Integer getCantidadStock() {
    return cantidadStock;
  }

  public void setCantidadStock(Integer cantidadStock) {
    this.cantidadStock = cantidadStock;
  }

  public Categoria getCategoria() {
    return categoria;
  }

  public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
  }

  public String getCodigoBarras() {
    return codigoBarras;
  }

  public void setCodigoBarras(String codigoBarras) {
    this.codigoBarras = codigoBarras;
  }

//  public List<ComprasProducto> getComprasProductos() {
//    return comprasProductos;
//  }
//
//  public void setComprasProductos(List<ComprasProducto> comprasProductos) {
//    this.comprasProductos = comprasProductos;
//  }

  public Boolean getEstado() {
    return estado;
  }

  public void setEstado(Boolean estado) {
    this.estado = estado;
  }

  public Integer getIdCategoria() {
    return idCategoria;
  }

  public void setIdCategoria(Integer idCategoria) {
    this.idCategoria = idCategoria;
  }

  public Integer getIdProducto() {
    return idProducto;
  }

  public void setIdProducto(Integer idProducto) {
    this.idProducto = idProducto;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Double getPrecioVenta() {
    return precioVenta;
  }

  public void setPrecioVenta(Double precioVenta) {
    this.precioVenta = precioVenta;
  }

  @Override
  public String toString() {
    return "Producto{" +
        "cantidadStock=" + cantidadStock +
        ", idProducto=" + idProducto +
        ", categoria=" + categoria +
//        ", comprasProductos=" + comprasProductos +
        ", nombre='" + nombre + '\'' +
        ", idCategoria=" + idCategoria +
        ", codigoBarras='" + codigoBarras + '\'' +
        ", precioVenta=" + precioVenta +
        ", estado=" + estado +
        '}';
  }
}
