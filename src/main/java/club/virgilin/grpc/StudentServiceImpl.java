package club.virgilin.grpc;

import club.virgilin.proto.*;
import io.grpc.stub.StreamObserver;

import java.util.UUID;

/**
 * StudentServiceImpl
 *
 * @author virgilin
 * @date 2019/3/28
 */
public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase {

    @Override
    public void getRealNameByUsername(MyRequest request, StreamObserver<MyResponse> responseObserver) {
        System.out.println("接受客户端信息：" + request.getUsername());

        responseObserver.onNext(MyResponse.newBuilder().setRealname("张三").build());

        responseObserver.onCompleted();
    }


    @Override
    public void getStudentByAge(StudentRequest request, StreamObserver<StudentResponse> responseObserver) {
        System.out.println("接受到客户端信息：" + request.getAge());

        responseObserver.onNext(StudentResponse.newBuilder().setAge(22).setCity("上海2").setName("张三").build());
        responseObserver.onNext(StudentResponse.newBuilder().setAge(22).setCity("上海1").setName("张三").build());
        responseObserver.onNext(StudentResponse.newBuilder().setAge(22).setCity("上海3").setName("张三").build());
        responseObserver.onNext(StudentResponse.newBuilder().setAge(22).setCity("上海4").setName("张三").build());
        responseObserver.onNext(StudentResponse.newBuilder().setAge(22).setCity("上海5").setName("张三").build());

        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<StudentRequest> getStudnetWrapperByAges(StreamObserver<StudentResponseList> responseObserver) {
        return new StreamObserver<StudentRequest>() {
            @Override
            public void onNext(StudentRequest value) {
                System.out.println("onNext:" + value.getAge());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("onError:" + t.getMessage());
            }

            @Override
            public void onCompleted() {
                StudentResponse build = StudentResponse.newBuilder().setAge(22).setCity("上海2").setName("张三").build();
                StudentResponse build2 = StudentResponse.newBuilder().setAge(22).setCity("上海1").setName("张三").build();
                StudentResponseList responseList = StudentResponseList.newBuilder().addStudentResponse(build).addStudentResponse(build2).build();

                responseObserver.onNext(responseList);
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<StreamRequest> biTalk(StreamObserver<StreamResponse> responseObserver) {
        return new StreamObserver<StreamRequest>() {
            @Override
            public void onNext(StreamRequest value) {
                System.out.println(value.getRequestInfo());
                responseObserver.onNext(StreamResponse.newBuilder().setResponseInfo(UUID.randomUUID().toString()).build());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}
