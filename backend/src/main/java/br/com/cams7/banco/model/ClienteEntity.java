/**
 * 
 */
package br.com.cams7.banco.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

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
@Entity
@Table(name = "tb_cliente")
public class ClienteEntity {

	@Id
	@SequenceGenerator(name = "sq_cliente", sequenceName = "sq_cliente", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_cliente")
	@Column(name = "id_cliente")
	private Long id;
	
	@NotBlank
	@Size(min = 3, max = 50)
	private String nome;

	@NotBlank
	@CPF
	private String cpf;
	
	@NotNull
	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;
}
