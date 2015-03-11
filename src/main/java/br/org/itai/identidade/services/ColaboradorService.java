package br.org.itai.identidade.services;

import br.org.itai.identidade.models.Colaborador;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface ColaboradorService {

    List<Colaborador> buscaTodos();

    Page<Colaborador> buscaColaboradorPageable(Pageable pageable);
}
