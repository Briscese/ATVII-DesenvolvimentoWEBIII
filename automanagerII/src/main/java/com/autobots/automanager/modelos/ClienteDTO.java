package com.autobots.automanager.modelos;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.entidades.Telefone;

public class ClienteDTO {
	 private Long id;
	    private String nome;
	    private String nomeSocial;
	    private Date dataNascimento;
	    private Date dataCadastro;
	    private List<DocumentoDTO> documentos;
	    private EnderecoDTO endereco;
	    private List<TelefoneDTO> telefones;
	    
	    public Cliente toCliente() {
	        Cliente cliente = new Cliente();
	        cliente.setId(this.getId());
	        cliente.setNome(this.getNome());
	        cliente.setNomeSocial(this.getNomeSocial());
	        cliente.setDataNascimento(new java.util.Date(this.getDataNascimento().getTime()));
	        cliente.setDataCadastro(new java.util.Date(this.getDataCadastro().getTime()));
	        
	
	        List<Documento> documentos = this.getDocumentos().stream()
	                .map(DocumentoDTO::toDocumento)
	                .collect(Collectors.toList());
	        cliente.setDocumentos(documentos);

	   
	        cliente.setEndereco(this.getEndereco().toEndereco());

	    
	        List<Telefone> telefones = this.getTelefones().stream()
	                .map(TelefoneDTO::toTelefone)
	                .collect(Collectors.toList());
	        cliente.setTelefones(telefones);
	        
	        return cliente;
	    }
	    
	    public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getNomeSocial() {
			return nomeSocial;
		}
		public void setNomeSocial(String nomeSocial) {
			this.nomeSocial = nomeSocial;
		}
		public Date getDataNascimento() {
			return dataNascimento;
		}
		public void setDataNascimento(Date dataNascimento) {
			this.dataNascimento = dataNascimento;
		}
		public Date getDataCadastro() {
			return dataCadastro;
		}
		public void setDataCadastro(Date dataCadastro) {
			this.dataCadastro = dataCadastro;
		}
		public List<DocumentoDTO> getDocumentos() {
			return documentos;
		}
		public void setDocumentos(List<DocumentoDTO> documentos) {
			this.documentos = documentos;
		}
		public EnderecoDTO getEndereco() {
			return endereco;
		}
		public void setEndereco(EnderecoDTO endereco) {
			this.endereco = endereco;
		}
		public List<TelefoneDTO> getTelefones() {
			return telefones;
		}
		public void setTelefones(List<TelefoneDTO> telefones) {
			this.telefones = telefones;
		}
		
}
