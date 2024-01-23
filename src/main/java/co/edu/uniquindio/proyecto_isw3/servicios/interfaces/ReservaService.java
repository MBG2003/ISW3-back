package co.edu.uniquindio.proyecto_isw3.servicios.interfaces;

import co.edu.uniquindio.proyecto_isw3.dto.ReservaDTO;
import co.edu.uniquindio.proyecto_isw3.dto.get.ReservaGetDTO;

import java.util.List;

public interface ReservaService {

    List<ReservaGetDTO> listar() throws Exception;

    List<ReservaGetDTO> listarPorAula(String idFacultad, String idAula) throws Exception;

    int agregar(ReservaDTO reservaDTO) throws Exception;

    ReservaGetDTO actualizar(ReservaDTO reservaDTO) throws Exception;

    int eliminar(int idReserva) throws Exception;
}
