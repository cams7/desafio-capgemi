/**
 * 
 */
package br.com.cams7.banco.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.cams7.banco.model.ContaCorrenteEntity;

/**
 * @author ceanm
 *
 */
@Repository
public interface ContaCorrenteRepository extends CrudRepository<ContaCorrenteEntity, Long> {

	@EntityGraph(value = ContaCorrenteEntity.WITH_CLIENTE)
	Optional<ContaCorrenteEntity> findById(@Param("id") Long id);
}
