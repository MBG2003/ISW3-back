package co.edu.uniquindio.proyecto_isw3.servicios.impl;

import co.edu.uniquindio.proyecto_isw3.dto.SesionDTO;
import co.edu.uniquindio.proyecto_isw3.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto_isw3.modelo.Usuario;
import co.edu.uniquindio.proyecto_isw3.seguridad.TokenUtils;
import co.edu.uniquindio.proyecto_isw3.servicios.interfaces.SesionService;
import co.edu.uniquindio.proyecto_isw3.servicios.interfaces.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class SesionServiceImpl implements SesionService {

    private UsuarioService usuarioService;

    private MessageSource ms;

    @Override
    @Transactional(readOnly = true)
    public String login(SesionDTO sesionDTO) throws Exception {
        Usuario usuario = usuarioService.buscar(sesionDTO.getDocumento());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(usuario == null) {
            throw new Exception(ms.getMessage("usuario.no.encontrado", new Object[]{sesionDTO.getDocumento()}, LocaleContextHolder.getLocale()));
        }
        if(!encoder.matches(sesionDTO.getContrasenia(), usuario.getContrasenia())) {
            throw new Exception(ms.getMessage("usuario.contrasenia.incorrecta", null, LocaleContextHolder.getLocale()));
        }
        return TokenUtils.getJWTToken(usuario);
    }

    @Override
    @Transactional
    public String registrar(UsuarioDTO usuarioDTO) throws Exception {
        return usuarioService.crear(usuarioDTO);
    }

}
