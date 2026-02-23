import java.net.Socket;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;


public class Client {
    public static void main(String[] args) throws IOException {

//
        try {
            Socket socket = new Socket("localhost", 3000);
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter pw= new PrintWriter(outputStream);
            pw.print("Connected to server");
            pw.flush();
        }
        catch (IOException e){
            System.out.println("Porta non disponibile");

        }
       /* InputStream inputStream = socket.getInputStream();


        DataInputStream dataInputStream = new DataInputStream(inputStream);
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        String clientMessage = "Ciao";
        dataOutputStream.writeUTF(clientMessage);

        String serverResponse = dataInputStream.readUTF();
        System.out.println("Received from server: " + serverResponse);

        inputStream.close();
        outputStream.close();
        socket.close();
        */
    }
}
