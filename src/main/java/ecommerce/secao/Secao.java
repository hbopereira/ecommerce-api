package ecommerce.secao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import ecommerce.base.BaseEntity;
import ecommerce.produto.Produto;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="secao")
@JsonIdentityInfo(
		generator=ObjectIdGenerators.PropertyGenerator.class,
		property="cod")
public class Secao extends BaseEntity{
	
	@OneToMany(mappedBy = "secao", fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Produto> produtos;
	
	public Secao() {
		this.produtos = new ArrayList<Produto>();
	}
	
	@Column(name="DESCRICAO")
	private String descricao;
	

}
