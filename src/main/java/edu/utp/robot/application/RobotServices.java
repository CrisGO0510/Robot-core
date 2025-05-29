package edu.utp.robot.application;

import edu.utp.robot.domain.Robot;
import edu.utp.robot.domain.module.dynamic.Extension;
import edu.utp.robot.domain.module.dynamic.Rotation;
import edu.utp.robot.domain.module.dynamic.Helical;

public class RobotServices {
    private Robot robot;
    private Extension extension;
    private Rotation rotation;
    private Helical helical;

    public RobotServices(Robot robot, Extension extension, Rotation rotation, Helical helical) {
        this.robot = robot;
        this.extension = extension;
        this.rotation = rotation;
        this.helical = helical;
    }

    public void iniciarRobot() {
        robot.encender();
        System.out.println("Robot iniciado y listo para operar.");
    }

    public void detenerRobot() {
        robot.apagar();
        System.out.println("Robot detenido.");
    }

    public void avanzarPasos(int pasos) {
        for (int i = 0; i < pasos; i++) {
            extension.avanzar();
        }
    }

    public void realizarMovimientoHelicoidal() {
        helical.moverse(new float[]{});
    }

    public void girarDerecha() {
        rotation.girarDerecha();
    }

    public void girarIzquierda() {
        rotation.girarIzquierda();
    }
}
