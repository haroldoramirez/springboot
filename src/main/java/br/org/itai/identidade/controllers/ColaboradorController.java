package br.org.itai.identidade.controllers;

import br.org.itai.identidade.models.Colaborador;
import br.org.itai.identidade.services.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class ColaboradorController {

    @Autowired
    ColaboradorService colaboradorService;

    @RequestMapping(value = "/colaboradores", method = GET)
    @Transactional(readOnly = true)
    public List<Colaborador> lista() {
       return this.colaboradorService.lista();
    }

    @RequestMapping(value = "/colaborador/{id}", method = GET, params = "enable")
    String findById(@PathVariable Integer id) {
        return "encontrou com o id - " + id;
    }

}
