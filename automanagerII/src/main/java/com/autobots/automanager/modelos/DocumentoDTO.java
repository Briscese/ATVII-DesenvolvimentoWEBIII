package com.autobots.automanager.modelos;

import com.autobots.automanager.entidades.Documento;

public class DocumentoDTO {

	private Long id;
    private String tipo;
    private String numero;
    
    public Documento toDocumento() {
        Documento documento = new Documento();
        documento.setId(this.getId());
        documento.setTipo(this.getTipo());
        documento.setNumero(this.getNumero());
        
        return documento;
    }
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
    
}
