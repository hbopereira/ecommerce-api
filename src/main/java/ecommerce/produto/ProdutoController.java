package ecommerce.produto;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.base.BaseController;
import ecommerce.constantes.ConstantesRest;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:3000") // so para testes..aceitar chamadadas do front end..
@RestController
@RequestMapping(ConstantesRest.PATH_PRODUTOS)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProdutoController extends BaseController<Produto, ProdutoRepository, ProdutoService>{

	private final ProdutoService produtoService;

	@PostMapping(ConstantesRest.PATH_SALVAR)
	public ResponseEntity<String> salvar(@RequestBody Produto produto) {
		Optional<Produto> resultado = produtoService.salvarProduto(produto);
		if (resultado.isPresent()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(resultado.get().getCod().toString());
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resultado.get().toString());
		}
	}

}
