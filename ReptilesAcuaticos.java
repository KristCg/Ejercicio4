public class ReptilesAcuaticos {
    private String especie;
    private boolean tipoAgua;
    private int velocidadNado;
    private int duracionBuceo;
    private double recintos;

    public ReptilesAcuaticos(String especie, boolean tipoAgua, int velocidadNado, int duracionBuceo, double recintos) {
        this.especie = especie;
        this.tipoAgua = tipoAgua;
        this.velocidadNado = velocidadNado;
        this.duracionBuceo = duracionBuceo;
        this.recintos = recintos;
    }

    public String getEspecie() {
        return especie;
    }

    public boolean getTipoAgua() {
        return tipoAgua;
    }

    public int getVelocidadNado() {
        return velocidadNado;
    }

    public int getDuracionBuceo() {
        return duracionBuceo;
    }

    public double getRecintos() {
        return recintos;
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
