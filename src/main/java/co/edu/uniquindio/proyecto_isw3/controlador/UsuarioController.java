package co.edu.uniquindio.proyecto_isw3.controlador;

import co.edu.uniquindio.proyecto_isw3.dto.MensajeDTO;
import co.edu.uniquindio.proyecto_isw3.servicios.interfaces.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@Validated
@CrossOrigin("*")
@AllArgsConstructor
public class UsuarioController {

    private UsuarioService usuarioService;

    private MessageSource ms;

    @GetMapping("/consultaNombreUsuario/{documento}")
    public ResponseEntity<MensajeDTO> consultaNombreUsuario(@PathVariable String documento) throws Exception {
        String nombre = usuarioService.consultarNombreUsuario(documento);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO(HttpStatus.OK, false, ms.getMessage("usuario.nombre.encontrado", new Object[]{documento}, LocaleContextHolder.getLocale()), nombre));
    }
}
