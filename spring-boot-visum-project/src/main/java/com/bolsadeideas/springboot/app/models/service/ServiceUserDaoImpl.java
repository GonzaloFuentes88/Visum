package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bolsadeideas.springboot.app.models.dao.IUserDao;
import com.bolsadeideas.springboot.app.models.entity.Usuario;

@Service("serviceUser")
public class ServiceUserDaoImpl implements IServiceUserDao{
	
	@Autowired
	private IUserDao userDao;

	@Transactional(readOnly = true)
	@Override
	public List<Usuario> findAll() {
		return (List<Usuario>) userDao.findAll();
	}

	@Override
	public Usuario save(Usuario usuario) {
		return userDao.save(usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findOne(Long id) {
		return userDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Usuario findByUsernameAndPassword(String username, String password) {
		return userDao.findByUsernameAndPassword(username,password);
	}

	@Override
	public void delete(Long id) {
	
		userDao.deleteById(id);
		
	}

	
}
