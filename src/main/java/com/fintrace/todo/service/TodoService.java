package com.fintrace.todo.service;

import com.fintrace.todo.model.Todo;

public interface TodoService {
    Todo createTodo(String title);
    void deleteTodo(Long id);
}
