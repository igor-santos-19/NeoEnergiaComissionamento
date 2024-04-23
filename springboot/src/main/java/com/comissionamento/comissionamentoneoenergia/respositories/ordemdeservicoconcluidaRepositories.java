package com.comissionamento.comissionamentoneoenergia.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comissionamento.comissionamentoneoenergia.models.ordemdeservicoconcluida;

@Repository

//Arquivo respository basicamente é responsavel pelas consultas usando meio q uma funcao automatica de busca do spring

public interface ordemdeservicoconcluidaRepositories extends JpaRepository<ordemdeservicoconcluida, Long> {

  
} 