package com.kosmosipo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="kosmosipo")
public class KosmosipoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="nomo", nullable = false, length = 100 )
	private String nomo;
	
	@Column(name="filmoserio", nullable = false, length = 75 )
	private String filmoserio;

	
	
	//Getter y setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomo() {
		return nomo;
	}

	public void setNomo(String nomo) {
		this.nomo = nomo;
	}

	public String getFilmoserio() {
		return filmoserio;
	}

	public void setFilmoserio(String filmoserio) {
		this.filmoserio = filmoserio;
	}
	
	
	
	

}
