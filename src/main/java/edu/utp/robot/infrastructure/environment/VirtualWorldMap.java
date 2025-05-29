package edu.utp.robot.infrastructure.environment;

import java.util.HashSet;
import java.util.Set;

public class VirtualWorldMap {
    // Representa obstáculos como coordenadas (x, y)
    private Set<Position> obstaculos = new HashSet<>();
    private int filas = 10, columnas = 10; // Tamaño del mapa
    private int robotX = 0, robotY = 0;    // Posición inicial del robot

    // Orientación del robot
    public enum Direccion { NORTE, ESTE, SUR, OESTE }
    private Direccion orientacion = Direccion.NORTE;

    public VirtualWorldMap() {
        // Ejemplo: agrega algunos obstáculos por defecto
        agregarObstaculo(1, 1);
        agregarObstaculo(2, 2);
        agregarObstaculo(0, 2);
    }

    public void agregarObstaculo(int x, int y) {
        obstaculos.add(new Position(x, y));
    }

    public boolean hayObstaculo(int x, int y) {
        return obstaculos.contains(new Position(x, y));
    }

    // Intenta mover el robot en la dirección indicada (dx, dy)
    // Retorna true si el movimiento fue exitoso, false si hay obstáculo o fuera de límites
    public boolean moverRobot(int dx, int dy) {
        int nuevoX = robotX + dx;
        int nuevoY = robotY + dy;
        if (nuevoX < 0 || nuevoX >= filas || nuevoY < 0 || nuevoY >= columnas) return false;
        if (hayObstaculo(nuevoX, nuevoY)) return false;
        robotX = nuevoX;
        robotY = nuevoY;
        return true;
    }

    public int getRobotX() { return robotX; }
    public int getRobotY() { return robotY; }

    // Métodos de orientación
    public void girarDerecha() {
        switch (orientacion) {
            case NORTE: orientacion = Direccion.ESTE; break;
            case ESTE: orientacion = Direccion.SUR; break;
            case SUR: orientacion = Direccion.OESTE; break;
            case OESTE: orientacion = Direccion.NORTE; break;
        }
        System.out.println("Nueva orientación: " + orientacion);
    }

    public void girarIzquierda() {
        switch (orientacion) {
            case NORTE: orientacion = Direccion.OESTE; break;
            case OESTE: orientacion = Direccion.SUR; break;
            case SUR: orientacion = Direccion.ESTE; break;
            case ESTE: orientacion = Direccion.NORTE; break;
        }
        System.out.println("Nueva orientación: " + orientacion);
    }

    public Direccion getOrientacion() {
        return orientacion;
    }

    // Clase interna para representar posiciones
    public static class Position {
        private int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Position other = (Position) obj;
            return x == other.x && y == other.y;
        }

        @Override
        public int hashCode() {
            return 31 * x + y;
        }
    }
}
