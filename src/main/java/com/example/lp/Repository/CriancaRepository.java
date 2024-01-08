package com.example.lp.Repository;

import com.example.lp.Entity.Crianca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CriancaRepository extends JpaRepository<Crianca, Long> {
    Optional<Crianca> findById(Long ig);
    List<Crianca> findByBomComportamentoTrue();

    @Query("SELECT c FROM Crianca c WHERE LOWER(c.cidade.nome) LIKE LOWER(concat('%', ?1, '%'))")
    List<Crianca> findByCidade(String nome);
}