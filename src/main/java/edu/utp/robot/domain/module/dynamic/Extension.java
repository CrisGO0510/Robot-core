package edu.utp.robot.domain.module.dynamic;

import edu.utp.robot.infrastructure.environment.VirtualWorldMap;

public class Extension extends DynamicModule {

    private VirtualWorldMap worldMap;

    public Extension(int N_Motores, VirtualWorldMap worldMap) {
        super(N_Motores);
        this.worldMap = worldMap;
    }

    @Override
    public int moverse(float[] parametros) {
        // parametros[0]: pasos en X, parametros[1]: pasos en Y
        int dx = Math.round(parametros[0]);
        int dy = Math.round(parametros[1]);
        boolean exito = worldMap.moverRobot(dx, dy);
        System.out.println("Moviendo en modo Extensión con " + getN_Motores() + " motores. dx=" + dx + ", dy=" + dy);
        return exito ? 1 : 0;
    }

    /**
     * Avanza el robot un paso (ejemplo: hacia abajo).
     */
    public void avanzar() {
        moverse(new float[]{1, 0});
    }

    /**
     * Retrocede el robot un paso (ejemplo: hacia arriba).
     */
    public void retroceder() {
        moverse(new float[]{-1, 0});
    }

    // Métodos abstractos heredados de Module
    @Override
    public void encender() {
        System.out.println("Módulo de extensión encendido.");
    }

    @Override
    public void apagar() {
        System.out.println("Módulo de extensión apagado.");
    }

    @Override
    public void recibirInfoAccion(int accion) {
        System.out.println("Recibiendo acción: " + accion);
    }

    @Override
    public boolean enviarRespuestaAccion() {
        System.out.println("Enviando respuesta de acción.");
        return true;
    }

    @Override
    public String[] gestionarSolucion(int parametro) {
        System.out.println("Gestionando solución para parámetro: " + parametro);
        return new String[]{"Solución generada"};
    }
}
