package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.dao.IPeliculaDao;
import com.bolsadeideas.springboot.app.models.entity.Pelicula;

@Service("servicePelicula")
public class ServicePeliculaDaoImpl implements IServicePeliculasDao{
	

	@Autowired
	private IPeliculaDao peliculaDao;

	@Transactional(readOnly = true)
	@Override
	public List<Pelicula> findAll() {
		return (List<Pelicula>) peliculaDao.findAll();
	}

	@Override
	public Pelicula save(Pelicula pelicula) {
		return peliculaDao.save(pelicula);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Pelicula findOne(Long id) {
		return peliculaDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		peliculaDao.deleteById(id);
		
	}

	
	@Override
	@Transactional(readOnly = true)
	public List<Pelicula> findAllByUsuario_id(Long id) {
		return peliculaDao.findAllByUsuario_id(id);
	}

  

}
