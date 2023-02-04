package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import com.bolsadeideas.springboot.app.models.entity.Usuario;

public interface IServiceUserDao {

	public List<Usuario> findAll(); //Obtener la lista de clientes
	
	public Usuario save(Usuario usuario); //Guardar un nuevo cliente
	
	public Usuario findOne(Long id);
	
	public void delete(Long id);
	
	public Usuario findByUsernameAndPassword(String usuario,String password);
	
	
}
