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

import com.idat.ProjectEstudiante.model.Profesores;
import com.idat.ProjectEstudiante.service.ProfesorService;



@Controller
@RequestMapping("/profesor/v1")
public class ProfesorController {

	@Autowired
	public ProfesorService service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<Profesores>> listar() {
		return new ResponseEntity<List<Profesores>>(service.listarProfesores(),HttpStatus.OK);

	}
	
	@RequestMapping( path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Profesores profe) {
		service.guardarProfesor(profe);
		return  new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
	

	@RequestMapping( path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {

		Profesores p =service.obtenerProfesorId(id);
		
		if(p != null) {
			service.eliminarProfesor(id);
			return  new ResponseEntity<Void>(HttpStatus.OK);

		}
		
		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}
	
	
	@RequestMapping( path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody Profesores profe) {

		Profesores p =service.obtenerProfesorId(profe.getIdProfesor());
		
		if(p != null) {
			service.actualizarProfesor(profe);
			return  new ResponseEntity<Void>(HttpStatus.OK);

		}
		
		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}
	
	
	@RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Profesores> obtenerId(@PathVariable Integer id) {

		Profesores p =service.obtenerProfesorId(id);
		
		if(p != null) {
			return  new ResponseEntity<Profesores>(service.obtenerProfesorId(id),HttpStatus.OK);

		}
		
		return  new ResponseEntity<Profesores>(HttpStatus.NOT_FOUND);

	}

}