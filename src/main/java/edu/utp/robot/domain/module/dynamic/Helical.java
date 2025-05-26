package edu.utp.robot.domain.module.dynamic;

public class Helical extends DynamicModule {

    public Helical(int N_Motores) {
        super(N_Motores);
    }

    @Override
    public int moverse(float[] parametros) {
        // Lógica específica para el movimiento helicoidal
        System.out.println("Moviendo en modo Helicoidal con " + getN_Motores() + " motores.");
        return 3; // Retorna un valor de ejemplo
    }
}
