package cn.zsy.eg.xstream.bean;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("SyncAppOrderReq")
public class SyncAppOrderReq implements Serializable {

	private static final long serialVersionUID = -5719870901076921628L;

	@XStreamAsAttribute
	@XStreamAlias("xmlns")
	private String xmlns;

	@XStreamOmitField
	@XStreamAlias("TransactionID")
	private String transactionID;

	@XStreamAlias("MsgType")
	private String msgType;// 消息类型

	@XStreamAlias("Version")
	private String version;// 版本号

	@XStreamOmitField
	@XStreamAlias("Send_Address")
	private String send_Address;// 发送方地址

	@XStreamOmitField
	@XStreamAlias("Dest_Address")
	private String dest_Address;// 接收方地址

	@XStreamAlias("OrderID")
	private String orderID;// 订单编号

	@XStreamAlias("CheckID")
	private Integer checkID;// 开放平台订购，鉴权接口中的CheckID

	@XStreamAlias("TradeID")
	private String tradeID;// 外部交易ID

	@XStreamAlias("Price")
	private Integer price;// 业务资费(分)

	@XStreamAlias("ActionTime")
	private String actionTime;// 操作时间

	@XStreamAlias("ActionID")
	private Integer actionID;// 操作代码

	@XStreamAlias("MSISDN")
	private String MSISDN;// 目标用户手机号码

	@XStreamAlias("FeeMSISDN")
	private String feeMSISDN;// 计费手机号码

	@XStreamAlias("AppID")
	private String appID;// 应用ID

	@XStreamOmitField
	private String programID;// 应用程序包ID

	@XStreamAlias("PayCode")
	private String payCode;// 应用计费点编码

	@XStreamAlias("TotalPrice")
	private Integer totalPrice;// 订购总价(分)

	@XStreamAlias("SubsNumb")
	private Integer subsNumb;// 订购关系个数

	@XStreamAlias("SubsSeq")
	private Integer subsSeq;// 档次同步的序号

	@XStreamAlias("ChannelID")
	private String channelID;// 渠道ID

	@XStreamAlias("ExData")
	private String exData;// 应用自定义参数

	@XStreamAlias("OrderType")
	private Integer orderType; // 订单类型（默认为0）0：测试订单 1：正式订单

	@XStreamAlias("OrderPayment")
	private Integer orderPayment; // 订单支付方类型 1：移动 2：联通 3：电信 4：第三方支付：采用第三方支付方式

	@XStreamAlias("MD5Sign")
	private String md5Sign; // 32位大写MD5

	public String getXmlns() {
		return xmlns;
	}

	public void setXmlns(String xmlns) {
		this.xmlns = xmlns;
	}

	public String getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getSend_Address() {
		return send_Address;
	}

	public void setSend_Address(String send_Address) {
		this.send_Address = send_Address;
	}

	public String getDest_Address() {
		return dest_Address;
	}

	public void setDest_Address(String dest_Address) {
		this.dest_Address = dest_Address;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public Integer getCheckID() {
		return checkID;
	}

	public void setCheckID(Integer checkID) {
		this.checkID = checkID;
	}

	public String getTradeID() {
		return tradeID;
	}

	public void setTradeID(String tradeID) {
		this.tradeID = tradeID;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getActionTime() {
		return actionTime;
	}

	public void setActionTime(String actionTime) {
		this.actionTime = actionTime;
	}

	public Integer getActionID() {
		return actionID;
	}

	public void setActionID(Integer actionID) {
		this.actionID = actionID;
	}

	public String getMSISDN() {
		return MSISDN;
	}

	public void setMSISDN(String mSISDN) {
		MSISDN = mSISDN;
	}

	public String getFeeMSISDN() {
		return feeMSISDN;
	}

	public void setFeeMSISDN(String feeMSISDN) {
		this.feeMSISDN = feeMSISDN;
	}

	public String getAppID() {
		return appID;
	}

	public void setAppID(String appID) {
		this.appID = appID;
	}

	public String getProgramID() {
		return programID;
	}

	public void setProgramID(String programID) {
		this.programID = programID;
	}

	public String getPayCode() {
		return payCode;
	}

	public void setPayCode(String payCode) {
		this.payCode = payCode;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getSubsNumb() {
		return subsNumb;
	}

	public void setSubsNumb(Integer subsNumb) {
		this.subsNumb = subsNumb;
	}

	public Integer getSubsSeq() {
		return subsSeq;
	}

	public void setSubsSeq(Integer subsSeq) {
		this.subsSeq = subsSeq;
	}

	public String getChannelID() {
		return channelID;
	}

	public void setChannelID(String channelID) {
		this.channelID = channelID;
	}

	public String getExData() {
		return exData;
	}

	public void setExData(String exData) {
		this.exData = exData;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public Integer getOrderPayment() {
		return orderPayment;
	}

	public void setOrderPayment(Integer orderPayment) {
		this.orderPayment = orderPayment;
	}

	public String getMd5Sign() {
		return md5Sign;
	}

	public void setMd5Sign(String md5Sign) {
		this.md5Sign = md5Sign;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("OrderID:");
		sb.append(orderID);
		sb.append("\nActionTime:");
		sb.append(actionTime);
		sb.append("\nAppID:");
		sb.append(appID);
		sb.append("\nTradeID:");
		sb.append(tradeID);
		sb.append("\nPrice:");
		sb.append(price);
		sb.append("\nTotalPrice:");
		sb.append(totalPrice);
		sb.append("\nSubsNumb:");
		sb.append(subsNumb);
		sb.append("\nChannelID:");
		sb.append(channelID);
		sb.append("\nExData:");
		sb.append(exData);
		sb.append("\nOrderType:");
		sb.append(orderType);
		sb.append("\nMD5Sign:");
		sb.append(md5Sign);
		sb.append("\nOrderPayment:");
		sb.append(orderPayment);
		sb.append("\nMSISDN:");
		sb.append(MSISDN);
		return sb.toString();
	}

}
