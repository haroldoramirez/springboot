package br.org.itai.identidade.controllers;

import br.org.itai.identidade.models.Colaborador;
import br.org.itai.identidade.services.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class ColaboradorController {

    @Autowired
    ColaboradorService colaboradorService;

    //referencia
    @RequestMapping(value = "/colaborador/{id}", method = GET, params = "enable")
    String findById(@PathVariable Integer id) {
        return "encontrou com o id - " + id;
    }

    // URL - lista todos os colaboradores
    @RequestMapping(value = "/colaboradores", method = GET)
    @Transactional(readOnly = true)
    public List<Colaborador> lista() {
       return this.colaboradorService.lista();
    }

    //URL - Insere colaborador
    @RequestMapping(value = "/colaboradores", method = POST)
    Colaborador save(@RequestBody Colaborador colaborador) {
        return this.colaboradorService.inserir(colaborador);
    }

    //URL - busca por ID
    @RequestMapping(value = "/colaboradores/{id}", method = GET)
    Colaborador buscaPorId(@PathVariable Long id) {
        return this.colaboradorService.buscaPorId(id);
    }

    @RequestMapping(value = "/colaboradores/{id}", method = PUT)
    Colaborador edit(@RequestBody Colaborador colaborador, @PathVariable Long id) {
        return this.colaboradorService.editar(colaborador);
    }

    @RequestMapping(value = "/colaboradores/{id}", method = DELETE)
    public void delete(@PathVariable Long id) {
        this.colaboradorService.delete(id);
    }


}
