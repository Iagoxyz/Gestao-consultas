package tech.build.consultas.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.build.consultas.controller.dto.PacienteDTO;
import tech.build.consultas.controller.dto.PacienteResponseDTO;
import tech.build.consultas.controller.dto.PacienteUpdateDTO;
import tech.build.consultas.entities.Paciente;
import tech.build.consultas.repositories.PacienteRepository;
import tech.build.consultas.service.PacienteService;

import java.net.URI;


@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public ResponseEntity<Void> criarPaciente(@RequestBody PacienteDTO pacienteDTO) {
        Paciente novoPaciente = pacienteService.salvarPaciente(pacienteDTO);
        return ResponseEntity.created(URI.create("/pacientes/" + novoPaciente.getPacienteId())).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> buscarPaciente(@PathVariable Long id) {
        PacienteResponseDTO paciente = pacienteService.buscarPorId(id);
        return ResponseEntity.ok(paciente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPaciente(@PathVariable Long id) {
        pacienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> atualizarPaciente(
            @PathVariable Long id,
            @RequestBody PacienteUpdateDTO dto
    ) {
        PacienteResponseDTO atualizado = pacienteService.atualizar(id, dto);
        return ResponseEntity.ok(atualizado);
    }
}