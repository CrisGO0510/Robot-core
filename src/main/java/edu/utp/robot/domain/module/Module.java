package edu.utp.robot.domain.module;

public abstract class Module {
    // Atributos
    protected int id;
    protected String referencia;
    protected String descripcion;
    protected int largo;
    protected int ancho;
    protected int profundidad;

    // Métodos
    public abstract void encender();
    public abstract void apagar();
    public abstract void recibirInfoAccion(int accion);
    public abstract boolean enviarRespuestaAccion();
    public abstract String[] gestionarSolucion(int parametro);

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getReferencia() { return referencia; }
    public void setReferencia(String referencia) { this.referencia = referencia; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public int getLargo() { return largo; }
    public void setLargo(int largo) { this.largo = largo; }

    public int getAncho() { return ancho; }
    public void setAncho(int ancho) { this.ancho = ancho; }

    public int getProfundidad() { return profundidad; }
    public void setProfundidad(int profundidad) { this.profundidad = profundidad; }
}
