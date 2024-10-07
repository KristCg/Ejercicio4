import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaReptiles extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton editarButton, eliminarButton;
    private LeerCSV leerCSV;
    private List<Reptiles> reptiles; 

    public VentanaReptiles() {
        setTitle("Lista de Reptiles");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        leerCSV = new LeerCSV("data/Reptiles.csv");
        reptiles = leerCSV.LeerReptiles();

        // Crear tabla
        tableModel = new DefaultTableModel(new Object[]{"Nombre", "Esperanza de vida", "Temperatura", "Huevos", "Intercambio", "Mantenimiento", "Cuidados Especiales"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        cargarDatosTabla();

        
        editarButton = new JButton("Editar");
        eliminarButton = new JButton("Eliminar");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(editarButton);
        buttonPanel.add(eliminarButton);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Editar
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = table.getSelectedRow();
                if (filaSeleccionada != -1) {
                    editarReptil(filaSeleccionada);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona un reptil para editar.");
                }
            }
        });

        // Eliminar
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = table.getSelectedRow();
                if (filaSeleccionada != -1) {
                    eliminarReptil(filaSeleccionada);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona un reptil para eliminar.");
                }
            }
        });
    }

    private void cargarDatosTabla() {
        
        tableModel.setRowCount(0);
        for (ReptilesAcuaticos reptil : reptiles) {
            tableModel.addRow(new Object[]{
                reptil.getNombreCientifico(),
                reptil.getEsperanzaDeVida(),
                reptil.getTemperaturaCorporal(),
                reptil.getCantidadHuevos(),
                reptil.isIntercambio() ? "Sí" : "No",
                reptil.getMantenimiento(),
                reptil.getCuidadosEspeciales()
            });
        }
    }

    private void editarReptil(int filaSeleccionada) {
        ReptilesAcuaticos reptil = reptiles.get(filaSeleccionada);

        JTextField nombreField = new JTextField(reptil.getNombreCientifico());
        JTextField esperanzaVidaField = new JTextField(String.valueOf(reptil.getEsperanzaDeVida()));
        JTextField temperaturaField = new JTextField(String.valueOf(reptil.getTemperaturaCorporal()));
        JTextField cantidadHuevosField = new JTextField(String.valueOf(reptil.getCantidadHuevos()));
        JCheckBox intercambioCheckBox = new JCheckBox("Intercambio", reptil.isIntercambio());
        JTextField mantenimientoField = new JTextField(String.valueOf(reptil.getMantenimiento()));
        JTextField cuidadosEspecialesField = new JTextField(reptil.getCuidadosEspeciales());

    
        Object[] fields = {
            "Nombre Científico:", nombreField,
            "Esperanza de vida (años):", esperanzaVidaField,
            "Temperatura Corporal (°C):", temperaturaField,
            "Cantidad de Huevos:", cantidadHuevosField,
            "Intercambio:", intercambioCheckBox,
            "Mantenimiento (Costo):", mantenimientoField,
            "Cuidados Especiales:", cuidadosEspecialesField
        };

        int option = JOptionPane.showConfirmDialog(null, fields, "Editar Reptil", JOptionPane.OK_CANCEL_OPTION);
        
        if (option == JOptionPane.OK_OPTION) {
            
            reptil.setNombreCientifico(nombreField.getText());
            reptil.setEsperanzaDeVida(Integer.parseInt(esperanzaVidaField.getText()));
            reptil.setTemperaturaCorporal(Double.parseDouble(temperaturaField.getText()));
            reptil.setCantidadHuevos(Integer.parseInt(cantidadHuevosField.getText()));
            reptil.setIntercambio(intercambioCheckBox.isSelected());
            reptil.setMantenimiento(Double.parseDouble(mantenimientoField.getText()));
            reptil.setCuidadosEspeciales(cuidadosEspecialesField.getText());
            
            leerCSV.GuardarReptilesAcuaticos(reptiles);
            cargarDatosTabla();
        }
    }

    private void eliminarReptil(int filaSeleccionada) {
        reptiles.remove(filaSeleccionada);
        leerCSV.GuardarReptilesAcuaticos(reptiles);
        cargarDatosTabla();
    }

}
