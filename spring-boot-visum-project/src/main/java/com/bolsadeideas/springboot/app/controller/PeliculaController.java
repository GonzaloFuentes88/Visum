package com.bolsadeideas.springboot.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.bolsadeideas.springboot.app.models.entity.Pelicula;
import com.bolsadeideas.springboot.app.models.entity.Usuario;
import com.bolsadeideas.springboot.app.models.service.IServiceUserDao;


@Controller
@SessionAttributes("pelicula")
public class PeliculaController {

	@Autowired
	IServiceUserDao userDao;
	
	@GetMapping("/add/{id}")
	public String crear(@PathVariable Long id, Model model) {
		Usuario usuario = userDao.findOne(id);
		if(usuario == null) {
			return "redirect:/home";
		}
		
		Pelicula pelicula= new Pelicula();
		
		pelicula.setUsuario(usuario);
		model.addAttribute("pelicula",pelicula);
		model.addAttribute("usuario",usuario);
		model.addAttribute("titulo", "Añadir Pelicula");
		
		return "/add";
	}
	
	
}
