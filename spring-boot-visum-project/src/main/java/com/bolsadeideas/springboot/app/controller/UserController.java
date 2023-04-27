package com.bolsadeideas.springboot.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bolsadeideas.springboot.app.models.entity.Usuario;
import com.bolsadeideas.springboot.app.models.service.IServiceUserDao;

@Controller
@SessionAttributes("usuario")
public class UserController {

	@Autowired
	@Qualifier("serviceUser")
	IServiceUserDao serviceUser;

	
	
	@GetMapping("/home")
	public String home(Usuario usuario,Model model) {
		model.addAttribute("titulo", "VisumWeb");
		usuario = serviceUser.findOne(usuario.getId());
		model.addAttribute("usuario", usuario);
		
		return "home";
	}

	@GetMapping({"/login","/"})
	public String login(Model model) {
		model.addAttribute("titulo", "VisumWeb");

		return "login";
	}

	@PostMapping({"/login","/"})
	public String loginRealizado(String username,String password, Model model) {
		model.addAttribute("titulo", "VisumWeb");
		Usuario usuario = serviceUser.findByUsernameAndPassword(username, password);
		if (usuario != null) {
			model.addAttribute("usuario",usuario);
			return "redirect:/home";
		}
		return "redirect:/login";
		
	}

	@GetMapping("/registrar")
	public String registrar(Model model) {
		model.addAttribute("titulo", "VisumWeb");
		Usuario usuario = new Usuario();
		model.addAttribute("usuario",usuario);

		return "registrar";
	}
	@PostMapping("/registrar")
	public String registrarUser(Usuario usuario,BindingResult result,Model model) {
		model.addAttribute("titulo", "VisumWeb");
		
		if(usuario==null && result.hasErrors()) {
			return "register";
		}
		model.addAttribute("usuario",usuario);
		serviceUser.save(usuario);
		return "redirect:/login";
	}
	
	
	@GetMapping("/salir")
	public String salir(Usuario usuario, SessionStatus status) {
		
		status.setComplete();
		return "redirect:/login";
	}
	
}
