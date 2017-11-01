package cn.zsy.eg.xstream.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * Created by suoxiaojing on 2017/11/1.
 */
@XStreamAlias("versions")
public class Versions {

    @XStreamImplicit(itemFieldName="version")
    private List<String> version;

    public List<String> getVersion() {
        return version;
    }

    public void setVersion(List<String> version) {
        this.version = version;
    }
}
