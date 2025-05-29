package edu.utp.robot.domain.communication;

public class CommunicationGateway {
    // Puedes agregar atributos si necesitas mantener estado

    // Método para enviar un mensaje
    public String enviarMensaje(String mensaje) {
        // Lógica para enviar el mensaje
        // Por ahora, solo simula el envío
        System.out.println("Enviando mensaje: " + mensaje);
        return "Mensaje enviado";
    }

    // Método para recibir un mensaje
    public void recibirMensaje(String mensaje) {
        // Lógica para recibir el mensaje
        System.out.println("Mensaje recibido: " + mensaje);
    }

    // Método para recibir un mensaje con identificador
    public void recibirMensaje(String mensaje, int id) {
        // Lógica para recibir el mensaje con un identificador
        System.out.println("Mensaje recibido de " + id + ": " + mensaje);
    }
}
