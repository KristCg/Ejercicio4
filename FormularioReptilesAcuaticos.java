import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

public class FormularioReptilesAcuaticos extends JFrame {

    private JTextField nombreCientificoField;
    private JTextField esperanzaVidaField;
    private JTextField temperaturaCorporalField;
    private JTextField cantidadHuevosField;
    private JTextField longitudField;
    private JTextField especieField;
    private JTextField velocidadNadoField;
    private JTextField duracionBuceoField;
    private JComboBox<String> tipoAguaBox;
    private JTextArea resultadoArea;

    public FormularioReptilesAcuaticos() {
        setTitle("Reptiles Acuáticos");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(12, 2, 10, 10)); // 12 filas, 2 columnas, espacio entre componentes

        nombreCientificoField = new JTextField();
        esperanzaVidaField = new JTextField();
        temperaturaCorporalField = new JTextField();
        cantidadHuevosField = new JTextField();
        longitudField = new JTextField();
        especieField = new JTextField();
        velocidadNadoField = new JTextField();
        duracionBuceoField = new JTextField();
        tipoAguaBox = new JComboBox<>(new String[] { "Sí", "No" });
        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);

        add(new JLabel("Nombre Científico:"));
        add(nombreCientificoField);
        add(new JLabel("Esperanza de Vida:"));
        add(esperanzaVidaField);
        add(new JLabel("Temperatura Corporal:"));
        add(temperaturaCorporalField);
        add(new JLabel("Cantidad de Huevos:"));
        add(cantidadHuevosField);
        add(new JLabel("Longitud (metros):"));
        add(longitudField);
        add(new JLabel("Especie:"));
        add(especieField);
        add(new JLabel("Velocidad de Nado:"));
        add(velocidadNadoField);
        add(new JLabel("Duración de Buceo (min):"));
        add(duracionBuceoField);
        add(new JLabel("Tipo de Agua:"));
        add(tipoAguaBox);

        JButton crearReptilBtn = new JButton("Crear Reptil Acuático");
        add(crearReptilBtn);
        crearReptilBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearReptilAcuatico();
            }
        });

        JButton cargarCSVBtn = new JButton("Cargar desde CSV");
        add(cargarCSVBtn);
        cargarCSVBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarDatosDesdeCSV();
            }
        });

        add(new JLabel("Resultado:"));
        add(new JScrollPane(resultadoArea));

        setVisible(true);
    }

    private void crearReptilAcuatico() {
        try {
            String nombreCientifico = nombreCientificoField.getText();
            int esperanzaDeVida = Integer.parseInt(esperanzaVidaField.getText());
            int temperaturaCorporal = Integer.parseInt(temperaturaCorporalField.getText());
            int cantidadHuevos = Integer.parseInt(cantidadHuevosField.getText());
            double longitud = Double.parseDouble(longitudField.getText());
            String especie = especieField.getText();
            boolean tipoAgua = tipoAguaBox.getSelectedItem().equals("Sí");
            int velocidadNado = Integer.parseInt(velocidadNadoField.getText());
            int duracionBuceo = Integer.parseInt(duracionBuceoField.getText());

            ReptilesAcuaticos reptilAcuatico = new ReptilesAcuaticos(
                    nombreCientifico, esperanzaDeVida, temperaturaCorporal, cantidadHuevos,
                    longitud, especie, tipoAgua, velocidadNado, duracionBuceo);

            resultadoArea.setText("Reptil Acuático creado:\n" +
                    "Nombre Científico: " + reptilAcuatico.getNombreCientifico() + "\n" +
                    "Esperanza de Vida: " + reptilAcuatico.getEsperanzaDeVida() + " años\n" +
                    "Temperatura Corporal: " + reptilAcuatico.getTemperatura_corporal() + "°C\n" +
                    "Cantidad de Huevos: " + reptilAcuatico.getCantidad_huevos() + "\n" +
                    "Longitud: " + reptilAcuatico.getLongitud() + " metros\n" +
                    "Especie: " + reptilAcuatico.getEspecie() + "\n" +
                    "Velocidad de Nado: " + reptilAcuatico.getVelocidadNado() + " m/s\n" +
                    "Duración de Buceo: " + reptilAcuatico.getDuracionBuceo() + " min\n" +
                    "Tipo de Agua: " + (reptilAcuatico.getTipoAgua() ? "Sí" : "No") + "\n" +
                    "Tamaño de Recinto: " + reptilAcuatico.getRecinto() + " metros cuadrados\n");
        } catch (NumberFormatException ex) {
            resultadoArea.setText("Error: Por favor ingrese valores numéricos válidos.");
        }
    }

    private void cargarDatosDesdeCSV() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            LeerCSV lectorCSV = new LeerCSV(selectedFile.getAbsolutePath());

            List<ReptilesAcuaticos> reptilesAcuaticos = lectorCSV.LeerReptilesAcuaticos();
            if (!reptilesAcuaticos.isEmpty()) {
                ReptilesAcuaticos primerReptil = reptilesAcuaticos.get(0);
                nombreCientificoField.setText(primerReptil.getNombreCientifico());
                esperanzaVidaField.setText(String.valueOf(primerReptil.getEsperanzaDeVida()));
                temperaturaCorporalField.setText(String.valueOf(primerReptil.getTemperatura_corporal()));
                cantidadHuevosField.setText(String.valueOf(primerReptil.getCantidad_huevos()));
                longitudField.setText(String.valueOf(primerReptil.getLongitud()));
                especieField.setText(primerReptil.getEspecie());
                velocidadNadoField.setText(String.valueOf(primerReptil.getVelocidadNado()));
                duracionBuceoField.setText(String.valueOf(primerReptil.getDuracionBuceo()));
                tipoAguaBox.setSelectedItem(primerReptil.getTipoAgua() ? "Sí" : "No");
            } else {
                resultadoArea.setText("No se encontraron reptiles acuáticos en el archivo CSV.");
            }
        }
    }

    public static void main(String[] args) {
        new FormularioReptilesAcuaticos();
    }
}
