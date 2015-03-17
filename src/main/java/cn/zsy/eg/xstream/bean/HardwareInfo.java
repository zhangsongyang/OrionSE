package cn.zsy.eg.xstream.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import java.util.List;

@XStreamAlias("HardwareInfo")
public class HardwareInfo {

    @XStreamAsAttribute
    @XStreamAlias("xmlns")
    private String xmlns;

    private String cpuInfo;
    private String networkInfo;
    private List<DiskInfo> diskInfos;


    public String getXmlns() {
        return xmlns;
    }

    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }

    public String getCpuInfo() {
        return cpuInfo;
    }

    public void setCpuInfo(String cpuInfo) {
        this.cpuInfo = cpuInfo;
    }

    public String getNetworkInfo() {
        return networkInfo;
    }

    public void setNetworkInfo(String networkInfo) {
        this.networkInfo = networkInfo;
    }

    public List<DiskInfo> getDiskInfos() {
        return diskInfos;
    }

    public void setDiskInfos(List<DiskInfo> diskInfos) {
        this.diskInfos = diskInfos;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(cpuInfo);
        sb.append("\r\n");
        sb.append(networkInfo);
        sb.append("\r\n");
        for (DiskInfo disk : diskInfos) {
            sb.append(disk.toString());
            sb.append("\r\n");
        }
        return sb.toString();
    }

}
