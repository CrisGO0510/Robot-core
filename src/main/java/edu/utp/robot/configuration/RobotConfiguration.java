package edu.utp.robot.configuration;

public class RobotConfiguration {
    // Parámetros de configuración por defecto
    private String robotSerie = "1234";
    private String robotAlias = "Robo1";
    private String robotDescripcion = "Robot de pruebas";
    private int extensionMotores = 2;
    private int rotationMotores = 2;
    private int helicalMotores = 3;

    // Constructor vacío o con lógica para cargar configuración externa
    public RobotConfiguration() {
        // Aquí podrías cargar configuración desde un archivo o argumentos si lo deseas
    }

    // Getters
    public String getRobotSerie() { return robotSerie; }
    public String getRobotAlias() { return robotAlias; }
    public String getRobotDescripcion() { return robotDescripcion; }
    public int getExtensionMotores() { return extensionMotores; }
    public int getRotationMotores() { return rotationMotores; }
    public int getHelicalMotores() { return helicalMotores; }

    // Setters si necesitas modificar la configuración en tiempo de ejecución
    public void setRobotSerie(String robotSerie) { this.robotSerie = robotSerie; }
    public void setRobotAlias(String robotAlias) { this.robotAlias = robotAlias; }
    public void setRobotDescripcion(String robotDescripcion) { this.robotDescripcion = robotDescripcion; }
    public void setExtensionMotores(int extensionMotores) { this.extensionMotores = extensionMotores; }
    public void setRotationMotores(int rotationMotores) { this.rotationMotores = rotationMotores; }
    public void setHelicalMotores(int helicalMotores) { this.helicalMotores = helicalMotores; }
}
