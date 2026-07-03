package ar.edu.unahur.obj2.energia.ControladorOperaciones;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.energia.Exceptions.LimiteDeReservaException;
import ar.edu.unahur.obj2.energia.Operaciones.OperacionTransferencia;

public class Rutina implements OperacionTransferencia {
    private List<OperacionTransferencia> operacionesPendientes = new ArrayList<>();
    private List<OperacionTransferencia> operacionesEjecutadas = new ArrayList<>();

    

    public void registrarOperacion(OperacionTransferencia operacion){
        operacionesPendientes.add(operacion);
    }
    public List<OperacionTransferencia> getOperacionesPendientes(){
        return operacionesPendientes;
    }
    public void vaciarOperacionesPendientes(){
        operacionesPendientes.clear();   //agregado por si lo necesito en test!
    }
    @Override
    public void ejecutar() throws LimiteDeReservaException {
        operacionesEjecutadas.clear();
        try{
            for(OperacionTransferencia operacion : operacionesPendientes){
                operacion.ejecutar();
                operacionesEjecutadas.add(operacion);
            }
            vaciarOperacionesPendientes();
        } catch(LimiteDeReservaException e){
            deshacer();
            vaciarOperacionesPendientes();
            throw e;
        }
    }
    @Override
    public void deshacer() {
        for (int i = operacionesEjecutadas.size() - 1 ; i >= 0; i--){
            operacionesEjecutadas.get(i).deshacer();
        }
        operacionesEjecutadas.clear();
    }
}
