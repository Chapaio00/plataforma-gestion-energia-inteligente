package ar.edu.unahur.obj2.energia.Operaciones;

import javax.management.RuntimeErrorException;

import ar.edu.unahur.obj2.energia.Bateria.Bateria;
import ar.edu.unahur.obj2.energia.Exceptions.LimiteDeReservaException;
import ar.edu.unahur.obj2.energia.Exceptions.ValorInvalidoException;

public class OperacionCarga implements OperacionTransferencia{

    private Bateria bateria;
    private Integer cantidad;

    
    public OperacionCarga(Bateria bateria, Integer cantidad) {
        if(cantidad <= 0){
            throw new ValorInvalidoException("La cantidad a gargar debe ser mayor a 0!");
        }
        this.bateria = bateria;
        this.cantidad = cantidad;
    }


    @Override
    public void ejecutar() {
        bateria.cargarEnergia(cantidad);
    }


    @Override
    public void deshacer() {
        try {
            bateria.consumirEnergia(cantidad);
        } catch (LimiteDeReservaException e) {
            throw new RuntimeErrorException(null, "La bateria no puede ser inferior a la reserva!");
        }
    }
    
}