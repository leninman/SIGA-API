package com.tecnodestreza.siga.models.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDocumentodto {
    @NotEmpty
    private String tipoDocumento;
    @NotEmpty
    private String numeroDocumento;
}
