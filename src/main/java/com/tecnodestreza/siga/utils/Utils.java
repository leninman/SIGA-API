package com.tecnodestreza.siga.utils;



import com.tecnodestreza.siga.models.Lapso;
import com.tecnodestreza.siga.repo.ILapsoRepo;

import java.util.Optional;

public class Utils {
	
	static String porcentajeNota;

	private static ILapsoRepo lapsoRepo;

	public Utils(ILapsoRepo lapsoRepo) {
		this.lapsoRepo = lapsoRepo;
	}


	public static String calcularPorcentajeNota(String nota,String valor) {

		Float porcentajeNota= (float) (((Integer.valueOf(nota))*(Integer.valueOf(valor))))/100;

		return porcentajeNota.toString();
	}
        










        
        public static Float calcularPorcentajeNota(Float nota,Float rate){
        
           return nota*rate/100;
        
        }


}
