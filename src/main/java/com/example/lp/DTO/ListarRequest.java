package com.example.lp.DTO;

import com.example.lp.Entity.Crianca;
import com.example.lp.Status;

import java.time.LocalDateTime;

public record ListarRequest(
        Long id,
        String nome,
        int idade,
        String cidade,
        String estado,
        boolean bomComportamento,
        Status status,
        String presenteSolicitado,
        LocalDateTime dataEntrega){
    public ListarRequest(Crianca crianca) {
    this(crianca.getId(), crianca.getNome(), crianca.getIdade(), crianca.getCidade().getNome(),
            crianca.getCidade().getEstado().getNome(), crianca.isBomComportamento(),
            crianca.getStatus(), crianca.getPresenteSolicitado(), crianca.getDataPresente());
    }
}
