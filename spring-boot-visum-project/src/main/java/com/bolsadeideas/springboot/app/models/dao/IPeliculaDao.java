package com.bolsadeideas.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.app.models.entity.Pelicula;

public interface IPeliculaDao extends CrudRepository<Pelicula, Long>{
}
