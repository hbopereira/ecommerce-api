package ecommerce.produto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ecommerce.tabelapreco.TabelaPreco;
import ecommerce.tabelapreco.TabelaPrecoService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProdutoService {

	private final ProdutoRepository produtoRepository;
	private final TabelaPrecoService tabelaPrecoService;

	@Transactional
	public Optional<Produto> salvar(Produto produto) {
		Produto novo = produtoRepository.save(produto);
		if (produto.getTabelasPrecos().size() > 0) {
			for (TabelaPreco tab : produto.getTabelasPrecos()) {
				tab.setProduto(produto);
				tabelaPrecoService.salvar(tab);
			}
		}
		return Optional.of(novo);
	}

	@Transactional
	public Optional<Produto> atualizar(Produto produto) {
		if (produtoRepository.existsById(produto.getCod())) {
			salvar(produto);
			return Optional.of(produto);
		} else {
			return Optional.empty();
		}
	}

	@Transactional
	public void excluir(Long cod) {
		if (produtoRepository.existsById(cod)) {
			produtoRepository.deleteById(cod);
		} else
			throw new RuntimeException("Entidade [" + cod + "] não encontrada!");
	}

	@Transactional
	public List<Produto> listar() {
		return produtoRepository.findAll();
	}

}
