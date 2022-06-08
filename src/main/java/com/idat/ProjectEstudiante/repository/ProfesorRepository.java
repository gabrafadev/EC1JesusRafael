package com.idat.ProjectEstudiante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.ProjectEstudiante.model.Profesores;



@Repository
public interface ProfesorRepository extends JpaRepository<Profesores,Integer>{
	
}
