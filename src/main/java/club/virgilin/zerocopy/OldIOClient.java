package club.virgilin.zerocopy;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.Socket;

/**
 * OldIOClient
 *
 * @author virgilin
 * @date 2019/4/8
 */
public class OldIOClient {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 8899);
        String fileName = "D:\\用户目录\\下载\\yingshu.apk";
        FileInputStream inputStream = new FileInputStream(fileName);
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        byte[] buffer = new byte[4096];
        long readCount;
        long total = 0;
        long starttime = System.currentTimeMillis();

        while ((readCount = inputStream.read(buffer))>=0){
            total += readCount;
            dataOutputStream.write(buffer);
        }
        System.out.println("发送总字节数：" + total + ", 耗时：" +(System.currentTimeMillis() - starttime));
        dataOutputStream.close();
        socket.close();
        inputStream.close();
    }
}
