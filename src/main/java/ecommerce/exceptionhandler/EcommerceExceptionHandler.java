package ecommerce.exceptionhandler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import ecommerce.exceptions.base.EntidadeNaoEncontradaException;
import ecommerce.exceptions.base.StandartErroEntidadeNaoEncontrada;

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

}
