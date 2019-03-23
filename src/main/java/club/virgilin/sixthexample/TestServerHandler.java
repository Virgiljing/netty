package club.virgilin.sixthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * TestServerHandler
 *
 * @author virgilin
 * @date 2019/3/23
 */
public class TestServerHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) throws Exception {

        if (msg.getDataType().equals(MyDataInfo.MyMessage.DataType.PersonType)){
            MyDataInfo.Person person = msg.getPerson();
            System.out.println(person.getName());
            System.out.println(person.getAddress());
            System.out.println(person.getAge());
        }else if (msg.getDataType().equals(MyDataInfo.MyMessage.DataType.DogType)){
            MyDataInfo.Dog dog = msg.getDog();
            System.out.println(dog.getAge());
            System.out.println(dog.getName());
        }else if (msg.getDataType().equals(MyDataInfo.MyMessage.DataType.CatType)){
            MyDataInfo.Cat cat = msg.getCat();
            System.out.println(cat.getCity());
            System.out.println(cat.getName());
        }


    }
}
