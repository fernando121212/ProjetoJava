package br.com.projeto.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.model.Usuarios;
import br.com.projeto.services.Services;

@RestController
@RequestMapping("/usuarios")
public class ControlerApi {

	@Autowired
	private Services services;
		
	@PostMapping
	public Usuarios salvar(@Valid @RequestBody Usuarios usuarios) {		
		return services.save(usuarios);
	}
	@GetMapping
	public List<Usuarios>listar(){		
		return services.findAll();
	}
	
}
