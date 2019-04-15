package club.virgilin.test;

import io.netty.util.NettyRuntime;
import io.netty.util.internal.SystemPropertyUtil;

/**
 * Test
 *
 * @author virgilin
 * @date 2019/4/9
 */
public class Test {
    public static void main(String[] args) {
        int DEFAULT_EVENT_LOOP_THREADS = Math.max(1, SystemPropertyUtil.getInt(
                "io.netty.eventLoopThreads", NettyRuntime.availableProcessors() * 2));
        System.out.println(DEFAULT_EVENT_LOOP_THREADS);
    }
}
