package com.autobots.automanager.repositorios;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.entidades.Telefone;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

    Cliente findClienteByNome(String nome);

    List<Cliente> findClientesByNomeLike(String nome);
    
    boolean existsClienteByDocumentosContains(Documento documento);

    @Query("SELECT COUNT(c) > 0 FROM Cliente c JOIN c.documentos d WHERE d.numero = :numero")
    boolean existsClienteByDocumentosNumero(@Param("numero") String numero);
    
    @Query("SELECT c FROM Cliente c JOIN c.documentos d WHERE d.numero = :documentoNumero")
    List<Cliente> findClientesByDocumentoNumero(@Param("documentoNumero") String documentoNumero);

	boolean existsClienteByTelefonesContains(Telefone telefone);

	Cliente findClienteByDocumentosContains(Documento documentoSalvo);
	


    Cliente findClienteByTelefonesIn(List<Telefone> telefones);
    
    @Query("SELECT DISTINCT c FROM Cliente c JOIN c.telefones t WHERE t IN :telefones")
    boolean existsClienteByTelefonesIn(@Param("telefones") List<Telefone> telefones);



}
