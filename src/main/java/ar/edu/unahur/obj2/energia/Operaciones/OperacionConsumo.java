package ar.edu.unahur.obj2.energia.Operaciones;

import javax.management.RuntimeErrorException;

import ar.edu.unahur.obj2.energia.Bateria.Bateria;
import ar.edu.unahur.obj2.energia.Exceptions.LimiteDeReservaException;
import ar.edu.unahur.obj2.energia.Exceptions.ValorInvalidoException;

public class OperacionConsumo implements OperacionTransferencia {

    private Bateria bateria;
    private Integer energia;

    public OperacionConsumo(Bateria bateria, Integer energia) {
        if(energia <= 0){
            throw new ValorInvalidoException("La cantidad a consumir debe ser mayor a 0!");
        }
        this.bateria = bateria;
        this.energia = energia;
    }

    @Override
    public void ejecutar() {
        try {
            bateria.consumirEnergia(energia);
        } catch (LimiteDeReservaException e) {
            throw new RuntimeErrorException(null, "La bateria no puede ser inferior a la reserva!" );
        }
    }

    @Override
    public void deshacer() {
        bateria.cargarEnergia(energia);
    }
    
}
