package ar.edu.unahur.obj2.energia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.energia.Bateria.Bateria;
import ar.edu.unahur.obj2.energia.ControladorOperaciones.ControladorOperaciones;
import ar.edu.unahur.obj2.energia.ControladorOperaciones.Rutina;
import ar.edu.unahur.obj2.energia.Exceptions.LimiteDeReservaException;
import ar.edu.unahur.obj2.energia.Operaciones.OperacionCarga;
import ar.edu.unahur.obj2.energia.Operaciones.OperacionConsumo;

public class ControladorOperacionesTest {
    
    @Test
    void ejecutarAplicaUnaOperacionIndividual() throws LimiteDeReservaException{
        Bateria bateria = new Bateria("lmn1", 100);
        ControladorOperaciones controlador = new ControladorOperaciones();

        controlador.ejecutarInmediatamente(new OperacionCarga(bateria,30));
        assertEquals(130, bateria.getEnergia());
    }

    @Test
    void ejecutarInmediatamentePuedeUsarseEnRutinas() throws LimiteDeReservaException{
        Bateria bateria = new Bateria("lmn1", 100);
        ControladorOperaciones controlador = new ControladorOperaciones();

        Rutina rutina = new Rutina();
        rutina.registrarOperacion(new OperacionCarga(bateria,50));
        
        rutina.registrarOperacion(new OperacionConsumo(bateria,10));
        controlador.ejecutarInmediatamente(rutina);
        assertEquals(140, bateria.getEnergia());
        

    }
}
