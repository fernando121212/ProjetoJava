package br.com.projeto.controller;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

//Camada intermediária entre a view e a camada de serviços.
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.projeto.model.Usuarios;
import br.com.projeto.services.Services;
import br.com.projeto.ws.client.model.ListaUsuarios;
import br.com.projeto.ws.client.model.User;
import br.com.projeto.ws.client.service.ClientActions;

@Controller
public class Controler {
	
	@Autowired
	private Services services;
	
	@Autowired
	private ClientActions clientActions;
	
	@RequestMapping("cadastro")
	public String cadastro() {
		return "cadastro";
	}	
	
	@PostMapping ("salvar")
	public ModelAndView save (@Valid Usuarios usuarios,BindingResult result,RedirectAttributes attributes ) {

		if(result.hasErrors()) {

			ModelAndView modelandView = new ModelAndView("cadastro");
			Iterable<Usuarios> user = services.findAll();
			modelandView.addObject("usuarios",user);
			modelandView.addObject("usuariosobj",usuarios);
			List<String>msg = new ArrayList<String>();
			for (ObjectError objecterros:result.getAllErrors()) {
				msg.add(objecterros.getDefaultMessage());
			}
			modelandView.addObject("msg",msg);
			return modelandView;
			
		}
		services.save (usuarios);	
		ModelAndView andView = new ModelAndView("cadastro");
		Iterable<Usuarios>use = services.findAll();
		andView.addObject("usuarios",use);
		andView.addObject("usuarios",new Usuarios());
		andView.addObject("mensagem", "Cliente salvo com sucesso.");
		return andView;
	}
	
	@GetMapping ("post")
	public ModelAndView findAll () {
		
		ModelAndView usuarios = new ModelAndView ("cadastro");
		usuarios.addObject ("cadastro", services.findAll ());
		
		return usuarios;
	}
		
	@RequestMapping("listar")
	public String listaConvidados(Model model){
		ListaUsuarios user = clientActions.singleUserById(2);
		Iterable<Usuarios> usuarios = services.findAll();
		model.addAttribute("convidados", usuarios);
		model.addAttribute("user", user);

		return "listar";
			
	}
}
	
	

	
	
	


