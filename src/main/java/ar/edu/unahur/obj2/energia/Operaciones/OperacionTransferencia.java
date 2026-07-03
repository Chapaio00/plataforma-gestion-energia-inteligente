package ar.edu.unahur.obj2.energia.Operaciones;

import ar.edu.unahur.obj2.energia.Exceptions.LimiteDeReservaException;

public interface OperacionTransferencia {
    void ejecutar() throws LimiteDeReservaException;
    void deshacer();         //agregado para responder el ¿que pasa si queremos deshacer una operacion?
}
