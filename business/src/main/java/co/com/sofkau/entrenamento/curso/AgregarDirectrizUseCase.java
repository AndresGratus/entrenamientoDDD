package co.com.sofkau.entrenamento.curso;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.entrenamiento.curso.Curso;
import co.com.sofkau.entrenamiento.curso.Mentoria;
import co.com.sofkau.entrenamiento.curso.commands.AgregarDirectriz;
import co.com.sofkau.entrenamiento.curso.values.MentoriaId;

import java.util.Optional;

public class AgregarDirectrizUseCase extends UseCase<RequestCommand<AgregarDirectriz>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarDirectriz> agregarDirectrizRequestCommand) {
        var command  = agregarDirectrizRequestCommand.getCommand();
        command.getDirectiz();
        var curso = Curso.from(
                command.getCursoId(),repository().getEventsBy(command.getCursoId().value()));

        curso.agregarDirectrizDeMentoria(command.getMentoriaId(), command.getDirectiz());
        emit().onResponse(new ResponseEvents(curso.getUncommittedChanges()));

    }
}
