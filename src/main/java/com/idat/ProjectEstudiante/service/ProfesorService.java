package com.idat.ProjectEstudiante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.idat.ProjectEstudiante.model.Profesores;
import com.idat.ProjectEstudiante.repository.ProfesorRepository;


public class ProfesorService implements ProfesorServiceImpl {

	
	@Autowired
	private ProfesorRepository repository;
	
	@Override
	public void guardarProfesor(Profesores profe) {
		// TODO Auto-generated method stub
		repository.save(profe);

	}

	@Override
	public void actualizarProfesor(Profesores profe) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(profe);
	}

	@Override
	public void eliminarProfesor(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<Profesores> listarProfesores() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Profesores obtenerProfesorId(Integer id) {
		// TODO Auto-generated method stub
		return repository.getById(id);
	}

}
