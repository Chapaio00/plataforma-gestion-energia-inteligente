package ar.edu.unahur.obj2.energia.SistemasPerifericos;

import ar.edu.unahur.obj2.energia.Bateria.Bateria;

public class AlarmaReservaCritica implements SistemaInteresado {

    @Override
    public void notificar(Bateria bateria, String tipoMovimiento, Integer cantidad) {
        if (bateria.getEnergia() < 0){
            System.out.println("Alerta, bateria" + bateria.getIdentificador() + " tiene energia por debajo de su nivel de tolerancia!");
        }
    }
    
}
