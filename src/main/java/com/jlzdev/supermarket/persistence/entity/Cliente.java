package com.jlzdev.supermarket.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {
  @Id
  @Column(name="id", length = 20, nullable = false)
  private String id;

  @OneToMany(mappedBy = "cliente")
  List<Compra> compras;

  @Column(length = 40)
  private String nombre;

  @Column(length = 100)
  private String apellidos;

  @Column
  private Long celular;

  @Column(length = 80)
  private String direccion;

  @Column(name="correo_electronico" ,length = 70)
  private String correoElectronico;

  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  public Long getCelular() {
    return celular;
  }

  public void setCelular(Long celular) {
    this.celular = celular;
  }

  public String getCorreoElectronico() {
    return correoElectronico;
  }

  public void setCorreoElectronico(String correoElectronico) {
    this.correoElectronico = correoElectronico;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  @Override
  public String toString() {
    return "Cliente{" +
        "apellidos='" + apellidos + '\'' +
        ", id='" + id + '\'' +
        ", nombre='" + nombre + '\'' +
        ", celular=" + celular +
        ", direccion='" + direccion + '\'' +
        ", correoElectronico='" + correoElectronico + '\'' +
        '}';
  }
}
