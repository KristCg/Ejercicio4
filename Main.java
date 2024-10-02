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
    private JTextField longitudField;
    private JTextField colorPielField;
    private JCheckBox esVenenosaCheckBox;
    private JButton guardarButton;
    private JTextArea historialTextArea;

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
        panel.setLayout(new GridLayout(6, 2));

        JLabel nombreCientificoLabel = new JLabel("Nombre científico:");
        nombreCientificoField = new JTextField();

        JLabel longitudLabel = new JLabel("Longitud (metros):");
        longitudField = new JTextField();

        JLabel colorPielLabel = new JLabel("Color de piel:");
        colorPielField = new JTextField();

        JLabel esVenenosaLabel = new JLabel("¿Es venenosa?");
        esVenenosaCheckBox = new JCheckBox();

        guardarButton = new JButton("Guardar");

        historialTextArea = new JTextArea(10, 30);
        historialTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(historialTextArea);

        panel.add(nombreCientificoLabel);
        panel.add(nombreCientificoField);

        panel.add(longitudLabel);
        panel.add(longitudField);

        panel.add(colorPielLabel);
        panel.add(colorPielField);

        panel.add(esVenenosaLabel);
        panel.add(esVenenosaCheckBox);

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
                    double longitud = Double.parseDouble(longitudField.getText());
                    String especie = nombreCientificoField.getText();
                    String colorPiel = colorPielField.getText();
                    boolean esVenenosa = esVenenosaCheckBox.isSelected();

                    Serpientes nuevaSerpiente = new Serpientes(longitud, especie, colorPiel, esVenenosa, 0.0);

                    double recintoAsignado = nuevaSerpiente.asignarRecinto(longitud);
                    nuevaSerpiente.setRecinto(recintoAsignado);

                    serpientes.add(nuevaSerpiente);
                    ar.GuardarSerpientes(serpientes);

                    nombreCientificoField.setText("");
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
        JOptionPane.showMessageDialog(this, "Verificación de presupuesto no implementada.");
    }

    private void actualizarHistorial() {
        StringBuilder historial = new StringBuilder();
        for (Serpientes serpiente : serpientes) {
            historial.append("Especie: ").append(serpiente.getEspecie())
                    .append(", Longitud: ").append(serpiente.getLongitud()).append(" metros")
                    .append(", Color: ").append(serpiente.getColorPiel())
                    .append(", Venenosa: ").append(serpiente.getTipoVeneno() ? "Sí" : "No")
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
