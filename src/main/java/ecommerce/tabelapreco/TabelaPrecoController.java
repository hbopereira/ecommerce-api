package ecommerce.tabelapreco;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ecommerce.base.BaseController;
import ecommerce.constantes.ConstantesRest;

@RestController
@RequestMapping(ConstantesRest.PATH_TABELAS_PRECOS)
public class TabelaPrecoController extends BaseController<TabelaPreco, TabelaPrecoRepository, TabelaPrecoService>{

}
