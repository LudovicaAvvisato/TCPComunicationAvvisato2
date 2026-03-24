import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 3000;

        // Scenario 3: Se provi ad avviare due server sulla stessa porta, 
        // il secondo lancerà una BindException.
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Il server è In ascolto sulla porta " + port);

            // Accettiamo una singola connessione (Unicast)
            try (Socket clientSocket = serverSocket.accept()) {
                System.out.println("Client connesso: " + clientSocket.getInetAddress());

                // Stream per leggere e scrivere
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Lettura richiesta
                String richiesta = in.readLine();
                System.out.println("Richiesta ricevuta: " + richiesta);

                // Invio risposta
                String risposta = richiesta.toUpperCase();
                out.println("Risposta dal Server: " + risposta);

                System.out.println("Risposta inviata. Chiusura comunicazione.");
            }
            // Il blocco try-with-resources chiude automaticamente il clientSocket

        } catch (BindException e) {
            System.err.println("Porta " + port + " già in uso! (Scenario 3)");
        } catch (IOException e) {
            System.err.println("Errore di I/O nel server: " + e.getMessage());
        }
        System.out.println("Servizio terminato.");
    }
}