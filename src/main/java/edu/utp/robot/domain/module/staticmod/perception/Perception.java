package edu.utp.robot.domain.module.staticmod.perception;

import edu.utp.robot.domain.module.staticmod.StaticModule;

public abstract class Perception extends StaticModule {
    protected int N_Sensores;

    public Perception(int N_Sensores) {
        super();
        this.N_Sensores = N_Sensores;
    }

    public abstract Object procesarDatos(Object datos);
    public abstract Object captarInformacion();

    public int getN_Sensores() {
        return N_Sensores;
    }

    public void setN_Sensores(int n_Sensores) {
        N_Sensores = n_Sensores;
    }
}
