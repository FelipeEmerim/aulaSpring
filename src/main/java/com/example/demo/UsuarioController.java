package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {
	
	private final UsuarioService usuarioService;
	
	public UsuarioController(UsuarioService usuarioService){
		this.usuarioService = usuarioService;
	}
	
	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("list");
		mav.addObject("usuarios", usuarioService.lista());
		return mav;
	}
	
	@GetMapping("/new")
	public ModelAndView novo() {
		ModelAndView mav = new ModelAndView("form");
		mav.addObject("usuarios", usuarioService.lista());
		mav.addObject("usuario", new Usuario());
		return mav;
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id){
		usuarioService.apaga(id);
		return "redirect:/";
	}
	
	@PostMapping("/save")
	public String salva(Usuario usuario) {
		usuarioService.salva(usuario);
		return "redirect:/";
	}
	
	@GetMapping("/edita/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		
		ModelAndView mav = new ModelAndView("form");
		mav.addObject("usuario", usuarioService.busca(id));
		return mav;
	}
}
