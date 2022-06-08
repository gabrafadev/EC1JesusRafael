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

import com.idat.ProjectEstudiante.model.MallaCurricular;
import com.idat.ProjectEstudiante.service.MallaService;


@Controller
@RequestMapping( path = "/malla/v1")
public class MallaController {

	@Autowired
	private MallaService service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<MallaCurricular>>  listar() {
		
		return new ResponseEntity<List<MallaCurricular>>(service.listarMallas(), HttpStatus.OK) ;
	}
	
	@RequestMapping( path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody MallaCurricular malla) {
		service.guardarMalla(malla);
		return  new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
	

	@RequestMapping( path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {

		MallaCurricular p =service.obtenerMallasId(id);
		
		if(p != null) {
			service.eliminarMalla(id);
			return  new ResponseEntity<Void>(HttpStatus.OK);

		}
		
		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}
	
	
	@RequestMapping( path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody MallaCurricular malla) {

		MallaCurricular p =service.obtenerMallasId(malla.getIdMalla());
		
		if(p != null) {
			service.actualizarMalla(malla);
			return  new ResponseEntity<Void>(HttpStatus.OK);

		}
		
		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}
	
	
	@RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<MallaCurricular> obtenerId(@PathVariable Integer id) {

		MallaCurricular p =service.obtenerMallasId(id);
		
		if(p != null) {
			return  new ResponseEntity<MallaCurricular>(service.obtenerMallasId(id),HttpStatus.OK);

		}
		
		return  new ResponseEntity<MallaCurricular>(HttpStatus.NOT_FOUND);

	}
}
