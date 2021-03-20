package ecommerce.cor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.base.BaseController;
import ecommerce.constantes.ConstantesRest;

@RestController
@RequestMapping(ConstantesRest.PATH_CORES)
public class CorController extends BaseController<Cor,CorRepository,CorService>{

}
