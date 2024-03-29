package com.bolsadeideas.springboot.app.models.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
	@Column(name="id_serie")
	private Long id;
	
	@NotEmpty
	private String nombre;
	

	@NotNull
	@Min(value = 0)
	@Max(value = 10)
	private Integer puntuacion;
	
	@NotNull
	@Min(value = 0)
	private Integer capitulos;
	
	@NotNull
	@Column(name = "capitulos_vistos")
	@Min(value = 0)
	private Integer capitulosVistos;
	

	@ManyToOne(fetch=FetchType.LAZY) 
	//Lazy, carga peresoza (Consulta solo cuando se le llama), Eager(Consulta todo con las relaciones)
	@JoinColumn(name="fk_usuario")
	//@JsonProperty(access = Access.WRITE_ONLY)
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


	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}

	
	public Integer getCapitulos() {
		return capitulos;
	}


	public void setCapitulos(Integer capitulos) {
		this.capitulos = capitulos;
	}


	public Integer getCapitulosVistos() {
		return capitulosVistos;
	}


	public void setCapitulosVistos(Integer capitulosVistos) {
		this.capitulosVistos = capitulosVistos;
	}


	@Override
	public boolean equals(Object obj) {
		if(obj !=null) {
			if(obj instanceof Serie) {
				Serie s = (Serie) obj;
				if(s.getId() == this.id)
					return true;
		
			}
		}
			
		return false;
	}
}
