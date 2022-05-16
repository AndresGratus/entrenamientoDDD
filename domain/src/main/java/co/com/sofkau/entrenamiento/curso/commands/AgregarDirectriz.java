package co.com.sofkau.entrenamiento.curso.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.entrenamiento.curso.values.Directiz;

public class AgregarDirectriz extends  Command{
    private final Directiz directiz;

    public AgregarDirectriz(Directiz directiz) {
        this.directiz = directiz;
    }

    public Directiz getDirectiz() {
        return directiz;
    }
}
