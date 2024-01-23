package co.edu.uniquindio.proyecto_isw3.controlador;

import co.edu.uniquindio.proyecto_isw3.dto.MensajeDTO;
import co.edu.uniquindio.proyecto_isw3.dto.SolicitudDTO;
import co.edu.uniquindio.proyecto_isw3.dto.get.SolicitudGetDTO;
import co.edu.uniquindio.proyecto_isw3.servicios.interfaces.MejoraProblemaService;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/mejoraProblema")
@Validated
@CrossOrigin("*")
@AllArgsConstructor
public class SolicitudController {

    private MejoraProblemaService mpService;

    private MessageSource ms;

    @GetMapping("/listar")
    public ResponseEntity<MensajeDTO> listar() throws Exception {
        List<SolicitudGetDTO> solicitudes = mpService.listar();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO(HttpStatus.OK, false, ms.getMessage("mejora.problema.lista", null, LocaleContextHolder.getLocale()), solicitudes));
    }

    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crear(@RequestBody @Valid SolicitudDTO solicitudDTO) throws Exception {
        int idSolicitud = mpService.agregar(solicitudDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO(HttpStatus.OK, false, ms.getMessage("mejora.problema.creado", new Object[]{idSolicitud}, LocaleContextHolder.getLocale()), idSolicitud));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<MensajeDTO> actualizar(@RequestBody @Valid SolicitudDTO solicitudDTO) throws Exception {
        SolicitudGetDTO solicitud = mpService.actualizar(solicitudDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO(HttpStatus.OK, false, ms.getMessage("mejora.problema.actualizado", new Object[]{solicitud.getIdSolicitud()}, LocaleContextHolder.getLocale()), solicitud));
    }

    @DeleteMapping("/eliminar/{idSolicitud}")
    public ResponseEntity<MensajeDTO> eliminar(@PathVariable int idSolicitud) throws Exception {
        int idSolicitudDeleted = mpService.eliminar(idSolicitud);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO(HttpStatus.OK, false, ms.getMessage("mejora.problema.eliminado", new Object[]{idSolicitudDeleted}, LocaleContextHolder.getLocale()), idSolicitudDeleted));
    }
}
