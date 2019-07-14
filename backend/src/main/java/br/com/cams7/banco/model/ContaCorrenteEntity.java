/**
 * 
 */
package br.com.cams7.banco.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ceanm
 *
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@NamedEntityGraph(name = ContaCorrenteEntity.WITH_CLIENTE, attributeNodes = { @NamedAttributeNode("cliente") })
@Entity
@Table(name = "tb_conta_corrente", uniqueConstraints = { @UniqueConstraint(columnNames = { "id_cliente" }) })
public class ContaCorrenteEntity {

	public static final String WITH_CLIENTE = "ContaCorrente.withCliente";

	@Id
	@SequenceGenerator(name = "sq_conta_corrente", sequenceName = "sq_conta_corrente", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_conta_corrente")
	@Column(name = "id_conta_corrente")
	private Long id;

	@NotNull
	@Column(name = "saldo_atual")
	private BigDecimal saldo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente")
	private ClienteEntity cliente;

}
