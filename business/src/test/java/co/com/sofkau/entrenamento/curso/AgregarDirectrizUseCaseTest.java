package co.com.sofkau.entrenamento.curso;

//Prueba unitaria

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofkau.entrenamiento.curso.Mentoria;
import co.com.sofkau.entrenamiento.curso.commands.AgregarDirectriz;
import co.com.sofkau.entrenamiento.curso.events.CursoCreado;
import co.com.sofkau.entrenamiento.curso.events.DirectrizAgregadaAMentoria;
import co.com.sofkau.entrenamiento.curso.events.MentoriaCreada;
import co.com.sofkau.entrenamiento.curso.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AgregarDirectrizUseCaseTest {

    @InjectMocks
    private AgregarDirectrizUseCase UseCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarDirectrizHappyPass(){
        //arrange
        CursoId coursoId = CursoId.of("ddddd");
        MentoriaId mentoriaId = MentoriaId.of("qwerty");
        Directiz directriz = new Directiz("hacer test");

        var command = new AgregarDirectriz(coursoId,mentoriaId, directriz);

        when(repository.getEventsBy("ddddd")).thenReturn(history());
        UseCase.addRepository(repository);

        //when(repository.getEventsBy("ddddd")).thenReturn(history());
       // useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getMentoriaId().value())
                .syncExecutor(UseCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (DirectrizAgregadaAMentoria)events.get(0);
        Assertions.assertEquals("hacer test", event.getDirectiz().value());
    }

    private List<DomainEvent> history(){
        Nombre nombre = new Nombre("DDD");
        Descripcion descripcion = new Descripcion("Curso complementario para el training");
        var event = new CursoCreado(
                nombre,
                descripcion
        );
        event.setAggregateRootId("xxxxx");

        MentoriaId mentoriaId = MentoriaId.of("qwerty");
        Nombre nombreM = new Nombre("EEE");
        Fecha fechaM = new Fecha(LocalDateTime.now(), LocalDate.now());
        var event2 = new MentoriaCreada(mentoriaId, nombre,fechaM);

        return List.of(event,event2);
    }

}
