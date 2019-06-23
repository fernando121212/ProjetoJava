package br.com.projeto.services;
//Classes de serviço e/ou negócio.
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.model.Usuarios;
import br.com.projeto.repository.Repository;


@Service
public class Services {
	
	
	@Autowired
	private Repository repository;
	
	public Usuarios save(Usuarios usuarios){
		return repository.save(usuarios);
				
	}
		
	public List<Usuarios>findAll(){
		return  repository.findAll();

	}
}
