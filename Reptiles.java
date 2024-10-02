public class Reptiles extends Animales {
    protected int temperatura_corporal;
    protected int cantidad_huevos;

    public Reptiles(String nombre_cientifico, int esperanza_de_vida, int temperatura_corporal, int cantidad_huevos){
        super(nombre_cientifico, esperanza_de_vida);
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
