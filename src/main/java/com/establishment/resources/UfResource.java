package com.establishment.resources;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.establishment.entities.Uf;
import com.establishment.services.UfService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/clientes/ufs")
@Api(value = "API REST Establishment")
@CrossOrigin(origins = "*")
public class UfResource {

	@Autowired
	private UfService ufService;
	
	@GetMapping
	@ApiOperation(value = "Retornar uma lista de UF.")
	public ResponseEntity<List<Uf>> findAll(){
		List<Uf> ufs = ufService.findAll();
		return ResponseEntity.ok().body(ufs);
	}
	
	@GetMapping(value = "/{estado}")
	@ApiOperation(value = "Retornar um Município com base no Estado.")
	public ResponseEntity<Stream<Uf>> findByEstado(@PathVariable("estado") String estado){
		return ufService.findByEstado(estado);
	}
}
