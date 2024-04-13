package co.edu.uniquindio.proyecto_isw3.modelo.key;

import co.edu.uniquindio.proyecto_isw3.modelo.CursoGrupo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class HorarioGrupoKey implements Serializable {

    @ManyToOne
    @EqualsAndHashCode.Include
    @JoinColumns({
            @JoinColumn(name = "id_facultad", referencedColumnName = "id_facultad"),
            @JoinColumn(name = "id_programa", referencedColumnName = "id_programa"),
            @JoinColumn(name = "id_curso", referencedColumnName = "id_curso"),
            @JoinColumn(name = "id_grupo", referencedColumnName = "id_grupo")
    })
    private CursoGrupo grupo;

    @EqualsAndHashCode.Include
    @Column(name = "id_horario", nullable = false)
    private int idHorario;
}
