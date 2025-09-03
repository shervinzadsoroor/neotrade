package com.neotrade.infrastructure.persistence.mapper;

import com.neotrade.domain.model.BaseDomain;
import com.neotrade.infrastructure.persistence.entity.BaseEntity;

public abstract class BaseMapper<D extends BaseDomain, E extends BaseEntity> {

    void setupBaseFieldsOnEntity(D source, E target) {
        target.setId(source.getId());
        target.setVersion(source.getVersion());
        target.setCreatedDate(source.getCreatedDate());
        target.setModifiedDate(source.getModifiedDate());
    }

    void setupBaseFieldsOnDomain(E source, D target) {
        target.setId(source.getId());
        target.setVersion(source.getVersion());
        target.setCreatedDate(source.getCreatedDate());
        target.setModifiedDate(source.getModifiedDate());
    }

    abstract D toDomain(E e);

    abstract E toEntity(D d);
}
