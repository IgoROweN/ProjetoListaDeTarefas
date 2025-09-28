package com.igor_owen.lista_de_tarefas.repository;

import com.igor_owen.lista_de_tarefas.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    // aqui podemos criar métodos customizados se precisar
}
