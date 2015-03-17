package br.org.itai.identidade.controllers;

import br.org.itai.identidade.models.Colaborador;
import br.org.itai.identidade.services.ColaboradorService;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
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
//    @RequestMapping(value = "/colaborador/{id}", method = GET, params = "enable")
//    String findById(@PathVariable Integer id) {
//        return "encontrou com o id - " + id;
//    }

    @ApiOperation(value = "Lista todos", response = Boolean.class, httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lista todos")}
    )
    @RequestMapping(value = "/colaboradores", method = GET)
    @Transactional(readOnly = true)
    public List<Colaborador> lista() {
       return this.colaboradorService.lista();
    }

    @ApiOperation(value = "Adiciona na base da dados", response = Boolean.class, httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Cadastrado com sucesso", response = Colaborador.class),
            @ApiResponse(code = 400, message = "já cadastrado"),
            @ApiResponse(code = 500, message = "Erro interno de sistema")}
    )
    @RequestMapping(value = "/colaboradores", method = POST)
    Colaborador save(@RequestBody Colaborador colaborador) {
        return this.colaboradorService.inserir(colaborador);
    }

    @ApiOperation(value = "Busca por ID", response = Boolean.class, httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "encontrado"),
            @ApiResponse(code = 404, message = "não encontrado")}
    )
    @RequestMapping(value = "/colaboradores/{id}", method = GET)
    Colaborador buscaPorId(@PathVariable Long id) {
        return this.colaboradorService.buscaPorId(id);
    }

    @ApiOperation(value = "Atualiza os dados existentes", response = Boolean.class, httpMethod = "PUT")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Atualizado com sucesso", response = Colaborador.class),
            @ApiResponse(code = 400, message = "já cadastrado"),
            @ApiResponse(code = 500, message = "Erro interno de sistema")}
    )
    @RequestMapping(value = "/colaboradores/{id}", method = PUT)
    Colaborador edit(@RequestBody Colaborador colaborador, @PathVariable Long id) {
        return this.colaboradorService.editar(colaborador);
    }

    @ApiOperation(value = "Remove", response = Boolean.class, httpMethod = "DELETE")
        @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Removido com sucesso", response = Colaborador.class),
            @ApiResponse(code = 404, message = "não encontrado"),
            @ApiResponse(code = 400, message = "Não foi possível remover"),
            @ApiResponse(code = 500, message = "Erro interno de sistema")}
    )
    @RequestMapping(value = "/colaboradores/{id}", method = DELETE)
    public void delete(@PathVariable Long id) {
        this.colaboradorService.delete(id);
    }

}
