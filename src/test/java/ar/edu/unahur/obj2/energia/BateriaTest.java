package ar.edu.unahur.obj2.energia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.energia.Bateria.Bateria;
import ar.edu.unahur.obj2.energia.Exceptions.LimiteDeReservaException;
import ar.edu.unahur.obj2.energia.Operaciones.OperacionConsumo;
import ar.edu.unahur.obj2.energia.SistemasPerifericos.RegistroCentralAuditoria;
import ar.edu.unahur.obj2.energia.SistemasPerifericos.SistemaInteresado;

class BateriaTest{

    
    @Test
    void alAgregarObservadorSeAñadeCorrectamente(){
        Bateria bateria = new Bateria("123", 200);
        SistemaInteresado RegistroCentralAuditoria = new RegistroCentralAuditoria();
        bateria.agregarObservador(RegistroCentralAuditoria);
        bateria.listaObservadores().contains(RegistroCentralAuditoria);

    }
    @Test
    void alConsultarNivelEnergiaDevuelveElInicial(){
        Bateria bateria = new Bateria("123", 200);
        assertEquals(200, bateria.getEnergia());
          }
    @Test
    void cargarEnergiaYConsumirCambiaLaEnergia() throws LimiteDeReservaException{
        Bateria bateria = new Bateria("123", 200);
        bateria.cargarEnergia(100);
        bateria.consumirEnergia(50);

        assertEquals(250, bateria.getEnergia());
    }
    @Test
    void ConsumirEnergiaLanzaExcepcionSiSuperaLaReserva(){
        Bateria bateria = new Bateria("123", 200);
        assertThrows(LimiteDeReservaException.class, () -> {
            bateria.consumirEnergia(5500);
        });
    }
    
    @Test
    void deshacerRevierteElConsumoAplicado() throws LimiteDeReservaException{
        Bateria bateria = new Bateria("321", 100);
        OperacionConsumo operacion = new OperacionConsumo(bateria, 30);

        operacion.ejecutar();
        operacion.deshacer();
        assertEquals(100, bateria.getEnergia());
    }
    

}