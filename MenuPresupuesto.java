import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPresupuesto extends JFrame {

    private Animales animal;
    private JLabel labelTamañoReptil;
    private JLabel labelCostoAlimentacion; 
    private JLabel labelPresupuestoDado;
    private JLabel labelResultado; 
    private JLabel labelCostoMantenimiento;
    private JTextField textTamañoReptil; 
    private JTextField textCostoAlimentacion; 
    private JTextField textPresupuestoDado; 
    private JTextField textResultado; 
    private JTextField textCostoMantenimiento;
    private JButton calcularButton;

    public MenuPresupuesto(Animales animal) {
        this.animal = animal;
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setTitle("Presupuesto de Animales");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        // Crear componentes
        labelTamañoReptil = new JLabel("Tamaño del reptil (pequeno/mediano/grande):");
        labelPresupuestoDado = new JLabel("Presupuesto Dado:");
        labelCostoAlimentacion = new JLabel("Costo de Alimentación:");
        labelCostoMantenimiento = new JLabel("Costo de Mantenimiento:");
        labelResultado = new JLabel("¿Presupuesto suficiente?:");

        textTamañoReptil = new JTextField();
        textCostoAlimentacion = new JTextField();
        textPresupuestoDado = new JTextField();
        textCostoMantenimiento = new JTextField();
        textResultado = new JTextField();
        
        textCostoMantenimiento.setEditable(false);
        textResultado.setEditable(false);
        
        calcularButton = new JButton("Calcular");

        // Agregar componentes al JFrame
        add(labelTamañoReptil);
        add(textTamañoReptil);
        add(labelCostoAlimentacion);
        add(textCostoAlimentacion);
        add(labelPresupuestoDado);
        add(textPresupuestoDado);
        add(labelCostoMantenimiento);
        add(textCostoMantenimiento);
        add(labelResultado);
        add(textResultado);
        add(calcularButton);

        // Acción del botón
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularPresupuesto();
            }
        });
    }

    private void calcularPresupuesto() {
        // Obtener datos de los campos de texto
        String tamañoReptil = textTamañoReptil.getText();
        double costoAlimentacion = Double.parseDouble(textCostoAlimentacion.getText());
        double presupuestoDado = Double.parseDouble(textPresupuestoDado.getText());

        // Calcular costo de mantenimiento
        double costoMantenimiento = animal.CostoMantenimiento(tamañoReptil, costoAlimentacion);
        textCostoMantenimiento.setText(String.valueOf(costoMantenimiento));

        // Verificar si el presupuesto dado es suficiente
        boolean esSuficiente = animal.PresupuestoRecinto(presupuestoDado, costoMantenimiento);
        textResultado.setText(esSuficiente ? "Sí" : "No");
    }

    public static void main(String[] args) {
        // Crear un objeto de la clase Animales
        Animales animal = new Animales("Python regius", 30);

        // Crear la ventana y hacerla visible
        MenuPresupuesto ventana = new MenuPresupuesto(animal);
        ventana.setVisible(true);
    }
}

