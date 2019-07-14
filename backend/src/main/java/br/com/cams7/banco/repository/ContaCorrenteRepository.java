/**
 * 
 */
package br.com.cams7.banco.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cams7.banco.model.ContaCorrenteEntity;

/**
 * @author ceanm
 *
 */
@Repository
public interface ContaCorrenteRepository extends CrudRepository<ContaCorrenteEntity, Long> {

	@EntityGraph(value = ContaCorrenteEntity.WITH_CLIENTE)
	Optional<ContaCorrenteEntity> findByClienteId(@Param("clienteId") Long clienteId);

	@Query("SELECT cc.saldo FROM ContaCorrenteEntity cc WHERE cc.id = :contaId")
	Optional<BigDecimal> buscarSaldo(@Param("contaId") Long contaId);

	@Modifying
	@Transactional
	@Query("UPDATE ContaCorrenteEntity cc SET cc.saldo = :novoSaldo WHERE cc.id = :contaId")
	void atualizarSaldo(@Param("contaId") Long contaId, @Param("novoSaldo") BigDecimal novoSaldo);
}
