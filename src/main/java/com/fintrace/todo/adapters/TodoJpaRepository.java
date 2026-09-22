package com.fintrace.todo.adapters;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fintrace.todo.entity.TodoEntity;
import com.fintrace.todo.model.Todo;

public interface TodoJpaRepository extends JpaRepository<TodoEntity, Long> {
    Todo save(Todo todo);

    @Override
    void deleteById(Long id);
}
