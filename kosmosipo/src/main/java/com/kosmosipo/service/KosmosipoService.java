package com.kosmosipo.service;


import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.kosmosipo.entity.KosmosipoModel;
import com.kosmosipo.repository.KosmosipoRepository;




@Service
public class KosmosipoService {

	@Autowired
	private KosmosipoRepository repo;
	
	@CacheEvict(value="kosmosipo", allEntries=true)
	@Cacheable(value = "kosmosipo")
	@GetMapping("/all")
	public List<KosmosipoModel> getAll(){
		return repo.findAll();
	}
	
	@Cacheable(value = "kosmosipo")
	public List<KosmosipoModel> getAllKosmosipo(int pg, int tm){
		System.out.println(repo.findAll(PageRequest.of(pg, tm)).getContent().toString());
		return repo.findAll(PageRequest.of(pg, tm)).getContent();
		
	}

	@Cacheable(value = "kosmosipo", key = "#id")
	public KosmosipoModel getKosmosipoById(Long id) {
		return repo.findById(id).orElseThrow();
	}
	

	public List<KosmosipoModel> searchKosmosipoByNombre(String nombre) {
		return repo.findByNomoContaining(nombre);
	}
	
	public KosmosipoModel crearKosmosipo(KosmosipoModel kosmosipo) {
		return repo.save(kosmosipo);
	}
	
	@Cacheable(value = "kosmosipo", key = "#id")
	public KosmosipoModel updateKosmosipo(Long id, KosmosipoModel kosmosipo) {
		KosmosipoModel existeKosmosipo = getKosmosipoById(id);
		existeKosmosipo.setNomo(kosmosipo.getNomo());
		existeKosmosipo.setFilmoserio(kosmosipo.getFilmoserio());
		return repo.save(existeKosmosipo);
	}
	
	@Cacheable(value = "kosmosipo", key = "#id")
	public void deleteKosmosipo(Long id) {
		repo.deleteById(id);
	}
}
