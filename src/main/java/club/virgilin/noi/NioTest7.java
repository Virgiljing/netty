package club.virgilin.noi;

import java.nio.ByteBuffer;

/**
 * NioTest7
 * 我们可以随时将一个普通的buffer调用asReadOnlyBuffer()方法转换成只读的buffer
 * 但是不能将一个只读的buffer转换成一个普通的buffer
 *
 * @author virgilin
 * @date 2019/4/8
 */
public class NioTest7 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        System.out.println(buffer.getClass());
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte)i);
        }

        ByteBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();
        System.out.println(readOnlyBuffer.getClass());

        readOnlyBuffer.put(1,(byte)0);
    }
}
