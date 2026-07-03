package ar.edu.unahur.obj2.energia.SistemasPerifericos;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.energia.Bateria.Bateria;

public class RegistroCentralAuditoria implements SistemaInteresado {

    private List<String> registros = new ArrayList<>();

    @Override
    public void notificar(Bateria bateria, String tipoMovimiento, double cantidad) {
        String registro = bateria.getIdentificador() + "-" + "tipoMovimiento" + "-" + "cantidad";
        registros.add(registro);
    }

    public List<String> getRegistros(){
        return registros;
    }
    
}
