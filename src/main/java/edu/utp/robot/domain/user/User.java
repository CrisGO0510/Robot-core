package edu.utp.robot.domain.user;

public class User {
    private int id;
    private String alias;
    private String tipo;

    public User(int id, String alias, String tipo) {
        this.id = id;
        this.alias = alias;
        this.tipo = tipo;
    }

    public void enviarMensaje(String[] mensaje) {
        // Lógica para enviar mensaje
        System.out.println(alias + " envía mensaje: " + String.join(", ", mensaje));
    }

    public void recibirMensaje(String[] mensaje) {
        // Lógica para recibir mensaje
        System.out.println(alias + " recibe mensaje: " + String.join(", ", mensaje));
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getAlias() { return alias; }
    public void setAlias(String alias) { this.alias = alias; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}
