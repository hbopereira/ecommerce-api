package ecommerce.tabelapreco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.base.BaseService;
import ecommerce.produto.ProdutoService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TabelaPrecoService extends BaseService<TabelaPreco, TabelaPrecoRepository> {

	private final TabelaPrecoRepository tabelaPrecoRepository;
	
	public void atualizarQtdEstoquePorTabelaPreco(TabelaPreco tabelaPreco) {
		if(tabelaPrecoRepository.existsById(tabelaPreco.getCod())) {
			tabelaPrecoRepository.save(tabelaPreco);
		}
	}

}
