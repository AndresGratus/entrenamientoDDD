package co.com.sofkau.entrenamiento.curso.values;

import co.com.sofka.domain.generic.Identity;
import co.com.sofkau.entrenamiento.curso.Mentoria;

public class MentoriaId extends Identity {
//    public MentoriaId(String id){
//        super(id);
//    }
//
    public static MentoriaId of(String id){
        return  new MentoriaId();
    }
}
