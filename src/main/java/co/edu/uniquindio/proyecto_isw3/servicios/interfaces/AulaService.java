package co.edu.uniquindio.proyecto_isw3.servicios.interfaces;

import co.edu.uniquindio.proyecto_isw3.dto.AulaDTO;
import co.edu.uniquindio.proyecto_isw3.dto.get.AulaGetDTO;
import co.edu.uniquindio.proyecto_isw3.dto.get.ReservaGetDTO;
import co.edu.uniquindio.proyecto_isw3.modelo.Aula;
import co.edu.uniquindio.proyecto_isw3.modelo.DiaSemana;

import java.util.List;

public interface AulaService {

    List<AulaGetDTO> listar() throws Exception;

    List<AulaGetDTO> listarPorFacultad(String idFacultad) throws Exception;

    String crear(AulaDTO aulaDTO) throws Exception;

    AulaGetDTO actualizar(AulaDTO aulaDTO) throws Exception;

    String eliminar(String idFacultad, String idAula) throws Exception;

    Aula buscar(String idFacultad, String idAula) throws Exception;

    List<AulaGetDTO> listarPorHorario(int diaSemana, int horaInicio, int horaFin) throws Exception;
}
