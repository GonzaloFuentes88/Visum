package com.bolsadeideas.springboot.app.models.entity;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="series")
public class Serie implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7304430373646833212L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String nombre;
	
	@NotNull
	@Size(min=1, max=10)
	private Integer puntuacion;
	
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REMOVE})
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	
	
	public Serie() {
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Integer getPuntuacion() {
		return puntuacion;
	}



	public void setPuntuacion(Integer puntuacion) {
		this.puntuacion = puntuacion;
	}



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	


	@Override
	public String toString() {
		return "Serie [id=" + id + ", nombre=" + nombre + ", puntuacion=" + puntuacion + ", usuario=" + usuario + "]";
	}

	
}
