package com.joevmartin.spring.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode( callSuper = true )
@Entity
@Table(name = "vets")
public class Vet extends Person {

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "vet_specialties",
			joinColumns = @JoinColumn(name = "vet_id"),
			inverseJoinColumns = @JoinColumn(name = "specialty_id")
	)
	private Set<Specialty> specialties = new HashSet<>();

}
