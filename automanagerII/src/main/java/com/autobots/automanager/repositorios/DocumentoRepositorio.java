package com.autobots.automanager.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.autobots.automanager.entidades.Documento;

public interface DocumentoRepositorio extends JpaRepository<Documento, Long> {

    @Query("SELECT d FROM Documento d WHERE d.numero = :numero")
    Documento findDocumentoByNumero(@Param("numero") String numero);
    
    boolean existsByNumero(String numero);
}
