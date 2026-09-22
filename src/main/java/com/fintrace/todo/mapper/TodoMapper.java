package com.fintrace.todo.mapper;

import com.fintrace.shared.adapters.BaseMapper;
import com.fintrace.todo.entity.TodoEntity;
import com.fintrace.todo.model.Todo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TodoMapper extends BaseMapper<Todo, TodoEntity> {
}
