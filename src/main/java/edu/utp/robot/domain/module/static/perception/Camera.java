package edu.utp.robot.domain.module.Static.perception;

import edu.utp.robot.infrastructure.environment.VirtualWorldMap;

public class Camera extends Perception {
    private int id;
    private String tipo;
    private String descripcion;
    private boolean encendida = false;
    private Object ultimaCaptura = null;
    private VirtualWorldMap worldMap; // Referencia al mapa

    public Camera(int N_Sensores, int id, String tipo, String descripcion, VirtualWorldMap worldMap) {
        super(N_Sensores);
        this.id = id;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.worldMap = worldMap;
    }

    @Override
    public Object procesarDatos(Object datos) {
        if (!encendida) {
            System.out.println("Cámara " + id + " (" + tipo + ") está apagada. No puede procesar datos.");
            return null;
        }
        // Detecta animal o obstáculo
        if (datos != null && datos.toString().toLowerCase().contains("animal")) {
            String resultado = "Cámara " + id + ": ¡Animal detectado!";
            System.out.println(resultado);
            return resultado;
        }
        if (datos != null && datos.toString().toLowerCase().contains("obstáculo")) {
            String resultado = "Cámara " + id + ": ¡Obstáculo detectado!";
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
        int x = worldMap.getRobotX();
        int y = worldMap.getRobotY();
        // Revisa si hay obstáculo en la posición actual o adyacente
        int[][] dirs = { {0,0}, {1,0}, {-1,0}, {0,1}, {0,-1} };
        for (int[] d : dirs) {
            int nx = x + d[0];
            int ny = y + d[1];
            if (nx >= 0 && nx < 10 && ny >= 0 && ny < 10 && worldMap.hayObstaculo(nx, ny)) {
                ultimaCaptura = "Obstáculo detectado por cámara " + id;
                System.out.println(ultimaCaptura);
                return ultimaCaptura;
            }
        }
        ultimaCaptura = "Sin obstáculos en la vista de la cámara " + id;
        System.out.println(ultimaCaptura);
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
