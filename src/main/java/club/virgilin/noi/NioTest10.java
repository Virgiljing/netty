package club.virgilin.noi;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * NioTest10
 *
 * @author virgilin
 * @date 2019/4/8
 */
public class NioTest10 {
    public static void main(String[] args) throws Exception{
        RandomAccessFile randomAccessFile = new RandomAccessFile("NioTest10.txt", "rw");
        FileChannel channel = randomAccessFile.getChannel();
        FileLock lock = channel.lock(3, 6, true);
        System.out.println("Valid:" + lock.isValid());
        System.out.println("lock type:" + lock.isShared());
        lock.release();
        channel.close();
        randomAccessFile.close();
    }
}
