package com.jlzdev.supermarket.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "compras")
public class Compra {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_compra")
  private Integer idCompra;

  @Column(name = "id_cliente")
  private Integer idCliente;

  private LocalDateTime fecha;

  @Column(name="medio_pago")
  private String medioPago;

  private String comentario;

  private String estado;

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

  @Override
  public String toString() {
    return "Compra{" +
        "comentario='" + comentario + '\'' +
        ", idCompra=" + idCompra +
        ", idCliente=" + idCliente +
        ", fecha=" + fecha +
        ", medioPago='" + medioPago + '\'' +
        ", estado='" + estado + '\'' +
        '}';
  }
}
