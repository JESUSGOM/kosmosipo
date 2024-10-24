package com.kosmosipo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.kosmosipo.entity.KosmosipoModel;
import com.kosmosipo.service.KosmosipoService;

@RestController
@RequestMapping(path = "/api/flota")
public class KosmosipoController {

	@Autowired
	private KosmosipoService service;
	
	@GetMapping(path = "all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> all() {
		return ResponseEntity.ok(this.service.getAll());		
	}
	

	@GetMapping("/listadogeneral")
	public ResponseEntity<List<?>> getAllKosmosipo(@RequestParam int pg, @RequestParam int tm){
		List<String> sincontenido = new ArrayList<String>();
		sincontenido.add("Listado vacío");
		if(tm>pg) {
			return ResponseEntity.ok(sincontenido);
		}
			return ResponseEntity.ok(service.getAllKosmosipo(pg, tm));
		
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/search")
	public ResponseEntity<List<?>> searchKosmosipoByNombre(@RequestParam String nombre){
		List<String> sincontenido = new ArrayList<String>();
		sincontenido.add("Listado vacío");
		if(nombre == "") {
			return ResponseEntity.ok(sincontenido);
		} else {
			return ResponseEntity.ok(service.searchKosmosipoByNombre(nombre));
		}
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/porid")
	public ResponseEntity<?> buscarporId(@RequestParam Long id){
		List<String> sincontenido = new ArrayList<String>();
		sincontenido.add("Listado vacío");
		if(id == 0 || id < 0) {
			return ResponseEntity.ok(sincontenido);
		} else {
			return ResponseEntity.ok(service.getKosmosipoById(id));
		}
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping
	public ResponseEntity<?> crearKosmosipo(@RequestBody KosmosipoModel kosmosipo){
		List<String> sincontenido = new ArrayList<String>();
		sincontenido.add("Listado vacío");
		if(kosmosipo == null) {
			return ResponseEntity.ok(sincontenido);
		} else {
			return ResponseEntity.ok(service.crearKosmosipo(kosmosipo));
		}
	}
	
	@SuppressWarnings("unchecked")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteKosmosipo(@PathVariable Long id){
		List<String> sincontenido = new ArrayList<String>();
		sincontenido.add("Listado vacío");
		if(id == 0 || id < 0) {
			return ResponseEntity.ok(sincontenido);
		} else {
			service.deleteKosmosipo(id);
			return ResponseEntity.noContent().build();
		}
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/generalpaginado")
	public ResponseEntity<?> generalPaginado(@RequestParam Integer pg, @RequestParam Integer tm){
		List<String> sincontenido = new ArrayList<String>();
		sincontenido.add("Listado vacío");
		if(tm<pg) {
			return ResponseEntity.ok(sincontenido);
		} else {
			return ResponseEntity.ok(service.getAllKosmosipo(pg, tm));
		}
	}
	
}
