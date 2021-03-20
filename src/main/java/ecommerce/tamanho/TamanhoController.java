package ecommerce.tamanho;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.base.BaseController;
import ecommerce.constantes.ConstantesRest;

@RestController
@RequestMapping(ConstantesRest.PATH_TAMANHOS)
public class TamanhoController extends BaseController<Tamanho,TamanhoRepository,TamanhoService>{

}
