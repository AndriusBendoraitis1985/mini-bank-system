package andrius.bendoraitis.mini.bank.system.rests.mapper;

import andrius.bendoraitis.mini.bank.system.entities.BaseEntity;

import java.util.Collection;
import java.util.List;

public interface BaseMapper<E extends BaseEntity, D> {

    E toEntity(D dto);

    D toDto(E entity);

    default List<E> toEntities(Collection<D> dtos) {
        return dtos.stream()
                .map(this::toEntity)
                .toList();
    }

    default List<D> toDtos(Collection<E> entities) {
        return entities.stream()
                .map(this::toDto)
                .toList();
    }

}
