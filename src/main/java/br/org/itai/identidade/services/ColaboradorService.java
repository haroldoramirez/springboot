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

    public List<Colaborador> lista() {
        return colaboradorRepository.findAll();
    }

}
