package ecommerce.produto;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.base.BaseController;
import ecommerce.constantes.ConstantesRest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(ConstantesRest.PATH_PRODUTOS)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProdutoController extends BaseController<Produto, ProdutoRepository, ProdutoService>{

	private final ProdutoService produtoService;

	@PostMapping(ConstantesRest.PATH_SALVAR)
	public ResponseEntity<String> salvar(@RequestBody Produto produto) {
		Optional<Produto> resultado = produtoService.salvar(produto);
		if (resultado.isPresent()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(resultado.get().getCod().toString());
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}
	
	@PutMapping(ConstantesRest.PATH_ATUALIZAR)
	public ResponseEntity<String> atualizar(@RequestBody Produto produto) {
		Optional<Produto> resultado = produtoService.atualizar(produto);
		if (resultado.isPresent()) {
			return ResponseEntity.ok(resultado.get().getCod().toString());
		}
		return ResponseEntity.notFound().build();
	}

	
	@DeleteMapping(ConstantesRest.PATH_EXCLUIR_POR_COD)
	public ResponseEntity<Void> excluir(@RequestParam("cod") Long cod) {
		produtoService.excluir(cod);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(ConstantesRest.PATH_LISTAR)
	public List<Produto> listar(){
		return produtoService.listar();
	}

}
