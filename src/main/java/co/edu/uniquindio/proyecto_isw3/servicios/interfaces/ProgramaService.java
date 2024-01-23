package co.edu.uniquindio.proyecto_isw3.servicios.interfaces;

import co.edu.uniquindio.proyecto_isw3.dto.get.ProgramaGetDTO;
import co.edu.uniquindio.proyecto_isw3.modelo.Programa;

import java.util.List;

public interface ProgramaService {

    List<ProgramaGetDTO> listar() throws Exception;

    List<ProgramaGetDTO> listarPorFacultad(String idFacultad) throws Exception;

    Programa buscar(String idFacultad, String idPrograma) throws Exception;
}
