package cn.zsy.eg.xstream.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("metadata")
public class Metadata {

    @XStreamAlias("groupId")
    private String groupId;

    @XStreamAlias("artifactId")
    private String artifactId;

    @XStreamAlias("versioning")
    private Versioning versioning;


    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public Versioning getVersioning() {
        return versioning;
    }

    public void setVersioning(Versioning versioning) {
        this.versioning = versioning;
    }
}
