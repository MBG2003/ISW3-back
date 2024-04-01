package co.edu.uniquindio.proyecto_isw3.modelo;

import co.edu.uniquindio.proyecto_isw3.modelo.key.HorarioGrupoKey;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class HorarioGrupo implements Serializable {

    @EmbeddedId
    private HorarioGrupoKey key;

    @Column(nullable = false)
    private DiaSemana diaSemana;

    @Column(nullable = false)
    private int horaInicio;

    @Column(nullable = false)
    private int horaFin;

}
