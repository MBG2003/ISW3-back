package co.edu.uniquindio.proyecto_isw3.modelo;

import co.edu.uniquindio.proyecto_isw3.modelo.key.AulaCursoKey;
import co.edu.uniquindio.proyecto_isw3.modelo.key.AulaKey;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalTime;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "aula_curso")
public class AulaCurso implements Serializable {

    @EmbeddedId
    private AulaCursoKey key;

    @Column(nullable = false)
    private DiaSemana dia;

    @Column(nullable = false)
    private int horaInicio;

    @Column(nullable = false)
    private int horaFin;
}
