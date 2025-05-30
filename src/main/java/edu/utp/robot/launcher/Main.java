package edu.utp.robot.launcher;

import edu.utp.robot.application.RobotServices;
import edu.utp.robot.domain.Robot;
import edu.utp.robot.domain.communication.CommunicationGateway;
import edu.utp.robot.domain.communication.Message;
import edu.utp.robot.domain.module.dynamic.Extension;
import edu.utp.robot.domain.module.dynamic.Helical;
import edu.utp.robot.domain.module.dynamic.Rotation;
import edu.utp.robot.domain.module.Static.actuation.Actuator;
import edu.utp.robot.domain.module.Static.perception.Camera;
import edu.utp.robot.domain.module.Static.perception.SensorProximity;
import edu.utp.robot.infrastructure.environment.VirtualWorldMap;
import edu.utp.robot.infrastructure.environment.VirtualWorldMap.Position;
import edu.utp.robot.infrastructure.actuactors.VirtualSpeaker;
import edu.utp.robot.configuration.RobotConfiguration;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Configuración del robot
            RobotConfiguration config = new RobotConfiguration();
            config.setRobotSerie("1234");
            config.setRobotAlias("Robo1");
            config.setRobotDescripcion("Robot de pruebas");
            config.setExtensionMotores(2);
            config.setRotationMotores(2);
            config.setHelicalMotores(3);

            // Inicialización de módulos y servicios principales
            VirtualWorldMap worldMap = new VirtualWorldMap();
            Extension extension = new Extension(config.getExtensionMotores(), worldMap);
            Rotation rotation = new Rotation(config.getRotationMotores(), worldMap, null);
            Helical helical = new Helical(config.getHelicalMotores(), worldMap);

            Robot robot = new Robot(config.getRobotSerie(), config.getRobotAlias(), config.getRobotDescripcion());
            RobotServices robotServices = new RobotServices(robot, extension, rotation, helical);

            // Módulos estáticos
            Actuator actuator = new Actuator(1, 1, "Luz", "Actuador de luz LED");

            // Sensores
            Camera camera = new Camera(1, 101, "Frontal", "Cámara HD frontal", worldMap);
            SensorProximity sensorProximity = new SensorProximity(1, worldMap);

            // Comunicación
            CommunicationGateway gateway = new CommunicationGateway();

            // VirtualSpeaker para el movimiento inteligente
            VirtualSpeaker virtualSpeaker = new VirtualSpeaker();

            // Animales y obstáculos
            Set<Position> animales = new HashSet<>();
            animales.add(new Position(3, 3));
            animales.add(new Position(6, 2));
            animales.add(new Position(8, 7));
            animales.add(new Position(1, 8));
            animales.add(new Position(5, 8));
            animales.add(new Position(2, 5));

            worldMap.agregarObstaculo(1, 1);
            worldMap.agregarObstaculo(2, 2);
            worldMap.agregarObstaculo(0, 2);
            worldMap.agregarObstaculo(4, 4);
            worldMap.agregarObstaculo(5, 5);
            worldMap.agregarObstaculo(7, 3);
            worldMap.agregarObstaculo(2, 7);
            worldMap.agregarObstaculo(9, 0);
            worldMap.agregarObstaculo(3, 6);
            worldMap.agregarObstaculo(8, 2);
            worldMap.agregarObstaculo(0, 5);
            worldMap.agregarObstaculo(1, 6);
            worldMap.agregarObstaculo(2, 9);
            worldMap.agregarObstaculo(4, 1);
            worldMap.agregarObstaculo(5, 3);
            worldMap.agregarObstaculo(6, 6);
            worldMap.agregarObstaculo(7, 8);

            JFrame frame = new JFrame("Robot GUI");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 500);

            final boolean[] robotEncendido = {false};

            JPanel campoPanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    int cellSize = 40;
                    for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < 10; j++) {
                            int x = j * cellSize;
                            int y = i * cellSize;
                            g.setColor(Color.LIGHT_GRAY);
                            g.drawRect(x, y, cellSize, cellSize);

                            if (worldMap.hayObstaculo(i, j)) {
                                g.setColor(Color.BLACK);
                                g.fillRect(x + 5, y + 5, cellSize - 10, cellSize - 10);
                            }
                            if (animales.contains(new Position(i, j))) {
                                g.setColor(Color.ORANGE);
                                g.fillOval(x + 10, y + 10, cellSize - 20, cellSize - 20);
                            }
                        }
                    }
                    int rx = worldMap.getRobotY() * cellSize;
                    int ry = worldMap.getRobotX() * cellSize;
                    g.setColor(Color.RED);
                    g.fillOval(rx + 10, ry + 10, cellSize - 20, cellSize - 20);
                }
            };
            campoPanel.setPreferredSize(new Dimension(400, 400));

            JLabel lblEstado = new JLabel("Posición: (0,0)");
            JLabel lblEncendido = new JLabel("Robot apagado");
            JLabel lblSensor = new JLabel("Sensor: ---");
            JLabel lblCamara = new JLabel("Cámara: ---");
            JLabel lblActuador = new JLabel("Actuador: ---");
            JLabel lblComunicacion = new JLabel("Comunicación: ---");
            JLabel lblAccion = new JLabel("Acción: ---");

            JButton btnEncender = new JButton("Encender Robot");
            JButton btnApagar = new JButton("Apagar Robot");
            JButton btnAvanzarInteligente = new JButton("Iniciar Movimiento Inteligente");
            JButton btnSensor = new JButton("Leer Sensor Proximidad");
            JButton btnCamara = new JButton("Captar Cámara");
            JButton btnActuador = new JButton("Activar Actuador");
            JButton btnComunicar = new JButton("Enviar Mensaje");

            btnEncender.addActionListener(e -> {
                robotServices.iniciarRobot();
                robotEncendido[0] = true;
                lblEncendido.setText("Robot encendido");
            });

            btnApagar.addActionListener(e -> {
                robotServices.detenerRobot();
                robotEncendido[0] = false;
                lblEncendido.setText("Robot apagado");
            });

            btnAvanzarInteligente.addActionListener(e -> {
                if (!robotEncendido[0]) {
                    JOptionPane.showMessageDialog(frame, "El robot está apagado.");
                    return;
                }
                String pasosStr = JOptionPane.showInputDialog(frame, "¿Cuántos pasos avanzar?");
                if (pasosStr == null) return;
                int pasos;
                try {
                    pasos = Integer.parseInt(pasosStr);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Número de pasos inválido.");
                    return;
                }
                moverInteligente(pasos, worldMap, animales, virtualSpeaker, frame, campoPanel, lblEstado, lblAccion, robotEncendido, extension, rotation, helical);
            });

            btnSensor.addActionListener(e -> {
                sensorProximity.encender();
                Object lectura = sensorProximity.captarInformacion();
                lblSensor.setText("Sensor: " + (lectura != null ? lectura : "Sin lectura"));
                sensorProximity.apagar();
            });

            btnCamara.addActionListener(e -> {
                camera.encender();
                Object captura = camera.captarInformacion();
                Object resultado = camera.procesarDatos(captura);
                lblCamara.setText("Cámara: " + (resultado != null ? resultado : "Sin datos"));
                camera.apagar();
            });

            btnActuador.addActionListener(e -> {
                actuator.encender();
                int res = actuator.realizarAccion();
                lblActuador.setText("Actuador: " + (res == 1 ? "Acción realizada" : "No se pudo"));
                actuator.apagar();
            });

            btnComunicar.addActionListener(e -> {
                Message msg = new Message("Hola desde el robot!", 1, 2);
                String respuesta = gateway.enviarMensaje(msg.getContenido());
                lblComunicacion.setText("Comunicación: " + respuesta);
            });

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(6, 2, 10, 10));
            panel.add(btnEncender);
            panel.add(btnApagar);
            panel.add(btnAvanzarInteligente);
            panel.add(lblEstado);
            panel.add(btnSensor);
            panel.add(lblSensor);
            panel.add(btnCamara);
            panel.add(lblCamara);
            panel.add(btnActuador);
            panel.add(lblActuador);
            panel.add(btnComunicar);
            panel.add(lblComunicacion);
            panel.add(lblEncendido);
            panel.add(lblAccion);

            frame.setLayout(new BorderLayout());
            frame.add(campoPanel, BorderLayout.NORTH);
            frame.add(panel, BorderLayout.CENTER);

            frame.pack();
            frame.setVisible(true);
        });
    }

    // Método para mover el robot de forma inteligente
    private static void moverInteligente(
        int pasos,
        VirtualWorldMap worldMap,
        Set<Position> animales,
        VirtualSpeaker speaker,
        JFrame frame,
        JPanel campoPanel,
        JLabel lblEstado,
        JLabel lblAccion,
        boolean[] robotEncendido,
        Extension extension,
        Rotation rotation,
        Helical helical
    ) {
        Set<Position> visitados = new HashSet<>();
        visitados.add(new Position(worldMap.getRobotX(), worldMap.getRobotY()));
        LinkedList<Position> ultimosPasos = new LinkedList<>();
        ultimosPasos.add(new Position(worldMap.getRobotX(), worldMap.getRobotY()));
    
        new Thread(() -> {
            Position anterior = new Position(worldMap.getRobotX(), worldMap.getRobotY());
            int pasosDados = 0;
            int intentos = 0;
            int maxIntentos = 30;
    
            while (pasosDados < pasos && intentos < maxIntentos) {
                if (!robotEncendido[0]) break;
    
                int x = worldMap.getRobotX();
                int y = worldMap.getRobotY();
    
                List<int[]> dirsList = Arrays.asList(
                    new int[]{1,0},   // abajo
                    new int[]{0,1},   // derecha
                    new int[]{0,-1},  // izquierda
                    new int[]{-1,0},  // arriba
                    new int[]{1,1}    // helicoidal
                );
                Collections.shuffle(dirsList);
                int[][] dirs = dirsList.toArray(new int[0][]);
    
                boolean movido = false;
                String accion = "";
    
                // Primer intento: posiciones no visitadas
                for (int[] d : dirs) {
                    int nx = x + d[0];
                    int ny = y + d[1];
                    Position nextPos = new Position(nx, ny);
                    if (nx >= 0 && nx < 10 && ny >= 0 && ny < 10 &&
                            !visitados.contains(nextPos) &&
                            !ultimosPasos.contains(nextPos) &&
                            !worldMap.hayObstaculo(nx, ny) &&
                            !nextPos.equals(anterior)) {
                        if (Arrays.equals(d, new int[]{1,0})) { 
                            extension.avanzar(); 
                            accion = "Avanzando"; 
                            movido = true; 
                            pasosDados++; 
                            intentos = 0;
                        }
                        else if (Arrays.equals(d, new int[]{-1,0})) { 
                            extension.retroceder(); 
                            accion = "Retrocediendo"; 
                            movido = true; 
                            pasosDados++; 
                            intentos = 0;
                        }
                        else if (Arrays.equals(d, new int[]{1,1})) { 
                            helical.moverse(new float[]{1}); 
                            accion = "Movimiento helicoidal"; 
                            movido = true; 
                            pasosDados++; 
                            intentos = 0;
                        }
                        else if (Arrays.equals(d, new int[]{0,1})) { 
                            rotation.girarDerecha(); 
                            accion = "Girando a la derecha"; 
                            movido = true; 
                            pasosDados++; 
                            intentos++;
                        }
                        else if (Arrays.equals(d, new int[]{0,-1})) { 
                            rotation.girarIzquierda(); 
                            accion = "Girando a la izquierda"; 
                            movido = true; 
                            pasosDados++; 
                            intentos++;
                        }
                        break;
                    }
                }
    
                if (!movido) {
                    // Intento con cualquier casilla libre
                    for (int[] d : dirs) {
                        int nx = x + d[0];
                        int ny = y + d[1];
                        Position nextPos = new Position(nx, ny);
                        if (nx >= 0 && nx < 10 && ny >= 0 && ny < 10 &&
                                !worldMap.hayObstaculo(nx, ny) &&
                                !nextPos.equals(anterior)) {
                            if (Arrays.equals(d, new int[]{1,0})) { 
                                extension.avanzar(); 
                                accion = "Avanzando (forzado)"; 
                                movido = true; 
                                pasosDados++; 
                                intentos = 0;
                            }
                            else if (Arrays.equals(d, new int[]{-1,0})) { 
                                extension.retroceder(); 
                                accion = "Retrocediendo (forzado)"; 
                                movido = true; 
                                pasosDados++; 
                                intentos = 0;
                            }
                            else if (Arrays.equals(d, new int[]{1,1})) { 
                                helical.moverse(new float[]{1}); 
                                accion = "Movimiento helicoidal (forzado)"; 
                                movido = true; 
                                pasosDados++; 
                                intentos = 0;
                            }
                            break;
                        }
                    }
                }
    
                if (!movido) break;
    
                anterior = new Position(x, y);
                Position actual = new Position(worldMap.getRobotX(), worldMap.getRobotY());
                visitados.add(actual);
                ultimosPasos.add(actual);
                if (ultimosPasos.size() > 4) ultimosPasos.removeFirst();
    
                if (animales.contains(actual)) {
                    speaker.emitirSonido("¡Animal detectado! Sonido ahuyentador.");
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(frame, "¡Animal detectado! Sonido ahuyentador.");
                    animales.remove(actual);
                    campoPanel.repaint();
                }
    
                String finalAccion = accion;
                SwingUtilities.invokeLater(() -> {
                    campoPanel.repaint();
                    lblEstado.setText("Posición: (" + worldMap.getRobotX() + "," + worldMap.getRobotY() + ")");
                    lblAccion.setText("Acción: " + finalAccion);
                });
                try { Thread.sleep(400); } catch (InterruptedException ex) { }
    
                if (pasosDados >= pasos) break;
            }
    
            if (intentos >= maxIntentos) {
                SwingUtilities.invokeLater(() ->
                        JOptionPane.showMessageDialog(frame, "El robot no puede avanzar más y ha dejado de intentar.")
                );
            }
        }).start();
    }
}

