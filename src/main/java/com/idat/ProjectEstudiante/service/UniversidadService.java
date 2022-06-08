package com.idat.ProjectEstudiante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.idat.ProjectEstudiante.model.Universidad;
import com.idat.ProjectEstudiante.repository.UniversidadRepository;


public class UniversidadService implements UniversidadServiceImpl {

	@Autowired
	private UniversidadRepository repository;
	
	@Override
	public void guardarUniversidad(Universidad malla) {
		// TODO Auto-generated method stub
		repository.save(malla);

	}

	@Override
	public void actualizarUniversidad(Universidad malla) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(malla);

	}

	@Override
	public void eliminarUniversidad(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);

	}

	@Override
	public List<Universidad> listarUniversidad() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Universidad obtenerUniversidadId(Integer id) {
		// TODO Auto-generated method stub
		return repository.getById(id);
	}

}
