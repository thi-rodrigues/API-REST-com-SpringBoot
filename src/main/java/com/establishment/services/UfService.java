package com.establishment.services;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.establishment.entities.Uf;
import com.establishment.repositories.UfRepository;

@Service
public class UfService {

	@Autowired
	private UfRepository ufRepository;

	@Transactional(readOnly = true)
	public List<Uf> findAll() {
		List<Uf> ufs = ufRepository.findAll();
		Collections.sort(ufs);

		return ufs;

	}
	
	@Transactional(readOnly = true)
	public ResponseEntity<Stream<Uf>> findByEstado(String estado) {
		return ResponseEntity.ok().body(findAll().stream().filter(u -> u.getNome().equalsIgnoreCase(estado)));
	}
}
