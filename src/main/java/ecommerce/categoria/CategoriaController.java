package ecommerce.categoria;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.base.BaseController;
import ecommerce.constantes.ConstantesRest;

@RestController
@RequestMapping(ConstantesRest.PATH_CATEGORIAS)
public class CategoriaController extends BaseController<Categoria, CategoriaRepository, CategoriaService> {

	
}
