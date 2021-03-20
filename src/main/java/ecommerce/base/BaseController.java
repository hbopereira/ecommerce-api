package ecommerce.base;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import lombok.RequiredArgsConstructor;

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
	public ResponseEntity<String> atualizar(@RequestBody ENTITY entity) {
		Optional<ENTITY> resultado = service.atualizar(entity);
		if (resultado.isPresent()) {
			return ResponseEntity.ok(resultado.get().getCod().toString());
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ENTITY> encontrarPeloId(@PathVariable("id") Long id) {
		Optional<ENTITY> resultado = service.encontrarPeloId(id);
		if (resultado.isPresent()) {
			return ResponseEntity.ok(resultado.get());
		}
		return ResponseEntity.notFound().build();
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
