package six.jay.EventClean.infrastructure.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import six.jay.EventClean.core.gateway.EventoGateway;
import six.jay.EventClean.core.useCases.*;

@Configuration
public class BeanConfiguration {

    @Bean
    public CriarEventoUseCase criarEventoUseCase(EventoGateway eventoGateway){
        return new CriarEventoUseCaseImpl(eventoGateway);
    }

    @Bean
    public ListarEventosUseCase listarEventosUseCase(EventoGateway eventoGateway){
        return new ListarEventoUseCaseImpl(eventoGateway);
    }

    @Bean
    public FiltrarIdentificadorEventoUseCase filtrarIdentificadorEventoUseCase(EventoGateway eventoGateway){
        return new FiltrarIdentificadorEventoUseCaseImpl(eventoGateway);
    }
}
