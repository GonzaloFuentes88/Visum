package com.bolsadeideas.springboot.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bolsadeideas.springboot.app.models.entity.Pelicula;
import com.bolsadeideas.springboot.app.models.entity.Usuario;
import com.bolsadeideas.springboot.app.models.service.IServiceUserDao;

import jakarta.servlet.http.HttpSession;


@Controller
@SessionAttributes("pelicula")
@RequestMapping("/pelicula")
public class PeliculaController {

	@Autowired
	IServiceUserDao userDao;
	
	@GetMapping("/add")
	public String crearForm(Model model) {
		Pelicula pelicula = new Pelicula();
		
		model.addAttribute("pelicula",pelicula);
		return "/pelicula/add";
	}
	
	@PostMapping("/add")
	public String savePelicula(Pelicula pelicula, SessionStatus session, @SessionAttribute("usuario") Usuario usuario, Model model ) {
		
		usuario.addPelicula(pelicula);
		
		userDao.save(usuario);
		
		session.setComplete();
		
		return "redirect:/home";
	}
	
	@GetMapping("/add/{id}")
	public String editar(@PathVariable Long id,@SessionAttribute("usuario") Usuario usuario, Model model) {
		Pelicula pelicula = usuario.getPeliculas().stream().filter(p->p.getId() == id).findFirst().orElse(null);
		if(pelicula == null) {
			return "redirect:/home";
		}
		
		model.addAttribute("pelicula",pelicula);
		model.addAttribute("titulo", "Añadir Pelicula");
		
		return "/pelicula/add";
	}
	
	
	//ESTE METODO NO FUNCIONA REPARARLO
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable Long id, @SessionAttribute("usuario") Usuario usuario, Model model) {
		Pelicula pelicula = usuario.getPeliculas().stream().filter(p->p.getId() == id).findFirst().orElse(null);
		
		usuario.removePelicula(pelicula);

		userDao.save(usuario);
		
		return "redirect:/home";
	}
	
	
	
	
	
}
