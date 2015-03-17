package cn.zsy.eg.xstream.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("DiskInfo")
public class DiskInfo {

    @XStreamAsAttribute
    @XStreamAlias("diskName")
    private String name;
    private int totalSize;
    private int avilableSize;
    private int usedSize;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotleSize() {
        return totalSize;
    }

    public void setTotleSize(int totleSize) {
        this.totalSize = totleSize;
    }

    public int getAvilableSize() {
        return avilableSize;
    }

    public void setAvilableSize(int avilableSize) {
        this.avilableSize = avilableSize;
    }

    public int getUserSize() {
        return usedSize;
    }

    public void setUserSize(int userSize) {
        this.usedSize = userSize;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name + "\r\n");
        sb.append("TotalSize:" + totalSize + "|Used Size:" + usedSize
                + "|Available Size:" + avilableSize);
        return sb.toString();
    }
}
