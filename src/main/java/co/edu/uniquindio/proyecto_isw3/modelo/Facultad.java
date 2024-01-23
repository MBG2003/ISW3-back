package co.edu.uniquindio.proyecto_isw3.modelo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Facultad implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id_facultad", nullable = false, length = 20)
    private String idFacultad;

    @Column(nullable = false, length = 30)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String descripcion;

    @OneToMany(mappedBy = "key.facultad")
    private List<Programa> programas;

    @OneToMany(mappedBy = "key.facultad")
    private List<Aula> aulas;
}
