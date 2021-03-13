package ecommerce.produto;
import java.math.BigDecimal;

import javax.persistence.Column;
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
	
	@Column(name="DESCRICAO")
	private String descricao;
	
	@Column(name="VALVEN")
	private BigDecimal valven;

}
