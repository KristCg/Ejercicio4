import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeerCSV {
    private String archivoCSV_serpiente;
    private String archivoCSV_reptilA = "Ejercicio4\\data\\ReptilesAcuaticos.csv";

    public LeerCSV(String archivoCSV_serpiente) {
        this.archivoCSV_serpiente = archivoCSV_serpiente;
        
    }

    public List<Serpientes> Leer() {
        List<Serpientes> animales = new ArrayList<>();
        String linea;
        String separador = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV_serpiente))) {
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(separador);
                String nombre_cientifico = datos[0];
                int esperanza_de_vida = Integer.parseInt(datos[1]);
                int temperatura_corporal = Integer.parseInt(datos[2]);
                int cantidad_huevos = Integer.parseInt(datos[3]);
                double longitud = Double.parseDouble(datos[4]);
                String especie = datos[5];
                String color_piel = datos[6];
                boolean tipo_veneno = Integer.parseInt(datos[7]) == 1;

                Serpientes serpiente = new Serpientes(nombre_cientifico, esperanza_de_vida, temperatura_corporal,
                        cantidad_huevos, longitud, especie, color_piel, tipo_veneno);
                animales.add(serpiente);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return animales;
    }

    public void GuardarSerpientes(List<Serpientes> serpientes) {
        try (FileWriter writer = new FileWriter(archivoCSV_serpiente)) {
            for (Serpientes serpiente : serpientes) {
                writer.append(serpiente.getNombreCientifico());
                writer.append(",");
                writer.append(String.valueOf(serpiente.getEsperanzaDeVida()));
                writer.append(",");
                writer.append(String.valueOf(serpiente.getTemperatura_corporal()));
                writer.append(",");
                writer.append(String.valueOf(serpiente.getCantidad_huevos()));
                writer.append(",");
                writer.append(String.valueOf(serpiente.getLongitud()));
                writer.append(",");
                writer.append(serpiente.getEspecie());
                writer.append(",");
                writer.append(serpiente.getColorPiel());
                writer.append(",");
                writer.append(String.valueOf(serpiente.getTipoVeneno() ? 1 : 0));
                writer.append(",");
                writer.append(String.valueOf(serpiente.getRecinto()));
                writer.append("\n");
            }
        } catch (IOException e) {

        }
    }

    public List<ReptilesAcuaticos> LeerReptilesAcuaticos() {
        List<ReptilesAcuaticos> reptilesAcuaticos = new ArrayList<>();
        String linea;
        String separador = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV_reptilA))) {
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(separador);
                String nombre_cientifico = datos[0];
                int esperanza_de_vida = Integer.parseInt(datos[1]);
                int temperatura_corporal = Integer.parseInt(datos[2]);
                int cantidad_huevos = Integer.parseInt(datos[3]);
                double longitud = Double.parseDouble(datos[4]);
                String especie = datos[5];
                boolean tipoAgua = Integer.parseInt(datos[6]) == 1;
                int velocidadNado = Integer.parseInt(datos[7]);
                int duracionBuceo = Integer.parseInt(datos[8]);

                ReptilesAcuaticos reptilAcuatico = new ReptilesAcuaticos(nombre_cientifico, esperanza_de_vida,
                        temperatura_corporal, cantidad_huevos, longitud, especie, tipoAgua, velocidadNado,
                        duracionBuceo);
                reptilesAcuaticos.add(reptilAcuatico);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return reptilesAcuaticos;
    }

    public void GuardarReptilesAcuaticos(List<ReptilesAcuaticos> reptilesAcuaticos) {
        try (FileWriter writer = new FileWriter(archivoCSV_reptilA)) {
            for (ReptilesAcuaticos reptilAcuatico : reptilesAcuaticos) {
                writer.append(reptilAcuatico.getNombreCientifico());
                writer.append(",");
                writer.append(String.valueOf(reptilAcuatico.getEsperanzaDeVida()));
                writer.append(",");
                writer.append(String.valueOf(reptilAcuatico.getTemperatura_corporal()));
                writer.append(",");
                writer.append(String.valueOf(reptilAcuatico.getCantidad_huevos()));
                writer.append(",");
                writer.append(String.valueOf(reptilAcuatico.getLongitud()));
                writer.append(",");
                writer.append(reptilAcuatico.getEspecie());
                writer.append(",");
                writer.append(String.valueOf(reptilAcuatico.getTipoAgua() ? 1 : 0));
                writer.append(",");
                writer.append(String.valueOf(reptilAcuatico.getVelocidadNado()));
                writer.append(",");
                writer.append(String.valueOf(reptilAcuatico.getDuracionBuceo()));
                writer.append(",");
                writer.append(String.valueOf(reptilAcuatico.getRecinto()));
                writer.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}