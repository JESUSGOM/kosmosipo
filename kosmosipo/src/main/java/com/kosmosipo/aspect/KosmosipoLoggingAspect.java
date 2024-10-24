package com.kosmosipo.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class KosmosipoLoggingAspect {

	 @AfterReturning("execution(* com.example.kosmosiposervice.service.KosmosipoService.getKosmosipoeById(..)) && args(id)")
	    public void logNegativeId(Long id) {
	        if (id < 0) {
	            System.out.println("Se solicitó un kosmosipo con ID negativo: " + id);
	        }
	    }
}