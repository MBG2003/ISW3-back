package co.edu.uniquindio.proyecto_isw3.dto.get;

import co.edu.uniquindio.proyecto_isw3.modelo.TipoRecursoAV;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RecursoGetDTO {

    private int idRecurso;

    private String marca;

    private String referencia;

    private TipoRecursoAV tipo;
}
