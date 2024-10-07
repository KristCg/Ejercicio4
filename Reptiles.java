
public class Reptiles extends Animales {
    protected int temperatura_corporal;
    protected int cantidad_huevos;

    public Reptiles(String nombre_cientifico, int esperanza_de_vida, int temperatura_corporal, int cantidad_huevos){
        super(nombre_cientifico, esperanza_de_vida);
        this.temperatura_corporal =  temperatura_corporal;
        this.cantidad_huevos = cantidad_huevos;
    }

    public int getTemperatura_corporal() {
        return temperatura_corporal;
    }

    public int getCantidad_huevos() {
        return cantidad_huevos;
    }
    public double cantidadComida(double longitud, double peso) {
        if (longitud < 0.20) {
            return (peso * 0.10);
        } else if (longitud >= 0.20 && longitud < 0.40) {
            return (peso * 0.15);
        } else if (longitud >= 0.40 && longitud < 1.0) {
            return (peso * 0.20);
        } else if (longitud >= 1.0 && longitud < 2.0) {
            return (peso * 0.06);
        } else {
            return (peso * 0.08);
        }
    }
    public double costoAlimentacionTotal(double longitud, double peso) {
        // Llamamos al método cantidadComida para obtener la cantidad de comida en gramos
        double cantidadComidaEnGramos = cantidadComida(longitud, peso);
        
        // Calculamos el costo total de la alimentación multiplicando la cantidad de comida por el costo por gramo
        double costo_alimentacion = cantidadComidaEnGramos * 0.25;
    
        return costo_alimentacion;
    }
}
