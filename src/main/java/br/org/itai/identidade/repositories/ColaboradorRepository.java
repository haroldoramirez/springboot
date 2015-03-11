package br.org.itai.identidade.repositories;

import br.org.itai.identidade.models.Colaborador;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {

    List<Colaborador> buscaTodos();
    Page<Colaborador> buscaPageable(Pageable pageable);
}
