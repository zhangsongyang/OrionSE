package cn.zsy.eg;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotEmpty;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class UTraceLogEntity implements Serializable {

  private static final long serialVersionUID = 7091487868197041161L;

  /**
   * 链路标识，使用UUID
   */
  @NotEmpty
  private String uTraceId;

  /**
   * 位置标识
   */
  @NotEmpty
  private String uSpanId = "0.1";

  /**
   * 日志埋点类型cs、cr
   */
  @NotEmpty
  private String step;

  /**
   * 业务编码
   */
  @NotEmpty
  private String bId;

  /**
   * 系统名称,APP
   */
  @NotEmpty
  private String sys = "APPSERVER";

  /**
   * 子服务名称
   */
  private String subSys = "";

  /**
   * unix时间戳
   */
  private long ts;

  /**
   * 配置安全类型:1-安全 2-非安全
   */
  private int ctype;

  /**
   * 模块安全类型: 0-非安全 1-安全 2-0.5安全
   */
  private int stype;

  /**
   * 配置协议：1代表smartlink 2代表softap
   */
  private int cfg;

  /**
   * 返回码 00000代表成功，其它代表失败。(CR、SS有值)
   */
  private String code = "";

  /**
   * 时间耗时，毫秒
   */
  private int span;

  /**
   * APPID
   */
  private String aId = "";

  /**
   * 网器mac
   */
  private String dId = "";

  /**
   * 用户id
   */
  private String uId = "";

  /**
   * 用户token
   */
  private String tk = "";

  /**
   * 接口名称或URL,URL中包含动态参数用{0}替换
   */
  @NotEmpty
  private String bName;

  /**
   * 请求技术方式(http)
   */
  @NotEmpty
  private String prot;

  /**
   * 请求Header(json)
   */
  private String rqHd = "";

  /**
   * 请求BODY(body)json方式
   */
  private String ipm = "";

  /**
   * 响应内容 json方式
   */
  private String rrt = "";

  /**
   * 异常信息
   */
  private String exp = "";

  /**
   * 非00000时，保存info信息
   */
  private String desc = "";

  /**
   * smartlink配置成功的方式(smartlink config mode)：1代表组播 2代表广播
   */
  private int scm;

  /**
   * 版本类型
   */
  private String ver = "";

  /**
   * 拓展属性
   */
  private Map<String, String> args;

  public UTraceLogEntity() {
    super();
  }

  public UTraceLogEntity(String uTraceId, String uSpanId, String step, String bId, String sys,
                         long ts, String bName, String prot) {
    super();
    this.uTraceId = uTraceId;
    this.uSpanId = uSpanId;
    this.step = step;
    this.bId = bId;
    this.sys = sys;
    this.ts = ts;
    this.bName = bName;
    this.prot = prot;
  }

  public UTraceLogEntity(String uTraceId, String uSpanId, String step, String bId, String sys, String subSys, long ts,
                         int ctype, int stype, int cfg, String code, int span, String aId, String dId, String uId,
                         String tk, String bName, String prot, String rqHd, String ipm, String rrt, String exp,
                         String desc, Integer scm, String ver, Map<String, String> args) {
    this.uTraceId = uTraceId;
    this.uSpanId = uSpanId;
    this.step = step;
    this.bId = bId;
    this.sys = sys;
    this.subSys = subSys;
    this.ts = ts;
    this.ctype = ctype;
    this.stype = stype;
    this.cfg = cfg;
    this.code = code;
    this.span = span;
    this.aId = aId;
    this.dId = dId;
    this.uId = uId;
    this.tk = tk;
    this.bName = bName;
    this.prot = prot;
    this.rqHd = rqHd;
    this.ipm = ipm;
    this.rrt = rrt;
    this.exp = exp;
    this.desc = desc;
    this.scm = scm;
    this.ver = ver;
    this.args = args;
  }

  public String getuTraceId() {
    return uTraceId;
  }

  public void setuTraceId(String uTraceId) {
    this.uTraceId = uTraceId;
  }

  public String getuSpanId() {
    return uSpanId;
  }

  public void setuSpanId(String uSpanId) {
    this.uSpanId = uSpanId;
  }

  public String getStep() {
    return step;
  }

  public void setStep(String step) {
    this.step = step;
  }

  public String getbId() {
    return bId;
  }

  public void setbId(String bId) {
    this.bId = bId;
  }

  public String getSys() {
    return sys;
  }

  public void setSys(String sys) {
    this.sys = sys;
  }

  public String getSubSys() {
    return subSys;
  }

  public void setSubSys(String subSys) {
    this.subSys = subSys;
  }

  public long getTs() {
    return ts;
  }

  public void setTs(long ts) {
    this.ts = ts;
  }

  public int getCtype() {
    return ctype;
  }

  public void setCtype(int ctype) {
    this.ctype = ctype;
  }

  public int getStype() {
    return stype;
  }

  public void setStype(int stype) {
    this.stype = stype;
  }

  public int getCfg() {
    return cfg;
  }

  public void setCfg(int cfg) {
    this.cfg = cfg;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public int getSpan() {
    return span;
  }

  public void setSpan(int span) {
    this.span = span;
  }

  public String getaId() {
    return aId;
  }

  public void setaId(String aId) {
    this.aId = aId;
  }

  public String getdId() {
    return dId;
  }

  public void setdId(String dId) {
    this.dId = dId;
  }

  public String getuId() {
    return uId;
  }

  public void setuId(String uId) {
    this.uId = uId;
  }

  public String getTk() {
    return tk;
  }

  public void setTk(String tk) {
    this.tk = tk;
  }

  public String getbName() {
    return bName;
  }

  public void setbName(String bName) {
    this.bName = bName;
  }

  public String getProt() {
    return prot;
  }

  public void setProt(String prot) {
    this.prot = prot;
  }

  public String getRqHd() {
    return rqHd;
  }

  public void setRqHd(String rqHd) {
    this.rqHd = rqHd;
  }

  public String getIpm() {
    return ipm;
  }

  public void setIpm(String ipm) {
    this.ipm = ipm;
  }

  public String getRrt() {
    return rrt;
  }

  public void setRrt(String rrt) {
    this.rrt = rrt;
  }

  public String getExp() {
    return exp;
  }

  public void setExp(String exp) {
    this.exp = exp;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public int getScm() {
    return scm;
  }

  public void setScm(int scm) {
    this.scm = scm;
  }

  public String getVer() {
    return ver;
  }

  public void setVer(String ver) {
    this.ver = ver;
  }

  public Map<String, String> getArgs() {
    return args;
  }

  public void setArgs(Map<String, String> args) {
    this.args = args;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

  public UTraceLogEntity(HttpServletRequest request, String spanFix, String step, String retCode,
                         int usedTime, String url, String protocol, String requestBody, String responseBody, Map<String, String> args) {
    super();
    String uTraceId = request.getHeader("uTraceId");
    String uSpanId = request.getHeader("uSpanId");
    String appId = request.getHeader("appId");
    String accessToken = request.getHeader("accessToken");
    String userId = (String) request.getAttribute("uagUserId");
    String appVersion = request.getHeader("appVersion");

    this.uTraceId = StringUtils.replace(uTraceId, "-", "");
    this.uSpanId = uSpanId != null ? uSpanId.concat(spanFix) : "";
    this.step = step;
    this.bId = "bind";
    this.sys = "APPSERVER";
    this.subSys = "emuplus";
    this.ts = System.currentTimeMillis();
    this.ctype  = 1;
    this.stype = 1;
    this.cfg = 1;
    this.code = retCode;
    this.span = usedTime;
    this.aId = appId;
    this.dId = "";
    this.uId = userId;
    this.tk = accessToken;
    this.bName = url;
    this.prot = protocol;
    this.rqHd = "";
    this.ipm = requestBody;
    this.rrt = responseBody;
    this.exp = "";
    this.desc = "";
    this.ver = appVersion;
    this.args = args;
  }



  public static void addList(List<UTraceLogEntity> list, UTraceLogEntity traceLogBean) {
    if (null == traceLogBean || StringUtils.isEmpty(traceLogBean.getuTraceId())) {
      return;
    }
    list.add(traceLogBean);
  }

}
