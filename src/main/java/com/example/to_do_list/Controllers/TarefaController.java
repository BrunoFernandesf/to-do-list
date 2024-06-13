package com.example.to_do_list.Controllers;

import com.example.to_do_list.Entity.Tarefa;
import com.example.to_do_list.Repositories.TarefaRepository;
import com.example.to_do_list.Services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService){
        this.tarefaService = tarefaService;
    }

    @PostMapping
    List<Tarefa> create(@RequestBody Tarefa tarefa){
        return tarefaService.create(tarefa);
    }

    @GetMapping
    List<Tarefa> list(){
        return tarefaService.list();
    }

    @PutMapping
    List<Tarefa> update(@RequestBody Tarefa tarefa){
        return tarefaService.update(tarefa);
    }

    @DeleteMapping("{id}")
    List<Tarefa> delete(@PathVariable("id") Long id){
        return tarefaService.delete(id);
    }

}
