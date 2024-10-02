public class ReptilesAcuaticos extends Reptiles{
    private double longitud;
    private String especie;
    private boolean tipoAgua;
    private int velocidadNado;
    private int duracionBuceo;
    private double recinto;

    public ReptilesAcuaticos(String nombre_cientifico, int esperanza_de_vida, int temperatura_corporal, int cantidad_huevos, double longitud, String especie, boolean tipoAgua, int velocidadNado, int duracionBuceo){
        super(nombre_cientifico, esperanza_de_vida, temperatura_corporal, cantidad_huevos);
        this.longitud = longitud;
        this.especie = especie;
        this.tipoAgua = tipoAgua;
        this.velocidadNado = velocidadNado;
        this.duracionBuceo = duracionBuceo;
        this.recinto = asignarRecinto(longitud);
    }
    public double getLongitud() {
        return longitud;
    }
    public String getEspecie(){
        return especie;
    }
    public boolean getTipoAgua(){
        return tipoAgua;
    }
    public int getVelocidadNado(){
        return velocidadNado;
    }
    public int getDuracionBuceo(){
        return duracionBuceo;
    }
    public double getRecinto() {
        return recinto;
    }
    public void setRecinto(double recinto) {
        this.recinto = recinto;
    }
    public double asignarRecinto(double longitud) {
        if (longitud < 0.2) {
            return 1.0; 
        } else if (longitud >= 0.2 && longitud <= 0.4) {
            return 2.0; 
        } else {
            return 4.0; 
        }   
    }
}
