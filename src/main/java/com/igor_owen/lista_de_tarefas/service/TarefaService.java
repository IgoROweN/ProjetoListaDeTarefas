package com.igor_owen.lista_de_tarefas.service;

import com.igor_owen.lista_de_tarefas.model.Tarefa;

import java.util.List;
import java.util.Optional;

public interface TarefaService {
    Tarefa criarTarefa(Tarefa tarefa);
    List<Tarefa> listarTarefas();
    Optional<Tarefa> buscarPorId(Long id);
    Tarefa atualizarTarefa(Long id, Tarefa tarefaAtualizada);
    void deletarTarefa(Long id);
}