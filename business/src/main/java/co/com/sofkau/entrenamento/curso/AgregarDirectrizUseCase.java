package co.com.sofkau.entrenamento.curso;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.entrenamiento.curso.commands.AgregarDirectriz;

public class AgregarDirectrizUseCase extends UseCase<RequestCommand<AgregarDirectriz>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarDirectriz> agregarDirectrizRequestCommand) {
        var command  = agregarDirectrizRequestCommand.getCommand();
    }
}
