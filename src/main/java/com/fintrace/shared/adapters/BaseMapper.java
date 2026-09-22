package com.fintrace.shared.adapters;

import java.util.List;

import org.mapstruct.MappingTarget;

/**
 * Generic base mapper interface for MapStruct.
 * Do NOT annotate this interface with @Mapper.
 * Instead, annotate each concrete subinterface with @Mapper(componentModel = "spring").
 *
 * @param <D> Domain model type
 * @param <E> JPA Entity type
 */
public interface BaseMapper<D, E> {

    // Map a single Domain Model to an Entity
    E mapToEntity(D domain);

    // Map a single Entity to a Domain Model
    D mapToDomain(E entity);

    // Map a List of Domain Models to a List of Entities
    List<E> mapToEntityList(List<D> domainList);

    // Map a List of Entities to a List of Domain Models
    List<D> mapToDomainList(List<E> entityList);

    // Update an existing entity instance with changes from a domain model (useful for PUT/PATCH)
    void updateEntityFromDomain(D domain, @MappingTarget E entity);
}
