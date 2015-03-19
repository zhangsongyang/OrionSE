package cn.zsy.eg.xstream;

import cn.zsy.eg.xstream.bean.SyncAppOrderReq;
import cn.zsy.eg.xstream.bean.SyncAppOrderResp;
import com.thoughtworks.xstream.XStream;

public class TestStreamXMLToJavaBean {

    public static void main(String[] args) {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<SyncAppOrderReq xmlns=\"http://www.monternet.com/dsmp/schemas/\">\n" +
                "    <TransactionID>CSSP16892054</TransactionID>\n" +
                "    <MsgType>SyncAppOrderReq</MsgType>\n" +
                "    <Version>1.0.0</Version>\n" +
                "    <Send_Address>\n" +
                "        <DeviceType>200</DeviceType>\n" +
                "        <DeviceID>CSSP</DeviceID>\n" +
                "    </Send_Address>\n" +
                "    <Dest_Address>\n" +
                "        <DeviceType>1002</DeviceType>\n" +
                "        <DeviceID>f0_0</DeviceID>\n" +
                "    </Dest_Address>\n" +
                "    <OrderID>11150319120540161714</OrderID>\n" +
                "    <CheckID>0</CheckID>\n" +
                "    <ActionTime>20150319120540</ActionTime>\n" +
                "    <ActionID>1</ActionID>\n" +
                "    <MSISDN></MSISDN>\n" +
                "    <FeeMSISDN>0BEA87B3F84C3BF3</FeeMSISDN>\n" +
                "    <AppID>300008916432</AppID>\n" +
                "    <PayCode>30000891643205</PayCode>\n" +
                "    <TradeID>9041B6B2F8E9291692A436D22105C538</TradeID>\n" +
                "    <Price>100</Price>\n" +
                "    <TotalPrice>100</TotalPrice>\n" +
                "    <SubsNumb>1</SubsNumb>\n" +
                "    <SubsSeq>1</SubsSeq>\n" +
                "    <ChannelID>000000000000</ChannelID>\n" +
                "    <ExData>20150319CMCC12051621046</ExData>\n" +
                "    <OrderType>0</OrderType>\n" +
                "    <MD5Sign>0287A2DD492C2A672E78F6789EBBD557</MD5Sign>\n" +
                "    <OrderPayment>1</OrderPayment>\n" +
                "</SyncAppOrderReq>";
        XStream xStream = new XStream();
        SyncAppOrderReq syncAppOrderReq = new SyncAppOrderReq();
        xStream.autodetectAnnotations(true);
        String javaToXML = xStream.toXML(syncAppOrderReq);   //这个在从xml到java Bean时候不能少，少了就会报异常，尽管这个方法作用是javaBean到xml, 这里我推测这个方便有将xml和bean映射作用
        System.out.println(javaToXML);
        System.out.println("---------");
        xStream.setClassLoader(SyncAppOrderReq.class.getClassLoader());
        SyncAppOrderReq readObject = (SyncAppOrderReq) xStream.fromXML(xml);
        System.out.println("Object loaded by xstream:\n " + readObject);
        System.out.println("---------");


        SyncAppOrderResp syncAppOrderResp = new SyncAppOrderResp();
        syncAppOrderResp.setTransactionID(readObject.getTransactionID());
        syncAppOrderResp.setXmlns(readObject.getXmlns());
        syncAppOrderResp.setMsgType("SyncAppOrderResp");
        syncAppOrderResp.setVersion("1.0.0");
        syncAppOrderResp.sethRet(0);
        syncAppOrderResp.setXmlns("http://www.monternet.com/dsmp/schemas/");
        String xmlcc = xStream.toXML(syncAppOrderResp);
        xmlcc = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + xmlcc;
        System.out.println(xmlcc);


    }

}
