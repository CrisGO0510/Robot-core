package edu.utp.robot.domain.communication;

public class Message {
    private String contenido;
    private int remitenteId;
    private int destinatarioId;
    private long timestamp;

    public Message(String contenido, int remitenteId, int destinatarioId) {
        this.contenido = contenido;
        this.remitenteId = remitenteId;
        this.destinatarioId = destinatarioId;
        this.timestamp = System.currentTimeMillis();
    }

    // Getters y setters
    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }

    public int getRemitenteId() { return remitenteId; }
    public void setRemitenteId(int remitenteId) { this.remitenteId = remitenteId; }

    public int getDestinatarioId() { return destinatarioId; }
    public void setDestinatarioId(int destinatarioId) { this.destinatarioId = destinatarioId; }

    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }
}
