package com.bolsadeideas.springboot.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="usuarios")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private Long id;
	
	@NotEmpty
	private String username;
	
	@NotEmpty
	private String password;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotNull
	@Column(name="fecha_nacimiento")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaNacimiento;
	
	@OneToMany(mappedBy="usuario",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Pelicula> peliculas;
	
	@OneToMany(mappedBy="usuario",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Serie> series;
	
	
	public Usuario() {
		peliculas=new ArrayList<>();
		series = new ArrayList<>();
	}
	
	@PrePersist
	public void prePersist() {
		fechaNacimiento= new Date();
	}
	
	public void addPelicula(Pelicula pelicula) {
		pelicula.setUsuario(this);
		peliculas.add(pelicula);
	}
	public void removePelicula(Long id) {
		Pelicula pelicula = this.getPeliculas().stream().filter(p->p.getId() == id).findFirst().orElse(null);
		peliculas.remove(pelicula);
	}
	
	
	public void addSerie(Serie serie) {
		serie.setUsuario(this);
		series.add(serie);
	}
	public void removeSerie(Long id) {
		Serie serie = this.getSeries().stream().filter(s->s.getId() == id).findFirst().orElse(null);
		series.remove(serie);
	}
	
	

	public List<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	public List<Serie> getSeries() {
		return series;
	}

	public void setSeries(List<Serie> series) {
		this.series = series;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", fechaNacimiento=" + fechaNacimiento + ", peliculas=" + peliculas + ", series=" + series + "]";
	}
	
	
	
}
