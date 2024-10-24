package com.kosmosipo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kosmosipo.entity.KosmosipoModel;

import jakarta.persistence.TypedQuery;

@Repository
public interface KosmosipoRepository extends JpaRepository<KosmosipoModel, Long>{
	
//	@Query("SELECT k FROM KosmosipoModel k WHERE k.nomo LIKE CONCAT ('%', :nomo, '%'")
//	//public Optional<KosmosipoModel> findByNomoContaining(@Param("nombre") String nombre);
//	List<KosmosipoModel> findByNomoContaining(String nomo);
	
	
	@Query("SELECT k FROM KosmosipoModel k where LOWER(k.nomo) like LOWER(concat ('%', :nomo, '%'))")
	List<KosmosipoModel> findByNomoContaining(String nomo);
	
	@Transactional(readOnly = true)
	List<KosmosipoModel> findAll();
}
