package com.idat.ProjectEstudiante.service;

import java.util.List;

import com.idat.ProjectEstudiante.model.Cursos;


public interface CursoServiceImpl {

	void guardarCurso(Cursos curso);
	void actualizarCurso(Cursos curso);
	void eliminarCurso(Integer id);
	List<Cursos> listarCursos();
	Cursos obtenerCursosId(Integer id);
}
