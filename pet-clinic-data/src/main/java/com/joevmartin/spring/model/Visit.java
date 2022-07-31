package com.joevmartin.spring.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode( callSuper = true )
@Entity
@Table(name = "visit")
public class Visit extends BaseEntity {

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@ManyToOne
	@JoinColumn(name = "pet_id")
	private Pet pet;

	@Column(name = "date")
	private LocalDate date;

	@Column(name = "description")
	private String description;


}
