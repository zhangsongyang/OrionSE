package cn.zsy.eg.google.protobuf.main;

import cn.zsy.eg.google.protobuf.bean.UTraceLogBean;
import com.google.protobuf.InvalidProtocolBufferException;

import java.util.Date;

public class TestProtobuf {

    public static void main(String[] args) throws InvalidProtocolBufferException {
        UTraceLogBean.TraceApp uTraceApp = UTraceLogBean.TraceApp.newBuilder()
            .setSys("app").setId("12").setTs(new Date().toString())
            .setCode("00000").setSpan("32").build();
        System.out.println(uTraceApp.isInitialized());
        byte[] byteArray = uTraceApp.toByteArray();

        UTraceLogBean.TraceApp uTraceApp1 = UTraceLogBean.TraceApp.parseFrom(byteArray);
        System.out.println("utraceApp: " + uTraceApp1.toString());

    }

}
