package edu.utp.robot.domain.module.staticmod.actuation;
import edu.utp.robot.domain.module.staticmod.StaticModule;

public abstract class Actuacion extends StaticModule {
    protected int N_Actuadores;

    public Actuacion(int N_Actuadores) {
        super();
        this.N_Actuadores = N_Actuadores;
    }

    public abstract int realizarAccion();

    public int getN_Actuadores() {
        return N_Actuadores;
    }

    public void setN_Actuadores(int n_Actuadores) {
        N_Actuadores = n_Actuadores;
    }
}
