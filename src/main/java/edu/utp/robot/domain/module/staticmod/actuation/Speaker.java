package edu.utp.robot.domain.module.staticmod.actuation;

public class Speaker extends Actuacion {
    private boolean encendido = false;
    private int ultimaAccion = -1;

    public Speaker(int N_Actuadores) {
        super(N_Actuadores);
    }

    @Override
    public int realizarAccion() {
        if (!encendido) {
            System.out.println("Altavoz apagado. No puede emitir sonido.");
            return -1;
        }
        System.out.println("Altavoz emitiendo sonido...");
        ultimaAccion = 1;
        return 1;
    }

    @Override
    public void encender() {
        encendido = true;
        System.out.println("Altavoz encendido.");
    }

    @Override
    public void apagar() {
        encendido = false;
        System.out.println("Altavoz apagado.");
    }

    @Override
    public void recibirInfoAccion(int accion) {
        this.ultimaAccion = accion;
        System.out.println("Altavoz recibió info de acción: " + accion);
    }

    @Override
    public boolean enviarRespuestaAccion() {
        System.out.println("Altavoz responde a la acción: " + ultimaAccion);
        return encendido && ultimaAccion != -1;
    }

    @Override
    public String[] gestionarSolucion(int parametro) {
        String resultado = "Altavoz gestionó solución para parámetro: " + parametro;
        System.out.println(resultado);
        return new String[]{resultado};
    }
}
