package co.edu.uniquindio.proyecto_isw3.modelo.key;

import co.edu.uniquindio.proyecto_isw3.modelo.Aula;
import co.edu.uniquindio.proyecto_isw3.modelo.CursoGrupo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AulaCursoKey implements Serializable {

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "id_facu_aula", referencedColumnName = "id_facultad"),
            @JoinColumn(name = "id_aula", referencedColumnName = "id_aula")
    })
    private Aula aula;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "id_facu_curso", referencedColumnName = "id_facultad"),
            @JoinColumn(name = "id_prog_curso", referencedColumnName = "id_programa"),
            @JoinColumn(name = "id_curso", referencedColumnName = "id_curso"),
            @JoinColumn(name = "id_grupo", referencedColumnName = "id_grupo")
    })
    private CursoGrupo cursoGrupo;
}
