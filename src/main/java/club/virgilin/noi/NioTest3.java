package club.virgilin.noi;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * NioTest3
 *
 * @author virgilin
 * @date 2019/4/3
 */
public class NioTest3 {
    public static void main(String[] args) throws Exception{
        FileOutputStream fileOutputStream = new FileOutputStream("Niotest3.txt");
        FileChannel channel = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        byte[] messages = "hello world welcome virgilin".getBytes();
        for (byte message : messages) {
            byteBuffer.put(message);
        }

        byteBuffer.flip();

        channel.write(byteBuffer);
        fileOutputStream.close();
    }
}
