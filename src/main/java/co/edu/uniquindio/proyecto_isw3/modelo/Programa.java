package co.edu.uniquindio.proyecto_isw3.modelo;

import co.edu.uniquindio.proyecto_isw3.modelo.key.ProgramaKey;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Programa implements Serializable {

    @EmbeddedId
    private ProgramaKey key;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 250)
    private String descripcion;

    @OneToMany(mappedBy = "key.programa")
    private List<Curso> cursos;
}
