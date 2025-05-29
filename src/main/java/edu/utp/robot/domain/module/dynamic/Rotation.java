package edu.utp.robot.domain.module.dynamic;

import edu.utp.robot.infrastructure.environment.VirtualWorldMap;

public class Rotation extends DynamicModule {

    private VirtualWorldMap worldMap;
    private Runnable onRotateCallback; // Para notificar a la UI

    public Rotation(int N_Motores, VirtualWorldMap worldMap, Runnable onRotateCallback) {
        super(N_Motores);
        this.worldMap = worldMap;
        this.onRotateCallback = onRotateCallback;
    }

    @Override
    public int moverse(float[] parametros) {
        System.out.println("Moviendo en modo Rotación con " + getN_Motores() + " motores.");
        return 2;
    }

    /**
     * Gira el robot hacia la derecha.
     */
    public void girarDerecha() {
        if (worldMap != null) {
            worldMap.girarDerecha(); // Implementa este método en VirtualWorldMap
        }
        System.out.println("Girando a la derecha.");
        if (onRotateCallback != null) onRotateCallback.run(); // Notifica a la UI
    }

    /**
     * Gira el robot hacia la izquierda.
     */
    public void girarIzquierda() {
        if (worldMap != null) {
            worldMap.girarIzquierda(); // Implementa este método en VirtualWorldMap
        }
        System.out.println("Girando a la izquierda.");
        if (onRotateCallback != null) onRotateCallback.run(); // Notifica a la UI
    }

    // Métodos abstractos heredados de Module
    @Override
    public void encender() {
        System.out.println("Módulo de rotación encendido.");
    }

    @Override
    public void apagar() {
        System.out.println("Módulo de rotación apagado.");
    }

    @Override
    public void recibirInfoAccion(int accion) {
        System.out.println("Recibiendo acción de rotación: " + accion);
    }

    @Override
    public boolean enviarRespuestaAccion() {
        System.out.println("Enviando respuesta de rotación.");
        return true;
    }

    @Override
    public String[] gestionarSolucion(int parametro) {
        System.out.println("Gestionando solución de rotación para parámetro: " + parametro);
        return new String[]{"Solución de rotación generada"};
    }
}
