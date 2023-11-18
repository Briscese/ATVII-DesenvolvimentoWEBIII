package com.autobots.automanager.modelos;

import com.autobots.automanager.entidades.Telefone;

public class TelefoneDTO {
	private Long id;
    private String ddd;
    
    public Telefone toTelefone() {
        Telefone telefone = new Telefone();
        telefone.setId(this.getId());
        telefone.setDdd(this.getDdd());
        telefone.setNumero(this.getNumero());
        return telefone;
    }
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	private String numero;
}
