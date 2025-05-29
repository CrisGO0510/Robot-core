package edu.utp.robot.domain.module.Static.perception;

public class Camera extends Perception {
    private int id;
    private String tipo;
    private String descripcion;
    private boolean encendida = false;
    private Object ultimaCaptura = null;

    public Camera(int N_Sensores, int id, String tipo, String descripcion) {
        super(N_Sensores);
        this.id = id;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    @Override
    public Object procesarDatos(Object datos) {
        if (!encendida) {
            System.out.println("Cámara " + id + " (" + tipo + ") está apagada. No puede procesar datos.");
            return null;
        }
        // Simulación: si los datos contienen la palabra "animal", detecta un animal
        if (datos != null && datos.toString().toLowerCase().contains("animal")) {
            String resultado = "Cámara " + id + ": ¡Animal detectado!";
            System.out.println(resultado);
            return resultado;
        }
        String resultado = "Cámara " + id + ": No se detectó nada relevante.";
        System.out.println(resultado);
        return resultado;
    }

    @Override
    public Object captarInformacion() {
        if (!encendida) {
            System.out.println("Cámara " + id + " (" + tipo + ") está apagada. No puede captar información.");
            return null;
        }
        // Simulación: genera una "imagen" aleatoria (puedes cambiar esto por una imagen real si lo deseas)
        ultimaCaptura = "Imagen simulada por cámara " + id;
        System.out.println("Cámara " + id + " captó información visual.");
        return ultimaCaptura;
    }

    @Override
    public void encender() {
        encendida = true;
        System.out.println("Cámara " + id + " (" + tipo + ") encendida.");
    }

    @Override
    public void apagar() {
        encendida = false;
        System.out.println("Cámara " + id + " (" + tipo + ") apagada.");
    }

    @Override
    public void recibirInfoAccion(int accion) {
        System.out.println("Cámara " + id + " recibió info de acción: " + accion);
    }

    @Override
    public boolean enviarRespuestaAccion() {
        System.out.println("Cámara " + id + " responde a la acción.");
        return encendida;
    }

    @Override
    public String[] gestionarSolucion(int parametro) {
        String resultado = "Cámara " + id + " gestionó solución para parámetro: " + parametro;
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

    public boolean isEncendida() { return encendida; }
    public Object getUltimaCaptura() { return ultimaCaptura; }
}
