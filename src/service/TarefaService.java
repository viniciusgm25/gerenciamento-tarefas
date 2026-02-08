package com.vinicius.tarefas.service;

import com.vinicius.tarefas.dto.TarefaRequestDTO;
import com.vinicius.tarefas.dto.TarefaResponseDTO;
import com.vinicius.tarefas.model.Tarefa;
import com.vinicius.tarefas.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TarefaService {

    private final TarefaRepository repository;

    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }

    public List<TarefaResponseDTO> listar() {
        return repository.findAll()
                .stream()
                .map(t -> new TarefaResponseDTO(
                        t.getId(),
                        t.getTitulo(),
                        t.getDescricao(),
                        t.isConcluida()
                ))
                .collect(Collectors.toList());
    }

    public TarefaResponseDTO criar(TarefaRequestDTO dto) {
        Tarefa tarefa = new Tarefa(dto.getTitulo(), dto.getDescricao());
        Tarefa salva = repository.save(tarefa);

        return new TarefaResponseDTO(
                salva.getId(),
                salva.getTitulo(),
                salva.getDescricao(),
                salva.isConcluida()
        );
    }

    public void concluir(Long id) {
        Tarefa tarefa = repository.findById(id).orElseThrow();
        tarefa.setConcluida(true);
        repository.save(tarefa);
    }
}
