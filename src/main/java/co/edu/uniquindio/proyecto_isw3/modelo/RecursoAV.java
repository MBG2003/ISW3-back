package co.edu.uniquindio.proyecto_isw3.modelo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

public enum RecursoAV {

    COMPUTADORA(1),
    VIDEOBEAM(2);

    private int idRecurso;

    RecursoAV(int idRecurso) {
        this.idRecurso = idRecurso;
    }

    public int getIdRecurso() {
        return this.idRecurso;
    }
}
