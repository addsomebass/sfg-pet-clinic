package com.joevmartin.spring.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode( callSuper = true )
@Entity
@Table(name = "owners")
public class Owner extends Person {

	@Builder
	public Owner( Long id, String firstName, String lastName, String address, String city, String telephone, Set<Pet> pets ) {
		super(id, firstName, lastName );
		this.address = address;
		this.city = city;
		this.telephone = telephone;
		this.pets = pets;
	}

	@Column(name = "address")
	private String address;

	@Column(name = "city")
	private String city;

	@Column(name = "telephone")
	private String telephone;

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany( cascade = CascadeType.ALL, mappedBy = "owner")
	private Set<Pet> pets = new HashSet<>();

}
