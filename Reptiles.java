
public class Reptiles extends Animales {
    protected int temperatura_corporal;
    protected int cantidad_huevos;
    private boolean esIntercambio;
    private double mantenimiento;
    private String cuidadosEspeciales;

    public Reptiles(String nombre_cientifico, int esperanza_de_vida, int temperatura_corporal, int cantidad_huevos, boolean esIntercambio, double mantenimiento, String cuidadosEspeciales) {
        super(nombre_cientifico, esperanza_de_vida);
        this.temperatura_corporal = temperatura_corporal;
        this.cantidad_huevos = cantidad_huevos;
        this.esIntercambio = esIntercambio;
        this.mantenimiento = mantenimiento;
        this.cuidadosEspeciales = cuidadosEspeciales;
    }

    public int getTemperatura_corporal() {
        return temperatura_corporal;
    }

    public int getCantidad_huevos() {
        return cantidad_huevos;
    }

    public boolean isEsIntercambio() {
        return esIntercambio;
    }

    public double getMantenimiento() {
        return mantenimiento;
    }

    public String getCuidadosEspeciales() {
        return cuidadosEspeciales;
    }

    public void setTemperatura(int temperatura_corporal) {
        this.temperatura_corporal = temperatura_corporal;
    }


    public void setCantidadHuevos(int cantidad_huevos) {
        this.cantidad_huevos = cantidad_huevos;
    }

    public void setEsIntercambio(boolean esIntercambio) {
        this.esIntercambio = esIntercambio;
    }

    public void setMantenimiento(double mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

    public void setCuidadosEspeciales(String cuidadosEspeciales) {
        this.cuidadosEspeciales = cuidadosEspeciales;
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
    
        double cantidadComidaEnGramos = cantidadComida(longitud, peso);

        
        double costo_alimentacion = cantidadComidaEnGramos * 0.25;

        return costo_alimentacion;
    }
}
