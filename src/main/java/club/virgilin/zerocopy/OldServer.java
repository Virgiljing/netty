package club.virgilin.zerocopy;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * OldServer
 *
 * @author virgilin
 * @date 2019/4/8
 */
public class OldServer {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(8899);
        while (true) {
            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            try {
                byte[] bytesArray = new byte[4096];
                int readCount = 0;
                while (readCount != -1) {
                     readCount = dataInputStream.read(bytesArray, 0, bytesArray.length);
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
