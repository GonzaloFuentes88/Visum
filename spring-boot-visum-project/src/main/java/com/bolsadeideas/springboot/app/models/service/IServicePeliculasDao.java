package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import com.bolsadeideas.springboot.app.models.entity.Pelicula;

public interface IServicePeliculasDao {

	public List<Pelicula> findAll(); //Obtener la lista de clientes
	
	public Pelicula save(Pelicula pelicula); //Guardar un nuevo cliente
	
	public Pelicula findOne(Long id);
	
	public void delete(Long id);
	
	public List<Pelicula> findAllByUsuario_id(Long id);
	

}
