package com.idat.ProjectEstudiante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.idat.ProjectEstudiante.model.MallaCurricular;
import com.idat.ProjectEstudiante.repository.MallaRepository;


public class MallaService implements MallaServiceImpl {

	

	@Autowired
	private MallaRepository repository;
	
	@Override
	public void guardarMalla(MallaCurricular malla) {
		// TODO Auto-generated method stub
		repository.save(malla);

	}

	@Override
	public void actualizarMalla(MallaCurricular malla) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(malla);

	}

	@Override
	public void eliminarMalla(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);

	}

	@Override
	public List<MallaCurricular> listarMallas() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public MallaCurricular obtenerMallasId(Integer id) {
		// TODO Auto-generated method stub
		return repository.getById(id);
	}

}
