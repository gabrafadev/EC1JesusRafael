package com.idat.ProjectEstudiante.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name="Curso")
public class Cursos{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCurso;
	private String curso,descripcion;
	
	
	
	@ManyToMany(mappedBy = "cursos",cascade = {CascadeType.PERSIST,
			CascadeType.MERGE})
	private List<Profesores> profesores = new ArrayList<>();
	
	
	@ManyToOne
	@JoinColumn(
			name="id_malla", 
			nullable=false, 
			unique =true, 
			foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_malla) references MallaCurricular(id_malla)")
			
			)
	private Cursos cursos;

	public Integer getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	} 

	
	
}
