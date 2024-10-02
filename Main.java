import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame {

    String archivoCSV = "data/Serpientes.csv";
    String archivoCSVReptiles = "data/ReptilesAcua.csv";
    LeerCSV ar = new LeerCSV(archivoCSV);
    LeerCSV arReptiles = new LeerCSV(archivoCSVReptiles);

    private JTextField nombreCientificoField;
    private JTextField esperanzaDeVidaField;       
    private JTextField temperaturaCorporalField;   
    private JTextField cantidadHuevosField;
    private JTextField longitudField;
    private JTextField colorPielField;
    private JCheckBox esVenenosaCheckBox;
    private JButton guardarButton;
    private JTextArea historialTextArea;
    private JTextField presupuestoField;
    private JTextField costoAlimentacionField;
    private JTextField tamañoReptilField;

    private List<Serpientes> serpientes;

    public Main() {
        serpientes = new ArrayList<>();

        setTitle("Registro de Animales");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Opciones");
        JMenuItem menuSerpientes = new JMenuItem("Agregar Serpientes");
        JMenuItem menuReptiles = new JMenuItem("Agregar Reptiles Acuáticos");
        JMenuItem menuPresupuesto = new JMenuItem("Verificar Presupuesto");

        menu.add(menuSerpientes);
        menu.add(menuReptiles);
        menu.add(menuPresupuesto);
        menuBar.add(menu);

        setJMenuBar(menuBar);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 2));

        JLabel nombreCientificoLabel = new JLabel("Nombre científico:");
        nombreCientificoField = new JTextField();

        JLabel esperanzaDeVidaLabel = new JLabel("Esperanza de vida (años):");
        esperanzaDeVidaField = new JTextField();

        JLabel temperaturaCorporalLabel = new JLabel("Temperatura corporal (°C):");
        temperaturaCorporalField = new JTextField();

        JLabel cantidadHuevosLabel = new JLabel("Cantidad de huevos:");
        cantidadHuevosField = new JTextField();

        JLabel longitudLabel = new JLabel("Longitud (metros):");
        longitudField = new JTextField();

        JLabel colorPielLabel = new JLabel("Color de piel:");
        colorPielField = new JTextField();

        JLabel esVenenosaLabel = new JLabel("¿Es venenosa?");
        esVenenosaCheckBox = new JCheckBox();

        JLabel tamañoReptilLabel = new JLabel("Tamaño del reptil (pequeño, mediano, grande):");  // Añadido
        tamañoReptilField = new JTextField();  // Añadido

        JLabel presupuestoLabel = new JLabel("Presupuesto disponible:");  // Añadido
        presupuestoField = new JTextField();  // Añadido

        JLabel costoAlimentacionLabel = new JLabel("Costo de alimentación mensual:");  // Añadido
        costoAlimentacionField = new JTextField();

        guardarButton = new JButton("Guardar");

        historialTextArea = new JTextArea(10, 30);
        historialTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(historialTextArea);

        panel.add(nombreCientificoLabel);
        panel.add(nombreCientificoField);

        panel.add(esperanzaDeVidaLabel);
        panel.add(esperanzaDeVidaField);

        panel.add(temperaturaCorporalLabel);
        panel.add(temperaturaCorporalField);

        panel.add(cantidadHuevosLabel);
        panel.add(cantidadHuevosField);

        panel.add(longitudLabel);
        panel.add(longitudField);

        panel.add(colorPielLabel);
        panel.add(colorPielField);

        panel.add(esVenenosaLabel);
        panel.add(esVenenosaCheckBox);

        panel.add(presupuestoLabel);
        panel.add(presupuestoField);

        panel.add(costoAlimentacionLabel); 
        panel.add(costoAlimentacionField);

        panel.add(tamañoReptilLabel);
        panel.add(tamañoReptilField);

        panel.add(new JLabel());
        panel.add(guardarButton);

        JPanel historialPanel = new JPanel();
        historialPanel.setLayout(new BorderLayout());
        historialPanel.add(new JLabel("Historial de Serpientes:"), BorderLayout.NORTH);
        historialPanel.add(scrollPane, BorderLayout.CENTER);

        add(panel, BorderLayout.NORTH);
        add(historialPanel, BorderLayout.CENTER);

        serpientes = ar.Leer();
        actualizarHistorial();

        menuSerpientes.addActionListener(e -> {
            mostrarFormularioSerpientes();
        });

        menuReptiles.addActionListener(e -> {
            mostrarFormularioReptiles();
        });

        menuPresupuesto.addActionListener(e -> {
            verificarPresupuesto();
        });

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombreCientifico = nombreCientificoField.getText();
                    int esperanzaDeVida = Integer.parseInt(esperanzaDeVidaField.getText());
                    int temperaturaCorporal = Integer.parseInt(temperaturaCorporalField.getText());
                    int cantidadHuevos = Integer.parseInt(cantidadHuevosField.getText());
                    double longitud = Double.parseDouble(longitudField.getText());
                    String colorPiel = colorPielField.getText();
                    boolean esVenenosa = esVenenosaCheckBox.isSelected();

                    Serpientes nuevaSerpiente = new Serpientes(nombreCientifico, esperanzaDeVida, temperaturaCorporal, cantidadHuevos, longitud, nombreCientifico, colorPiel, esVenenosa);

                    double recintoAsignado = nuevaSerpiente.asignarRecinto(longitud);
                    nuevaSerpiente.setRecinto(recintoAsignado);

                    serpientes.add(nuevaSerpiente);
                    ar.GuardarSerpientes(serpientes);

                    nombreCientificoField.setText("");
                    esperanzaDeVidaField.setText("");
                    temperaturaCorporalField.setText("");
                    cantidadHuevosField.setText("");
                    longitudField.setText("");
                    colorPielField.setText("");
                    esVenenosaCheckBox.setSelected(false);

                    JOptionPane.showMessageDialog(null, "Serpiente guardada correctamente.");

                    actualizarHistorial();

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese datos válidos.");
                }
            }
        });
    }

    private void mostrarFormularioSerpientes() {
        JOptionPane.showMessageDialog(this, "Formulario para agregar serpientes.");
    }
    private void mostrarFormularioReptiles() {
        JOptionPane.showMessageDialog(this, "Formulario para agregar reptiles acuáticos.");
    }

    private void verificarPresupuesto() {
        JOptionPane.showMessageDialog(this, "Verificación de presupuesto.");
        try{
            String tamañoReptil = tamañoReptilField.getText();
            double presupuestoDado = Double.parseDouble(presupuestoField.getText());
            double costoAlimentacion = Double.parseDouble(costoAlimentacionField.getText());
            Animales animales = new Animales("",0);

        // Calcular el costo de mantenimiento
            double costoMes = animales.CostoMantenimiento(tamañoReptil, costoAlimentacion);

        // Verificar si el presupuesto es suficiente
            if (animales.PresupuestoRecinto(presupuestoDado, costoMes)) {
                JOptionPane.showMessageDialog(null, "El presupuesto es suficiente.");
            }else {
            JOptionPane.showMessageDialog(null, "El presupuesto no es suficiente.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese valores válidos para el presupuesto y el costo de alimentación.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al verificar el presupuesto: " + ex.getMessage());
    }
}
    private void actualizarHistorial() {
        StringBuilder historial = new StringBuilder();
        for (Serpientes serpiente : serpientes) {
            historial.append("Especie: ").append(serpiente.getEspecie())
                    .append(", Longitud: ").append(serpiente.getLongitud()).append(" metros")
                    .append(", Color: ").append(serpiente.getColorPiel())
                    .append(", Venenosa: ").append(serpiente.getTipoVeneno() ? "Sí" : "No")
                    .append(", Esperanza de vida: ").append(serpiente.getEsperanzaDeVida()).append(" años")
                    .append(", Temperatura corporal: ").append(serpiente.getTemperatura_corporal()).append(" °C")
                    .append(", Cantidad de huevos: ").append(serpiente.getCantidad_huevos())
                    .append(", Recinto: ").append(serpiente.getRecinto()).append(" metros cuadrados")
                    .append("\n");
        }
        historialTextArea.setText(historial.toString());
    }

    public static void main(String[] args) {
        Main ventana = new Main();
        ventana.setVisible(true);
    }
}
