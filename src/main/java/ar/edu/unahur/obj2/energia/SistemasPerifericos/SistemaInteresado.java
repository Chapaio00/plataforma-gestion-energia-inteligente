package ar.edu.unahur.obj2.energia.SistemasPerifericos;

import ar.edu.unahur.obj2.energia.Bateria.Bateria;

public interface SistemaInteresado {

    void notificar(Bateria bateria, String tipoMovimiento, Integer cantidad);
}
