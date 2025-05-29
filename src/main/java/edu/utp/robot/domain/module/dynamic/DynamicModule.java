package edu.utp.robot.domain.module.dynamic;

import edu.utp.robot.domain.module.Module;

public abstract class DynamicModule extends Module {
    // Atributo privado para el número de motores
    private int N_Motores;

    // Constructor para inicializar el número de motores
    public DynamicModule(int N_Motores) {
        super(); // Llama al constructor de Module
        this.N_Motores = N_Motores;
    }

    // Getter para N_Motores
    public int getN_Motores() {
        return N_Motores;
    }

    // Setter para N_Motores
    public void setN_Motores(int N_Motores) {
        this.N_Motores = N_Motores;
    }

    // Método abstracto que debe ser implementado por las subclases
    public abstract int moverse(float[] parametros);
}
