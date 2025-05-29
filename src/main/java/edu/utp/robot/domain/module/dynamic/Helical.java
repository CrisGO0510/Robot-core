package edu.utp.robot.domain.module.dynamic;

import edu.utp.robot.infrastructure.environment.VirtualWorldMap;

public class Helical extends DynamicModule {

    private VirtualWorldMap worldMap;

    public Helical(int N_Motores, VirtualWorldMap worldMap) {
        super(N_Motores);
        this.worldMap = worldMap;
    }

    @Override
    public int moverse(float[] parametros) {
        // Movimiento helicoidal: avanza en diagonal (x+1, y+1)
        int pasos = parametros.length > 0 ? Math.round(parametros[0]) : 1;
        int movidos = 0;
        for (int i = 0; i < pasos; i++) {
            // Intenta moverse en diagonal
            if (worldMap.moverRobot(1, 1)) {
                movidos++;
            } else if (worldMap.moverRobot(1, 0)) {
                // Si no puede en diagonal, intenta abajo
                movidos++;
            } else if (worldMap.moverRobot(0, 1)) {
                // Si no puede abajo, intenta derecha
                movidos++;
            } else {
                // No puede moverse más
                break;
            }
        }
        System.out.println("Moviendo en modo Helicoidal con " + getN_Motores() + " motores. Pasos efectivos: " + movidos);
        return movidos;
    }

    @Override
    public void encender() {
        System.out.println("Módulo helicoidal encendido.");
    }

    @Override
    public void apagar() {
        System.out.println("Módulo helicoidal apagado.");
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
        return new String[]{"Solución helicoidal generada"};
    }
}
