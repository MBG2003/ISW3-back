package co.edu.uniquindio.proyecto_isw3.servicios.interfaces;

import co.edu.uniquindio.proyecto_isw3.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto_isw3.modelo.Usuario;

public interface UsuarioService {

    Usuario buscar(String documento) throws Exception;

    String crear(UsuarioDTO usuarioDTO) throws Exception;

    String consultarNombreUsuario(String documento) throws Exception;
}
