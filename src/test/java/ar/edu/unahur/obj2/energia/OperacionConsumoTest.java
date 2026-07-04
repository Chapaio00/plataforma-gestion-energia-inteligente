package ar.edu.unahur.obj2.energia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.energia.Bateria.Bateria;
import ar.edu.unahur.obj2.energia.Exceptions.LimiteDeReservaException;
import ar.edu.unahur.obj2.energia.Exceptions.ValorInvalidoException;
import ar.edu.unahur.obj2.energia.Operaciones.OperacionConsumo;

public class OperacionConsumoTest{

    @Test
    void constructorLanzaExceptionSiCantidadEs0(){
        Bateria bateria = new Bateria("321", 100);
        assertThrows(ValorInvalidoException.class, () -> new OperacionConsumo(bateria, 0));
    }

    @Test
    void ejecutarReduceElNivelDeLaBateria() throws LimiteDeReservaException{
        Bateria bateria = new Bateria("321", 100);
        OperacionConsumo operacion = new OperacionConsumo(bateria, 30);
        operacion.ejecutar();
        assertEquals(70, bateria.getEnergia());
    }
    @Test
    void ejecutarLanzaExceptionSiSuepraLaReserva(){
        Bateria bateria = new Bateria("321", 100);
        OperacionConsumo operacion = new OperacionConsumo(bateria, 6000);
        assertThrows(LimiteDeReservaException.class, operacion::ejecutar); //tuve que buscar como hacer esto pq nunca se me hubiera ocurrido

    }
}