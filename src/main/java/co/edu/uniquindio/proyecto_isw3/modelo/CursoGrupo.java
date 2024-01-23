package co.edu.uniquindio.proyecto_isw3.modelo;

import co.edu.uniquindio.proyecto_isw3.modelo.key.CursoGrupoKey;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CursoGrupo implements Serializable {

    @EmbeddedId
    private CursoGrupoKey key;

    @Column(nullable = false)
    private int cupos;
}
