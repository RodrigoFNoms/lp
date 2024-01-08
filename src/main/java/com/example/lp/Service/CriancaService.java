package com.example.lp.Service;

import com.example.lp.DTO.CadastroRequest;
import com.example.lp.DTO.ListarRequest;
import com.example.lp.Entity.Cidade;
import com.example.lp.Entity.Crianca;
import com.example.lp.Repository.CidadeRepository;
import com.example.lp.Repository.CriancaRepository;
import com.example.lp.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CriancaService {
    @Autowired
    private CriancaRepository criancaRepository;
    @Autowired
    private CidadeRepository cidadeRepository;

    public Crianca cadastro(CadastroRequest dados){
        Crianca crianca = new Crianca();
        Cidade cidade = cidadeRepository.getReferenceById(dados.cidadeId());

        if(sortearBoolean()){
            crianca.setBomComportamento(true);
            crianca.setStatus(Status.PENDENTE);
        } else{
            crianca.setBomComportamento(false);
            crianca.setStatus(Status.NEGADO);
        }
        crianca.setNome(dados.nome());
        crianca.setIdade(dados.idade());
        crianca.setPresenteSolicitado(dados.presenteSolicitado());
        crianca.setCidade(cidade);
        crianca.setEstado(cidade.getEstado());
        return crianca;
    }
    public ListarRequest cadastrarCrianca(CadastroRequest dados){
        Crianca crianca = cadastro(dados);
        criancaRepository.save(crianca);
        return new ListarRequest(crianca);
    }
    public List<ListarRequest> listarCriancas(){
        List<Crianca> crianca = criancaRepository.findAll();
        try {
            return crianca.stream().map((Crianca id) -> new ListarRequest(id))
                    .collect(Collectors.toList());
        }catch (NullPointerException ex){
            return null;
        }
    }
    public List<ListarRequest> listarCriancasComBomComportamento(){
        List<Crianca> crianca = criancaRepository.findByBomComportamentoTrue();
        try {
            return crianca.stream()
                    .map(ListarRequest::new)
                    .collect(Collectors.toList());
        }catch (NullPointerException ex){
            return null;
        }
    }
    public List<ListarRequest> listarCriancasPorCidade(String cidade){
        List<Crianca> crianca = criancaRepository.findByCidade(cidade);
        try {
            return crianca.stream().map(ListarRequest::new)
                    .collect(Collectors.toList());
        }catch (NullPointerException ex){
            return null;
        }
    }
    public boolean sortearBoolean(){
        int max = 10;
        int min = 1;
        int range = max - min + 1;
        int numero = (int)(Math.random() * range) + min;

        if(numero % 2 == 0){
            return true;
        } else{
            return false;
        }
    }
    public ListarRequest entregarPresente(Long criancaId) {
        Crianca crianca = criancaRepository.getReferenceById(criancaId);

        if(crianca.isBomComportamento()){
            if(crianca.getStatus() == Status.ENTREGUE){
                return new ListarRequest(crianca);
            } else{
                crianca.setStatus(Status.ENTREGUE);
                crianca.setDataPresente(LocalDateTime.now());
                criancaRepository.save(crianca);
                return new ListarRequest(crianca);
            }
        } else{
            return null;
        }
    }
}