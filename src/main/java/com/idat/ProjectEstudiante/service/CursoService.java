package com.idat.ProjectEstudiante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.idat.ProjectEstudiante.model.Cursos;
import com.idat.ProjectEstudiante.repository.CursoRepository;


public class CursoService implements CursoServiceImpl {

	
	@Autowired
	private CursoRepository repository;
	
	@Override
	public void guardarCurso(Cursos curso) {
		// TODO Auto-generated method stub
		repository.save(curso);
	}

	@Override
	public void actualizarCurso(Cursos curso) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(curso);
	}

	@Override
	public void eliminarCurso(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<Cursos> listarCursos() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Cursos obtenerCursosId(Integer id) {
		// TODO Auto-generated method stub
		return repository.getById(id);
	}

}
