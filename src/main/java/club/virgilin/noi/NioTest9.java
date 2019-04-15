package club.virgilin.noi;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * NioTest9
 *
 * @author virgilin
 * @date 2019/4/8
 */
public class NioTest9  {
    public static void main(String[] args) throws Exception{
        RandomAccessFile randomAccessFile = new RandomAccessFile("NioTest9.txt", "rw");
        FileChannel channel = randomAccessFile.getChannel();
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
        map.put(0,(byte)'a');
        map.put(3,(byte)'b');
        channel.close();
        randomAccessFile.close();
    }
}
