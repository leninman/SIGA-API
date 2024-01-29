package com.tecnodestreza.siga.models.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




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
