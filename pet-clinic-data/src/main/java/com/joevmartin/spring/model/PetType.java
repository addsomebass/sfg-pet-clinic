package com.joevmartin.spring.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode( callSuper = true )
@Entity
@Table(name = "types")
public class PetType extends BaseEntity {

	@Column(name = "name")
	private String name;

}
