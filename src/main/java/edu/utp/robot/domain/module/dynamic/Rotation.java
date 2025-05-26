package edu.utp.robot.domain.module.dynamic;

public class Rotation extends DynamicModule {

    public Rotation(int N_Motores) {
        super(N_Motores);
    }

    @Override
    public int moverse(float[] parametros) {
        // Lógica específica para el movimiento de rotación
        System.out.println("Moviendo en modo Rotación con " + getN_Motores() + " motores.");
        return 2; // Retorna un valor de ejemplo
    }
}
