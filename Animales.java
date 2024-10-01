public class Animales(){
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

    public double CostoMantenimiento() {

    }

    public double PresupuestoRecinto() {

    }

    public String AsignarRecinto() {

    }
}