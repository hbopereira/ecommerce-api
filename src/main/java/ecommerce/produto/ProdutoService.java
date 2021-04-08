package ecommerce.produto;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ecommerce.base.BaseService;
import ecommerce.exceptions.base.EntidadeNaoEncontradaException;
import ecommerce.exceptions.produto.SecaoObrigatoriaException;
import ecommerce.secao.Secao;
import ecommerce.secao.SecaoRepository;
import ecommerce.tabelapreco.TabelaPrecoService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProdutoService extends BaseService<Produto, ProdutoRepository> {

	private final ProdutoRepository produtoRepository;
	private final SecaoRepository secaoRepository;
	private final TabelaPrecoService tabelaPrecoService;

	@Transactional
	public Optional<Produto> salvarProduto(Produto produto) {
		try {
			if (validarAntesDeSalvarProduto(produto)) {
				produtoRepository.save(produto);
				if (produto.getTabelasPrecos().size() > 0) {
					produto.getTabelasPrecos().forEach(tab -> {
						tab.setProduto(produto);
						tabelaPrecoService.salvar(tab);
					});
				}
			}
			return Optional.of(produto);
		} catch (Exception erro) {
			throw erro;
		}
	}

	public Boolean validarAntesDeSalvarProduto(Produto produto) {
		Boolean validou = false;
		Optional<Secao> secao = Optional.ofNullable(produto.getSecao());
		if (!secao.isPresent()) {
			secao.orElseThrow(() -> new SecaoObrigatoriaException("Campo seção obrigatorio !"));
		} else {
			validou = true;
		}

		if (!secaoRepository.existsById(secao.get().getCod())) {
			throw new EntidadeNaoEncontradaException("Registro não encontrado");
		} else {
			validou = true;
		}
		return validou;
	}
}
