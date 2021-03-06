package ecommerce.produto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import ecommerce.base.BaseEntity;
import ecommerce.cor.Cor;
import ecommerce.secao.Secao;
import ecommerce.subsecao.SubSecao;
import ecommerce.tabelapreco.TabelaPreco;
import ecommerce.tamanho.Tamanho;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "produto")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "cod")
public class Produto extends BaseEntity {

	@OneToMany(mappedBy = "produto", fetch = FetchType.EAGER, orphanRemoval = true)
	private List<TabelaPreco> tabelasPrecos;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "produto_cor", joinColumns = { @JoinColumn(name = "produto_cod") }, inverseJoinColumns = {
			@JoinColumn(name = "cor_cod") })
	private Set<Cor> cores;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "produto_tamanho", joinColumns = { @JoinColumn(name = "produto_cod") }, inverseJoinColumns = {
			@JoinColumn(name = "tamanho_cod") })
	private Set<Tamanho> tamanhos;

	@OneToOne
	@JoinColumn(name = "secao_cod")
	private Secao secao;
	
	@OneToOne
	@JoinColumn(name = "subsecao_cod")
	private SubSecao subsecao;

	public Produto() {
		this.cores = new HashSet<Cor>();
		this.tamanhos = new HashSet<Tamanho>();
		this.tabelasPrecos = new ArrayList<TabelaPreco>();
	}

	@Column(name = "DESCRICAO")
	private String descricao;

	@Column(name = "VALVEN")
	private BigDecimal valven;

}
