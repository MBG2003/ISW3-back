package co.edu.uniquindio.proyecto_isw3.modelo.key;

import co.edu.uniquindio.proyecto_isw3.modelo.Facultad;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProgramaKey implements Serializable {

    @EqualsAndHashCode.Include
    @Column(name = "id_programa", nullable = false, length = 10)
    private String idPrograma;

    @ManyToOne
    @EqualsAndHashCode.Include
    @JoinColumn(name = "id_facultad", referencedColumnName = "id_facultad")
    private Facultad facultad;
}
