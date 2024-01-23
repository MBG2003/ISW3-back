package co.edu.uniquindio.proyecto_isw3.servicios.interfaces;

import co.edu.uniquindio.proyecto_isw3.dto.get.FacultadGetDTO;
import co.edu.uniquindio.proyecto_isw3.modelo.Facultad;

import java.util.List;

public interface FacultadService {

    List<FacultadGetDTO> listar() throws Exception;

    Facultad buscar(String idFacultad) throws Exception;
}
