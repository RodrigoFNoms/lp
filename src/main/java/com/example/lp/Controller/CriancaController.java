package com.example.lp.Controller;

import com.example.lp.DTO.CadastroRequest;
import com.example.lp.DTO.ListarRequest;
import com.example.lp.Service.CriancaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crianca")
public class CriancaController {
    @Autowired
    private CriancaService service;

    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity<ListarRequest> cadastrarCrianca(@RequestBody CadastroRequest dados){
        if(dados.idade() <= 14){
            var response = service.cadastrarCrianca(dados);
            return ResponseEntity.status(200).body(response);
        } else{
            return ResponseEntity.status(406).build();
        }
    }
    @GetMapping("/lista")
    public ResponseEntity<List<ListarRequest>> listarCriancas(){
        var response = service.listarCriancas();
        return ResponseEntity.status(200).body(response);
    }
    @GetMapping("/lista/porBomComportamento")
    public List<ListarRequest> listarCriancasComBomComportamento(){
        var response = service.listarCriancasComBomComportamento();
        return response;
    }
    @GetMapping("/lista/{cidade}")
    public List<ListarRequest> listarCrancasPorCidade(@PathVariable String cidade) {
        var response = service.listarCriancasPorCidade(cidade);
        return response;
    }
    @PostMapping("/entregarPresente/{idCrianca}")
    public ResponseEntity<ListarRequest> entregarPresente(@PathVariable("idCrianca") Long criancaId) {
        var response = service.entregarPresente(criancaId);
        if(response == null){
            return ResponseEntity.status(406).build();
        }
        return ResponseEntity.ok(response);
    }
}