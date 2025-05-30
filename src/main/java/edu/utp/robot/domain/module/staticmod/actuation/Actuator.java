package edu.utp.robot.domain.module.staticmod.actuation;

public class Actuator extends Actuacion {
    private int id;
    private String tipo;
    private String descripcion;
    private boolean encendido = false;
    private int ultimaAccion = -1;

    public Actuator(int N_Actuadores, int id, String tipo, String descripcion) {
        super(N_Actuadores);
        this.id = id;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    @Override
    public int realizarAccion() {
        if (!encendido) {
            System.out.println("Actuador " + id + " (" + tipo + ") está apagado. No puede realizar acción.");
            return -1;
        }
        System.out.println("Actuador " + id + " (" + tipo + ") realiza su acción principal.");
        ultimaAccion = 1; // Por ejemplo, 1 = acción realizada
        return 1;
    }

    @Override
    public void encender() {
        encendido = true;
        System.out.println("Actuador " + id + " (" + tipo + ") encendido.");
    }

    @Override
    public void apagar() {
        encendido = false;
        System.out.println("Actuador " + id + " (" + tipo + ") apagado.");
    }

    @Override
    public void recibirInfoAccion(int accion) {
        this.ultimaAccion = accion;
        System.out.println("Actuador " + id + " recibió info de acción: " + accion);
    }

    @Override
    public boolean enviarRespuestaAccion() {
        System.out.println("Actuador " + id + " responde a la acción: " + ultimaAccion);
        return encendido && ultimaAccion != -1;
    }

    @Override
    public String[] gestionarSolucion(int parametro) {
        String resultado = "Actuador " + id + " gestionó solución para parámetro: " + parametro;
        System.out.println(resultado);
        return new String[]{resultado};
    }

    // Getters y setters para los atributos propios
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
