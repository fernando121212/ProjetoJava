package br.com.projeto.repository;
//Reposit�rios do Spring Data JPA respons�veis pelo acesso a dados.
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.model.Usuarios;

public interface Repository extends JpaRepository<Usuarios, Long> {

}
