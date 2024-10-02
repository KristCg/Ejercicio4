public class Serpientes extends Reptiles {
    private double longitud;
    private String especie;
    private String color_piel;
    private boolean tipo_veneno;
    private double recinto;

    public Serpientes(double longitud, String especie, String color_piel, boolean tipo_veneno, double recinto) {
        this.longitud = longitud;
        this.especie = especie;
        this.color_piel = color_piel;
        this.tipo_veneno = tipo_veneno;
        this.recinto = asignarRecinto(longitud);
    }

    public double getLongitud() {
        return longitud;
    }

    public String getEspecie() {
        return especie;
    }

    public String getColorPiel() {
        return color_piel;
    }

    public Boolean getTipoVeneno() {
        return tipo_veneno;
    }

    public double getRecinto() {
        return recinto;
    }

    public void setRecinto(double recinto) {
        this.recinto = recinto;
    }

    public double asignarRecinto(double longitud) {
        if (longitud < 1) {
            return 2.0;
        } else if (longitud >= 1 && longitud <= 2) {
            return 4.0;
        } else {
            return 6.0;
        }
    }
}