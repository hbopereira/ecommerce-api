package ecommerce.produto;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Table;
import ecommerce.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="produto")
public class Produto extends BaseEntity{
	
	private String descricao;
	private BigDecimal valven;

}
