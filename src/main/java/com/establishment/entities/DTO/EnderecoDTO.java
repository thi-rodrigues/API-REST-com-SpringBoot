package com.establishment.entities.DTO;

import java.io.Serializable;

import com.establishment.entities.Endereco;

public class EnderecoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String logradouro;
	private String cep;
	private Long uf_id;

	public EnderecoDTO() {
	}

	public EnderecoDTO(Endereco endereco) {
		logradouro = endereco.getLogradouro();
		cep = endereco.getCep();
		uf_id = endereco.getUf().getId();
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Long getUf_id() {
		return uf_id;
	}

	public void setUf_id(Long uf_id) {
		this.uf_id = uf_id;
	}

}
