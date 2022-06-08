package com.idat.ProjectEstudiante.service;

import java.util.List;


import com.idat.ProjectEstudiante.model.Universidad;

public interface UniversidadServiceImpl {

	void guardarUniversidad(Universidad malla);
	void actualizarUniversidad(Universidad malla);
	void eliminarUniversidad(Integer id);
	List<Universidad> listarUniversidad();
	Universidad obtenerUniversidadId(Integer id);
}
