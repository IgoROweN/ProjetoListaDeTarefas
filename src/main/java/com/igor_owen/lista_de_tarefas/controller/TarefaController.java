package com.igor_owen.lista_de_tarefas.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.igor_owen.lista_de_tarefas.model.Tarefa;
import com.igor_owen.lista_de_tarefas.service.TarefaService;
import com.igor_owen.lista_de_tarefas.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    /**
     * Cria uma nova tarefa.
     * Retorna 201 Created com Location header apontando para /api/tarefas/{id}
     */
    @PostMapping
    public ResponseEntity<Tarefa> criarTarefa(@Valid @RequestBody Tarefa tarefa, UriComponentsBuilder uriBuilder) {
        Tarefa criada = tarefaService.criarTarefa(tarefa);
        URI location = uriBuilder.path("/api/tarefas/{id}").buildAndExpand(criada.getId()).toUri();
        return ResponseEntity.created(location).body(criada);
    }

    /**
     * Lista todas as tarefas.
     */
    @GetMapping
    public ResponseEntity<List<Tarefa>> listarTarefas() {
        List<Tarefa> lista = tarefaService.listarTarefas();
        return ResponseEntity.ok(lista);
    }

    /**
     * Busca uma tarefa por id.
     * Se não encontrada, lança ResourceNotFoundException (mapeado para 404).
     */
    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarPorId(@PathVariable Long id) {
        Optional<Tarefa> opt = tarefaService.buscarPorId(id);
        return opt.map(ResponseEntity::ok)
                  .orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada com id: " + id));
    }

    /**
     * Atualiza uma tarefa.
     * Substitui conteúdo da tarefa com os dados do request body.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable Long id, @Valid @RequestBody Tarefa tarefaAtualizada) {
        Tarefa atualizada = tarefaService.atualizarTarefa(id, tarefaAtualizada);
        return ResponseEntity.ok(atualizada);
    }

    /**
     * Deleta uma tarefa.
     * Retorna 204 No Content quando removida com sucesso.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
        tarefaService.deletarTarefa(id);
        return ResponseEntity.noContent().build();
    }
}