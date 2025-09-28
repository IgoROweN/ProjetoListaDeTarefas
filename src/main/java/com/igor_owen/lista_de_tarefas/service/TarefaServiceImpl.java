package com.igor_owen.lista_de_tarefas.service;

import com.igor_owen.lista_de_tarefas.exception.ResourceNotFoundException;
import com.igor_owen.lista_de_tarefas.model.Tarefa;
import com.igor_owen.lista_de_tarefas.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaServiceImpl implements TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaServiceImpl(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    @Override
    public Tarefa criarTarefa(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    @Override
    public List<Tarefa> listarTarefas() {
        return tarefaRepository.findAll();
    }

    @Override
    public Optional<Tarefa> buscarPorId(Long id) {
        return tarefaRepository.findById(id);
    }

    @Override
    public Tarefa atualizarTarefa(Long id, Tarefa tarefaAtualizada) {
        return tarefaRepository.findById(id)
                .map(tarefa -> {
                    tarefa.setNome(tarefaAtualizada.getNome());
                    tarefa.setDescricao(tarefaAtualizada.getDescricao());
                    tarefa.setStatus(tarefaAtualizada.getStatus());
                    tarefa.setObservacoes(tarefaAtualizada.getObservacoes());
                    return tarefaRepository.save(tarefa);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada com id: " + id));
    }

    @Override
    public void deletarTarefa(Long id) {
        if (!tarefaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Tarefa não encontrada com id: " + id);
        }
        tarefaRepository.deleteById(id);
    }
}
