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
    public String getIdentificador(){
        return this.identificador;
    }
    public void agregarObservador(SistemaInteresado sistema){
        observadores.add(sistema);
    }
    public void eliminarObservador(SistemaInteresado sistema){
        observadores.remove(sistema);
    }
    public void notifivarObservadores(String tipoMovimiento, Integer cantidad){
        for(SistemaInteresado sistema : observadores){
            sistema.notificar(this, tipoMovimiento, cantidad);
        }
    }
    public Integer getEnergia(){
        return this.energia;
    }
    public List<SistemaInteresado> listaObservadores(){
        return observadores;   //agregada para testeos
    }
    public void cargarEnergia(Integer energia){
        this.energia = this.energia + energia;
        notifivarObservadores("Carga", energia);
    }
    public void consumirEnergia(Integer energia) throws LimiteDeReservaException{
        Integer resultado = this.energia - energia;
        if(resultado < ReservaMinima){
            throw new LimiteDeReservaException("La bateria no puede ser inferior a la reserva!");
        }
        this.energia = this.energia - energia;
        notifivarObservadores("Consumo", energia);

    }


    
}
