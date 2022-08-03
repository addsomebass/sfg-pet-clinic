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

	public Person( Long id, String firstName, String lastName ) {
		super( id );
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

}
