package com.idat.ProjectEstudiante.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="MallaCurricular")
public class MallaCurricular {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMalla;
	private String año;
	
	@OneToMany(mappedBy = "mallaCurricular")
	private List<Cursos> cursos = new ArrayList<>();
	
	
	@OneToOne(mappedBy = "mallaCurricular")
	private Universidad universidad;

	public Integer getIdMalla() {
		return idMalla;
	}

	public void setIdMalla(Integer idMalla) {
		this.idMalla = idMalla;
	}

	public String getAño() {
		return año;
	}

	public void setAño(String año) {
		this.año = año;
	}
	
	
	
	
}
