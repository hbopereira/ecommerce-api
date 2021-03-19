package ecommerce.categoria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="categoria")
public class Categoria {
	
	@Column(name="DESCRICAO")
	private String descricao;
	
}
