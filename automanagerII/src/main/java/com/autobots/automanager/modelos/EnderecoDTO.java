package com.autobots.automanager.modelos;

import com.autobots.automanager.entidades.Endereco;

public class EnderecoDTO {
	private Long id;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String numero;
    private String codigoPostal;
    private String informacoesAdicionais;
    
    public Endereco toEndereco() {
        Endereco endereco = new Endereco();
        endereco.setId(this.getId());
        endereco.setEstado(this.getEstado());
        endereco.setCidade(this.getCidade());
        endereco.setBairro(this.getBairro());
        endereco.setRua(this.getRua());
        endereco.setNumero(this.getNumero());
        endereco.setCodigoPostal(this.getCodigoPostal());
        endereco.setInformacoesAdicionais(this.getInformacoesAdicionais());
        return endereco;
    }

    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getInformacoesAdicionais() {
		return informacoesAdicionais;
	}
	public void setInformacoesAdicionais(String informacoesAdicionais) {
		this.informacoesAdicionais = informacoesAdicionais;
	}
	

}
