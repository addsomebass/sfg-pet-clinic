package com.joevmartin.spring.model;

import java.time.LocalDate;


public class Visit extends BaseEntity {

	private Pet pet;
	private LocalDate appointmentTime;
	private String description;


	public Pet getPet() {
		return pet;
	}

	public void setPet( Pet pet ) {
		this.pet = pet;
	}

	public LocalDate getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime( LocalDate appointmentTime ) {
		this.appointmentTime = appointmentTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription( String description ) {
		this.description = description;
	}
}
