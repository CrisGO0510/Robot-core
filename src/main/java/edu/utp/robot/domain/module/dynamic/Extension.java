package edu.utp.robot.domain.module.dynamic;

public class Extension extends DynamicModule {

    public Extension(int N_Motores) {
        super(N_Motores);
    }

    @Override
    public int moverse(float[] parametros) {
        // Lógica específica para el movimiento de extensión
        System.out.println("Moviendo en modo Extensión con " + getN_Motores() + " motores.");
        return 1; // Retorna un valor de ejemplo
    }
}
