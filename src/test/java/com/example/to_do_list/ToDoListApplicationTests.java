package com.example.to_do_list;

import com.example.to_do_list.Entity.Tarefa;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ToDoListApplicationTests {
	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testCreateTarefaSucess() {
		var tarefa = new Tarefa("tarefa 1", "desc tarefa 1", false, 1);

		webTestClient
				.post()
				.uri("tarefas")
				.bodyValue(tarefa)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$.length").isEqualTo(1)
				.jsonPath("$[0].nome").isEqualTo(tarefa.getNome())
				.jsonPath("$[0].descricao").isEqualTo(tarefa.getDescricao())
				.jsonPath("$[0].realizado").isEqualTo(tarefa.getRealizado())
				.jsonPath("$[0].prioridade").isEqualTo(tarefa.getPrioridade());


	}

	@Test
	void testCreateTarefaFailure() {
		webTestClient
				.post()
				.uri("tarefas")
				.bodyValue(
						new Tarefa("", "",false, 0))
				.exchange()
				.expectStatus().isBadRequest();
	}

}
