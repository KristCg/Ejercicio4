import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VentanaReptiles extends JFrame {
    private JTable tablaReptiles;
    private DefaultTableModel modeloTabla;
    private List<Reptiles> listaReptiles;
    private String archivoCSV = "data/Reptiles.csv";

    public VentanaReptiles() {
        setTitle("Administrar Reptiles");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        listaReptiles = leerReptilesDesdeCSV();


        String[] columnas = {"Nombre", "Esperanza de Vida", "Temperatura", "Cantidad de Huevos", "Intercambio", "Mantenimiento", "Cuidados Especiales"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaReptiles = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaReptiles);
        cargarDatosEnTabla();

        
        JButton btnModificar = new JButton("Modificar");
        JButton btnEliminar = new JButton("Eliminar");

        
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnModificar);
        panelBotones.add(btnEliminar);

        add(scrollPane, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        
        btnEliminar.addActionListener(e -> eliminarReptil());

        
        btnModificar.addActionListener(e -> modificarReptil());
    }

    private List<Reptiles> leerReptilesDesdeCSV() {
        List<Reptiles> reptiles = new ArrayList<>();
        String linea;
        String separador = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(separador);
                String nombre = datos[0];
                int esperanzaDeVida = Integer.parseInt(datos[1]);
                double temperatura = Double.parseDouble(datos[2]);
                int cantidadHuevos = Integer.parseInt(datos[3]);
                boolean esIntercambio = Boolean.parseBoolean(datos[4]);
                double mantenimiento = Double.parseDouble(datos[5]);
                String cuidadosEspeciales = datos[6];

                Reptiles reptil = new Reptiles(nombre, esperanzaDeVida, temperatura, cantidadHuevos, esIntercambio, mantenimiento, cuidadosEspeciales);
                reptiles.add(reptil);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reptiles;
    }

    private void cargarDatosEnTabla() {
        modeloTabla.setRowCount(0); 
        for (Reptiles reptil : listaReptiles) {
            Object[] fila = {
                reptil.getNombreCientifico(),
                reptil.getEsperanzaDeVida(),
                reptil.getTemperatura_corporal(),
                reptil.getCantidad_huevos(),
                reptil.isEsIntercambio(),
                reptil.getMantenimiento(),
                reptil.getCuidadosEspeciales()
            };
            modeloTabla.addRow(fila);
        }
    }

    private void eliminarReptil() {
        int filaSeleccionada = tablaReptiles.getSelectedRow();
        if (filaSeleccionada != -1) {
            listaReptiles.remove(filaSeleccionada); 
            modeloTabla.removeRow(filaSeleccionada); 
            guardarReptilesEnCSV(); 
            JOptionPane.showMessageDialog(this, "Reptil eliminado correctamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un reptil para eliminar.");
        }
    }

    private void modificarReptil() {
        int filaSeleccionada = tablaReptiles.getSelectedRow();
        if (filaSeleccionada != -1) {
            Reptiles reptilSeleccionado = listaReptiles.get(filaSeleccionada);

            
            JTextField nombreField = new JTextField(reptilSeleccionado.getNombreCientifico());
            JTextField esperanzaDeVidaField = new JTextField(String.valueOf(reptilSeleccionado.getEsperanzaDeVida()));
            JTextField temperaturaField = new JTextField(String.valueOf(reptilSeleccionado.getTemperatura_corporal()));
            JTextField cantidadHuevosField = new JTextField(String.valueOf(reptilSeleccionado.getCantidad_huevos()));
            JCheckBox esIntercambioCheckBox = new JCheckBox("Es intercambio", reptilSeleccionado.isEsIntercambio());
            JTextField mantenimientoField = new JTextField(String.valueOf(reptilSeleccionado.getMantenimiento()));
            JTextField cuidadosEspecialesField = new JTextField(reptilSeleccionado.getCuidadosEspeciales());

            Object[] mensaje = {
                "Nombre:", nombreField,
                "Esperanza de vida:", esperanzaDeVidaField,
                "Temperatura:", temperaturaField,
                "Cantidad de huevos:", cantidadHuevosField,
                "¿Es intercambio?", esIntercambioCheckBox,
                "Mantenimiento:", mantenimientoField,
                "Cuidados especiales:", cuidadosEspecialesField
            };

            int opcion = JOptionPane.showConfirmDialog(this, mensaje, "Modificar Reptil", JOptionPane.OK_CANCEL_OPTION);
            if (opcion == JOptionPane.OK_OPTION) {
                reptilSeleccionado.setNombre(nombreField.getText());
                reptilSeleccionado.setEsperanzaDeVida(Integer.parseInt(esperanzaDeVidaField.getText()));
                reptilSeleccionado.setTemperatura(Double.parseDouble(temperaturaField.getText()));
                reptilSeleccionado.setCantidadHuevos(Integer.parseInt(cantidadHuevosField.getText()));
                reptilSeleccionado.setEsIntercambio(esIntercambioCheckBox.isSelected());
                reptilSeleccionado.setMantenimiento(Double.parseDouble(mantenimientoField.getText()));
                reptilSeleccionado.setCuidadosEspeciales(cuidadosEspecialesField.getText());

                cargarDatosEnTabla(); 
                guardarReptilesEnCSV(); 
                JOptionPane.showMessageDialog(this, "Reptil modificado correctamente.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un reptil para modificar.");
        }
    }

    private void guardarReptilesEnCSV() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoCSV))) {
            for (Reptiles reptil : listaReptiles) {
                bw.write(reptil.getNombreCientifico() + "," + reptil.getEsperanzaDeVida() + "," + reptil.getTemperatura_corporal() + "," +
                        reptil.getCantidad_huevos() + "," + reptil.isEsIntercambio() + "," +
                        reptil.getMantenimiento() + "," + reptil.getCuidadosEspeciales());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
