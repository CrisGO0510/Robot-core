package edu.utp.robot.domain.control;

import java.util.function.Consumer;

public class ControlSystem {

    private Consumer<String> uiNotifier;

    public ControlSystem(Consumer<String> uiNotifier) {
        this.uiNotifier = uiNotifier;
    }

    public void interpretarMensaje(String mensaje) {
        System.out.println("Interpretando mensaje: " + mensaje);
        if (uiNotifier != null) uiNotifier.accept("Mensaje interpretado: " + mensaje);
    }

    public void informarAccion(String accion) {
        System.out.println("Acción informada: " + accion);
        if (uiNotifier != null) uiNotifier.accept("Acción realizada: " + accion);
    }

    // ...otros métodos...
}
