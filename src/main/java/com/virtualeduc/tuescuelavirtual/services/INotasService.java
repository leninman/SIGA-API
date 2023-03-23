package com.virtualeduc.tuescuelavirtual.services;

import com.virtualeduc.tuescuelavirtual.models.*;
import com.virtualeduc.tuescuelavirtual.models.DTOS.AlumnoDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.NotaParDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.NotaWrapper;
import com.virtualeduc.tuescuelavirtual.models.DTOS.NotaWrapperPorLapso;

import java.util.List;

public interface INotasService {
	
	public Responses guardarNotasParciales(List<NotaParDTO> notas);

    public Responses actualizarNotasParciales(Long idAlumno,Long idMateria,Long idCurso,Float notaLapso1,Float notaLapso2,Float notaLapso3);
        
        public NotaParDTO guardarNotaParcial(NotaPar notaPar);
        
        public List<NotaWrapper> consultarNotasPorCedula(String tipoDoc, String numDoc);
        
        public List<NotaWrapper> consultarNotasPorCedulaYperiodo(String tipoDoc, String numDoc, String periodo);
        
        public List<NotaWrapper> consultarNotasPorCedulaPeriodoYlapso(String tipoDoc, String numDoc, String periodo, String lapso);
        
        public List<AnnioEscolar>  consultarPeriodos();
        
        public List<Lapso>  consultarLapsos();
        
        public List<Lapso>  consultarLapsosHabilitados(Long idMat,Long idCurso);
        
        public List<NotaWrapperPorLapso> consultarNotasPorCursoMateria(List<AlumnoDTO> alumnos, Long idMat, Long idCurso);


        public Long[] consultarNotasPorIdCurso(Long idCurso);

        

}
