package ecommerce.base;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ecommerce.constantes.ConstantesRest;

public class BaseController<ENTITY extends BaseEntity, REPOSITORY extends BaseRepository<ENTITY>, SERVICE extends BaseService<ENTITY, REPOSITORY>> {

	@Autowired
	private SERVICE service;

	@Autowired
	private REPOSITORY repo;

	@PostMapping
	public ResponseEntity<String> salvar(@RequestBody ENTITY entity) {
		Optional<ENTITY> resultado = service.salvar(entity);
		if (resultado.isPresent()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(resultado.get().getCod().toString());
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}

	@PutMapping
	public ResponseEntity<ENTITY> atualizar(@RequestBody ENTITY entidade) {
		ENTITY entidadeParaAtualizar = service.chamarAtualizar(entidade);
		return ResponseEntity.ok().body(entidadeParaAtualizar);
	}
	
	@GetMapping(ConstantesRest.PATH_LISTAR_POR_COD)
	public ResponseEntity<ENTITY> listarPorCod(@RequestParam("cod") Long cod) {
		ENTITY entidade = service.listarPorCod(cod);
		return ResponseEntity.ok().body(entidade);
	}

	
	@DeleteMapping
	public ResponseEntity<Void> excluir(@RequestParam("cod") Long cod) {
		service.excluir(cod);
		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public Page<ENTITY> consultar(Pageable p,
			@RequestParam(name = "searchTerm", defaultValue = "", required = false) String searchTerm) {
		if (searchTerm.isEmpty()) {
			return repo.consultar(p);
		}
		Page<ENTITY> page = repo.consultar(p, "%" + searchTerm + "%");
		return page;
	}
}
