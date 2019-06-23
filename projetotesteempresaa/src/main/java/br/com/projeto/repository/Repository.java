package br.com.projeto.repository;
//Repositórios do Spring Data JPA responsáveis pelo acesso a dados.
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.model.Usuarios;

public interface Repository extends JpaRepository<Usuarios, Long> {

}
