// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: bank.proto

package alistar.moneysave.bank;

public final class BankProto {
  private BankProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_bank_CreateBankRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_bank_CreateBankRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_bank_CreateBankReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_bank_CreateBankReply_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_bank_Bank_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_bank_Bank_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_bank_GetBanksReplay_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_bank_GetBanksReplay_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\nbank.proto\022\004bank\032\033google/protobuf/empt" +
      "y.proto\"6\n\021CreateBankRequest\022\014\n\004name\030\001 \001" +
      "(\t\022\023\n\013persianName\030\002 \001(\t\"\"\n\017CreateBankRep" +
      "ly\022\017\n\007message\030\001 \001(\t\"5\n\004Bank\022\n\n\002id\030\001 \001(\t\022" +
      "\014\n\004name\030\002 \001(\t\022\023\n\013persianName\030\003 \001(\t\"+\n\016Ge" +
      "tBanksReplay\022\031\n\005banks\030\001 \003(\0132\n.bank.Bank2" +
      "\211\001\n\013BankService\022>\n\nCreateBank\022\027.bank.Cre" +
      "ateBankRequest\032\025.bank.CreateBankReply\"\000\022" +
      ":\n\010GetBanks\022\026.google.protobuf.Empty\032\024.ba" +
      "nk.GetBanksReplay\"\000B+\n\026alistar.moneysave" +
      ".bankB\tBankProtoP\001\242\002\003BNKb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.EmptyProto.getDescriptor(),
        });
    internal_static_bank_CreateBankRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_bank_CreateBankRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_bank_CreateBankRequest_descriptor,
        new java.lang.String[] { "Name", "PersianName", });
    internal_static_bank_CreateBankReply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_bank_CreateBankReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_bank_CreateBankReply_descriptor,
        new java.lang.String[] { "Message", });
    internal_static_bank_Bank_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_bank_Bank_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_bank_Bank_descriptor,
        new java.lang.String[] { "Id", "Name", "PersianName", });
    internal_static_bank_GetBanksReplay_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_bank_GetBanksReplay_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_bank_GetBanksReplay_descriptor,
        new java.lang.String[] { "Banks", });
    com.google.protobuf.EmptyProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
