package ecommerce.secao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import ecommerce.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "secao")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "cod")
public class Secao extends BaseEntity {

	public Secao() {
	}

	@Column(name = "DESCRICAO")
	private String descricao;

}
