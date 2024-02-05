package co.edu.uniquindio.proyecto_isw3.servicios.impl;

import co.edu.uniquindio.proyecto_isw3.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto_isw3.modelo.Usuario;
import co.edu.uniquindio.proyecto_isw3.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto_isw3.servicios.interfaces.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepo usuarioRepo;

    private MessageSource ms;

    @Override
    @Transactional(readOnly = true)
    public Usuario buscar(String documento) throws Exception {
        validar(documento);
        return usuarioRepo.findById(documento).get();
    }

    @Override
    @Transactional
    public String crear(UsuarioDTO usuarioDTO) throws Exception {
        Usuario usuario = convertir(usuarioDTO);
        return usuarioRepo.save(usuario).getDocumento();
    }

    @Override
    @Transactional(readOnly = true)
    public String consultarNombreUsuario(String documento) throws Exception {
        validar(documento);
        return usuarioRepo.findById(documento).get().getNombre();
    }

    private Usuario convertir(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();

        usuario.setDocumento(usuarioDTO.getDocumento());
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setContrasenia(usuario.getContrasenia());

        return usuario;
    }

    private void validar(String documento) throws Exception {
        if(!usuarioRepo.existsById(documento)) {
            throw new Exception(ms.getMessage("usuario.no.encontrado", new Object[]{documento}, LocaleContextHolder.getLocale()));
        }
    }
}
