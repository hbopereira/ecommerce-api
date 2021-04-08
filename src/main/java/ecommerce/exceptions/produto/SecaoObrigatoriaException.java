package ecommerce.exceptions.produto;

public class SecaoObrigatoriaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SecaoObrigatoriaException(String mensagem) {
		super(mensagem);
	}
}
