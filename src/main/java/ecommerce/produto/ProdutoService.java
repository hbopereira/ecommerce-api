package ecommerce.produto;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ecommerce.base.BaseService;
import ecommerce.tabelapreco.TabelaPreco;
import ecommerce.tabelapreco.TabelaPrecoService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProdutoService extends BaseService<Produto, ProdutoRepository> {

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
}
