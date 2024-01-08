package com.example.lp.DTO;

import com.example.lp.Status;

public record CadastroRequest(
    String nome,
    int idade,
    Long cidadeId,
    Status status,
    String presenteSolicitado
){
}
