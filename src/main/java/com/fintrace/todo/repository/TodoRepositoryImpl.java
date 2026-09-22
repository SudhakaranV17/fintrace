package com.fintrace.todo.repository;

import org.springframework.stereotype.Repository;

import com.fintrace.todo.adapters.TodoJpaRepository;
import com.fintrace.todo.entity.TodoEntity;
import com.fintrace.todo.mapper.TodoMapper;
import com.fintrace.todo.model.Todo;

@Repository
public class TodoRepositoryImpl implements TodoRepository {

    private final TodoJpaRepository todoJpaRepository;
    private final TodoMapper mapper;

    public TodoRepositoryImpl(TodoJpaRepository todoJpaRepository, TodoMapper mapper) {
        this.todoJpaRepository = todoJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Todo save(Todo todo) {
        TodoEntity entity = mapper.mapToEntity(todo);
        TodoEntity savedEntity = todoJpaRepository.save(entity);
        return mapper.mapToDomain(savedEntity);
    }

    @Override
    public void deleteById(Long id) {
        todoJpaRepository.deleteById(id);
    }
}
