package edu.utp.robot.infrastructure.actuactors;

public class VirtualSpeaker {

    public VirtualSpeaker() {
        // Inicialización si es necesaria
    }

    public void emitirSonido(String sonido) {
        System.out.println("Simulación: Altavoz emitiendo sonido -> " + sonido);
    }

    public void encender() {
        System.out.println("Simulación: Altavoz encendido.");
    }

    public void apagar() {
        System.out.println("Simulación: Altavoz apagado.");
    }
}
