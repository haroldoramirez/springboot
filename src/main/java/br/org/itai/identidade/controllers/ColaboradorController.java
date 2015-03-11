package br.org.itai.identidade.controllers;

import br.org.itai.identidade.services.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class ColaboradorController {

    @Autowired(required = true)
    private ColaboradorService colaboradorService;

    @RequestMapping(value = "/colaboradores", method = GET)
    @ResponseBody
    @Transactional(readOnly = true)
    public List lista() {
       return this.colaboradorService.buscaTodos();
    }

    @RequestMapping(value = "/colaborador/{id}", method = GET, params = "enable")
    String findById(@PathVariable Integer id) {
        return "encontrou com o id - " + id;
    }

}
