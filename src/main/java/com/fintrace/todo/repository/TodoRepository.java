package com.fintrace.todo.repository;

import com.fintrace.todo.model.Todo;

public interface TodoRepository {
    Todo save(Todo todo);
    void deleteById(Long id);
}
