package com.tecnodestreza.siga.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlumnoTest {

    @Test
    void tipoDocumentoTest() {
        Alumno alumno=new Alumno();
        alumno.setTipoDocumento("V");
        assertEquals("V",alumno.getTipoDocumento());
    }
}