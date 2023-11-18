package com.autobots.automanager.controles;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.entidades.Endereco;
import com.autobots.automanager.entidades.Telefone;
import com.autobots.automanager.modelos.ClienteAtualizador;
import com.autobots.automanager.modelos.ClienteCadastro;
import com.autobots.automanager.modelos.ClienteDTO;
import com.autobots.automanager.modelos.ClienteSelecionador;
import com.autobots.automanager.modelos.DocumentoDTO;
import com.autobots.automanager.modelos.EnderecoDTO;
import com.autobots.automanager.modelos.TelefoneDTO;
import com.autobots.automanager.repositorios.ClienteRepositorio;

@RestController
@RequestMapping("/clientes")
public class ClienteControle {
	@Autowired
	private ClienteRepositorio repositorio;
	@Autowired
	private ClienteSelecionador selecionador;
	@Autowired
    private ClienteCadastro clienteCadastro;
	
	

	@GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> obterCliente(@PathVariable long id) {
        List<Cliente> clientes = repositorio.findAll();
        
        Optional<Cliente> clienteOptional = selecionador.selecionar(clientes, id);
        
        if (clienteOptional.isPresent()) {
            Cliente clienteSelecionado = clienteOptional.get();
            ClienteDTO clienteDTO = converterParaDTO(clienteSelecionado);
            return new ResponseEntity<>(clienteDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

	@GetMapping
	public List<ClienteDTO> obterClientes() {
		List<Cliente> clientes = repositorio.findAll();
		List<ClienteDTO> clientesDTO = clientes.stream().map(this::converterParaDTO).collect(Collectors.toList());
		return clientesDTO;
	}

	private ClienteDTO converterParaDTO(Cliente cliente) {

		Date dataNascimento = cliente.getDataNascimento();
		Date dataCadastro = cliente.getDataCadastro();

		java.sql.Date sqlDataNascimento = new java.sql.Date(dataNascimento.getTime());
		java.sql.Date sqlDataCadastro = new java.sql.Date(dataCadastro.getTime());

		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(cliente.getId());
		clienteDTO.setNome(cliente.getNome());
		clienteDTO.setNomeSocial(cliente.getNomeSocial());
		clienteDTO.setDataNascimento(sqlDataNascimento);
		clienteDTO.setDataCadastro(sqlDataCadastro);
		clienteDTO.setDocumentos(converterDocumentosParaDTO(cliente.getDocumentos()));
		clienteDTO.setEndereco(converterEnderecoParaDTO(cliente.getEndereco()));
		clienteDTO.setTelefones(converterTelefonesParaDTO(cliente.getTelefones()));
		return clienteDTO;
	}

	private List<DocumentoDTO> converterDocumentosParaDTO(List<Documento> documentos) {
		return documentos.stream().map(this::converterDocumentoParaDTO).collect(Collectors.toList());
	}

	private DocumentoDTO converterDocumentoParaDTO(Documento documento) {
		DocumentoDTO documentoDTO = new DocumentoDTO();
		documentoDTO.setId(documento.getId());
		documentoDTO.setTipo(documento.getTipo());
		documentoDTO.setNumero(documento.getNumero());
		return documentoDTO;
	}

	private EnderecoDTO converterEnderecoParaDTO(Endereco endereco) {
		EnderecoDTO enderecoDTO = new EnderecoDTO();
		enderecoDTO.setId(endereco.getId());
		enderecoDTO.setEstado(endereco.getEstado());
		enderecoDTO.setCidade(endereco.getCidade());
		enderecoDTO.setBairro(endereco.getBairro());
		enderecoDTO.setRua(endereco.getRua());
		enderecoDTO.setNumero(endereco.getNumero());
		enderecoDTO.setCodigoPostal(endereco.getCodigoPostal());
		enderecoDTO.setInformacoesAdicionais(endereco.getInformacoesAdicionais());
		return enderecoDTO;
	}

	private List<TelefoneDTO> converterTelefonesParaDTO(List<Telefone> telefones) {
		List<TelefoneDTO> telefonesDTO = new ArrayList<>();
		for (Telefone telefone : telefones) {
			TelefoneDTO telefoneDTO = new TelefoneDTO();
			telefoneDTO.setId(telefone.getId());
			telefoneDTO.setDdd(telefone.getDdd());
			telefoneDTO.setNumero(telefone.getNumero());
			telefonesDTO.add(telefoneDTO);
		}
		return telefonesDTO;
	}

	@PostMapping
    public ResponseEntity<?> cadastrarCliente(@RequestBody Cliente cliente) {
        try {
            Cliente novoCliente = clienteCadastro.cadastrarNovoCliente(cliente);
            return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

	@PutMapping
	public void atualizarCliente(@RequestBody Cliente atualizacao) {
		Cliente cliente = repositorio.getById(atualizacao.getId());
		ClienteAtualizador atualizador = new ClienteAtualizador();
		atualizador.atualizar(cliente, atualizacao);
		repositorio.save(cliente);
	}

	@DeleteMapping("/{id}")
	public void excluirCliente(@PathVariable Long id) {
	    // Verifique os logs para garantir que o ID esteja sendo capturado corretamente
	    System.out.println("Excluindo cliente com ID: " + id);
	    
	    Cliente cliente = repositorio.getById(id);
	    if (cliente != null) {
	        repositorio.delete(cliente);
	    } else {
	        
	    }
	}
}
