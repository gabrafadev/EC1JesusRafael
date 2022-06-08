package com.idat.ProjectEstudiante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.ProjectEstudiante.model.MallaCurricular;



@Repository
public interface MallaRepository extends JpaRepository<MallaCurricular,Integer>{
	
}
