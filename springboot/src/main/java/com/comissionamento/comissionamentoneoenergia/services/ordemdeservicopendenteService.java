package com.comissionamento.comissionamentoneoenergia.services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.comissionamento.comissionamentoneoenergia.models.ordemdeservicopendente;
import com.comissionamento.comissionamentoneoenergia.respositories.ordemdeservicopendenteRepositories;

import jakarta.transaction.Transactional;

//Arquivo responsavel por realizar o CRUD da tabela de ordemdeserviço pedente

@Service
public class ordemdeservicopendenteService {


    @Autowired
    private ordemdeservicopendenteRepositories ordemdeservicopendenteRepositories;

    public ordemdeservicopendente findById(Long Id){ //Funcao para procurar a ose pelo id

        Optional<ordemdeservicopendente> ordemdeservicopendente = this.ordemdeservicopendenteRepositories.findById(Id);
        return ordemdeservicopendente.orElseThrow(()-> new RuntimeException(
            "Ordem de Serviço Pendente não econtrada"+ Id + " Tipo: " + ordemdeservicopendente.class.getName()
        ));
    }

    @Transactional
    public ordemdeservicopendente create(ordemdeservicopendente obj) {
        obj = this.ordemdeservicopendenteRepositories.save(obj);
        return obj;
    }

    @Transactional
    public List<ordemdeservicopendente> listarTodos(){
        return(List<ordemdeservicopendente>) ordemdeservicopendenteRepositories.findAll();
    }

    @Transactional
    public ordemdeservicopendente update (ordemdeservicopendente obj){ //funcao para dar um update na ose
        ordemdeservicopendente newObj = findById(obj.getId());
        return this.ordemdeservicopendenteRepositories.save(newObj);
    }

    public void delete(Long Id){ //funcao para deletar a ose pendente
        findById(Id);
        try {
            this.ordemdeservicopendenteRepositories.deleteById(Id);   
        } catch (Exception e){
            throw new RuntimeException("Não foi possivel deletar a ordem concluida");
        }
    }
}
