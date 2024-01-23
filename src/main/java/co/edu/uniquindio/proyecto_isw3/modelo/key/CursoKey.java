package co.edu.uniquindio.proyecto_isw3.modelo.key;

import co.edu.uniquindio.proyecto_isw3.modelo.Programa;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CursoKey implements Serializable {

    @EqualsAndHashCode.Include
    @Column(name = "id_curso", nullable = false, length = 10)
    private String idCurso;

    @ManyToOne
    @EqualsAndHashCode.Include
    @JoinColumns({
            @JoinColumn(name = "id_facultad", referencedColumnName = "id_facultad"),
            @JoinColumn(name = "id_programa", referencedColumnName = "id_programa")
    })
    private Programa programa;
}
