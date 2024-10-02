public class Serpientes extends Reptiles{
    private double longitud;
    private String especie;
    private String color_piel;
    private boolean tipo_veneno;

    public Serpientes(double longitud, String especie, String color_piel, boolean tipo_veneno){
        this.longitud = longitud;
        this.especie = especie;
        this.color_piel = color_piel;
        this.tipo_veneno = tipo_veneno;
    }

    public double getLongitud(){
        return longitud;
    }

    public String getEspecie(){
        return especie;
    }

    public String getColorPiel(){
        return color_piel;
    }

    public boolean getTipoVeneno(){
        return tipo_veneno;
    }
    
    public String asignarRecinto(double longitud) {
        if (longitud < 1) {
            return "Recinto de 1-2 metros cuadrados para serpiente pequeña.";
        } else if (longitud >= 1 && longitud <= 2) {
            return "Recinto de 2-4 metros cuadrados para serpiente mediana.";
        } else {
            return "Recinto de 4-6 metros cuadrados para serpiente grande.";
        }
    }
}