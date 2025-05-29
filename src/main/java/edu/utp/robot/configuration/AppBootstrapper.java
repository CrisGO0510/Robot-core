package edu.utp.robot.configuration;

import edu.utp.robot.domain.Robot;
import edu.utp.robot.domain.module.dynamic.Extension;
import edu.utp.robot.domain.module.dynamic.Rotation;
import edu.utp.robot.domain.module.dynamic.Helical;
import edu.utp.robot.infrastructure.environment.VirtualWorldMap;
import edu.utp.robot.application.RobotServices;
import edu.utp.robot.application.CommandHandler;

public class AppBootstrapper {

    private Robot robot;
    private Extension extension;
    private Rotation rotation;
    private Helical helical;
    private RobotServices robotServices;
    private CommandHandler commandHandler;
    private VirtualWorldMap worldMap;

    public void initialize() {
        // Instanciar el mapa antes de los módulos
        worldMap = new VirtualWorldMap();

        // Instanciar los módulos y servicios principales
        robot = new Robot("1234", "Robo1", "Robot de pruebas");
        extension = new Extension(2, worldMap);
        rotation = new Rotation(2, worldMap, () -> {/* repintar panel o dejar vacío si no hay UI aquí */});
        helical = new Helical(3, worldMap);

        robotServices = new RobotServices(robot, extension, rotation, helical);
        commandHandler = new CommandHandler(robot, extension, rotation, helical);

        System.out.println("Sistema inicializado correctamente.");
    }

    public RobotServices getRobotServices() {
        return robotServices;
    }

    public CommandHandler getCommandHandler() {
        return commandHandler;
    }

    public VirtualWorldMap getWorldMap() {
        return worldMap;
    }
}
