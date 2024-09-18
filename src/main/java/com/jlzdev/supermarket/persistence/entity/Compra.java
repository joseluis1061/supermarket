package com.jlzdev.supermarket.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "compras")
public class Compra {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_compra")
  private Integer idCompra;

  @ManyToOne
  @JoinColumn(name = "id", insertable = false, updatable = false)
  private Cliente cliente;

//  @OneToMany(mappedBy = "producto")
  @OneToMany(mappedBy = "compra")
  private List<ComprasProducto> productos;

  @Column(name = "id_cliente")
  private Integer idCliente;

  private LocalDateTime fecha;

  @Column(name="medio_pago")
  private String medioPago;

  private String comentario;

  private String estado;

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public String getComentario() {
    return comentario;
  }

  public void setComentario(String comentario) {
    this.comentario = comentario;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public LocalDateTime getFecha() {
    return fecha;
  }

  public void setFecha(LocalDateTime fecha) {
    this.fecha = fecha;
  }

  public Integer getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(Integer idCliente) {
    this.idCliente = idCliente;
  }

  public Integer getIdCompra() {
    return idCompra;
  }

  public void setIdCompra(Integer idCompra) {
    this.idCompra = idCompra;
  }

  public String getMedioPago() {
    return medioPago;
  }

  public void setMedioPago(String medioPago) {
    this.medioPago = medioPago;
  }

  public List<ComprasProducto> getProductos() {
    return productos;
  }

  public void setProductos(List<ComprasProducto> productos) {
    this.productos = productos;
  }

  @Override
  public String toString() {
    return "Compra{" +
        "cliente=" + cliente +
        ", idCompra=" + idCompra +
        ", productos=" + productos +
        ", idCliente=" + idCliente +
        ", fecha=" + fecha +
        ", medioPago='" + medioPago + '\'' +
        ", comentario='" + comentario + '\'' +
        ", estado='" + estado + '\'' +
        '}';
  }
}
