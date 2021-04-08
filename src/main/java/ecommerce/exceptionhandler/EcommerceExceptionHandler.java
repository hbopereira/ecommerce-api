package ecommerce.exceptionhandler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import ecommerce.exceptions.base.EntidadeNaoEncontradaException;
import ecommerce.exceptions.base.StandartErroEntidadeNaoEncontrada;
import ecommerce.exceptions.produto.SecaoObrigatoriaException;
import ecommerce.exceptions.produto.StandartErroSecaoObrigatoria;

@ControllerAdvice
public class EcommerceExceptionHandler {
	
	@ExceptionHandler(EntidadeNaoEncontradaException.class)
	public ResponseEntity<StandartErroEntidadeNaoEncontrada> entidadeNaoEcontrada(EntidadeNaoEncontradaException e, HttpServletRequest request){
		StandartErroEntidadeNaoEncontrada erro = new StandartErroEntidadeNaoEncontrada();
		erro.setStatus(HttpStatus.NOT_FOUND.value());
		erro.setErro("Registro nao encontrado !");
		erro.setMensagem(e.getMessage());
		erro.setCaminho(request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(SecaoObrigatoriaException.class)
	public ResponseEntity<StandartErroSecaoObrigatoria> secaoObrigatoria(SecaoObrigatoriaException e, HttpServletRequest request){
		StandartErroSecaoObrigatoria erro = new StandartErroSecaoObrigatoria();
		erro.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		erro.setErro("Seção obrigatória !");
		erro.setMensagem(e.getMessage());
		erro.setCaminho(request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
	}

}
