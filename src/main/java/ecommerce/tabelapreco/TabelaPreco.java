package ecommerce.tabelapreco;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ecommerce.base.BaseEntity;
import ecommerce.produto.Produto;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="tabela_preco")
public class TabelaPreco extends BaseEntity{
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="produto_cod")
	private Produto produto;
	
	@Column(name = "VALVEN")
	private BigDecimal valven;
	
	

}
