package com.sena.application.config;

import com.sena.application.core.port.in.*;
import com.sena.application.core.port.out.AtualizaClienteOutputPort;
import com.sena.application.core.port.out.BuscaClientesOutputPort;
import com.sena.application.core.port.out.CadastraClienteOutputPort;
import com.sena.application.core.port.out.DeletaClienteOutPort;
import com.sena.application.core.service.ClienteService;
import com.sena.application.core.usecase.AtualizaClienteUseCase;
import com.sena.application.core.usecase.BuscaClientesUseCase;
import com.sena.application.core.usecase.CadastraClienteUseCase;
import com.sena.application.core.usecase.DeletaClienteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CadastroClienteConfig {

    @Bean
    public ClienteInputPort clienteService(CadastraClienteInputPort cadastraClienteInputPort,
                                           DeletaClienteInputPort deletaClienteInputPort,
                                           BuscaClientesInputPort buscaClientesInputPort,
                                           AtualizaClienteInputPort atualizaClienteInputPort) {
        return new ClienteService(
                cadastraClienteInputPort,
                deletaClienteInputPort,
                buscaClientesInputPort,
                atualizaClienteInputPort);
    }
    @Bean
    public CadastraClienteInputPort cadastraClienteInputPort(CadastraClienteOutputPort cadastraClienteOutPort){
        return new CadastraClienteUseCase(cadastraClienteOutPort);
    }
    @Bean
    public DeletaClienteInputPort deletaClienteInputPort(DeletaClienteOutPort deletaClienteOutPort){
        return new DeletaClienteUseCase(deletaClienteOutPort);
    }
    @Bean
    public BuscaClientesInputPort buscaClientesInputPort(BuscaClientesOutputPort buscaClientesOutPort) {
        return new BuscaClientesUseCase(buscaClientesOutPort);
    }

    @Bean
    public AtualizaClienteInputPort atualizaClienteInputPort(AtualizaClienteOutputPort atualizaClienteOutputPort) {
        return new AtualizaClienteUseCase(atualizaClienteOutputPort);
    }


}
