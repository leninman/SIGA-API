package com.tecnodestreza.siga.models.mappers;

import com.tecnodestreza.siga.models.Representante;
import com.tecnodestreza.siga.models.DTOS.AlumnoDTO;

import java.util.function.Function;

public class AlumnoDtoToRepresentanteMapper implements Function<AlumnoDTO, Representante> {
    @Override
    public Representante apply(AlumnoDTO alumnoDTO) {
        Representante representante=new Representante();
        Representante rep = new Representante();
        rep.setTipoDocRpr(alumnoDTO.getTipoDocRep2());
        rep.setNumDocRpr(alumnoDTO.getNumDocRep2());
        rep.setPrimNombRpr(alumnoDTO.getPrimNombRpr2());
        rep.setSegNombRpr(alumnoDTO.getSegNombRpr2());
        rep.setPrimApellRpr(alumnoDTO.getPrimApellRpr2());
        rep.setSegApellRpr(alumnoDTO.getSegApellRpr2());

        rep.setSexoRpr(alumnoDTO.getSexoRpr2());
        rep.setFechNacRpr(alumnoDTO.getFechNacRpr2());

        rep.setEdadRpr(alumnoDTO.getEdadRpr2());
        rep.setEdoCivRpr(alumnoDTO.getEdoCivRpr2());
        //rep.setParentescoRpr(alumnoDTO.getParentescoRpr2());

        rep.setDirPpalRpr(alumnoDTO.getTextoDirPpalRpr2().concat(",").concat(alumnoDTO.getEstadodirppalrep2())
                .concat(",").concat(alumnoDTO.getMunicipiodirppalrep2()).concat(",")
                .concat(alumnoDTO.getCiudaddirppalrep2()).concat(",").concat(alumnoDTO.getParroquiadirppalrep2())
                .concat(",").concat(alumnoDTO.getCodpostaldirppalrep2()));

        if ((alumnoDTO.getTextoDirSecRpr2() != "" || alumnoDTO.getTextoDirSecRpr2() != null)
                && alumnoDTO.getEstadodirsecrep2() != null && alumnoDTO.getMunicipiodirsecrep2() != null
                && alumnoDTO.getCiudaddirsecrep2() != null && (alumnoDTO.getParroquiadirsecrep2() != null)
                && alumnoDTO.getCodpostaldirsecrep2() != null) {
            rep.setDirSecRpr(alumnoDTO.getTextoDirSecRpr2().concat(",").concat(alumnoDTO.getEstadodirsecrep2())
                    .concat(",").concat(alumnoDTO.getMunicipiodirsecrep2()).concat(",")
                    .concat(alumnoDTO.getCiudaddirsecrep2()).concat(",").concat(alumnoDTO.getParroquiadirsecrep2())
                    .concat(",").concat(alumnoDTO.getCodpostaldirsecrep2()));
        } else {
            rep.setDirSecRpr(rep.getDirPpalRpr());
        }

        rep.setTlfPpalRpr(alumnoDTO.getCodoperadorappalrep2().concat("-").concat(alumnoDTO.getTextoTlfPpalRpr2()));

        if (alumnoDTO.getCodoperadorasecrep2() != null
                && (alumnoDTO.getTextoTlfSecRpr2() != "" || alumnoDTO.getTextoTlfSecRpr2() != null)) {
            rep.setTlfSecRpr(alumnoDTO.getCodoperadorasecrep2().concat("-").concat(alumnoDTO.getTextoTlfSecRpr2()));
        } else {
            rep.setTlfSecRpr(rep.getTlfPpalRpr());
        }

        rep.setEmailRpr(alumnoDTO.getEmailRpr2());

        return rep;
    }
}
