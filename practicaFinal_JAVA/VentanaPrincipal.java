import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

    private final ArchivoCalificaciones archivo = new ArchivoCalificaciones();

    private final String[] MESES = {
            "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO",
            "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"
    };

       private void configurarESC() {

    JRootPane rootPane = getRootPane();

    KeyStroke escapeKey =
            KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);

    rootPane.getInputMap(
            JComponent.WHEN_IN_FOCUSED_WINDOW
    ).put(
            escapeKey,
            "SALIR"
    );

    rootPane.getActionMap().put(
            "SALIR",
            new AbstractAction() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    int resp = JOptionPane.showConfirmDialog(
                            VentanaPrincipal.this,
                            "¿Desea salir del sistema?",
                            "Salir",
                            JOptionPane.YES_NO_OPTION
                    );

                    if (resp == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    }

                }
            }
    );
}

    public VentanaPrincipal() {

        setTitle("Colegio Dios es Bueno");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel titulo = new JLabel(
                "<html><center>COLEGIO DIOS ES BUENO<br>SISTEMA DE CALIFICACIONES</center></html>",
                SwingConstants.CENTER
        );

        titulo.setFont(new Font("Arial", Font.BOLD, 18));

        JButton btnRegistrar = new JButton("Registro de Calificaciones");
        JButton btnReporte = new JButton("Reporte de Calificaciones");

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(2, 1, 10, 10));
        panelBotones.add(btnRegistrar);
        panelBotones.add(btnReporte);

        JLabel lblEsc = new JLabel(
                "Presione ESC para salir",
                SwingConstants.CENTER
        );

        add(titulo, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.CENTER);
        add(lblEsc, BorderLayout.SOUTH);

        btnRegistrar.addActionListener(e -> registrarCalificaciones());
        btnReporte.addActionListener(e -> generarReporte());

        configurarESC();
        setVisible(true);
        
    }

    private void registrarCalificaciones() {

        String mes = (String) JOptionPane.showInputDialog(
                this,
                "Seleccione el mes:",
                "Mes",
                JOptionPane.QUESTION_MESSAGE,
                null,
                MESES,
                MESES[0]
        );

        if (mes == null) {
            return;
        }

        String curso = JOptionPane.showInputDialog(
                this,
                "Ingrese el curso:"
        );

        if (curso == null || curso.trim().isEmpty()) {
            return;
        }

        curso = curso.trim().toUpperCase();

        while (true) {

            String nombre = JOptionPane.showInputDialog(
                    this,
                    "Nombre:"
            );

            if (nombre == null) {
                break;
            }

            String apellido = JOptionPane.showInputDialog(
                    this,
                    "Apellido:"
            );

            if (apellido == null) {
                break;
            }

            try {

                double matematica = Double.parseDouble(
                        JOptionPane.showInputDialog(this, "Matemática:")
                );

                double lengua = Double.parseDouble(
                        JOptionPane.showInputDialog(this, "Lengua:")
                );

                double naturales = Double.parseDouble(
                        JOptionPane.showInputDialog(this, "Naturales:")
                );

                double sociales = Double.parseDouble(
                        JOptionPane.showInputDialog(this, "Sociales:")
                );

                Estudiante est = new Estudiante(
                        nombre.trim(),
                        apellido.trim(),
                        curso,
                        mes,
                        matematica,
                        lengua,
                        naturales,
                        sociales
                );

                archivo.guardar(est);

                JOptionPane.showMessageDialog(
                        this,
                        "Estudiante guardado.\n" +
                                "Promedio: " + String.format("%.1f", est.calcularPromedio()) +
                                "\nLiteral: " + est.getLiteral()
                );

                int continuar = JOptionPane.showConfirmDialog(
                        this,
                        "¿Agregar otro estudiante?",
                        "Continuar",
                        JOptionPane.YES_NO_OPTION
                );

                if (continuar != JOptionPane.YES_OPTION) {
                    break;
                }

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Las calificaciones deben ser números.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    private void generarReporte() {

        String mes = (String) JOptionPane.showInputDialog(
                this,
                "Seleccione el mes:",
                "Mes",
                JOptionPane.QUESTION_MESSAGE,
                null,
                MESES,
                MESES[0]
        );

        if (mes == null) {
            return;
        }

        String curso = JOptionPane.showInputDialog(
                this,
                "Ingrese el curso:"
        );

        if (curso == null || curso.trim().isEmpty()) {
            return;
        }

        curso = curso.trim().toUpperCase();

        ArrayList<Estudiante> estudiantes =
                archivo.leerPorMesCurso(mes, curso);

        if (estudiantes.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "No se encontraron registros."
            );

            return;
        }

        estudiantes.sort(
                (a, b) -> a.getApellido()
                        .compareToIgnoreCase(b.getApellido())
        );

        StringBuilder reporte = new StringBuilder();

        reporte.append("Colegio Dios es Bueno\n");
        reporte.append("Reporte de Calificaciones de ")
                .append(mes)
                .append("\n");

        reporte.append("Curso: ")
                .append(curso)
                .append("\n\n");

        reporte.append(
                String.format(
                        "%-15s %-15s %-10s %-10s %-10s %-10s %-10s %-10s%n",
                        "Nombre",
                        "Apellido",
                        "Mat",
                        "Leng",
                        "Nat",
                        "Soc",
                        "Prom",
                        "Lit"
                )
        );

        reporte.append(
                "----------------------------------------------------------------------------\n"
        );

        for (Estudiante est : estudiantes) {

            reporte.append(
                    String.format(
                            "%-15s %-15s %-10.1f %-10.1f %-10.1f %-10.1f %-10.1f %-10s%n",
                            est.getNombre(),
                            est.getApellido(),
                            est.getMatematica(),
                            est.getLengua(),
                            est.getNaturales(),
                            est.getSociales(),
                            est.calcularPromedio(),
                            est.getLiteral()
                    )
            );
        }

        reporte.append("\nTotal de estudiantes: ")
                .append(estudiantes.size());

        JTextArea area = new JTextArea(reporte.toString());
        area.setEditable(false);
        area.setFont(new Font("Monospaced", Font.PLAIN, 12));

        JScrollPane scroll = new JScrollPane(area);
        scroll.setPreferredSize(new Dimension(900, 400));

        JOptionPane.showMessageDialog(
                this,
                scroll,
                "Reporte",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}