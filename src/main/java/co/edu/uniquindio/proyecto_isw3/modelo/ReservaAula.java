package co.edu.uniquindio.proyecto_isw3.modelo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ReservaAula implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReserva;

    @Column(nullable = false, length = 30)
    private String asunto;

    @Column(nullable = false, length = 2000)
    private String descripcion;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;

    @Column(nullable = false)
    private int horaInicio;

    @Column(nullable = false)
    private int horaFin;

    @Column(nullable = false)
    private EstadoSolicitud estado;

    @Column(nullable = false, length = 1000)
    private String observaciones;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "id_facultad", referencedColumnName = "id_facultad"),
            @JoinColumn(name = "id_aula", referencedColumnName = "id_aula")
    })
    private Aula aula;

    @ManyToOne
    @JoinColumn(name = "emisor", referencedColumnName = "id_usuario")
    private Usuario emisor;
}
