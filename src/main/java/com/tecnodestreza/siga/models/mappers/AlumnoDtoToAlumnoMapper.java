package com.tecnodestreza.siga.models.mappers;

import com.tecnodestreza.siga.models.Alumno;
import com.tecnodestreza.siga.models.DTOS.AlumnoDTO;

import java.util.function.Function;

public class AlumnoDtoToAlumnoMapper implements Function<AlumnoDTO,Alumno> {
   @Override
   public Alumno apply(AlumnoDTO alumnoDTO) {
      Alumno alumno=new Alumno();
      alumno.setIdAl(alumnoDTO.getIdAl());
      alumno.setTipoDocAl(alumnoDTO.getTipoDocAl());
      alumno.setNumDocAl(alumnoDTO.getNumDocAl());
      alumno.setPrimNombAl(alumnoDTO.getPrimNombAl());
      alumno.setSegNombAl(alumnoDTO.getSegNombAl());
      alumno.setPrimApellAl(alumnoDTO.getPrimApellAl());
      alumno.setSegApellAl(alumnoDTO.getSegApellAl());
      alumno.setSexoAl(alumnoDTO.getSexoAl());
      alumno.setFechNacAl(alumnoDTO.getFechNacAl());
      alumno.setEdadAl(alumnoDTO.getEdadAl());
      alumno.setDirPpalAl(alumnoDTO.getTextoDirPpalAl().concat(",").concat(alumnoDTO.getEstadodirppalest()).concat(",")
              .concat(alumnoDTO.getMunicipiodirppalest()).concat(",").concat(alumnoDTO.getCiudaddirppalest())
              .concat(",").concat(alumnoDTO.getParroquiadirppalest()).concat(",")
              .concat(alumnoDTO.getCodpostaldirppalest()));
      if (alumnoDTO.getTextoDirSecAl() != "" && alumnoDTO.getEstadodirsecest() != null && alumnoDTO.getMunicipiodirsecest() != null
              && alumnoDTO.getCiudaddirsecest() != null && alumnoDTO.getParroquiadirsecest() != null
              && alumnoDTO.getCodpostaldirsecest() != null) {
         alumno.setDirSecAl(alumnoDTO.getTextoDirSecAl().concat(",").concat(alumnoDTO.getEstadodirsecest()).concat(",")
                 .concat(alumnoDTO.getMunicipiodirsecest()).concat(",").concat(alumnoDTO.getCiudaddirsecest())
                 .concat(",").concat(alumnoDTO.getParroquiadirsecest()).concat(",")
                 .concat(alumnoDTO.getCodpostaldirsecest()));
      } else {
         alumno.setDirSecAl(alumno.getDirPpalAl());
      }
      alumno.setTlfPpalAl(alumnoDTO.getCodoperadorappalest().concat("-").concat(alumnoDTO.getTextoTlfPpalAl()));

      if (alumnoDTO.getCodoperadorasecest() != null
              && alumnoDTO.getTextoTlfSecAl() != "") {
         alumno.setTlfSecAl(alumnoDTO.getCodoperadorasecest().concat("-").concat(alumnoDTO.getTextoTlfSecAl()));
      } else {
         alumno.setTlfSecAl(alumno.getTlfPpalAl());
      }
      alumno.setEmailAl(alumnoDTO.getEmailAl());
      alumno.setFechIngAl(alumnoDTO.getFechIngAl());
      alumno.setStatus(alumnoDTO.getStatus());
      alumno.setParRpr1(alumnoDTO.getParRpr1());
      alumno.setParRpr2(alumnoDTO.getParRpr2());
      return alumno;
   }
}
