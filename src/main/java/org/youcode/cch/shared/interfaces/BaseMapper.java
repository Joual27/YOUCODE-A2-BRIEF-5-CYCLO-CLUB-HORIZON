package org.youcode.cch.shared.interfaces;


public interface BaseMapper<E , D> {
    E toEntity(D dto);
    D entityToDto(E entity);
}
