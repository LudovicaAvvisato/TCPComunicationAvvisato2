import java.io.*;
import java.net.*;
import java.util.*;
public class Client {
    public static void main(String[] args) {
        String host = "localhost"; // Cambia in "locaost" per testare lo Scenario 4
        int port = 3000;

        System.out.println("Avvio tentativo di connessione...");

        try (Socket socket = new Socket(host, port)) {
            System.out.println("Client Connesso al server!");

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Invio richiesta
            String messaggio = "ciao server";
            //scanner
            out.println(messaggio);
            System.out.println("messaggio Inviato: " + messaggio);

            // Lettura risposta
            String risposta = in.readLine();
            System.out.println("messaggio Ricevuto: " + risposta);

        } catch (UnknownHostException e) {
            System.err.println("Host non trovato: " + host + " (Scenario 4)");
        } catch (ConnectException e) {
            System.err.println("Connessione rifiutata. Il server è attivo? (Scenario 2)");
        } catch (IOException e) {
            System.err.println("Errore di comunicazione: " + e.getMessage());
        }
        System.out.println("Chiusura.");
    }
}
