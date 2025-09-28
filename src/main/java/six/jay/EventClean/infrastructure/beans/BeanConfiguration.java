package six.jay.EventClean.infrastructure.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import six.jay.EventClean.core.gateway.EventoGateway;
import six.jay.EventClean.core.useCases.CriarEventoUseCase;
import six.jay.EventClean.core.useCases.CriarEventoUseCaseImpl;

@Configuration
public class BeanConfiguration {

    @Bean
    public CriarEventoUseCase criarEventoUseCase(EventoGateway eventoGateway){
        return  new CriarEventoUseCaseImpl(eventoGateway);
    }
}
