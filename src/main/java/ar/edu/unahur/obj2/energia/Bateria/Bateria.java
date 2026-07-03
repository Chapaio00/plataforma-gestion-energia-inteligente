package ar.edu.unahur.obj2.energia.Bateria;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.energia.Exceptions.LimiteDeReservaException;
import ar.edu.unahur.obj2.energia.SistemasPerifericos.SistemaInteresado;

public class Bateria {
    private String identificador;
    private Integer energia;
    private List<SistemaInteresado> observadores = new ArrayList<>();
    private static final Integer ReservaMinima = -5000;

    public Bateria(String identificador, Integer energia) {
        this.identificador = identificador;
        this.energia = energia;
    }

    public void agregarObservador(SistemaInteresado sistema){
        observadores.add(sistema);
    }
    

    public Integer getEnergia(){
        return this.energia;
    }

    public void cargarEnergia(Integer energia){
        this.energia = this.energia + energia;
    }
    public void consumirEnergia(Integer energia) throws LimiteDeReservaException{
        Integer resultado = this.energia - energia;
        if(resultado<ReservaMinima){
            throw new LimiteDeReservaException("La bateria no puede ser inferior a la reserva!");
        }
        this.energia = this.energia - energia;
    }

    
}
