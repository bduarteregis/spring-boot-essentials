package br.com.devdojo.springbootessentials.endpoint;

import br.com.devdojo.springbootessentials.error.CustomErrorType;
import br.com.devdojo.springbootessentials.model.Dados;
import br.com.devdojo.springbootessentials.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Arrays.asList;

@RestController
@RequestMapping("dados")
public class DadosEndpoint {
    @Autowired
    private DateUtil dateUtil;

    public DadosEndpoint(DateUtil dateUtil) {
        this.dateUtil = dateUtil;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listAll() {
        System.out.println("---------- Registro de Acesso");
        System.out.println("---------- Horário: " + dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(Dados.dadosList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<?> getDadosById(@PathVariable("id") int id) {
        Dados dados = new Dados();
        dados.setId(id);
        int index = Dados.dadosList.indexOf(dados);
        if(index == -1)
            return new ResponseEntity<>(new CustomErrorType("Dado nao encontrado"), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(Dados.dadosList.get(index),HttpStatus.OK);
        }
    }
