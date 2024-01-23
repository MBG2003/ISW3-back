package co.edu.uniquindio.proyecto_isw3.controlador;

import co.edu.uniquindio.proyecto_isw3.dto.MensajeDTO;
import co.edu.uniquindio.proyecto_isw3.dto.ReservaDTO;
import co.edu.uniquindio.proyecto_isw3.dto.get.ReservaGetDTO;
import co.edu.uniquindio.proyecto_isw3.servicios.interfaces.ReservaService;
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
@RequestMapping("/reserva")
@Validated
@CrossOrigin("*")
@AllArgsConstructor
public class ReservaController {

    private ReservaService reservaService;

    private MessageSource ms;

    @GetMapping("/listar")
    public ResponseEntity<MensajeDTO> listar() throws Exception {
        List<ReservaGetDTO> reservas = reservaService.listar();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO(HttpStatus.OK, false, ms.getMessage("reserva.lista", null, LocaleContextHolder.getLocale()), reservas));
    }

    @GetMapping("/listarPorAula")
    public ResponseEntity<MensajeDTO> listarPorAula(@RequestParam String idFacultad, @RequestParam String idAula) throws Exception {
        List<ReservaGetDTO> reservas = reservaService.listarPorAula(idFacultad, idAula);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO(HttpStatus.OK, false, ms.getMessage("reserva.lista", null, LocaleContextHolder.getLocale()), reservas));
    }

    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crear(@RequestBody @Valid ReservaDTO reservaDTO) throws Exception {
        int reserva = reservaService.agregar(reservaDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO(HttpStatus.OK, false, ms.getMessage("reserva.creado", new Object[]{reserva}, LocaleContextHolder.getLocale()), reserva));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<MensajeDTO> actualizar(@RequestBody @Valid ReservaDTO reservaDTO) throws Exception {
        ReservaGetDTO reserva = reservaService.actualizar(reservaDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO(HttpStatus.OK, false, ms.getMessage("reserva.actualizado", new Object[]{reserva.getIdReserva()}, LocaleContextHolder.getLocale()), reserva));
    }

    @DeleteMapping("/eliminar/{idReserva}")
    public ResponseEntity<MensajeDTO> eliminar(@PathVariable int idReserva) throws Exception {
        int reserva = reservaService.eliminar(idReserva);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO(HttpStatus.OK, false, ms.getMessage("reserva.eliminado", new Object[]{reserva}, LocaleContextHolder.getLocale()), reserva));
    }
}
