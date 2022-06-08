package com.idat.ProjectEstudiante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idat.ProjectEstudiante.model.Cursos;
import com.idat.ProjectEstudiante.service.CursoService;



@Controller
@RequestMapping( path = "/curso/v1")
public class CursoController {

	@Autowired
	private CursoService service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<Cursos>>  listar() {
		
		return new ResponseEntity<List<Cursos>>(service.listarCursos(), HttpStatus.OK) ;
	}
	
	@RequestMapping( path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Cursos cursos) {
		service.guardarCurso(cursos);
		return  new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
	

	@RequestMapping( path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {

		Cursos p =service.obtenerCursosId(id);
		
		if(p != null) {
			service.eliminarCurso(id);
			return  new ResponseEntity<Void>(HttpStatus.OK);

		}
		
		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}
	
	
	@RequestMapping( path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody Cursos cursos) {

		Cursos p =service.obtenerCursosId(cursos.getIdCurso());
		
		if(p != null) {
			service.actualizarCurso(cursos);
			return  new ResponseEntity<Void>(HttpStatus.OK);

		}
		
		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}
	
	
	@RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cursos> obtenerId(@PathVariable Integer id) {

		Cursos p =service.obtenerCursosId(id);
		
		if(p != null) {
			return  new ResponseEntity<Cursos>(service.obtenerCursosId(id),HttpStatus.OK);

		}
		
		return  new ResponseEntity<Cursos>(HttpStatus.NOT_FOUND);

	}
}