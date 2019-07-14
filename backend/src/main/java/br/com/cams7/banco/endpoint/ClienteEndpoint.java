/**
 * 
 */
package br.com.cams7.banco.endpoint;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cams7.banco.model.ClienteEntity;
import br.com.cams7.banco.repository.ClienteRepository;

/**
 * @author ceanm
 *
 */
@RestController
@RequestMapping(path = "/clientes")
public class ClienteEndpoint {

	@Autowired
	private ClienteRepository clienteRepository;

	@ResponseStatus(value = OK)
	@GetMapping
	public Iterable<ClienteEntity> buscarClientes() {
		return clienteRepository.findAll();
	}

	@ResponseStatus(value = OK)
	@GetMapping(path = "{id}")
	public ClienteEntity buscarCliente(@PathVariable Long id) {
		return clienteRepository.findById(id).get();
	}

	@ResponseStatus(value = CREATED)
	@PostMapping
	public ClienteEntity salvarCliente(@Valid @RequestBody ClienteEntity cliente) {
		return clienteRepository.save(cliente);
	}

	@ResponseStatus(value = OK)
	@PutMapping
	public void atualizarCliente(@Valid @RequestBody ClienteEntity cliente) {
		clienteRepository.save(cliente);
	}

	@ResponseStatus(value = OK)
	@DeleteMapping(path = "{id}")
	public void excluirCliente(@PathVariable Long id) {
		clienteRepository.deleteById(id);
	}

}
