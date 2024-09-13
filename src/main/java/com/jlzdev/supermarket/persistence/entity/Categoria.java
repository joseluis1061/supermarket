package com.jlzdev.supermarket.persistence.entity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categorias")
public class Categoria {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_categoria")
  private int idCategoria;

  @OneToMany(mappedBy = "categoria")
  List<Producto> productos;

  @Column(length = 45, nullable = false)
  private String descripcion;

  @Column(nullable = false)
  private boolean estado;

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public boolean isEstado() {
    return estado;
  }

  public void setEstado(boolean estado) {
    this.estado = estado;
  }

  public int getIdCategoria() {
    return idCategoria;
  }

  public void setIdCategoria(int idCategoria) {
    this.idCategoria = idCategoria;
  }

  @Override
  public String toString() {
    return "Categoria{" +
        "descripcion='" + descripcion + '\'' +
        ", idCategoria=" + idCategoria +
        ", estado=" + estado +
        '}';
  }
}
