package edu.utp.robot.application;

import edu.utp.robot.domain.Robot;
import edu.utp.robot.domain.module.dynamic.Extension;
import edu.utp.robot.domain.module.dynamic.Rotation;
import edu.utp.robot.domain.module.dynamic.Helical;

public class CommandHandler {
    private Robot robot;
    private Extension extension;
    private Rotation rotation;
    private Helical helical;

    public CommandHandler(Robot robot, Extension extension, Rotation rotation, Helical helical) {
        this.robot = robot;
        this.extension = extension;
        this.rotation = rotation;
        this.helical = helical;
    }

    public void handleCommand(String command) {
        switch (command.toLowerCase()) {
            case "encender":
                robot.encender();
                break;
            case "apagar":
                robot.apagar();
                break;
            case "avanzar":
                extension.avanzar();
                break;
            case "retroceder":
                extension.retroceder();
                break;
            case "girar derecha":
                rotation.girarDerecha();
                break;
            case "girar izquierda":
                rotation.girarIzquierda();
                break;
            case "helicoidal":
                helical.moverse(new float[]{});
                break;
            default:
                System.out.println("Comando no reconocido: " + command);
        }
    }
}
