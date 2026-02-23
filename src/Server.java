
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;


public class Server {
    public static void main(String[] args) throws IOException {

        System.out.println("Server inizio esecuzione");

//

        try {
            ServerSocket server=new ServerSocket(3000);
            System.out.println("Server in attesa di richieste dal client");
            Socket s=server.accept();
            System.out.println("Server connesso");
        }catch (IOException e){
            System.out.println("errore");
        }

        /*int port = 3333;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server connesso alla porta: " + port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket);

            InputStream inputStream = clientSocket.getInputStream(); //LETTURA
            OutputStream outputStream = clientSocket.getOutputStream(); //SCRITTURA

            DataInputStream dataInputStream = new DataInputStream(inputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            String clientMessage = dataInputStream.readUTF();
            System.out.println("Ricevuto dal Client: " + clientMessage);

            String serverResponse = "Risposta dal Server: " + clientMessage.toUpperCase();
            dataOutputStream.writeUTF(serverResponse);

            inputStream.close();
            outputStream.close();
            clientSocket.close();
        }
        */
    }
}

