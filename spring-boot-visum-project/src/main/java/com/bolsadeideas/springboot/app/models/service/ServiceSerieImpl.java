package com.bolsadeideas.springboot.app.models.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.dao.ISerieDao;


@Service("serviceSerie")
public class ServiceSerieImpl implements IServiceSerieDao{
	
	@Autowired
	private ISerieDao serieDao;
	
	
	@Override
	public void delete(Long id) {
		serieDao.deleteById(id);
	}
	

}
