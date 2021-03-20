package ecommerce.produto;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import ecommerce.base.BaseEntity;
import ecommerce.cor.Cor;
import ecommerce.tamanho.Tamanho;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="produto")
public class Produto extends BaseEntity{
	
    @ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="produto_cor", joinColumns=
	{@JoinColumn(name="produto_id")}, inverseJoinColumns=
	{@JoinColumn(name="cor_id")})
	private Set<Cor> cores;
    
    @ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="produto_tamanho", joinColumns=
	{@JoinColumn(name="produto_id")}, inverseJoinColumns=
	{@JoinColumn(name="tamanho_id")})
	private Set<Tamanho> tamanhos;
    
	public Produto() {
		cores = new HashSet<Cor>();
		tamanhos = new HashSet<Tamanho>();
	}
	
	@Column(name="DESCRICAO")
	private String descricao;
	
	@Column(name="VALVEN")
	private BigDecimal valven;

}
