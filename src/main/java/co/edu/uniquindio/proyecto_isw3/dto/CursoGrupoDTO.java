package co.edu.uniquindio.proyecto_isw3.dto;

import co.edu.uniquindio.proyecto_isw3.modelo.Grupo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CursoGrupoDTO {

    private int idGrupo;

    private int cupos;

    private List<HorarioGrupoDTO> horario;
}
