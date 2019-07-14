/**
 * 
 */
package br.com.cams7.banco.model.vo;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

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
public class OperacaoVO {

	@NotNull
	private Long contaId;

	@NotNull
	@DecimalMin("1.00")
	private BigDecimal valorInformado;

	@NotNull
	private TipoOperacao tipoOperacao;

	public static enum TipoOperacao {
		DEPOSITO, SAQUE
	}

}
