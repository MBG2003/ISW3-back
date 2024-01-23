package co.edu.uniquindio.proyecto_isw3.modelo;

import co.edu.uniquindio.proyecto_isw3.modelo.key.AulaKey;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "aula")
public class Aula implements Serializable {

    @EmbeddedId
    private AulaKey key;

    @Column(nullable = false, length = 30)
    private String nombre;

    @Column(nullable = false)
    private int capacidad;

    @Column(nullable = false)
    private EstadoAula estado;

    @ElementCollection(targetClass = RecursoAV.class)
    @CollectionTable(name = "aula_recurso",
            joinColumns = {
                    @JoinColumn(name = "id_facultad", referencedColumnName = "id_facultad"),
                    @JoinColumn(name = "id_aula", referencedColumnName = "id_aula")})
    @Enumerated(EnumType.ORDINAL)
    private Set<RecursoAV> recursosAV;

    @ManyToMany(mappedBy = "aulas")
    private List<Curso> cursos;

    @OneToMany(mappedBy = "aula")
    private List<MejoraProblema> solicitudes;

    @OneToMany(mappedBy = "key.aula")
    private List<AulaCurso> horario;

    @OneToMany(mappedBy = "aula")
    private List<ReservaAula> reservas;
}
