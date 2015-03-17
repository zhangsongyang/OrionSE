package cn.zsy.eg.xstream;

import cn.zsy.eg.xstream.bean.DiskInfo;
import cn.zsy.eg.xstream.bean.HardwareInfo;
import com.thoughtworks.xstream.XStream;

import java.util.ArrayList;

public class TestXStream {

    public static void main(String[] args) {
        DiskInfo disk1 = new DiskInfo();
        disk1.setName("D:\\");
        disk1.setTotleSize(100);
        disk1.setUserSize(20);
        disk1.setAvilableSize(80);
        DiskInfo disk2 = new DiskInfo();
        disk2.setName("E:\\");
        disk2.setTotleSize(200);
        disk2.setUserSize(40);
        disk2.setAvilableSize(160);

        ArrayList<DiskInfo> diskInfos = new ArrayList<DiskInfo>();
        diskInfos.add(disk1);
        diskInfos.add(disk2);

        HardwareInfo hwInfo = new HardwareInfo();
        hwInfo.setXmlns("http://www.monternet.com/dsmp/schemas/");
        hwInfo.setCpuInfo("cpu info is ...");
        hwInfo.setNetworkInfo("network info is ...");
        hwInfo.setDiskInfos(diskInfos);

        XStream xStream = new XStream();
        xStream.autodetectAnnotations(true);
        String xml = xStream.toXML(hwInfo);
        System.out.println( "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + xml);
        System.out.println("------------------------------------------------");

        String xmlT  =  "<?xml version=\"1.0\" encoding=\"UTF-8\"?><HardwareInfo>\n" +
                "  <cpuInfo>cpu1111111 info is ...</cpuInfo>\n" +
                "  <networkInfo>network info is ...</networkInfo>\n" +
                "  <diskInfos>\n" +
                "    <DiskInfo diskName=\"D:\\\">\n" +
                "      <totalSize>100</totalSize>\n" +
                "      <avilableSize>80</avilableSize>\n" +
                "      <usedSize>20</usedSize>\n" +
                "    </DiskInfo>\n" +
                "    <DiskInfo diskName=\"E:\\\">\n" +
                "      <totalSize>200</totalSize>\n" +
                "      <avilableSize>160</avilableSize>\n" +
                "      <usedSize>40</usedSize>\n" +
                "    </DiskInfo>\n" +
                "  </diskInfos>\n" +
                "</HardwareInfo> " ;
        HardwareInfo info2 = (HardwareInfo) xStream.fromXML(xmlT);
        System.out.println(info2.getCpuInfo());
        System.out.println(info2);
    }

}
