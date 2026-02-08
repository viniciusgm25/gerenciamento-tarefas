package com.vinicius.tarefas.controller;

import com.vinicius.tarefas.dto.TarefaRequestDTO;
import com.vinicius.tarefas.dto.TarefaResponseDTO;
import com.vinicius.tarefas.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService service;

    public TarefaController(TarefaService service) {
        this.service = service;
    }

    @GetMapping
    public List<TarefaResponseDTO> listar() {
        return service.listar();
    }

    @PostMapping
    public TarefaResponseDTO criar(
            @RequestBody @Valid TarefaRequestDTO dto) {
        return service.criar(dto);
    }

    @PutMapping("/{id}/concluir")
    public void concluir(@PathVariable Long id) {
        service.concluir(id);
    }

    @Operation(summary = "Listar tarefas")
    @GetMapping
    public List<TarefaResponseDTO> listar() {
        return service.listar();
    }
    
    @Operation(summary = "Criar nova tarefa")
    @PostMapping
    public TarefaResponseDTO criar(
            @RequestBody @Valid TarefaRequestDTO dto) {
        return service.criar(dto);
    }
    
    @Operation(summary = "Marcar tarefa como concluída")
    @PutMapping("/{id}/concluir")
    public void concluir(@PathVariable Long id) {
        service.concluir(id);
    }

}
