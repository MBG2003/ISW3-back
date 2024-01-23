package co.edu.uniquindio.proyecto_isw3.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
public class SesionDTO {

    @NotEmpty(message = "{usuario.documento.vacio}")
    @Length(max = 10, message = "{usuario.documento.tamax}")
    private String documento;

    @NotEmpty(message = "{usuario.contrasenia.vacio}")
    @Length(max = 50, message = "{usuario.contrasenia.tamax}")
    private String contrasenia;
}
