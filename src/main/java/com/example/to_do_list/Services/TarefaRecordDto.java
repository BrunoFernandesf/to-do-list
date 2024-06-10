package com.example.to_do_list.Services;

import org.antlr.v4.runtime.misc.NotNull;

public record TarefaRecordDto(@NotNull String name, @NotNull String descricao, @NotNull boolean realizado, @NotNull int prioridade) {
}
