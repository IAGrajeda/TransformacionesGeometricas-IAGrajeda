/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author aleja
 */
public class AccionesGraficas {

    public static synchronized void pintarPlanoCartesiano(Graphics g) {
        //eje de la y
        g.setColor(Color.red);
        g.drawLine(250, 500, 250, 0);
        // letra Y

        // YYYY flecha abajo
        g.drawLine(250, 500, 260, 490);
        g.drawLine(250, 500, 240, 490);
        // YYYY flecha arriba
        g.drawLine(250, 0, 260, 10);
        g.drawLine(250, 0, 240, 10);
        //eje de la x
        g.setColor(Color.blue);
        g.drawLine(0, 250, 500, 250);
        // XXXX flecha derecha
        g.drawLine(500, 250, 490, 260);
        g.drawLine(500, 250, 490, 240);
        // XXXX flecha izquierda
        g.drawLine(0, 250, 10, 260);
        g.drawLine(0, 250, 10, 240);
    }

    public static void DibujarLiena(Graphics g, int x1, int y1, int x2, int y2) {
        x1 = x1 + 250;
        y1 = 250 - y1;
        x2 = x2 + 250;
        y2 = 250 - y2;

        //diferenciaX y diferenciaY
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);

        //signo de la direccion Si x2 > x1, sx será igual a 1 y la línea se 
        //dicuja hacia la derecha. Si x2 < x1, sx será igual a -1 y la línea se dibuja hacia la izquierda.
        int sx = (x1 < x2) ? 1 : -1;
        int sy = (y1 < y2) ? 1 : -1;
        //variable de desicion, para saber a donde moverse 
        int err = dx - dy;

        int contador = 0;
        while (true) {
            if (contador % 2 == 0) {
                g.drawLine(x1, y1, x1, y1);
            }
            contador++;

            if (x1 == x2 && y1 == y2) {
                break;
            }

            int e2 = 2 * err;
            if (e2 > -dy) {
                err -= dy;
                x1 += sx;
            }
            if (e2 < dx) {
                err += dx;
                y1 += sy;
            }
        }
    }
    
    public static void DibujarLineaChingona(Graphics g, int x1, int y1, int x2, int y2, double angle) {
        int xCentro = 250;
        int yCentro = 250;

        // Aplicar la rotación a los puntos de inicio y fin de la línea
        double anguloRadian = Math.toRadians(angle);

        int rotatedX1 = (int) ((x1 - xCentro) * Math.cos(anguloRadian) - (y1 - yCentro) * Math.sin(anguloRadian)) + xCentro;
        int rotatedY1 = (int) ((x1 - xCentro) * Math.sin(anguloRadian) + (y1 - yCentro) * Math.cos(anguloRadian)) + yCentro;

        int rotatedX2 = (int) ((x2 - xCentro) * Math.cos(anguloRadian) - (y2 - yCentro) * Math.sin(anguloRadian)) + xCentro;
        int rotatedY2 = (int) ((x2 - xCentro) * Math.sin(anguloRadian) + (y2 - yCentro) * Math.cos(anguloRadian)) + yCentro;

        // Dibujar la línea rotada
        DibujarLiena(g, rotatedX1, rotatedY1, rotatedX2, rotatedY2);
    }


    public static double AnguloLinea(int x1, int y1, int x2, int y2) {
        // Calcular la diferencia en las coordenadas x e y
        int dx = x2 - x1;
        int dy = y2 - y1;

        // Calcular el ángulo en radianes
        double angulo = Math.atan2(dy, dx);

        // Convertir el ángulo a grados
        double grados = Math.toDegrees(angulo);

        // Asegurarse de que el ángulo esté en el rango de 0 a 360 grados
        if (grados < 0) {
            grados += 360;
        }

        return grados;
    }
    
    
    public static void DibujarLineaConAngulo(Graphics g, int x1, int y1, int x2, int y2, double angle) {
        x1 = x1 + 250;
        y1 = 250 - y1;
        x2 = x2 + 250;
        y2 = 250 - y2;
        // Calculamos los puntos finales de la línea teniendo en cuenta el ángulo
        int x3 = (int) (x1 + Math.cos(Math.toRadians(angle)) * 100);
        int y3 = (int) (y1 + Math.sin(Math.toRadians(angle)) * 100);
        // Dibujamos la línea
        g.drawLine(x1, y1, x3, y3);
    }
    
    

    public static void DibujarCirculo(Graphics g, int xcentro, int ycentro, int radio) {
        int xCentro = 250 + xcentro;
        int yCentro = 250 - ycentro;

        int x = radio;
        int y = 0;

        int p = 1 - radio;

        while (x >= y) {
            // Dibujar los puntos del círculo en los cuatro cuadrantes
            g.drawLine(xCentro + x, yCentro + y, xCentro + x, yCentro + y);
            g.drawLine(xCentro - x, yCentro + y, xCentro - x, yCentro + y);
            g.drawLine(xCentro + x, yCentro - y, xCentro + x, yCentro - y);
            g.drawLine(xCentro - x, yCentro - y, xCentro - x, yCentro - y);

            g.drawLine(xCentro + y, yCentro + x, xCentro + y, yCentro + x);
            g.drawLine(xCentro - y, yCentro + x, xCentro - y, yCentro + x);
            g.drawLine(xCentro + y, yCentro - x, xCentro + y, yCentro - x);
            g.drawLine(xCentro - y, yCentro - x, xCentro - y, yCentro - x);

            y++;

            // Decisiones de Bresenham
            if (p < 0) {
                p = p + 2 * y + 1;
            } else {
                x--;
                p = p + 2 * (y - x) + 1;
            }
        }
    }

    public static void DibujarRectangulo(Graphics g, int x, int y, int width, int height) {
        int xCentro = x + width / 2;
        int yCentro = y + height / 2;

        DibujarLiena(g, x, y, x + width, y); // Borde superior
        DibujarLiena(g, x + width, y, x + width, y + height); // Borde derecho
        DibujarLiena(g, x + width, y + height, x, y + height); // Borde inferior
        DibujarLiena(g, x, y + height, x, y); // Borde izquierdo
    }
    
    public static void DibujarRectanguloConAngulo(Graphics g, int x, int y, int width, int height, double angle) {
        int xCentro = x + width / 2;
        int yCentro = y + height / 2;

        int[] xPuntos = new int[4];
        int[] yPuntos = new int[4];

        double anguloRadian = Math.toRadians(angle);

        // Calcular las coordenadas rotadas para cada vértice del cuadrado
        xPuntos[0] = (int) (x - xCentro);
        yPuntos[0] = (int) (y - yCentro);
        xPuntos[1] = (int) (x + width - xCentro);
        yPuntos[1] = (int) (y - yCentro);
        xPuntos[2] = (int) (x + width - xCentro);
        yPuntos[2] = (int) (y + height - yCentro);
        xPuntos[3] = (int) (x - xCentro);
        yPuntos[3] = (int) (y + height - yCentro);

        for (int i = 0; i < 4; i++) {
            double rotarX = xPuntos[i] * Math.cos(anguloRadian) - yPuntos[i] * Math.sin(anguloRadian);
            double rotarY = xPuntos[i] * Math.sin(anguloRadian) + yPuntos[i] * Math.cos(anguloRadian);

            xPuntos[i] = (int) (rotarX + xCentro);
            yPuntos[i] = (int) (rotarY + yCentro);
        }

        // Dibujar el cuadrado rotado
        for (int i = 0; i < 4; i++) {
            int siguienteIndice = (i + 1) % 4;
            DibujarLiena(g, xPuntos[i], yPuntos[i], xPuntos[siguienteIndice], yPuntos[siguienteIndice]);
        }
    }

    public static void DibujarTriangulo(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3) {
        int xCentro = (x1 + x2 + x3) / 3;
        int yCentro = (y1 + y2 + y3) / 3;

        // Dibujar las líneas del triángulo
        DibujarLiena(g, x1, y1, x2, y2);
        DibujarLiena(g, x2, y2, x3, y3);
        DibujarLiena(g, x3, y3, x1, y1); 
    }
    
    public static void DibujarTriangulo(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, double angle) {
        int xCentro = (x1 + x2 + x3) / 3;
        int yCentro = (y1 + y2 + y3) / 3;

        // Calcular las coordenadas rotadas para cada vértice del triángulo
        double AnguloRadian = Math.toRadians(angle);

        int[] xPuntos = new int[3];
        int[] yPuntos = new int[3];

        xPuntos[0] = (int) (x1 - xCentro);
        yPuntos[0] = (int) (y1 - yCentro);
        xPuntos[1] = (int) (x2 - xCentro);
        yPuntos[1] = (int) (y2 - yCentro);
        xPuntos[2] = (int) (x3 - xCentro);
        yPuntos[2] = (int) (y3 - yCentro);

        for (int i = 0; i < 3; i++) {
            double rotarX = xPuntos[i] * Math.cos(AnguloRadian) - yPuntos[i] * Math.sin(AnguloRadian);
            double rotarY = xPuntos[i] * Math.sin(AnguloRadian) + yPuntos[i] * Math.cos(AnguloRadian);

            xPuntos[i] = (int) (rotarX + xCentro);
            yPuntos[i] = (int) (rotarY + yCentro);
        }

        // Dibujar el triángulo rotado
        DibujarLiena(g, xPuntos[0], yPuntos[0], xPuntos[1], yPuntos[1]);
        DibujarLiena(g, xPuntos[1], yPuntos[1], xPuntos[2], yPuntos[2]);
        DibujarLiena(g, xPuntos[2], yPuntos[2], xPuntos[0], yPuntos[0]);
    }


    public static void DibujarElipse(Graphics g, int x, int y, int width, int height) {

        int xCentro = (250) + (x + width / 2);
        int yCentro = (250) - (y + height / 2);

        int a = width / 2;
        int b = height / 2;

        int xSq = a * a;
        int ySq = b * b;

        int x0 = 0;
        int y0 = b;
        int p = 2 * ySq - 2 * b * xSq + xSq;

        DibujarPuntosDeElipse(g, xCentro, yCentro, x0, y0);

        while (xSq * (y0 - 0.5) > ySq * (x0 + 1)) {
            if (p < 0) {
                x0++;
                p += 2 * ySq * x0 + ySq;
            } else {
                x0++;
                y0--;
                p += 2 * ySq * x0 - 2 * xSq * y0 + ySq;
            }

            DibujarPuntosDeElipse(g, xCentro, yCentro, x0, y0);
        }

        p = (int) (ySq * (x0 + 0.5) * (x0 + 0.5) + xSq * (y0 - 1) * (y0 - 1) - xSq * ySq);

        while (y0 > 0) {
            if (p < 0) {
                y0--;
                x0++;
                p += 2 * ySq * x0 - 2 * xSq * y0 + xSq;
            } else {
                y0--;
                p -= 2 * xSq * y0 + xSq;
            }

            DibujarPuntosDeElipse(g, xCentro, yCentro, x0, y0);
        }
    }
    
    public static void DibujarElipseConAngulo(Graphics g, int x, int y, int width, int height, double angle) {
        int xCentro = 250 + (x + width / 2);
        int yCentro = 250 - (y + height / 2);

        int a = width / 2;
        int b = height / 2;

        double AnguloRadian = Math.toRadians(angle);

        // Calcular las coordenadas rotadas para cada punto de la elipse
        for (int t = 0; t <= 360; t++) {
            double anguloT = Math.toRadians(t);
            double rotarX = a * Math.cos(anguloT) * Math.cos(AnguloRadian) - b * Math.sin(anguloT) * Math.sin(AnguloRadian);
            double rotarY = a * Math.cos(anguloT) * Math.sin(AnguloRadian) + b * Math.sin(anguloT) * Math.cos(AnguloRadian);

            int xPoint = (int) (rotarX + xCentro);
            int yPoint = (int) (rotarY + yCentro);

            DibujarPuntoDeElipseConAngulo(g, xPoint, yPoint);
        }
    }
    
    private static void DibujarPuntoDeElipseConAngulo(Graphics g, int x, int y) {
        g.drawLine(x, y, x, y);
    }



    public static void DibujarPuntosDeElipse(Graphics g, int xCentro, int yCentro, int x, int y) {
        g.drawLine(xCentro + x, yCentro + y, xCentro + x, yCentro + y);
        g.drawLine(xCentro - x, yCentro + y, xCentro - x, yCentro + y);
        g.drawLine(xCentro + x, yCentro - y, xCentro + x, yCentro - y);
        g.drawLine(xCentro - x, yCentro - y, xCentro - x, yCentro - y);
    }

    public static void DibujarLineaRotada(Graphics g, int x1, int y1, int x2, int y2, double angle) {
        // Convertir a coordenadas polares    
        double x = x2 - x1;
        double y = y2 - y1;
        double radian = Math.toRadians(angle);
        double cosa = Math.cos(radian);
        double sina = Math.sin(radian);
        // Rotar usando transformada afín    
        int rx1 = (int) (x1 + x * cosa - y * sina);
        int ry1 = (int) (y1 + x * sina + y * cosa);
        int rx2 = (int) (x2 + x * cosa - y * sina);
        int ry2 = (int) (y2 + x * sina + y * cosa);
        // Trazar la línea rotada    

        x1 = rx1;
        y1 = ry1;
        x2 = rx2;
        y2 = ry2;

        DibujarLiena(g, rx1, ry1, rx2, ry2);
    }
}
