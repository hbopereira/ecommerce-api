package ecommerce.base;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ecommerce.exceptions.base.EntidadeNaoEncontradaException;

public class BaseService<ENTITY extends BaseEntity, REPOSITORY extends BaseRepository<ENTITY>> {

	@Autowired
	private REPOSITORY repo;

	@Transactional
	public Optional<ENTITY> salvar(ENTITY entity) {
		ENTITY nova = repo.save(entity);
		return Optional.of(nova);
	}

	@Transactional
	public Optional<ENTITY> atualizar(ENTITY entidade) {
		if (repo.existsById(entidade.getCod())) {
			salvar(entidade);
			return Optional.of(entidade);
		} else {
			return Optional.empty();
		}
	}
	
	public ENTITY chamarAtualizar(ENTITY entidade) {
		return atualizar(entidade)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Registro não encontrado" + entidade.getCod()));
	}
	
	@Transactional
	public ENTITY listarPorCod(Long cod) {
		return repo.findById(cod)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Registro não encontrado" + cod));
	}

	@Transactional
	public void excluir(ENTITY entity) {
		if (repo.existsById(entity.getCod())) {
			repo.deleteById(entity.getCod());
		}
	}

	@Transactional
	public void excluir(Long id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
		}
	}

}