package club.virgilin.zerocopy;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * NewIOServer
 *
 * @author virgilin
 * @date 2019/4/8
 */
public class NewIOServer {
    public static void main(String[] args) throws IOException {
        InetSocketAddress address = new InetSocketAddress(8899);
        ByteBuffer byteBuffer = ByteBuffer.allocate(4096);
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            ServerSocket socket = serverSocketChannel.socket();
            socket.setReuseAddress(true);
            socket.bind(address);
            while (true) {
                SocketChannel socketChannel = serverSocketChannel.accept();
                socketChannel.configureBlocking(true);
                int readCount = 0;
                while (-1 != readCount) {
                    readCount = socketChannel.read(byteBuffer);
                    byteBuffer.rewind();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
