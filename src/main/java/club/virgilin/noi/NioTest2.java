package club.virgilin.noi;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * NioTest2
 *
 * @author virgilin
 * @date 2019/4/3
 */
public class NioTest2 {
    public static void main (String[] args) throws Exception{
        FileInputStream fileInputStream = new FileInputStream("Niotest2.txt");
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer allocate = ByteBuffer.allocate(512);
        channel.read(allocate);
        allocate.flip();
        while (allocate.remaining() > 0){
            byte b = allocate.get();
            System.out.println((char)b);
        }
        fileInputStream.close();
    }
}
