package com.sena.application.adapter.in.controller.mapper;

import com.sena.application.adapter.in.controller.dto.ClienteDTO;
import com.sena.application.core.domain.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteDTOMapper {

    ClienteDTOMapper INSTANCE = Mappers.getMapper(ClienteDTOMapper.class);

    Cliente toDomain(ClienteDTO clienteDto);
    ClienteDTO toDto(Cliente cliente);

    List<ClienteDTO> toDtoList(List<Cliente> clientes);
}
