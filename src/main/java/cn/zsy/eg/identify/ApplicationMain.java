package cn.zsy.eg.identify;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplicationMain {

    public static void main(String[] args) throws IOException {

        List<String> list = FileUtils.readLines(new File("D:\\code\\github\\OrionSE\\src\\main\\resources\\typeid.txt"));
        Map<String, String> outList = new HashMap<>();
        System.out.println(list.size());
        list.forEach((n) -> {
            System.out.println(n);
            SDKUtils.DeviceTypeInfo deviceTypeInfo = SDKUtils.parseDeviceTypeAndSpecialId(n);
            outList.put(n, deviceTypeInfo.getMainType().getAbbreviation());
        });
        List<String> ll = new ArrayList();

        outList.forEach((k, v) -> {
            ll.add(k + "\t" + v);
        });

        FileUtils.writeLines(
            new File("D:\\code\\github\\OrionSE\\src\\main\\resources\\typeid_wifiname.txt"), ll);
    }

}
