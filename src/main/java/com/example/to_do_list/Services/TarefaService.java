package com.example.to_do_list.Services;

import com.example.to_do_list.Entity.Tarefa;
import com.example.to_do_list.Repositories.TarefaRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {
    private TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public List<Tarefa> create(Tarefa tarefa){
        tarefaRepository.save(tarefa);
        return list();
    }
    public List<Tarefa> list(){
        Sort sort = Sort.by("prioridade").descending().and(
                Sort.by("nome").ascending());
        return tarefaRepository.findAll(sort);
    }
    public List<Tarefa> update(Tarefa tarefa){
        tarefaRepository.save(tarefa);
        return list();
    }
    public List<Tarefa> delete(Long id){
        tarefaRepository.deleteById(null);
        return list();
    }
}
