package alista.moneysave.bank;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.29.0)",
    comments = "Source: bank.proto")
public final class BankGrpc {

  private BankGrpc() {}

  public static final String SERVICE_NAME = "bank.Bank";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<alista.moneysave.bank.CreateBankRequest,
      alista.moneysave.bank.CreateBankReply> getCreateBankMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBank",
      requestType = alista.moneysave.bank.CreateBankRequest.class,
      responseType = alista.moneysave.bank.CreateBankReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<alista.moneysave.bank.CreateBankRequest,
      alista.moneysave.bank.CreateBankReply> getCreateBankMethod() {
    io.grpc.MethodDescriptor<alista.moneysave.bank.CreateBankRequest, alista.moneysave.bank.CreateBankReply> getCreateBankMethod;
    if ((getCreateBankMethod = BankGrpc.getCreateBankMethod) == null) {
      synchronized (BankGrpc.class) {
        if ((getCreateBankMethod = BankGrpc.getCreateBankMethod) == null) {
          BankGrpc.getCreateBankMethod = getCreateBankMethod =
              io.grpc.MethodDescriptor.<alista.moneysave.bank.CreateBankRequest, alista.moneysave.bank.CreateBankReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateBank"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  alista.moneysave.bank.CreateBankRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  alista.moneysave.bank.CreateBankReply.getDefaultInstance()))
              .setSchemaDescriptor(new BankMethodDescriptorSupplier("CreateBank"))
              .build();
        }
      }
    }
    return getCreateBankMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BankStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BankStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BankStub>() {
        @java.lang.Override
        public BankStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BankStub(channel, callOptions);
        }
      };
    return BankStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BankBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BankBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BankBlockingStub>() {
        @java.lang.Override
        public BankBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BankBlockingStub(channel, callOptions);
        }
      };
    return BankBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BankFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BankFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BankFutureStub>() {
        @java.lang.Override
        public BankFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BankFutureStub(channel, callOptions);
        }
      };
    return BankFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class BankImplBase implements io.grpc.BindableService {

    /**
     */
    public void createBank(alista.moneysave.bank.CreateBankRequest request,
        io.grpc.stub.StreamObserver<alista.moneysave.bank.CreateBankReply> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateBankMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateBankMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                alista.moneysave.bank.CreateBankRequest,
                alista.moneysave.bank.CreateBankReply>(
                  this, METHODID_CREATE_BANK)))
          .build();
    }
  }

  /**
   */
  public static final class BankStub extends io.grpc.stub.AbstractAsyncStub<BankStub> {
    private BankStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BankStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BankStub(channel, callOptions);
    }

    /**
     */
    public void createBank(alista.moneysave.bank.CreateBankRequest request,
        io.grpc.stub.StreamObserver<alista.moneysave.bank.CreateBankReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateBankMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BankBlockingStub extends io.grpc.stub.AbstractBlockingStub<BankBlockingStub> {
    private BankBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BankBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BankBlockingStub(channel, callOptions);
    }

    /**
     */
    public alista.moneysave.bank.CreateBankReply createBank(alista.moneysave.bank.CreateBankRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateBankMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BankFutureStub extends io.grpc.stub.AbstractFutureStub<BankFutureStub> {
    private BankFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BankFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BankFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<alista.moneysave.bank.CreateBankReply> createBank(
        alista.moneysave.bank.CreateBankRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateBankMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_BANK = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BankImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BankImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_BANK:
          serviceImpl.createBank((alista.moneysave.bank.CreateBankRequest) request,
              (io.grpc.stub.StreamObserver<alista.moneysave.bank.CreateBankReply>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class BankBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BankBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return alista.moneysave.bank.BankProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Bank");
    }
  }

  private static final class BankFileDescriptorSupplier
      extends BankBaseDescriptorSupplier {
    BankFileDescriptorSupplier() {}
  }

  private static final class BankMethodDescriptorSupplier
      extends BankBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BankMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (BankGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BankFileDescriptorSupplier())
              .addMethod(getCreateBankMethod())
              .build();
        }
      }
    }
    return result;
  }
}
