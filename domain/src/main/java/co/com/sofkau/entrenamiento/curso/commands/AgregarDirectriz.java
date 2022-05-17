package co.com.sofkau.entrenamiento.curso.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofkau.entrenamiento.curso.values.CursoId;
import co.com.sofkau.entrenamiento.curso.values.Directiz;
import co.com.sofkau.entrenamiento.curso.values.MentoriaId;

public class AgregarDirectriz extends  Command{
    private final MentoriaId mentoriaId;
    private final Directiz directiz;

    private final CursoId cursoId;


    public AgregarDirectriz(CursoId cursoId,MentoriaId mentoriaId, Directiz directiz) {
        this.mentoriaId = mentoriaId;
        this.directiz = directiz;
        this.cursoId = cursoId;
    }

    public MentoriaId getMentoriaId() {
        return mentoriaId;
    }

    public Directiz getDirectiz() {
        return directiz;
    }

    public CursoId getCursoId() {
        return cursoId;
    }

    //El unico que le puede hacer gestion a una Entidad es el agregado NOoo el caso de uso

}
