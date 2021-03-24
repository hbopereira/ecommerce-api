package ecommerce.subsecao;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.base.BaseController;
import ecommerce.constantes.ConstantesRest;


@RestController
@RequestMapping(ConstantesRest.PATH_SUBSECOES)
public class SubSecaoController extends BaseController<SubSecao, SubSecaoRepository, SubSecaoService> {

}
