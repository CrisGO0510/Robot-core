package edu.utp.robot.infrastructure.actuactors;

public class VirtualMovementEngine {

    public VirtualMovementEngine() {
        // Inicialización si es necesaria
    }

    public void moverAdelante(int pasos) {
        System.out.println("Simulación: Moviendo adelante " + pasos + " pasos.");
    }

    public void moverAtras(int pasos) {
        System.out.println("Simulación: Moviendo atrás " + pasos + " pasos.");
    }

    public void girarDerecha() {
        System.out.println("Simulación: Girando a la derecha.");
    }

    public void girarIzquierda() {
        System.out.println("Simulación: Girando a la izquierda.");
    }

    public void movimientoHelicoidal() {
        System.out.println("Simulación: Movimiento helicoidal.");
    }
}
