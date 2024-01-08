package com.example.lp.Repository;

import com.example.lp.Entity.Cidade;
import com.example.lp.Entity.Crianca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    Optional<Cidade> findById(Long id);
    @Query("SELECT c FROM Crianca c WHERE LOWER(c.cidade.nome) LIKE LOWER(concat('%', ?1, '%'))")
    List<Crianca> findByNomeIgnoreCase(String nome);
}