package com.example.lp.Service;

import com.example.lp.DTO.ListarRequest;
import com.example.lp.Repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CidadeService {
    @Autowired
    private CidadeRepository cidadeRepository;

    public List<ListarRequest> listarPorCidade(String nome) {
        var lista = cidadeRepository.findByNomeIgnoreCase(nome);

        if (lista != null) {
            return lista.stream()
                    .map(crianca -> new ListarRequest(crianca))
                    .collect(Collectors.toList());
        }else {
            return Collections.emptyList();
        }
    }
}
