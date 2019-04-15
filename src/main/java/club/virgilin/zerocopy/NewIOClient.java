package club.virgilin.zerocopy;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * NewIOClient
 *
 * @author virgilin
 * @date 2019/4/8
 */
public class NewIOClient {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost",8899));
        socketChannel.configureBlocking(true);

        String fileName = "D:\\用户目录\\下载\\yingshu.apk";
        FileChannel fileChannel = new FileInputStream(fileName).getChannel();
        long starttime = System.currentTimeMillis();
        long transferCount = fileChannel.transferTo(0, fileChannel.size(), socketChannel);
        System.out.println("发送总字节数：" + transferCount + ",耗时：" + (System.currentTimeMillis() - starttime));

        fileChannel.close();
        socketChannel.close();
    }
}
