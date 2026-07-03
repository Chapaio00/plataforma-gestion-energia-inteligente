package ar.edu.unahur.obj2.energia.SistemasPerifericos;

import ar.edu.unahur.obj2.energia.Bateria.Bateria;

public class NotificacionesAdministrador implements SistemaInteresado {
    private String identificadorBateriaACargo;


    
    public NotificacionesAdministrador(String identificadorBateriaACargo) {
        this.identificadorBateriaACargo = identificadorBateriaACargo;
    }




    @Override
    public void notificar(Bateria bateria, String tipoMovimiento, double cantidad) {
        if(!bateria.getIdentificador().equals(identificadorBateriaACargo)){
            return;
        }
        if (tipoMovimiento == "Carga") {
            System.out.println("Se han cargado" + "" + cantidad + "a la bateria!");
        }
        if (tipoMovimiento == "Consumo"){
            System.out.println("Se han consumido" + "" + cantidad + "a la bateria!");
        }   //no supe como implementarlo sin poner dos if! se que si se agrega otro tipoMovimiento seria invalida esta solucion pero como no pidieron eso no lo tuve en cuenta!
    }
     
}
