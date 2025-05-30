package edu.utp.robot.domain.module.staticmod.perception;

import edu.utp.robot.infrastructure.environment.VirtualWorldMap;

public class SensorProximity extends Perception {
    private boolean encendido = false;
    private Object ultimaLectura = null;
    private VirtualWorldMap worldMap;

    public SensorProximity(int N_Sensores, VirtualWorldMap worldMap) {
        super(N_Sensores);
        this.worldMap = worldMap;
    }

    @Override
    public Object captarInformacion() {
        int x = worldMap.getRobotX();
        int y = worldMap.getRobotY();
        int[][] dirs = { {1,0}, {-1,0}, {0,1}, {0,-1} };
        for (int[] d : dirs) {
            int nx = x + d[0];
            int ny = y + d[1];
            if (nx >= 0 && nx < 10 && ny >= 0 && ny < 10 && worldMap.hayObstaculo(nx, ny)) {
                ultimaLectura = "Obstáculo cercano";
                return ultimaLectura;
            }
        }
        ultimaLectura = "Libre";
        return ultimaLectura;
    }

    @Override
    public Object procesarDatos(Object datos) {
        if (!encendido) {
            System.out.println("Sensor de proximidad apagado. No puede procesar datos.");
            return null;
        }
        if (datos != null && datos.toString().toLowerCase().contains("obstáculo")) {
            String resultado = "¡Obstáculo detectado!";
            System.out.println(resultado);
            return resultado;
        }
        String resultado = "Nada detectado por proximidad.";
        System.out.println(resultado);
        return resultado;
    }

    @Override
    public void encender() {
        encendido = true;
        System.out.println("Sensor de proximidad encendido.");
    }

    @Override
    public void apagar() {
        encendido = false;
        System.out.println("Sensor de proximidad apagado.");
    }

    @Override
    public void recibirInfoAccion(int accion) {
        System.out.println("Sensor de proximidad recibió info de acción: " + accion);
    }

    @Override
    public boolean enviarRespuestaAccion() {
        System.out.println("Sensor de proximidad responde a la acción.");
        return encendido;
    }

    @Override
    public String[] gestionarSolucion(int parametro) {
        String resultado = "Sensor de proximidad gestionó solución para parámetro: " + parametro;
        System.out.println(resultado);
        return new String[]{resultado};
    }

    public boolean isEncendido() { return encendido; }
    public Object getUltimaLectura() { return ultimaLectura; }
}
