package com.fintrace.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter // Generates getters for all fields cleanly
@Setter // Generates setters for all fields cleanly
@NoArgsConstructor // Mandatory: Hibernate requires a public/protected no-argument constructor
@AllArgsConstructor // Optional: Only if you want to use the Builder pattern
@Builder // Optional: Clean syntax for object creation (e.g., TodoEntity.builder()...)
public class User {
    private Long id;
    private String name;
    private String email;

    public static User createUser(String name, String email) {
        return User.builder().name(name).email(email).build();
    }

    // CRUCIAL: Custom equals and hashCode (Do NOT use @EqualsAndHashCode)
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof User other)) {
            return false;
        }
        // If the ID isn't saved yet (null), fallback to standard object reference check
        return id != null && id.equals(other.getId());
    }

    @Override
    public int hashCode() {
        // Must be a constant value to prevent the entity from "disappearing" from Sets
        // after saving
        return getClass().hashCode();
    }

    // CRUCIAL: Custom or targeted toString to prevent StackOverflowError loop
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
