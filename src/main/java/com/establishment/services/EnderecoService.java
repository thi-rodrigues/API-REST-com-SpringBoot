package com.establishment.services;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.establishment.entities.Endereco;
import com.establishment.entities.Uf;
import com.establishment.entities.DTO.EnderecoDTO;
import com.establishment.repositories.EnderecoRepository;
import com.establishment.repositories.UfRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private UfRepository ufRepository;

	@Transactional(readOnly = true)
	public List<Endereco> findAll() {
		List<Endereco> enderecos = enderecoRepository.findAll();
		return enderecos;
	}

	@Transactional(readOnly = true)
	public Stream<Endereco> findByCep(String cep) {
		return findAll().stream().filter(e -> e.getCep().equals(cep));
	}

	@Transactional
	public Endereco update(Long id, EnderecoDTO enderecoDTO) {
		Uf uf = ufRepository.getOne(enderecoDTO.getUf_id());

		Endereco endereco = new Endereco(id, enderecoDTO.getLogradouro(), enderecoDTO.getCep(), uf);

		return new Endereco(enderecoRepository.save(endereco));

	}

}
