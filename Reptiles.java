public class Reptiles extends Animales {
    protected int temperatura_corporal;
    protected int cantidad_huevos;
    protected double peso;

    public Reptiles(String nombre_cientifico, int esperanza_de_vida, int peso, int temperatura_corporal, int cantidad_huevos){
        super(nombre_cientifico, esperanza_de_vida);
        this.peso = peso;
        this.temperatura_corporal =  temperatura_corporal;
        this.cantidad_huevos = cantidad_huevos;
    }
    public double getPeso(){
        return peso;
    }
    public int getTemperatura_corporal() {
        return temperatura_corporal;
    }

    public int getCantidad_huevos() {
        return cantidad_huevos;
    }
    public double cantidadComida(double longitud){
        if (longitud < 0.20){
            return (peso * 0.10);
        } else if(longitud >= 0.20 && peso < 0.40){
            return (peso * 0.15);
        } else if(longitud >= 0.40 && longitud < 0.){
            return (peso * 0.20);
        } else if (longitud >= 0.40 && longitud < 1.0){
            return (peso * 0.05);
        } else if (longitud >= 1.0 && longitud < 2.0){
            return (peso * 0.06);
        } else{
            return (peso * 0.08);
            }
        }
    }
