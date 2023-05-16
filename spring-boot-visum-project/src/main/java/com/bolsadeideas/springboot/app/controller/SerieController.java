package com.bolsadeideas.springboot.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bolsadeideas.springboot.app.models.entity.Serie;
import com.bolsadeideas.springboot.app.models.entity.Usuario;
import com.bolsadeideas.springboot.app.models.service.IServiceSerieDao;
import com.bolsadeideas.springboot.app.models.service.IServiceUserDao;

@Controller
@SessionAttributes("serie")
@RequestMapping("/serie")
public class SerieController {
	
	@Autowired
	private IServiceUserDao userDao;
	
	@Autowired
	@Qualifier("serviceSerie")
	private IServiceSerieDao serieDao;
	
	@GetMapping("/add")
	public String crearForm(Model model) {
		Serie serie = new Serie();
		model.addAttribute("titulo", "VisumWeb");
		
		model.addAttribute("serie",serie);
		return "/serie/add";
	}
	
	@PostMapping("/add")
	public String saveSerie(Serie serie, SessionStatus session, @SessionAttribute("usuario") Usuario usuario, Model model ) {
		
		
		if(serie.getCapitulosVistos() > serie.getCapitulos()) {
			return "/serie/add";
		}
		usuario.addSerie(serie);
		
		userDao.save(usuario);
		
		session.setComplete();
		
		return "redirect:/home";
	}
	
	@GetMapping("/add/{id}")
	public String editar(@PathVariable Long id,@SessionAttribute("usuario") Usuario usuario, Model model) {
		Serie serie = usuario.getSeries().stream().filter(s->s.getId() == id).findFirst().orElse(null);
		if(serie == null) {
			return "redirect:/home";
		}
		model.addAttribute("titulo", "VisumWeb");
		model.addAttribute("serie",serie);
		
		return "/serie/add";
	}
	
	
	//ESTE METODO NO FUNCIONA REPARARLO
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable Long id, @SessionAttribute("usuario") Usuario usuario, Model model) {
		
		usuario.removeSerie(id);

		serieDao.delete(id);
		
		return "redirect:/home";
	}
	
}
