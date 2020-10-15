package com.establishment.resources;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.establishment.entities.Cliente;
import com.establishment.entities.DTO.ClienteDTO;
import com.establishment.services.ClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/clientes")
@Api(value = "API REST Establishment")
@CrossOrigin(origins = "*")
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	@ApiOperation(value = "Retornar uma lista de Clientes.")
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> clientes = clienteService.findAll();
		return ResponseEntity.ok().body(clientes);
	}

	@ApiOperation(value = "Retornar o Cliente por CPF.")
	@GetMapping(value = "/{cpf}")
	public Stream<Cliente> findById(@PathVariable("cpf") String cpf) {
		return clienteService.findByCpf(cpf);
	}

	@PostMapping
	@ApiOperation(value = "Salvar um Cliente.")
	public ResponseEntity<ClienteDTO> salvar(@RequestBody ClienteDTO clienteDTO){
		clienteService.salvar(clienteDTO);
		return ResponseEntity.ok().body(clienteDTO);
	}
	
	@PatchMapping(value = "/{id}")
	@ApiOperation(value = "Atualizar um Cliente passando um ID.")
	public ResponseEntity<ClienteDTO> update(@PathVariable("id") Long id, @RequestBody ClienteDTO clienteDTO){
		clienteService.update(id, clienteDTO);
		return ResponseEntity.ok().body(clienteDTO);
	}
	
	@DeleteMapping(value = "/{id}")
	@ApiOperation(value = "Deletar um Cliente passando um ID.")
	public void delete(@PathVariable("id") Long id) {
		clienteService.delete(id);
	}
	
}
