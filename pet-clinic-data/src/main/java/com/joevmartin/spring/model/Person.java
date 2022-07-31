package com.joevmartin.spring.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode( callSuper = true )
@MappedSuperclass
public class Person extends BaseEntity {

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

}
