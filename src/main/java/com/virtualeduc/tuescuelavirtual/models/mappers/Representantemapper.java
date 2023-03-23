package com.virtualeduc.tuescuelavirtual.models.mappers;

import com.virtualeduc.tuescuelavirtual.models.Alumno;
import com.virtualeduc.tuescuelavirtual.models.DTOS.AlumnoDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.RepresentanteDTO;
import com.virtualeduc.tuescuelavirtual.models.Representante;

public class Representantemapper {

    public Representante obtenerRepresentante1(AlumnoDTO alumnoDTO){
        Representante representante=new Representante();
        Representante rep = new Representante();
        rep.setTipoDocRpr(alumnoDTO.getTipoDocRep1());
        rep.setNumDocRpr(alumnoDTO.getNumDocRep1());
        rep.setPrimNombRpr(alumnoDTO.getPrimNombRpr1());
        rep.setSegNombRpr(alumnoDTO.getSegNombRpr1());
        rep.setPrimApellRpr(alumnoDTO.getPrimApellRpr1());
        rep.setSegApellRpr(alumnoDTO.getSegApellRpr1());

        rep.setSexoRpr(alumnoDTO.getSexoRpr1());
        rep.setFechNacRpr(alumnoDTO.getFechNacRpr1());

        rep.setEdadRpr(alumnoDTO.getEdadRpr1());
        rep.setEdoCivRpr(alumnoDTO.getEdoCivRpr1());
        //rep.setParentescoRpr(alumnoDTO.getParentescoRpr1());

        rep.setDirPpalRpr(alumnoDTO.getTextoDirPpalRpr1().concat(",").concat(alumnoDTO.getEstadodirppalrep1())
                .concat(",").concat(alumnoDTO.getMunicipiodirppalrep1()).concat(",")
                .concat(alumnoDTO.getCiudaddirppalrep1()).concat(",").concat(alumnoDTO.getParroquiadirppalrep1())
                .concat(",").concat(alumnoDTO.getCodpostaldirppalrep1()));

        if ((alumnoDTO.getTextoDirSecRpr1() != "" || alumnoDTO.getTextoDirSecRpr1() != null)
                && alumnoDTO.getEstadodirsecrep1() != null && alumnoDTO.getMunicipiodirsecrep1() != null
                && alumnoDTO.getCiudaddirsecrep1() != null && alumnoDTO.getParroquiadirsecrep1() != null) {
            rep.setDirSecRpr(alumnoDTO.getTextoDirSecRpr1().concat(",").concat(alumnoDTO.getEstadodirsecrep1())
                    .concat(",").concat(alumnoDTO.getMunicipiodirsecrep1()).concat(",")
                    .concat(alumnoDTO.getCiudaddirsecrep1()).concat(",").concat(alumnoDTO.getParroquiadirsecrep1())
                    .concat(",").concat(alumnoDTO.getCodpostaldirsecrep1()));
        } else {
            rep.setDirSecRpr(rep.getDirPpalRpr());
        }

        rep.setTlfPpalRpr(alumnoDTO.getCodoperadorappalrep1().concat("-").concat(alumnoDTO.getTextoTlfPpalRpr1()));

        if (alumnoDTO.getCodoperadorasecrep1() != null
                && alumnoDTO.getTextoTlfSecRpr1() != "") {
            rep.setTlfSecRpr(alumnoDTO.getCodoperadorasecrep1().concat("-").concat(alumnoDTO.getTextoTlfSecRpr1()));
        } else {
            rep.setTlfSecRpr(rep.getTlfPpalRpr());
        }

        rep.setEmailRpr(alumnoDTO.getEmailRpr1());

        return rep;
    }
    public Representante obtenerRepresentante2(AlumnoDTO alumnoDTO){
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
