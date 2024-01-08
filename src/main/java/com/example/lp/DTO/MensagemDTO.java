package com.example.lp.DTO;

import com.example.lp.MensagemResponse;

public record MensagemDTO(
    String mensagem
){

    public MensagemDTO(MensagemResponse mensagem){
        this(mensagem.mensagem());
    }
}
