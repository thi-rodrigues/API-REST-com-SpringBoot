package com.establishment.resources;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.establishment.entities.Endereco;
import com.establishment.entities.DTO.EnderecoDTO;
import com.establishment.services.EnderecoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/clientes/enderecos")
@Api(value = "API REST Establishment")
@CrossOrigin(origins = "*")
public class EnderecoResource {

	@Autowired
	private EnderecoService enderecoService;

	@GetMapping
	@ApiOperation(value = "Retornar uma lista de Endereços.")
	public ResponseEntity<List<Endereco>> findAll() {
		List<Endereco> enderecos = enderecoService.findAll();
		return ResponseEntity.ok().body(enderecos);
	}

	@GetMapping(value = "/{cep}")
	@ApiOperation(value = "Retornar um endereço pasando o CEP como parâmetro.")
	public Stream<Endereco> findByCep(@PathVariable String cep) {
		return enderecoService.findByCep(cep);
	}

	@PatchMapping(value = "/{id}")
	@ApiOperation(value = "Alterar um endereço passando o ID.")
	public ResponseEntity<EnderecoDTO> update(@PathVariable("id") Long id, @RequestBody EnderecoDTO enderecoDTO) {
		enderecoService.update(id, enderecoDTO);
		return ResponseEntity.ok().body(enderecoDTO);
	}
	
}