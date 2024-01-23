package co.edu.uniquindio.proyecto_isw3.controlador;

import co.edu.uniquindio.proyecto_isw3.dto.MensajeDTO;
import co.edu.uniquindio.proyecto_isw3.dto.get.ProgramaGetDTO;
import co.edu.uniquindio.proyecto_isw3.servicios.interfaces.ProgramaService;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/programa")
@Validated
@CrossOrigin("*")
@AllArgsConstructor
public class ProgramaController {

    private ProgramaService programaService;

    private MessageSource ms;

    @GetMapping("/listar")
    public ResponseEntity<MensajeDTO> listar() throws Exception {
        List<ProgramaGetDTO> programas = programaService.listar();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO(HttpStatus.OK, false, ms.getMessage("programa.lista", null, LocaleContextHolder.getLocale()), programas));
    }

    @GetMapping("/listarPorFacultad/{idFacultad}")
    public ResponseEntity<MensajeDTO> listarPorFacultad(@PathVariable String idFacultad) throws Exception {
        List<ProgramaGetDTO> programas = programaService.listarPorFacultad(idFacultad);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new MensajeDTO(HttpStatus.OK, false, ms.getMessage("programa.lista", null, LocaleContextHolder.getLocale()), programas));
    }
}
