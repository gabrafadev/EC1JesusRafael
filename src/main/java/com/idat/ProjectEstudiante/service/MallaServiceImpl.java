package com.idat.ProjectEstudiante.service;

import java.util.List;

import com.idat.ProjectEstudiante.model.MallaCurricular;

public interface MallaServiceImpl {

	void guardarMalla(MallaCurricular malla);
	void actualizarMalla(MallaCurricular malla);
	void eliminarMalla(Integer id);
	List<MallaCurricular> listarMallas();
	MallaCurricular obtenerMallasId(Integer id);
}
