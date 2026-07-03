package ar.edu.unahur.obj2.energia.ControladorOperaciones;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.energia.Exceptions.LimiteDeReservaException;
import ar.edu.unahur.obj2.energia.Operaciones.OperacionTransferencia;

public class ControladorOperaciones {
    
    private List<OperacionTransferencia> historialEjecutadas = new ArrayList<>();

    public void ejecutarInmediatamente(OperacionTransferencia operacion) throws LimiteDeReservaException{
        operacion.ejecutar();
        historialEjecutadas.add(operacion);
    }
    /*
    Es posible revertirlas ya que agregue en la interfaz el deshacer! habria que ver cual 
    revisando el historialEjecutadas.
    es responsabilidad de la operacion revertirla ya que a ella son enviadas los datos, para una operacion individual o rutina es simplemente poner operacion.deshacer()!
    
    me quedo vacia casi despues de convertir rutina en una extension de OperacionTransferencia.
    */

}
