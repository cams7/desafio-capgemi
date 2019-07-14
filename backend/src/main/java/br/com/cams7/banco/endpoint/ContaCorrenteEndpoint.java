/**
 * 
 */
package br.com.cams7.banco.endpoint;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.math.BigDecimal;

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

import br.com.cams7.banco.model.ContaCorrenteEntity;
import br.com.cams7.banco.model.vo.OperacaoVO;
import br.com.cams7.banco.repository.ContaCorrenteRepository;

/**
 * @author ceanm
 *
 */
@RestController
@RequestMapping(path = "/contas")
public class ContaCorrenteEndpoint {

	@Autowired
	private ContaCorrenteRepository contaCorrenteRepository;

	@ResponseStatus(value = OK)
	@GetMapping
	public Iterable<ContaCorrenteEntity> buscarContas() {
		return contaCorrenteRepository.findAll();
	}

	@ResponseStatus(value = OK)
	@GetMapping(path = "{id}")
	public ContaCorrenteEntity buscarConta(@PathVariable Long id) {
		return contaCorrenteRepository.findById(id).get();
	}

	@ResponseStatus(value = CREATED)
	@PostMapping
	public ContaCorrenteEntity salvarConta(@Valid @RequestBody ContaCorrenteEntity contaCorrente) {
		return contaCorrenteRepository.save(contaCorrente);
	}

	@ResponseStatus(value = OK)
	@PutMapping
	public void atualizarConta(@Valid @RequestBody ContaCorrenteEntity contaCorrente) {
		contaCorrenteRepository.save(contaCorrente);
	}

	@ResponseStatus(value = OK)
	@DeleteMapping(path = "{id}")
	public void excluirConta(@PathVariable Long id) {
		contaCorrenteRepository.deleteById(id);
	}

	@ResponseStatus(value = OK)
	@PostMapping(path = "/realizar_operacao")
	private BigDecimal realizarOperacao(@Valid @RequestBody OperacaoVO operacao) {
		ContaCorrenteEntity conta = contaCorrenteRepository.findById(operacao.getContaId()).get();
		BigDecimal saldoAtual = conta.getSaldo();
		switch (operacao.getTipoOperacao()) {
		case DEPOSITO:
			conta.setSaldo(saldoAtual.add(operacao.getValorInformado()));
			break;
		case SAQUE:
			conta.setSaldo(saldoAtual.subtract(operacao.getValorInformado()));
			break;
		default:
			break;
		}
		conta =  contaCorrenteRepository.save(conta);
		return conta.getSaldo();
	}

}
