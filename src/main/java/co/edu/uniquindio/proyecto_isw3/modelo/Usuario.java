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
public class Usuario implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id_usuario", nullable = false, length = 10)
    private String documento;

    @Column(nullable = false, length = 30)
    private String nombre;


    @Column(nullable = false, length = 200)
    private String contrasenia;

    @Column(nullable = false)
    private Rol rol;

    @OneToMany(mappedBy = "docente")
    private List<Curso> cursos;

    @OneToMany(mappedBy = "emisor")
    private List<MejoraProblema> solicitudes;

    @OneToMany(mappedBy = "emisor")
    private List<ReservaAula> reservas;
}
