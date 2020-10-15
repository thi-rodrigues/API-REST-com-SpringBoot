package com.establishment.entities.DTO;

import java.io.Serializable;

import com.establishment.entities.Cliente;

public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private String cpf;
	private Long endereco_id;

	public ClienteDTO() {
	}

	public ClienteDTO(Cliente cliente) {
		nome = cliente.getNome();
		cpf = cliente.getCpf();
		endereco_id = cliente.getEndereco().getId();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Long getEndereco_id() {
		return endereco_id;
	}

	public void setEndereco_id(Long endereco_id) {
		this.endereco_id = endereco_id;
	}

}
