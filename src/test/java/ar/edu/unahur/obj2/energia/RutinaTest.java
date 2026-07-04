package ar.edu.unahur.obj2.energia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.energia.Bateria.Bateria;
import ar.edu.unahur.obj2.energia.ControladorOperaciones.Rutina;
import ar.edu.unahur.obj2.energia.Exceptions.LimiteDeReservaException;
import ar.edu.unahur.obj2.energia.Operaciones.OperacionCarga;
import ar.edu.unahur.obj2.energia.Operaciones.OperacionConsumo;

public class RutinaTest {
    @Test
    void ejecutarAplicaTodasLasOperaciones() throws LimiteDeReservaException{
        Bateria bateria = new Bateria("321", 100);
        Rutina rutina = new Rutina();
        rutina.registrarOperacion(new OperacionCarga(bateria, 50));
        rutina.registrarOperacion(new OperacionConsumo(bateria, 20));
        rutina.ejecutar();

        assertEquals(130, bateria.getEnergia());
        
    }
    @Test
    void EjecutarLimpiaLaLista() throws LimiteDeReservaException{
        Bateria bateria = new Bateria("321", 100);
        Rutina rutina = new Rutina();
        rutina.registrarOperacion(new OperacionCarga(bateria, 50));
        rutina.registrarOperacion(new OperacionConsumo(bateria, 20));
        rutina.ejecutar();

        assertTrue(rutina.getOperacionesPendientes().size() == 0);
        
    }

    @Test
    void alEjecutarYFallarRevierteLasAnteriores() throws LimiteDeReservaException{
        Bateria bateria = new Bateria("321", 100);
        Rutina rutina = new Rutina();
        rutina.registrarOperacion(new OperacionCarga(bateria, 50));
        rutina.registrarOperacion(new OperacionConsumo(bateria, 7000));

        assertThrows(LimiteDeReservaException.class, rutina::ejecutar);
        
    }



}

