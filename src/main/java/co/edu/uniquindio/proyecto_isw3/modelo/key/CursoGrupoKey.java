package co.edu.uniquindio.proyecto_isw3.modelo.key;

import co.edu.uniquindio.proyecto_isw3.modelo.Curso;
import co.edu.uniquindio.proyecto_isw3.modelo.Grupo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CursoGrupoKey implements Serializable {

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "id_facultad", referencedColumnName = "id_facultad"),
            @JoinColumn(name = "id_programa", referencedColumnName = "id_programa"),
            @JoinColumn(name = "id_curso", referencedColumnName = "id_curso")
    })
    private Curso curso;

    @Enumerated(EnumType.STRING)
    private Grupo grupo;
}
