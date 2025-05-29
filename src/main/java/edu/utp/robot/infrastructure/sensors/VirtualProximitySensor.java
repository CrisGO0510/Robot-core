package edu.utp.robot.infrastructure.sensors;

public class VirtualProximitySensor {

    public VirtualProximitySensor() {
        // Inicialización si es necesaria
    }

    /**
     * Simula la detección de un obstáculo a una distancia dada.
     * @param distancia La distancia a la que se desea detectar.
     * @return true si hay obstáculo, false si no.
     */
    public boolean detectarObstaculo(double distancia) {
        // Lógica simulada: por ejemplo, obstáculo si distancia < 1.0
        boolean hayObstaculo = distancia < 1.0;
        System.out.println("Simulación: Sensor de proximidad detecta obstáculo: " + hayObstaculo);
        return hayObstaculo;
    }

    public void encender() {
        System.out.println("Simulación: Sensor de proximidad encendido.");
    }

    public void apagar() {
        System.out.println("Simulación: Sensor de proximidad apagado.");
    }
}
