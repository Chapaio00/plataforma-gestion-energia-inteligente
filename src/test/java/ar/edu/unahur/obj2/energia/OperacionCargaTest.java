package ar.edu.unahur.obj2.energia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.energia.Bateria.Bateria;
import ar.edu.unahur.obj2.energia.Exceptions.ValorInvalidoException;
import ar.edu.unahur.obj2.energia.Operaciones.OperacionCarga;

public class OperacionCargaTest {
    


    @Test
    void constructorLanzaExceptionSiCantidadEs0(){
        Bateria bateria = new Bateria("321", 100);
        assertThrows(ValorInvalidoException.class, () -> new OperacionCarga(bateria, 0));
    }
    @Test
    void ejecutarIncrementaElNivelDeLaBateria(){
        Bateria bateria = new Bateria("321", 100);
        OperacionCarga operacion = new OperacionCarga(bateria, 50);
        operacion.ejecutar();
        assertEquals(150, bateria.getEnergia());

    }
    @Test
    void deshacerRevierteLaCargaAplicada(){
        Bateria bateria = new Bateria("321", 100);
        OperacionCarga operacion = new OperacionCarga(bateria, 50);
        operacion.ejecutar();
        operacion.deshacer();

        assertEquals(100, bateria.getEnergia());
    }
}
