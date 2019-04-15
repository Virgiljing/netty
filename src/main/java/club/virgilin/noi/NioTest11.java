package club.virgilin.noi;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * NioTest11
 * 关于Buffer的Scattering与Gathering
 *
 * @author virgilin
 * @date 2019/4/8
 */
public class NioTest11 {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress(8899);
        serverSocketChannel.socket().bind(address);

        int messageLength = 2 + 3 + 4 ;
        ByteBuffer[] buffer = new ByteBuffer[3];

        buffer[0] =  ByteBuffer.allocate(2);
        buffer[1] =  ByteBuffer.allocate(3);
        buffer[2] =  ByteBuffer.allocate(4);

        SocketChannel socketChannel = serverSocketChannel.accept();
        while (true) {
            int bytesRead = 0;
            while (bytesRead < messageLength){
                long read = socketChannel.read(buffer);
                bytesRead += read;

                System.out.println("bytesRead:" + buffer);

                Arrays.asList(buffer).stream()
                        .map(bufferd -> "position: " + bufferd.position() + ", limit: " + bufferd.limit())
                        .forEach(System.out::println);
            }

            long bytesWritten = 0;

            while (bytesWritten < messageLength) {
                long read = socketChannel.write(buffer);
                bytesWritten += read;
            }

            Arrays.asList(buffer).forEach(bufferd -> {
                bufferd.clear();
            });
        }
    }
}
