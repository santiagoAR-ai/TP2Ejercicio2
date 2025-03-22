package org.example;

public enum Propina {
    BAJO(0.02F),
    MEDIO(0.03F),
    ALTO(0.05F);
    private final float porcentajeTotal;

    Propina(float porcentajeTotal){
        this.porcentajeTotal=porcentajeTotal;
    }
    public float porcentaje(){
        return porcentajeTotal;
    }
}
