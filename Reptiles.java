package Ejercicio4;

public class Reptiles {
    private int temperatura_corporal;
    private int cantidad_huevos;

    public Reptiles(int temperatura_corporal, int cantidad_huevos){
        this.temperatura_corporal =  temperatura_corporal;
        this.cantidad_huevos = cantidad_huevos;
    }

    public int getTemperatura_corporal(){
        return temperatura_corporal;
    }
    public int getCantidad_huevos(){
        return cantidad_huevos;
    }

}
