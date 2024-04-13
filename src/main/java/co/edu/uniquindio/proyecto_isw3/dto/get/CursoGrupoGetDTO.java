package co.edu.uniquindio.proyecto_isw3.dto.get;

import co.edu.uniquindio.proyecto_isw3.modelo.Grupo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CursoGrupoGetDTO {

    private int idGrupo;

    private String nombre;

    private int cupos;

    private List<HorarioGrupoGetDTO> horario;
}
