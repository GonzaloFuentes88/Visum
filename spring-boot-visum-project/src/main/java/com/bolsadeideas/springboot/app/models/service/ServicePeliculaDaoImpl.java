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


	@Override
	public void delete(Long id) {
		peliculaDao.deleteById(id);
		
	}

 

}
