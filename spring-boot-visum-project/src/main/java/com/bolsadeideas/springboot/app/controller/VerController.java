package com.bolsadeideas.springboot.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.bolsadeideas.springboot.app.models.entity.Usuario;
import com.bolsadeideas.springboot.app.models.service.IServiceUserDao;

@Controller
@RequestMapping("/ver")
public class VerController {
	
	@Autowired
	IServiceUserDao userDao;
	
	@GetMapping("/todo")
	public String verTodo(@SessionAttribute("usuario") Usuario usuario, Model model) {
		usuario = userDao.findOne(usuario.getId());
		model.addAttribute("titulo", "VisumWeb");
		
		model.addAttribute("usuario", usuario);
		
		return "/ver/todo";
	}
	

}
