package com.idat.ProjectEstudiante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.ProjectEstudiante.model.Cursos;



@Repository
public interface CursoRepository extends JpaRepository<Cursos,Integer>{
	
}
