package ecommerce.categoria;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CategoriaService {
	private final CategoriaRepository categoriaRepository;

	@Transactional
	public Optional<Categoria> salvar(Categoria categoria) {
		Categoria nova = categoriaRepository.save(categoria);
		return Optional.of(nova);
	}

	@Transactional
	public Optional<Categoria> atualizar(Categoria categoria) {
		if (categoriaRepository.existsById(categoria.getCod())) {
			salvar(categoria);
			return Optional.of(categoria);
		} else {
			return Optional.empty();
		}
	}

	@Transactional
	public void excluir(Long cod) {
		if (categoriaRepository.existsById(cod)) {
			categoriaRepository.deleteById(cod);
		} else
			throw new RuntimeException("Entidade [" + cod + "] não encontrada!");
	}

	@Transactional
	public List<Categoria> listar() {
		return categoriaRepository.findAll();
	}

}
