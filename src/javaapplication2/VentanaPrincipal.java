/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static javaapplication2.AccionesGraficas.DibujarLiena;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;

public class VentanaPrincipal extends JFrame {

    private JPanel lienzo2;
    private JButton btnPintarLinea;
    private JButton btnPintarCuadrado;
    private JButton btnPintarCirculo;
    private JButton btnPintarTriangulo;
    private JButton btnPintarElipse;
    private JButton btnLimpiar;
    private boolean limpiarActivo = false;
    private JLabel labelX;
    private JLabel labelY;
    private JLabel labelRotation;
    private JSpinner spinnerMovimientoHorizontal;
    private JSpinner spinnerMovimientoVertical;
    private JSpinner spinnerRotacion;
    

    int x1, y1, x2, y2, x3, y3, radio, ejemayor, ejemenor, alto1, ancho1;
    double angulolinea;
    String figuraActual = "";
    int valorspinnerx = 0;
    int valorspinnery = 0;
    int x1Original, y1Original, x2Original, y2Original, x3Original, y3Original, radioOriginal, ejemayorOriginal, ejemenorOriginal;
    double rotationAngle = 0.0;

    public VentanaPrincipal() {
        this.setLayout(null);
        this.setBounds(0, 0, 800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //aqui se agregan los componentes
        this.add(getLienzo());
        this.add(getBtnPintarLinea());
        this.add(getBtnPintarCuadrado());
        this.add(getBtnPintarCirculo());
        this.add(getBtnPintarTriangulo());
        this.add(getBtnPintarElipse());
        this.add(getBtnLimpiar());
        this.add(getlabelX());
        this.add(getlabelY());
        this.add(getSpinnerMovimientoHorizontal());
        this.add(getSpinnerMovimientoVertical());
        this.add(getspinnerRotacion());
        this.add(getlabelRotation());
        this.setVisible(true);

    }

    public JButton getBtnPintarLinea() {
        if (btnPintarLinea == null) {
            btnPintarLinea = new JButton("Pintar Linea");
        }

        btnPintarLinea.setBounds(25, 50, 200, 50);
        btnPintarLinea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                String valor1x = JOptionPane.showInputDialog("Coordenada 1 ingrese X:");
                String valor1y = JOptionPane.showInputDialog("Coordenada 1 ingrese Y:");
                String valor2x = JOptionPane.showInputDialog("Coordenada 2 ingrese X:");
                String valor2y = JOptionPane.showInputDialog("Coordenada 2 ingrese Y:");
                x1Original = Integer.parseInt(valor1x);
                y1Original = Integer.parseInt(valor1y);
                x2Original = Integer.parseInt(valor2x);
                y2Original = Integer.parseInt(valor2y);
                limpiarActivo = true;
                actualizarEstadoBotones();

                AccionesGraficas.DibujarLiena(getLienzo().getGraphics(), x1Original, y1Original, x2Original, y2Original);
                angulolinea = AccionesGraficas.AnguloLinea(x1Original, y1Original, x2Original, y2Original);
                figuraActual = "linea";
            }
        });
        return btnPintarLinea;
    }

    public JButton getBtnPintarCuadrado() {
        if (btnPintarCuadrado == null) {
            btnPintarCuadrado = new JButton("Pintar Cuadrado/Rectangulo");
        }
        btnPintarCuadrado.setBounds(25, 250, 200, 50);
        btnPintarCuadrado.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String valorx = JOptionPane.showInputDialog("Coordenada X  (para el centro):");
                String valory = JOptionPane.showInputDialog("Coordenada Y  (para el centro):");
                String ancho = JOptionPane.showInputDialog("Ancho:");
                String alto = JOptionPane.showInputDialog("Alto:");

                x1Original = Integer.parseInt(valorx);
                y1Original = Integer.parseInt(valory);
                alto1 = Integer.parseInt(ancho);
                ancho1 = Integer.parseInt(alto);

                limpiarActivo = true;
                actualizarEstadoBotones();

                AccionesGraficas.DibujarRectanguloConAngulo(getLienzo().getGraphics(), x1Original, y1Original, alto1, ancho1,rotationAngle);
                figuraActual = "cuadrado";
                System.out.println("x1=" + x1Original + " y1=" + y1Original + " x2=" + x2Original + " y2=" + y2Original);
            }
        });

        return btnPintarCuadrado;
    }

    public JButton getBtnPintarCirculo() {
        if (btnPintarCirculo == null) {
            btnPintarCirculo = new JButton("Pintar circulo");
        }
        btnPintarCirculo.setBounds(25, 100, 200, 50);
        btnPintarCirculo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String valorx = JOptionPane.showInputDialog("Coordenada X  (para el centro):");
                String valory = JOptionPane.showInputDialog("Coordenada Y  (para el centro):");
                String radio1 = JOptionPane.showInputDialog("Ingrese el radio del Circulo:");

                x1Original = Integer.parseInt(valorx);
                y1Original = Integer.parseInt(valory);
                radioOriginal = Integer.parseInt(radio1);

                limpiarActivo = true;
                actualizarEstadoBotones();

                AccionesGraficas.DibujarCirculo(getLienzo().getGraphics(), x1Original, y1Original, radioOriginal);
                figuraActual = "circulo";
                System.out.println("x1=" + x1Original + " y1=" + y1Original + " radio=" + radioOriginal);
            }
        });
        return btnPintarCirculo;
    }

    public JButton getBtnPintarTriangulo() {
        if (btnPintarTriangulo == null) {
            btnPintarTriangulo = new JButton("Pintar triangulo");
        }
        btnPintarTriangulo.setBounds(25, 150, 200, 50);
        btnPintarTriangulo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String valorx1 = JOptionPane.showInputDialog("Coordenada 1 ingrese X1:");
                String valory1 = JOptionPane.showInputDialog("Coordenada 1 ingrese Y1:");
                String valorx2 = JOptionPane.showInputDialog("Coordenada 1 ingrese X2:");
                String valory2 = JOptionPane.showInputDialog("Coordenada 1 ingrese Y2:");
                String valorx3 = JOptionPane.showInputDialog("Coordenada 1 ingrese X3:");
                String valory3 = JOptionPane.showInputDialog("Coordenada 1 ingrese Y3:");

                x1Original = Integer.parseInt(valorx1);
                y1Original = Integer.parseInt(valory1);
                x2Original = Integer.parseInt(valorx2);
                y2Original = Integer.parseInt(valory2);
                x3Original = Integer.parseInt(valorx3);
                y3Original = Integer.parseInt(valory3);

                limpiarActivo = true;
                actualizarEstadoBotones();

                AccionesGraficas.DibujarTriangulo(getLienzo().getGraphics(), x1Original, y1Original, x2Original, y2Original, x3Original, y3Original,rotationAngle);
                figuraActual = "triangulo";
                System.out.println("x1=" + x1Original + " y1=" + y1Original + " x2=" + x2Original + " y2=" + y2Original + " x3=" + x3Original + " y3=" + y3Original);

                //equilatero: (0,150) (259,-75) (-259,75)      recuerda: int x2 = (int) (150 * Math.sqrt(3));
                //isosceles: (0,150) (150,-150) (-150,-150)    getLienzo().getGraphics(), 0, 150, 150, -150, -150, -150
                //escaleno: (0,150) (100,-50) (-150,-150)      getLienzo().getGraphics(), 0, 150, 100, -50, -150, -150
            }
        });
        return btnPintarTriangulo;
    }

    public JButton getBtnPintarElipse() {
        if (btnPintarElipse == null) {
            btnPintarElipse = new JButton("Pintar Elipse");
        }
        btnPintarElipse.setBounds(25, 200, 200, 50);
        btnPintarElipse.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String valorx = JOptionPane.showInputDialog("Coordenada X  (para el centro):");
                String valory = JOptionPane.showInputDialog("Coordenada Y  (para el centro):");
                String valora = JOptionPane.showInputDialog("Tamaño semieje mayor");
                String valorb = JOptionPane.showInputDialog("Tamaño semieje menor");

                x1Original = Integer.parseInt(valorx);
                y1Original = Integer.parseInt(valory);
                ejemayorOriginal = Integer.parseInt(valora);
                ejemenorOriginal = Integer.parseInt(valorb);

                limpiarActivo = true;
                actualizarEstadoBotones();

                //AccionesGraficas.pintarElipse(getLienzo().getGraphics(), Integer.parseInt(valorx), Integer.parseInt(valory), Integer.parseInt(valora), Integer.parseInt(valorb));
                AccionesGraficas.DibujarElipseConAngulo(getLienzo().getGraphics(), x1Original, y1Original, ejemayorOriginal, ejemenorOriginal, rotationAngle);
                figuraActual = "elipse";
                System.out.println("x1=" + x1Original + " y1=" + y1Original + " x2=" + ejemayorOriginal + " y2=" + ejemenorOriginal);
            }
        });
        return btnPintarElipse;
    }

    public JButton getBtnLimpiar() {
        if (btnLimpiar == null) {
            btnLimpiar = new JButton("Limpiar");
        }
        btnLimpiar.setBounds(25, 300, 200, 50);
        btnLimpiar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Graphics g = getLienzo().getGraphics();
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(0, 0, getLienzo().getWidth(), getLienzo().getHeight());
                AccionesGraficas.pintarPlanoCartesiano(g);
                limpiarActivo = false;
                actualizarEstadoBotones();
                x1 = 0;
                y1 = 0;
                x2 = 0;
                y2 = 0;
                x3 = 0;
                y3 = 0;
                radio = 0;
                x1Original = 0;
                y1Original = 0;
                x2Original = 0;
                y2Original = 0;
                x3Original = 0;
                y3Original = 0;
                radioOriginal = 0;
                figuraActual = "";
            }
        });
        return btnLimpiar;
    }

    public JPanel getLienzo() {
        if (lienzo2 == null) {
            lienzo2 = new JPanel() {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    AccionesGraficas.pintarPlanoCartesiano(g);
                }
            };
            //configuracion del lienzo
            lienzo2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //super.mouseClicked(e); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                    System.out.println(e.getX() + " - " + e.getY());
                }
            });
            lienzo2.setBounds(250, 25, 500, 500);
            lienzo2.setBackground(Color.LIGHT_GRAY);
        }
        return lienzo2;
    }

    public JLabel getlabelX() {
        if (labelX == null) {
            labelX = new JLabel();
        }
        labelX.setText("Movimiento en X");
        labelX.setBounds(75, 340, 200, 50);
        return labelX;
    }

    public JSpinner getSpinnerMovimientoHorizontal() {
        if (spinnerMovimientoHorizontal == null) {
            spinnerMovimientoHorizontal = new JSpinner();
            spinnerMovimientoHorizontal.setBounds(25, 375, 200, 30);
            spinnerMovimientoHorizontal.setValue(valorspinnerx);
            spinnerMovimientoHorizontal.addChangeListener(e -> {
                int movimiento = (int) spinnerMovimientoHorizontal.getValue();
                if (movimiento > valorspinnerx) {
                    // Mover hacia la derecha sumando el valor de "movimiento" a las coordenadas X globales
                    x1 = x1Original + 1;
                    x2 = x2Original + 1;
                    x3 = x3Original + 1;
                    valorspinnerx = valorspinnerx + 1;
                } else if (movimiento < valorspinnerx) {
                    // Mover hacia la izquierda restando el valor absoluto de "movimiento" a las coordenadas X globales
                    x1 = x1Original - 1;
                    x2 = x2Original - 1;
                    x3 = x3Original - 1;
                    valorspinnerx = valorspinnerx - 1;
                }

                System.out.println("x1=" + x1 + " y1=" + y1 + " x2=" + x2 + " y2=" + y2 + " x3=" + x3 + " y3=" + y3);

                // Actualizar los valores originales
                x1Original = x1;
                x2Original = x2;
                x3Original = x3;

                //borrar lo anterior
                Graphics g = getLienzo().getGraphics();
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(0, 0, getLienzo().getWidth(), getLienzo().getHeight());
                AccionesGraficas.pintarPlanoCartesiano(g);

                //verificar cual esta activo para proceder a dibujar
                if (figuraActual == "linea") {
                    AccionesGraficas.DibujarLiena(getLienzo().getGraphics(), x1Original, y1Original, x2Original, y2Original);
                }
                if (figuraActual == "triangulo") {
                    AccionesGraficas.DibujarTriangulo(getLienzo().getGraphics(), x1Original, y1Original, x2Original, y2Original, x3Original, y3Original,rotationAngle);
                }
                if (figuraActual == "cuadrado") {
                    AccionesGraficas.DibujarRectanguloConAngulo(getLienzo().getGraphics(), x1Original, y1Original, alto1, ancho1,rotationAngle);
                }
                if (figuraActual == "circulo") {
                    AccionesGraficas.DibujarCirculo(getLienzo().getGraphics(), x1, y1Original, radioOriginal);
                }
                if (figuraActual == "elipse") {
                    AccionesGraficas.DibujarElipseConAngulo(getLienzo().getGraphics(), x1Original, y1Original, ejemayorOriginal, ejemenorOriginal, rotationAngle);
                }

                // Dibujar la línea actualizada en la nueva posición
                //AccionesGraficas2.drawLine(getLienzo().getGraphics(), x1, y1Original, x2, y2Original);
            });
        }
        return spinnerMovimientoHorizontal;
    }

    public JLabel getlabelY() {
        if (labelY == null) {
            labelY = new JLabel();
        }
        labelY.setText("Movimiento en Y");
        labelY.setBounds(75, 400, 200, 50);
        return labelY;
    }

    public JSpinner getSpinnerMovimientoVertical() {
        if (spinnerMovimientoVertical == null) {
            spinnerMovimientoVertical = new JSpinner();
            spinnerMovimientoVertical.setBounds(25, 435, 200, 30);
            spinnerMovimientoVertical.setValue(valorspinnery);
            spinnerMovimientoVertical.addChangeListener(e -> {
                int movimiento = (int) spinnerMovimientoVertical.getValue();
                if (movimiento > valorspinnery) {
                    // Mover hacia la derecha sumando el valor de "movimiento" a las coordenadas Y globales
                    y1 = y1Original + 1;
                    y2 = y2Original + 1;
                    y3 = y3Original + 1;
                    valorspinnery = valorspinnery + 1;
                } else if (movimiento < valorspinnery) {
                    // Mover hacia la izquierda restando el valor absoluto de "movimiento" a las coordenadas Y globales
                    y1 = y1Original - 1;
                    y2 = y2Original - 1;
                    y3 = y3Original - 1;
                    valorspinnery = valorspinnery - 1;
                }

                System.out.println("x1=" + x1 + " y1=" + y1 + " x2=" + x2 + " y2=" + y2 + " x3=" + x3 + " y3=" + y3);

                // Actualizar los valores originales
                y1Original = y1;
                y2Original = y2;
                y3Original = y3;

                //borrar lo anterior
                Graphics g = getLienzo().getGraphics();
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(0, 0, getLienzo().getWidth(), getLienzo().getHeight());
                AccionesGraficas.pintarPlanoCartesiano(g);

                //verificar cual esta activo para proceder a dibujar
                if (figuraActual == "linea") {
                    AccionesGraficas.DibujarLiena(getLienzo().getGraphics(), x1Original, y1Original, x2Original, y2Original);
                }
                if (figuraActual == "triangulo") {
                    AccionesGraficas.DibujarTriangulo(getLienzo().getGraphics(), x1Original, y1Original, x2Original, y2Original, x3Original, y3Original,rotationAngle);
                }
                if (figuraActual == "cuadrado") {
                    AccionesGraficas.DibujarRectanguloConAngulo(getLienzo().getGraphics(), x1Original, y1Original, alto1, ancho1,rotationAngle);
                }
                if (figuraActual == "circulo") {
                    AccionesGraficas.DibujarCirculo(getLienzo().getGraphics(), x1Original, y1, radioOriginal);
                }
                if (figuraActual == "elipse") {
                    AccionesGraficas.DibujarElipseConAngulo(getLienzo().getGraphics(), x1Original, y1Original, ejemayorOriginal, ejemenorOriginal, rotationAngle);
                }

                // Dibujar la línea actualizada en la nueva posición
                //AccionesGraficas2.drawLine(getLienzo().getGraphics(), x1, y1Original, x2, y2Original);
            });
        }
        return spinnerMovimientoVertical;
    }

    public JLabel getlabelRotation() {
        if (labelRotation == null) {
            labelRotation = new JLabel();
        }
        labelRotation.setText("Rotacion");
        labelRotation.setBounds(95, 455, 200, 50);
        return labelRotation;
    }

    public JSpinner getspinnerRotacion() {
        if (spinnerRotacion == null) {
            SpinnerModel spinnerModel = new SpinnerNumberModel(0.0, -180.0, 180.0, 1.0); // Rango y paso del Spinner
            spinnerRotacion = new JSpinner(spinnerModel);
            spinnerRotacion.setBounds(25, 495, 200, 30);
            spinnerRotacion.addChangeListener(e -> {
                double rotacion = (double) spinnerRotacion.getValue();
                rotationAngle = rotacion;
                // Borrar el contenido anterior
                Graphics g = getLienzo().getGraphics();
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(0, 0, getLienzo().getWidth(), getLienzo().getHeight());
                AccionesGraficas.pintarPlanoCartesiano(g);
                
                // Verificar cuál figura está activa y proceder a dibujar
                switch (figuraActual) {
                    case "linea":
                        
                        // Obtener el punto de rotación (punto final de la línea)
                    double pivotX = x2Original;
                    double pivotY = y2Original;

                    // Calcular los valores de traslación
                    double translateX = pivotX;
                    double translateY = pivotY;

                    // Calcular el ángulo de rotación en radianes
                    double theta = Math.toRadians(rotacion);

                    // Realizar la traslación para que el punto de rotación sea el origen
                    x1Original -= translateX;
                    y1Original -= translateY;
                    x2Original -= translateX;
                    y2Original -= translateY;

                    // Realizar la rotación
                    double cosTheta = Math.cos(theta);
                    double sinTheta = Math.sin(theta);
                    double x1Rotado = x1Original * cosTheta - y1Original * sinTheta;
                    double y1Rotado = x1Original * sinTheta + y1Original * cosTheta;
                    double x2Rotado = x2Original * cosTheta - y2Original * sinTheta;
                    double y2Rotado = x2Original * sinTheta + y2Original * cosTheta;

                    // Volver a trasladar el sistema de coordenadas a su posición original
                    x1Original = (int) (x1Rotado + translateX);
                    y1Original = (int) (y1Rotado + translateY);
                    x2Original = (int) (x2Rotado + translateX);
                    y2Original = (int) (y2Rotado + translateY);
                    
                    // Dibujar la línea rotada
                    AccionesGraficas.DibujarLiena(getLienzo().getGraphics(), x1Original, y1Original, x2Original, y2Original);
                    System.out.println(" x1="+x1+" y1="+ y1+ " x2=" + x2 + " y2=" + y2 + " angulo=" + rotationAngle);
                        System.out.println("angulo¿linea= " + angulolinea +" rotacion=" + rotacion + " rotationAngle=" + rotationAngle);
                        //AccionesGraficas.DibujarLineaConAngulo(g, x1Original, y1Original, x2Original, y2Original, rotationAngle);
                        //AccionesGraficas.DibujarLineaChingona(getLienzo().getGraphics(), x1Original, y1Original, x2Original, y2Original, rotationAngle+rotacion);
                        //AccionesGraficas.drawLine(getLienzo().getGraphics(), x1Original, y1Original, x2Original, y2Original, rotationAngle);
                        
                        break;
                    case "cuadrado": 
                       AccionesGraficas.DibujarRectanguloConAngulo(getLienzo().getGraphics(), x1Original, y1Original, alto1, ancho1,rotationAngle);
                        break;
                    case "circulo":
                        AccionesGraficas.DibujarCirculo(getLienzo().getGraphics(), x1, y1, radioOriginal);
                        break;
                    case "triangulo":
                        AccionesGraficas.DibujarTriangulo(getLienzo().getGraphics(), x1Original, y1Original, x2Original, y2Original, x3Original, y3Original,rotationAngle);
                        break;
                    case "elipse":
                        AccionesGraficas.DibujarElipseConAngulo(getLienzo().getGraphics(), x1Original, y1Original, ejemayorOriginal, ejemenorOriginal, rotationAngle);
                        break;
                    default:
                        break;
                }

            });
        }
        return spinnerRotacion;
    }

    public static void main(String[] args) {
        new VentanaPrincipal();
    }

    private void actualizarEstadoBotones() {
        btnPintarLinea.setEnabled(!limpiarActivo);
        btnPintarCuadrado.setEnabled(!limpiarActivo);
        btnPintarCirculo.setEnabled(!limpiarActivo);
        btnPintarTriangulo.setEnabled(!limpiarActivo);
        btnPintarElipse.setEnabled(!limpiarActivo);
        spinnerMovimientoHorizontal.setValue(0);

    }

}
