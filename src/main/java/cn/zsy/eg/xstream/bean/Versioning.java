package cn.zsy.eg.xstream.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.List;

/**
 * Created by suoxiaojing on 2017/11/1.
 */
@XStreamAlias("versioning")
public class Versioning {
    @XStreamAlias("versions")
    private Versions versions;
    @XStreamAlias("lastUpdated")
    private String lastUpdated;

    public Versions getVersions() {
        return versions;
    }

    public void setVersions(Versions versions) {
        this.versions = versions;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
