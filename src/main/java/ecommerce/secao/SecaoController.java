package ecommerce.secao;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.base.BaseController;
import ecommerce.constantes.ConstantesRest;

@RestController
@RequestMapping(ConstantesRest.PATH_SECOES)
public class SecaoController extends BaseController<Secao,SecaoRepository, SecaoService>{

}
