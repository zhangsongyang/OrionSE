package cn.zsy.util;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageSender {

	 /*
	 # 发送短信相关配置
	"MSG_CPID" : "010001000228",
	"MSG_MID" : "0",
	"MSG_PORT" : "170898",
	"MSG_GATEWAY":"http://api.10690909.com/newmt",
	"REDIS_SERVER":"192.168.210.76:6379"
	*/
	private static Logger logger = LoggerFactory.getLogger(MessageSender.class);

	/**
	 * 新版发送短信接口
	 * @param phonenum
	 * @param msg
	 * @return
	 */
	public static String sendPhoneMsg(String phonenum,String msg){

		if(StringUtils.isEmpty(phonenum) || StringUtils.isEmpty(msg)) {
			return "param error";
		}
		String result = "";
		String content = "";
		long startTime = System.currentTimeMillis();
		try {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
			String t = sdf.format(date);
			MD5 md5 = new MD5();

			String passwrord =  md5.getMD5ofStr("720d44817e9a9b848fc48e423e368cc5"+t, "UTF-8");
			msg = msg+"【XX】";
			//生成XML
			Document document = DocumentHelper.createDocument();
			Element root = document.addElement("MtPacket");
			root.addElement("cpid").setText(Config.MSG_CPID);
			root.addElement("mid").setText(Config.MSG_MID);
			root.addElement("cpmid").setText(date.getTime()+"");
			root.addElement("mobile").setText(phonenum);
			root.addElement("port").setText(Config.MSG_PORT);
			root.addElement("msg").setText(msg);
			root.addElement("msgtype").setText("1");
			root.addElement("signature").setText(passwrord);
			root.addElement("timestamp").setText(t);
			root.addElement("validtime").setText("0");
			//发送post请求
			content =  document.asXML();
			String ret = HttpUtil.getHttpUrlContent(Config.MSG_GATEWAY, "UTF-8", true, content, 8000);
			//解析返回的XML
			Document doc = null;
			doc = DocumentHelper.parseText(ret);
			result = doc.getRootElement().element("result").getText();
		} catch (Exception e) {
			logger.error(e.toString(), e);
			result = "server error";
		} finally {
			logger.info(String.format("sendmsg\t%s\t%s\t%s\t%s", Config.MSG_GATEWAY, result, (System.currentTimeMillis() - startTime), content));
		}
		return result;
	}


}
