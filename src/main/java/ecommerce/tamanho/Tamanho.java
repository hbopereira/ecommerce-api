package ecommerce.tamanho;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import ecommerce.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="tamanho")
public class Tamanho extends BaseEntity{

	@Column(name="DESCRICAO")
	private String descricao;
}
