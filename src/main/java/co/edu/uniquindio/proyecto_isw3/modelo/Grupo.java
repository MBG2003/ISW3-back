package co.edu.uniquindio.proyecto_isw3.modelo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Grupo implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id_grupo", nullable = false)
    private int idGrupo;

    @Column(nullable = false, length = 10)
    private String nombre;

    @OneToMany(mappedBy = "key.grupo")
    private List<CursoGrupo> cursos;
}
