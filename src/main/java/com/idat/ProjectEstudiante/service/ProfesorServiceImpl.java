package com.idat.ProjectEstudiante.service;

import java.util.List;

import com.idat.ProjectEstudiante.model.Profesores;

public interface ProfesorServiceImpl {

	void guardarProfesor(Profesores profe);
	void actualizarProfesor(Profesores profe);
	void eliminarProfesor(Integer id);
	List<Profesores> listarProfesores();
	Profesores obtenerProfesorId(Integer id);
}
