/**
 * 
 */
package br.com.cams7.banco.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.cams7.banco.model.ClienteEntity;

/**
 * @author ceanm
 *
 */
@Repository
public interface ClienteRepository extends CrudRepository<ClienteEntity, Long> {

}
