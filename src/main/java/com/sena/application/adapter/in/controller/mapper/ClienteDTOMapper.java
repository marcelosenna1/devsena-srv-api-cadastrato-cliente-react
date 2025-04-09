package com.sena.application.adapter.in.controller.mapper;

import com.sena.application.adapter.in.controller.dto.request.ClienteRequest;
import com.sena.application.adapter.in.controller.dto.response.ClienteResponse;
import com.sena.application.core.domain.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteDTOMapper {

    ClienteDTOMapper INSTANCE = Mappers.getMapper(ClienteDTOMapper.class);

    Cliente toDomain(ClienteRequest clienteRequest);
    ClienteResponse toResponse(Cliente cliente);

    List<ClienteResponse> toResponseList(List<Cliente> clientes);
}
