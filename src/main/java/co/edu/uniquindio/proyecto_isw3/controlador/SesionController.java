package co.edu.uniquindio.proyecto_isw3.controlador;

import co.edu.uniquindio.proyecto_isw3.dto.MensajeDTO;
import co.edu.uniquindio.proyecto_isw3.dto.SesionDTO;
import co.edu.uniquindio.proyecto_isw3.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto_isw3.servicios.interfaces.SesionService;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/sesion")
@Validated
@CrossOrigin("*")
@AllArgsConstructor
public class SesionController {

    private SesionService sesionService;

    private MessageSource ms;

    @PostMapping("/login")
    public ResponseEntity<MensajeDTO> login(@RequestBody @Valid SesionDTO sesionDTO) throws Exception {
        String token = sesionService.login(sesionDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO(HttpStatus.OK, false, ms.getMessage("usuario.autenticado", new Object[]{sesionDTO.getDocumento()}, LocaleContextHolder.getLocale()), token));
    }
}
