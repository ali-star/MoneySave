package alistar.moneysave.bank;

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
public final class BankServiceGrpc {

  private BankServiceGrpc() {}

  public static final String SERVICE_NAME = "bank.BankService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<alistar.moneysave.bank.CreateBankRequest,
      alistar.moneysave.bank.CreateBankReply> getCreateBankMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBank",
      requestType = alistar.moneysave.bank.CreateBankRequest.class,
      responseType = alistar.moneysave.bank.CreateBankReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<alistar.moneysave.bank.CreateBankRequest,
      alistar.moneysave.bank.CreateBankReply> getCreateBankMethod() {
    io.grpc.MethodDescriptor<alistar.moneysave.bank.CreateBankRequest, alistar.moneysave.bank.CreateBankReply> getCreateBankMethod;
    if ((getCreateBankMethod = BankServiceGrpc.getCreateBankMethod) == null) {
      synchronized (BankServiceGrpc.class) {
        if ((getCreateBankMethod = BankServiceGrpc.getCreateBankMethod) == null) {
          BankServiceGrpc.getCreateBankMethod = getCreateBankMethod =
              io.grpc.MethodDescriptor.<alistar.moneysave.bank.CreateBankRequest, alistar.moneysave.bank.CreateBankReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateBank"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  alistar.moneysave.bank.CreateBankRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  alistar.moneysave.bank.CreateBankReply.getDefaultInstance()))
              .setSchemaDescriptor(new BankServiceMethodDescriptorSupplier("CreateBank"))
              .build();
        }
      }
    }
    return getCreateBankMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      alistar.moneysave.bank.GetBanksReplay> getGetBanksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBanks",
      requestType = com.google.protobuf.Empty.class,
      responseType = alistar.moneysave.bank.GetBanksReplay.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      alistar.moneysave.bank.GetBanksReplay> getGetBanksMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, alistar.moneysave.bank.GetBanksReplay> getGetBanksMethod;
    if ((getGetBanksMethod = BankServiceGrpc.getGetBanksMethod) == null) {
      synchronized (BankServiceGrpc.class) {
        if ((getGetBanksMethod = BankServiceGrpc.getGetBanksMethod) == null) {
          BankServiceGrpc.getGetBanksMethod = getGetBanksMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, alistar.moneysave.bank.GetBanksReplay>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBanks"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  alistar.moneysave.bank.GetBanksReplay.getDefaultInstance()))
              .setSchemaDescriptor(new BankServiceMethodDescriptorSupplier("GetBanks"))
              .build();
        }
      }
    }
    return getGetBanksMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BankServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BankServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BankServiceStub>() {
        @java.lang.Override
        public BankServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BankServiceStub(channel, callOptions);
        }
      };
    return BankServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BankServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BankServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BankServiceBlockingStub>() {
        @java.lang.Override
        public BankServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BankServiceBlockingStub(channel, callOptions);
        }
      };
    return BankServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BankServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BankServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BankServiceFutureStub>() {
        @java.lang.Override
        public BankServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BankServiceFutureStub(channel, callOptions);
        }
      };
    return BankServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class BankServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Creates a bank
     * </pre>
     */
    public void createBank(alistar.moneysave.bank.CreateBankRequest request,
        io.grpc.stub.StreamObserver<alistar.moneysave.bank.CreateBankReply> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateBankMethod(), responseObserver);
    }

    /**
     * <pre>
     * Return list of banks
     * </pre>
     */
    public void getBanks(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<alistar.moneysave.bank.GetBanksReplay> responseObserver) {
      asyncUnimplementedUnaryCall(getGetBanksMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateBankMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                alistar.moneysave.bank.CreateBankRequest,
                alistar.moneysave.bank.CreateBankReply>(
                  this, METHODID_CREATE_BANK)))
          .addMethod(
            getGetBanksMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                alistar.moneysave.bank.GetBanksReplay>(
                  this, METHODID_GET_BANKS)))
          .build();
    }
  }

  /**
   */
  public static final class BankServiceStub extends io.grpc.stub.AbstractAsyncStub<BankServiceStub> {
    private BankServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BankServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BankServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a bank
     * </pre>
     */
    public void createBank(alistar.moneysave.bank.CreateBankRequest request,
        io.grpc.stub.StreamObserver<alistar.moneysave.bank.CreateBankReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateBankMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Return list of banks
     * </pre>
     */
    public void getBanks(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<alistar.moneysave.bank.GetBanksReplay> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetBanksMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BankServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<BankServiceBlockingStub> {
    private BankServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BankServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BankServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a bank
     * </pre>
     */
    public alistar.moneysave.bank.CreateBankReply createBank(alistar.moneysave.bank.CreateBankRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateBankMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Return list of banks
     * </pre>
     */
    public alistar.moneysave.bank.GetBanksReplay getBanks(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetBanksMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BankServiceFutureStub extends io.grpc.stub.AbstractFutureStub<BankServiceFutureStub> {
    private BankServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BankServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BankServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a bank
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<alistar.moneysave.bank.CreateBankReply> createBank(
        alistar.moneysave.bank.CreateBankRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateBankMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Return list of banks
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<alistar.moneysave.bank.GetBanksReplay> getBanks(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetBanksMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_BANK = 0;
  private static final int METHODID_GET_BANKS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BankServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BankServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_BANK:
          serviceImpl.createBank((alistar.moneysave.bank.CreateBankRequest) request,
              (io.grpc.stub.StreamObserver<alistar.moneysave.bank.CreateBankReply>) responseObserver);
          break;
        case METHODID_GET_BANKS:
          serviceImpl.getBanks((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<alistar.moneysave.bank.GetBanksReplay>) responseObserver);
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

  private static abstract class BankServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BankServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return alistar.moneysave.bank.BankProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BankService");
    }
  }

  private static final class BankServiceFileDescriptorSupplier
      extends BankServiceBaseDescriptorSupplier {
    BankServiceFileDescriptorSupplier() {}
  }

  private static final class BankServiceMethodDescriptorSupplier
      extends BankServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BankServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (BankServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BankServiceFileDescriptorSupplier())
              .addMethod(getCreateBankMethod())
              .addMethod(getGetBanksMethod())
              .build();
        }
      }
    }
    return result;
  }
}
