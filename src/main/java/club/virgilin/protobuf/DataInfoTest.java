package club.virgilin.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

public class DataInfoTest {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        DataInfo.Student student = DataInfo.Student.newBuilder().setName("张三")
                .setAge(19).setAddress("北京").build();
        byte[] studentByteArray = student.toByteArray();

        DataInfo.Student student1 = DataInfo.Student.parseFrom(studentByteArray);
        System.out.println(student1.getAddress());
        System.out.println(student1.getName());
        System.out.println(student1.getAge());

    }

}
