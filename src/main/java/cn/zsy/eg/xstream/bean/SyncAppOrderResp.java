package cn.zsy.eg.xstream.bean;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("SyncAppOrderResp")
public class SyncAppOrderResp implements Serializable {

	private static final long serialVersionUID = 7123473855192948887L;
	
    @XStreamAsAttribute
    @XStreamAlias("xmlns")
    private String xmlns;

	@XStreamOmitField
	@XStreamAlias("TransactionID")
	private String transactionID;

	@XStreamAlias("MsgType")
	private String MsgType;//消息类型

	@XStreamAlias("Version")
	private String Version;//版本号

	@XStreamAlias("hRet")
	private Integer hRet;//返回值

	public String getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	public String getVersion() {
		return Version;
	}

	public void setVersion(String version) {
		Version = version;
	}

	public Integer gethRet() {
		return hRet;
	}

	public void sethRet(Integer hRet) {
		this.hRet = hRet;
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MsgType:");
        sb.append(MsgType);
        sb.append("\nVersion:");
        sb.append(Version);
        sb.append("\nhRet:");
        sb.append(hRet);
        return sb.toString();
    }

}
