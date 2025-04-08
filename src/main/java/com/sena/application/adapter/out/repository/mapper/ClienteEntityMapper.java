package com.sena.application.adapter.out.repository.mapper;

import com.sena.application.adapter.out.repository.entity.ClienteEntity;
import com.sena.application.core.domain.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteEntityMapper {

    ClienteEntityMapper INSTANCE = Mappers.getMapper(ClienteEntityMapper.class);

    Cliente toDomain(ClienteEntity clienteEntity);
    List<Cliente> toDomainList(List<ClienteEntity> clienteEntities);
    ClienteEntity toEntity(Cliente cliente);

}
