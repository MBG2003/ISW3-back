package co.edu.uniquindio.proyecto_isw3.servicios.interfaces;

import co.edu.uniquindio.proyecto_isw3.dto.SolicitudDTO;
import co.edu.uniquindio.proyecto_isw3.dto.get.SolicitudGetDTO;

import java.util.List;

public interface MejoraProblemaService {

    List<SolicitudGetDTO> listar() throws Exception;

    int agregar(SolicitudDTO solicitudDTO) throws Exception;

    SolicitudGetDTO actualizar(SolicitudDTO solicitudDTO) throws Exception;

    int eliminar(int idSolicitud) throws Exception;
}