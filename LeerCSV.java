public class LeerCSV {
    private String archivoCSV

    public LeerCSV(String archivo) {
        this.archivo = archivo;
    }

    public List<Serpientes> Leer() {
        List<Serpientes> animales = new ArrayList<>();
        String linea;
        String separador = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(separador);
                double longitud = Double.parseDouble(datos[0]);
                String especie = datos[1];
                String color_piel = datos[2];
                boolean tipo_veneno = Integer.parseInt(datos[3]) == 1;

                Serpientes serpiente = new Serpientes(longitud, especie, color_piel, tipo_veneno);
                animales.add(serpiente);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return animales;
    }

    public void GuardarSerpientes(List<Serpientes> animales) {
        try (FileWriter writer = new FileWriter(archivo)) {
            for (Serpientes serpiente : animales) {
                writer.append(String.valueOf(serpiente.getLongitud()));
                writer.append(",");
                writer.append(serpiente.getEspecie());
                writer.append(",");
                writer.append(serpiente.getColorPiel());
                writer.append(",");
                writer.append(String.valueOf(serpiente.getTipoVeneno()));
                writer.append("\n");
            }
        } catch (IOException e) {

        }
    }
}
