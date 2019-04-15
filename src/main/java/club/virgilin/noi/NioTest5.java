package club.virgilin.noi;

import java.nio.ByteBuffer;

/**
 * NioTest5
 *
 * @author virgilin
 * @date 2019/4/8
 */
public class NioTest5 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(100);
        buffer.putChar('a');
        buffer.putDouble(1000l);
        buffer.putInt(9);
        buffer.putFloat(10.2f);
        buffer.putChar('张');
        buffer.flip();
        System.out.println(buffer.getChar());
        System.out.println(buffer.getDouble());
        System.out.println(buffer.getInt());
        System.out.println(buffer.getFloat());
        System.out.println(buffer.getChar());
    }
}
