package com.example.lp;

import com.example.lp.Entity.Cidade;
import com.example.lp.Entity.Estado;
import com.example.lp.Repository.CidadeRepository;
import com.example.lp.Repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/salvarCidades")
public class CidadeBanco {

    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private CidadeRepository cidadeRepository;
    @GetMapping
    public String SalvarCidade() {
        Estado e1 = new Estado("Rio Grande do Sul", "RS");
        Estado e2 = new Estado("Santa Catarina", "SC");
        Estado e3 = new Estado("Paraná", "PR");
        Estado e4 = new Estado("São Paulo", "SP");
        Estado e5 = new Estado("Rio de Janeiro", "RJ");


        estadoRepository.save(e1);
        estadoRepository.save(e2);
        estadoRepository.save(e3);
        estadoRepository.save(e4);
        estadoRepository.save(e5);

        Cidade c1 = new Cidade("Esteio", e1);
        Cidade c2 = new Cidade("Porto Alegre", e1);
        Cidade c3 = new Cidade("Canoas", e1);
        Cidade c4 = new Cidade("Florianópolis", e2);
        Cidade c5 = new Cidade("Tubarão", e2);
        Cidade c6 = new Cidade("Balneario Camburiu", e2);
        Cidade c7 = new Cidade("Curitiba", e3);
        Cidade c8 = new Cidade("Foz do Iguaçu", e3);
        Cidade c9 = new Cidade("Cascavel", e3);
        Cidade c10 = new Cidade("São Paulo", e4);
        Cidade c11 = new Cidade("Campinas", e4);
        Cidade c12 = new Cidade("Santos", e4);
        Cidade c13 = new Cidade("Rio de Janeiro", e5);
        Cidade c14 = new Cidade("Angra dos Reis", e5);
        Cidade c15 = new Cidade("Niterói", e5);

        cidadeRepository.save(c1);
        cidadeRepository.save(c2);
        cidadeRepository.save(c3);
        cidadeRepository.save(c4);
        cidadeRepository.save(c5);
        cidadeRepository.save(c6);
        cidadeRepository.save(c7);
        cidadeRepository.save(c8);
        cidadeRepository.save(c9);
        cidadeRepository.save(c10);
        cidadeRepository.save(c11);
        cidadeRepository.save(c12);
        cidadeRepository.save(c13);
        cidadeRepository.save(c14);
        cidadeRepository.save(c15);

        return "Cidades salvas";
    }
}
