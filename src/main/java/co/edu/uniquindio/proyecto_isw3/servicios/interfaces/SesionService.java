package co.edu.uniquindio.proyecto_isw3.servicios.interfaces;

import co.edu.uniquindio.proyecto_isw3.dto.SesionDTO;
import co.edu.uniquindio.proyecto_isw3.dto.UsuarioDTO;

public interface SesionService {

    String login(SesionDTO sesionDTO) throws Exception;

    String registrar(UsuarioDTO usuarioDTO) throws Exception;
}