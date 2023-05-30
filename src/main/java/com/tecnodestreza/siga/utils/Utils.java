package com.tecnodestreza.siga.utils;



import com.tecnodestreza.siga.models.Lapso;
import com.tecnodestreza.siga.repo.ILapsoRepo;

import java.util.Optional;

public class Utils {
	
	static String porcentajeNota;

	private static ILapsoRepo lapsoRepo = null;

	public Utils(ILapsoRepo lapsoRepo) {
		this.lapsoRepo = lapsoRepo;
	}


	public static String calcularPorcentajeNota(String nota,String valor) {

		Optional<Lapso> lapsoOptional=lapsoRepo.findLapsoByValor(valor);

		String porcentaje=lapsoOptional.get().getPorcentaje();

		Float porcentajeNota= (float) ((Integer.valueOf(nota))*(Integer.valueOf(porcentaje)));

		return porcentajeNota.toString();
	}
        










        
        public static Float calcularPorcentajeNota(Float nota,Float rate){
        
           return nota*rate/100;
        
        }


}
