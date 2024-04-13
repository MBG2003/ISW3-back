package co.edu.uniquindio.proyecto_isw3.dto.get;

import co.edu.uniquindio.proyecto_isw3.modelo.DiaSemana;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class HorarioGrupoGetDTO {

    private int idHorario;

    private int diaSemana;

    private int horaInicio;

    private int horaFin;


}
