package edu.utp.robot.domain;

public class Robot {
    private String serie;
    private String alias;
    private String descripcion;

    public Robot(String serie, String alias, String descripcion) {
        this.serie = serie;
        this.alias = alias;
        this.descripcion = descripcion;
    }

    public void encender() {
        // Lógica para encender el robot
        System.out.println(alias + " (Serie: " + serie + ") encendido.");
    }

    public void apagar() {
        // Lógica para apagar el robot
        System.out.println(alias + " (Serie: " + serie + ") apagado.");
    }

    // Getters y setters
    public String getSerie() { return serie; }
    public void setSerie(String serie) { this.serie = serie; }

    public String getAlias() { return alias; }
    public void setAlias(String alias) { this.alias = alias; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
