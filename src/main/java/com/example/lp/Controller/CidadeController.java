package com.example.lp.Controller;

import com.example.lp.DTO.ListarRequest;
import com.example.lp.Service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping("/{nomeCidade}")
    public ResponseEntity<List<ListarRequest>> ListarPorCidade(@PathVariable("nomeCidade") String nome) {
         var response = cidadeService.listarPorCidade(nome);
         return ResponseEntity.ok().body(response);
    }
}
