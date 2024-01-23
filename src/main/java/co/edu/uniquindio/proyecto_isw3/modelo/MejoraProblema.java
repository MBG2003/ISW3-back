package co.edu.uniquindio.proyecto_isw3.modelo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MejoraProblema implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSolicitud;

    @Column(nullable = false, length = 2000)
    private String descripcion;

    @Column(nullable = false, length = 1000)
    private String observaciones;

    @Column(nullable = false)
    private EstadoSolicitud estado;

    @ManyToOne
    @JoinColumn(name = "emisor", referencedColumnName = "id_usuario")
    private Usuario emisor;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "id_facultad", referencedColumnName = "id_facultad"),
            @JoinColumn(name = "id_aula", referencedColumnName = "id_aula")})
    private Aula aula;
}
