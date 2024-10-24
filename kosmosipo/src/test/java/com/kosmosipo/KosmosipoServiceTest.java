package com.kosmosipo;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.kosmosipo.entity.KosmosipoModel;
import com.kosmosipo.service.KosmosipoService;

public class KosmosipoServiceTest {
	
	@Test
	public void test1() {
		KosmosipoService servicio = new KosmosipoService();
		final List<KosmosipoModel> resultado = (List<KosmosipoModel>) servicio.getKosmosipoById(1L);
		
		Assertions.assertTrue(true);
		Assertions.assertFalse(false);
		Assertions.fail();
		
	}

}
