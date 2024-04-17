package co.edu.uniquindio.proyecto_isw3.controlador;

import co.edu.uniquindio.proyecto_isw3.dto.AulaDTO;
import co.edu.uniquindio.proyecto_isw3.dto.MensajeDTO;
import co.edu.uniquindio.proyecto_isw3.dto.get.AulaGetDTO;
import co.edu.uniquindio.proyecto_isw3.dto.get.ProgramaGetDTO;
import co.edu.uniquindio.proyecto_isw3.dto.get.ReservaGetDTO;
import co.edu.uniquindio.proyecto_isw3.modelo.DiaSemana;
import co.edu.uniquindio.proyecto_isw3.servicios.interfaces.AulaService;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/aula")
@Validated
@CrossOrigin("*")
@AllArgsConstructor
public class AulaController {

    private AulaService aulaService;

    private MessageSource ms;

    @GetMapping("/listar")
    public ResponseEntity<MensajeDTO> listar() throws Exception {
        List<AulaGetDTO> aulas = aulaService.listar();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO(HttpStatus.OK, false, ms.getMessage("aula.lista", null, LocaleContextHolder.getLocale()), aulas));
    }

    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crear(@RequestBody @Valid AulaDTO aulaDTO) throws Exception {
        String aulaId = aulaService.crear(aulaDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO(HttpStatus.OK, false, ms.getMessage("aula.creada", new Object[]{aulaId}, LocaleContextHolder.getLocale()), aulaId));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<MensajeDTO> actualizar(@RequestBody @Valid AulaDTO aulaDTO) throws Exception {
        AulaGetDTO aula = aulaService.actualizar(aulaDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO(HttpStatus.OK, false, ms.getMessage("aula.actualizada", new Object[]{aula.getIdAula()}, LocaleContextHolder.getLocale()), aula));
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<MensajeDTO> eliminar(@RequestParam String idFacultad, @RequestParam String idAula) throws Exception {
        String aulaId = aulaService.eliminar(idFacultad, idAula);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO(HttpStatus.OK, false, ms.getMessage("aula.eliminada", new Object[]{aulaId}, LocaleContextHolder.getLocale()), aulaId));
    }

    @GetMapping("/listarPorFacultad/{idFacultad}")
    public ResponseEntity<MensajeDTO> listarPorFacultad(@PathVariable String idFacultad) throws Exception {
        List<AulaGetDTO> aulas = aulaService.listarPorFacultad(idFacultad);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO(HttpStatus.OK, false, ms.getMessage("aula.lista", null, LocaleContextHolder.getLocale()), aulas));
    }

    @GetMapping("/listarPorHorario")
    public ResponseEntity<MensajeDTO> listarPorHorario(@RequestParam int diaSemana, @RequestParam int horaInicio, @RequestParam int horaFin) throws Exception {
        List<AulaGetDTO> aulas = aulaService.listarPorHorario(diaSemana, horaInicio, horaFin);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO(HttpStatus.OK, false, ms.getMessage("aula.lista", null, LocaleContextHolder.getLocale()), aulas));
    }
}
