package ecommerce.subsecao;

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
@Table(name="subsecao")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "cod")
public class SubSecao extends BaseEntity{
	
	@Column(name="DESCRICAO")
	private String descricao;
	
	public SubSecao() {
		
	}

}
