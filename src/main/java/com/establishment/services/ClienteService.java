package com.establishment.services;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.establishment.entities.Cliente;
import com.establishment.entities.Endereco;
import com.establishment.entities.DTO.ClienteDTO;
import com.establishment.repositories.ClienteRepository;
import com.establishment.repositories.EnderecoRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Stream<Cliente> findByCpf(String cpf) {
		return findAll().stream().filter(c -> c.getCpf().equals(cpf));
	}

	@Transactional
	public Cliente salvar(ClienteDTO clienteDTO) {
		Endereco endereco = enderecoRepository.getOne(clienteDTO.getEndereco_id());

		Cliente cliente = new Cliente(clienteDTO.getNome(), clienteDTO.getCpf(), endereco);

		return new Cliente(clienteRepository.save(cliente));
	}

	@Transactional
	public Cliente update(Long id, ClienteDTO clienteDTO) {

		Endereco endereco = enderecoRepository.getOne(clienteDTO.getEndereco_id());

		Cliente cliente = new Cliente(id, clienteDTO.getNome(), clienteDTO.getCpf(), endereco);

		return new Cliente(clienteRepository.save(cliente));
	}

	@Transactional
	public void delete(Long id) {
		clienteRepository.deleteById(id);
	}

}
