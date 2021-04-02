package ecommerce.exceptions.base;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StandartErroEntidadeNaoEncontrada implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer status;
	private String erro;
	private String mensagem;
	private String caminho;
	
	public StandartErroEntidadeNaoEncontrada() {
		
	}

}
