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


import com.idat.ProjectEstudiante.model.Universidad;
import com.idat.ProjectEstudiante.service.UniversidadService;



@Controller
@RequestMapping("/profesor/v1")
public class UniversidadController {

	@Autowired
	public UniversidadService service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<Universidad>> listar() {
		return new ResponseEntity<List<Universidad>>(service.listarUniversidad(),HttpStatus.OK);

	}
	
	@RequestMapping( path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Universidad uni) {
		service.guardarUniversidad(uni);
		return  new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
	

	@RequestMapping( path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {

		Universidad p =service.obtenerUniversidadId(id);
		
		if(p != null) {
			service.eliminarUniversidad(id);
			return  new ResponseEntity<Void>(HttpStatus.OK);

		}
		
		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}
	
	
	@RequestMapping( path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody Universidad uni) {

		Universidad p =service.obtenerUniversidadId(uni.getIdUniversidad());
		
		if(p != null) {
			service.actualizarUniversidad(uni);
			return  new ResponseEntity<Void>(HttpStatus.OK);

		}
		
		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}
	
	
	@RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Universidad> obtenerId(@PathVariable Integer id) {

		Universidad p =service.obtenerUniversidadId(id);
		
		if(p != null) {
			return  new ResponseEntity<Universidad>(service.obtenerUniversidadId(id),HttpStatus.OK);

		}
		
		return  new ResponseEntity<Universidad>(HttpStatus.NOT_FOUND);

	}

}