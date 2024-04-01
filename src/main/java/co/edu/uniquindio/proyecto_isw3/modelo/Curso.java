package co.edu.uniquindio.proyecto_isw3.modelo;

import co.edu.uniquindio.proyecto_isw3.modelo.key.CursoKey;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Curso implements Serializable {

    @EmbeddedId
    private CursoKey key;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 3)
    private String pensum;

    @Column(nullable = false)
    private int creditos;

    @Column(nullable = false)
    private int horas;

    @Column(nullable = false)
    private int nivel;

    @OneToMany(mappedBy = "key.curso")
    private List<CursoGrupo> grupos;

    @OneToMany(mappedBy = "key.curso")
    private List<AulaCurso> horario;

    @ManyToOne
    @JoinColumn(name = "id_docente", referencedColumnName = "id_usuario")
    private Usuario docente;

    @ManyToMany
    @JoinTable(name = "aula_curso",
            joinColumns = {
                    @JoinColumn(name = "id_facu_curso", referencedColumnName = "id_facultad"),
                    @JoinColumn(name = "id_prog_curso", referencedColumnName = "id_programa"),
                    @JoinColumn(name = "id_curso", referencedColumnName = "id_curso")},
            inverseJoinColumns = {
                    @JoinColumn(name = "id_facu_aula", referencedColumnName = "id_facultad"),
                    @JoinColumn(name = "id_aula", referencedColumnName = "id_aula")})
    private List<Aula> aulas;

    @ElementCollection(targetClass = RecursoAV.class)
    @CollectionTable(name = "curso_recurso",
            joinColumns = {
                    @JoinColumn(name = "id_facu_curso", referencedColumnName = "id_facultad"),
                    @JoinColumn(name = "id_prog_curso", referencedColumnName = "id_programa"),
                    @JoinColumn(name = "id_curso", referencedColumnName = "id_curso")})
    @Enumerated(EnumType.ORDINAL)
    private Set<RecursoAV> recursos;
}
