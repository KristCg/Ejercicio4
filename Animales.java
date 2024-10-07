public class Animales{
    protected String nombre_cientifico;
    protected int esperanza_de_vida;

    public Animales(String nombre_cientifico, int esperanza_de_vida){
        this.nombre_cientifico = nombre_cientifico;
        this.esperanza_de_vida = esperanza_de_vida;
    }

    public String getNombreCientifico() {
        return nombre_cientifico;
    }

    public int getEsperanzaDeVida() {
        return esperanza_de_vida;
    }


    public double CostoMantenimiento(String longitud, double costo_alimentacion){
        double costoMes = 0.00;
        if(longitud.equals("pequeno")){
            costoMes = (50*30) + costo_alimentacion;
        }
        else if(longitud.equals("mediano")){
            costoMes = (200*30) + costo_alimentacion;
        }

        
        else if(longitud.equals("grande")){
            costoMes = (500*30) + costo_alimentacion;
        }

        return costoMes;

    }

    public boolean PresupuestoRecinto(double presupuesto_dado, double costoMes){
        if (costoMes <= presupuesto_dado){
            return true;
        }
        else{
            return false;
        }

    }
}