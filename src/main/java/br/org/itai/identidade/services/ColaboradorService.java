package br.org.itai.identidade.services;

import br.org.itai.identidade.models.Colaborador;
import br.org.itai.identidade.repositories.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColaboradorService {

    @Autowired
    ColaboradorRepository colaboradorRepository;

    //lista todos os colaboradores
    public List<Colaborador> lista() {
        return this.colaboradorRepository.findAll();
    }

    //salva colaborador
    public Colaborador inserir(Colaborador colaborador) {
        return this.colaboradorRepository.save(colaborador);
    }

    //busca pelo id do colaborador
    public Colaborador buscaPorId(Long id) {
        return this.colaboradorRepository.findOne(id);
    }

    //remove o colaborador
    public void delete(Long id) {
        Colaborador colaborador = this.colaboradorRepository.findOne(id);
        this.colaboradorRepository.delete(colaborador);
    }

    //edita colaborador
    public Colaborador editar(Colaborador colaborador) {
        //Colaborador colaborador = this.colaboradorRepository.findOne(id);
        return this.colaboradorRepository.save(colaborador);
    }

}
