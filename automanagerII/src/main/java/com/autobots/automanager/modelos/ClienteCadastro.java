package com.autobots.automanager.modelos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.entidades.Endereco;
import com.autobots.automanager.entidades.Telefone;
import com.autobots.automanager.repositorios.ClienteRepositorio;
import com.autobots.automanager.repositorios.DocumentoRepositorio;
import com.autobots.automanager.repositorios.TelefoneRepositorio;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClienteCadastro {

	@Autowired
	private ClienteRepositorio clienteRepositorio;

	@Autowired
	private DocumentoRepositorio documentoRepositorio;

	@Autowired
	private TelefoneRepositorio telefoneRepositorio;

	@Transactional
	public Cliente cadastrarNovoCliente(Cliente cliente) {
	    validarCliente(cliente);

	    // Validar e salvar telefones antes de associá-los ao cliente
	    List<Telefone> telefonesSalvos = new ArrayList<>();
	    for (Telefone telefone : cliente.getTelefones()) {
	        // Verificar se o telefone já existe no banco de dados
	        if (!telefoneRepositorio.existsByNumero(telefone.getNumero())) {
	            // Se não existe, salvar antes de associar ao cliente
	            telefone = telefoneRepositorio.save(telefone);
	        }
	        telefonesSalvos.add(telefone);
	    }

	    // Associar telefones salvos ao cliente
	    cliente.setTelefones(telefonesSalvos);

	    // Associar documentos ao cliente
	    for (Documento documento : cliente.getDocumentos()) {
	        documento.setCliente(cliente);
	    }

	    // Salvar o cliente
	    cliente = clienteRepositorio.save(cliente);

	    // Retornar o cliente salvo
	    return cliente;
	}


	private void validarCliente(Cliente cliente) {
		// Verificar se o cliente já existe pelo nome
		Cliente clienteExistente = clienteRepositorio.findClienteByNome(cliente.getNome());
		if (clienteExistente != null && !clienteExistente.getId().equals(cliente.getId())) {
			throw new RuntimeException("Já existe um cliente com o mesmo nome.");
		}

		validarDocumentos(cliente.getDocumentos());
		validarEndereco(cliente.getEndereco());
	}


	private void validarDocumentos(List<Documento> documentos) {
		for (Documento documento : documentos) {
			// Verificando se o documento já existe no banco de dados
			if (documentoRepositorio.existsByNumero(documento.getNumero())) {
				throw new RuntimeException("Este documento já está associado a outro cliente.");
			}
		}
	}

	private void validarEndereco(Endereco endereco) {
		if (endereco == null) {
			throw new RuntimeException("O cliente deve ter um endereço.");
		}
	}
}
