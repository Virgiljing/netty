package club.virgilin.sixthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

/**
 * TestClientHandler
 *
 * @author virgilin
 * @date 2019/3/23
 */
public class TestClientHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        MyDataInfo.MyMessage myMessage = null;

        int nextInt = new Random().nextInt(3);

        if (0 == nextInt){
            myMessage = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.PersonType).
                    setPerson(MyDataInfo.Person.newBuilder().
                            setAge(20).setName("王五").setAddress("天津").build()).build();
        }else if (1 == nextInt){
            myMessage = MyDataInfo.MyMessage.newBuilder().
                    setDataType(MyDataInfo.MyMessage.DataType.DogType).
                    setDog(MyDataInfo.Dog.newBuilder().
                            setAge(3).setName("小岳岳").build()).build();
        }else {
            myMessage = MyDataInfo.MyMessage.newBuilder().
                    setDataType(MyDataInfo.MyMessage.DataType.CatType).
                    setCat(MyDataInfo.Cat.newBuilder().
                            setName("黑猫").setCity("深圳").build()).build();
        }


        ctx.channel().writeAndFlush(myMessage);
    }
}
