package com.fintrace.todo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Pure Domain Object for Todo.
 * Uses Lombok to reduce boilerplate, which is perfectly fine in Clean Architecture.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Todo {
    private Long id;
    private String title;
    private boolean completed;

    public static Todo create(String title) {
        return Todo.builder()
                .title(title)
                .completed(false)
                .build();
    }
}
