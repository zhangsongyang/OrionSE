package cn.zsy;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cn.zsy.util.Config;
import cn.zsy.util.HttpUtil;
import cn.zsy.util.MD5;
import cn.zsy.util.MessageSender;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageSenderTest {


	private static Logger logger = LoggerFactory.getLogger(MessageSenderTest.class);

	//酷我招募：150人
	private String content1 = "！凭借你的颜值和勤奋，你已成功获得海尔智爱星人奇妙夜奇葩轰趴的参加资格，请妥善保管好此短信。8月2日晚6点，请持此短信亲临活动现场，不玩不生活，一起high起来~";
	private String content2 = "您好！由于现场可容纳人数有限，我们只能接纳按时间顺序报名前150名的智爱星人亲临现场。在此非常遗憾地通知您，您来晚啦。非常感谢您的热心参与！也可留意海尔不玩不生活的其他主题轰趴，下次早点约起来~";

	//奔跑招募：30人
	private String content3 = "您好！由于现场可容纳人数有限，很遗憾您未被抽中亲临现场。非常感谢您的热心参与！也可留意海尔不玩不生活的其他主题轰趴，下次约起来~";
	private String content4 = "嘿！凭借你的颜值和幸运，你已成功获得海尔智爱星人奇妙夜奇葩轰趴的参加资格，请妥善保管好此短信。8月2日晚19:00北京星光现场，请身着最酷的奇葩服饰持此短信亲临活动现场，不玩不生活，一起high起来~";

	//海尔粉丝：30人
	private String content5 = "嘿！小伙伴儿，凭借与海尔多年的友谊，你已成功获得海尔智爱星人奇妙夜奇葩轰趴的参加资格，请妥善保管好此短信。8月2日晚19:00北京星光现场，请身着最酷的奇葩服饰持此短信亲临活动现场，不玩不生活，一起high起来~";

	//北京中心：100人
	private String content6 = "嘿！你已成功获得海尔智爱星人奇妙夜奇葩轰趴的参加资格，请妥善保管好此短信。8月2日晚19:00北京星光现场，请身着最酷的奇葩服饰持此短信亲临活动现场，不玩不生活，一起high起来~";

	@Test
	public void sendmess(){
//		sendPhoneMsg("18510164795", "收到没");
//		sendPhoneMsg("13810774027", "收到没");
		MessageSender.sendPhoneMsg("15109218909", "收到没");
	}

	//酷我招募succ
	@Test
	public void sendKUWOZHAOMUSucc() throws IOException{
		File file = new File("E:\\Users\\zhangsongyang\\github\\OrionSE\\src\\main\\resources\\user_act_bak.txt");
		List<String> line = FileUtils.readLines(file);
		for(String str : line){
			String[] split = StringUtils.split(str, "\t");
			for (int i = 0; i < split.length-1; i++){
				MessageSender.sendPhoneMsg(split[i + 1], "你好" + split[i] + content1);
			}
		}
	}

	//酷我招募fail
	@Test
	public void sendKUWOZHAOMUFail() throws IOException{
		File file = new File("E:\\Users\\zhangsongyang\\github\\OrionSE\\src\\main\\resources\\user_act_bak.txt");
		List<String> line = FileUtils.readLines(file);
		for(String str : line){
			String[] split = StringUtils.split(str, "\t");
			for (int i = 0; i < split.length-1; i++){
				MessageSender.sendPhoneMsg(split[i + 1], "你好" + split[i] + content1);
			}
		}
	}

	//奔跑招募succ
	@Test
	public void sendBenPaoSucc() throws IOException{
		File file = new File("E:\\Users\\zhangsongyang\\github\\OrionSE\\src\\main\\resources\\user_act_bak.txt");
		List<String> line = FileUtils.readLines(file);
		for(String str : line){
			String[] split = StringUtils.split(str, "\t");
			for (int i = 0; i < split.length-1; i++){
				MessageSender.sendPhoneMsg(split[i + 1], "你好" + split[i] + content1);
			}
		}
	}

	//奔跑招募fail
	@Test
	public void sendBenPaoFail() throws IOException{
		File file = new File("E:\\Users\\zhangsongyang\\github\\OrionSE\\src\\main\\resources\\user_act_bak.txt");
		List<String> line = FileUtils.readLines(file);
		for(String str : line){
			String[] split = StringUtils.split(str, "\t");
			for (int i = 0; i < split.length-1; i++){
				MessageSender.sendPhoneMsg(split[i + 1], "你好" + split[i] + content1);
			}
		}
	}

	////海尔粉丝
	@Test
	public void sendHaier() throws IOException{
		File file = new File("E:\\Users\\zhangsongyang\\github\\OrionSE\\src\\main\\resources\\user_act_bak.txt");
		List<String> line = FileUtils.readLines(file);
		for(String str : line){
			String[] split = StringUtils.split(str, "\t");
			for (int i = 0; i < split.length-1; i++){
				MessageSender.sendPhoneMsg(split[i + 1], "你好" + split[i] + content1);
			}
		}
	}

	//北京中心
	@Test
	public void sendBeijingzhongxin() throws IOException{
		File file = new File("E:\\Users\\zhangsongyang\\github\\OrionSE\\src\\main\\resources\\user_act_bak.txt");
		List<String> line = FileUtils.readLines(file);
		for(String str : line){
			String[] split = StringUtils.split(str, "\t");
			for (int i = 0; i < split.length-1; i++){
				MessageSender.sendPhoneMsg(split[i + 1], "你好" + split[i] + content1);
			}
		}
	}

}
