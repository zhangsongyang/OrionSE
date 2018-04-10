package cn.zsy.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

public class RegisterProduct implements Serializable {

  private static final long serialVersionUID = -581604076017008263L;

  // 会员ID
  private Long userId;

  // 品牌
  private String brandName;

  // 注册时间
  private String regTime;

  // 20位成品编码
  private String skuCode;

  // 产品名称
  private String productName;

  // 购买日期
  private String buyTime;

  // 购买价格
  private Double buyPrice;

  // 省id
  private Integer provinceId;

  // 省
  private String province;

  // 市id
  private Integer cityId;

  // 市
  private String city;

  // 区id
  private Integer districtId;

  // 区
  private String district;

  // 详细地址
  private String address;

  // 购买渠道id
  private Integer channelId;

  // 购买渠道名称
  private String channelName;

  // 推荐人会员ID
  private Long referee;

  // 注册来源
  private Integer sourceId;

  // 购买人电话
  private String mobile;

  // Mac地址
  private String mac;

  // 产品大类
  private String bigClass;

  // 产品小类
  private String smallClass;

  // 物料编码
  private String materialCode;

  public RegisterProduct() {
    super();
  }

  public RegisterProduct(Long userId, String brandName, String regTime, String skuCode,
                         String productName, String buyTime, Double buyPrice, Integer provinceId, String province,
                         Integer cityId, String city, Integer districtId, String district, String address,
                         Integer channelId, String channelName, Long referee, Integer sourceId, String mobile,
                         String mac, String bigClass, String smallClass, String materialCode) {
    super();
    this.userId = userId;
    this.brandName = brandName;
    this.regTime = regTime;
    this.skuCode = skuCode;
    this.productName = productName;
    this.buyTime = buyTime;
    this.buyPrice = buyPrice;
    this.provinceId = provinceId;
    this.province = province;
    this.cityId = cityId;
    this.city = city;
    this.districtId = districtId;
    this.district = district;
    this.address = address;
    this.channelId = channelId;
    this.channelName = channelName;
    this.referee = referee;
    this.sourceId = sourceId;
    this.mobile = mobile;
    this.mac = mac;
    this.bigClass = bigClass;
    this.smallClass = smallClass;
    this.materialCode = materialCode;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getBrandName() {
    return brandName;
  }

  public void setBrandName(String brandName) {
    this.brandName = brandName;
  }

  public String getRegTime() {
    return regTime;
  }

  public void setRegTime(String regTime) {
    this.regTime = regTime;
  }

  public String getSkuCode() {
    return skuCode;
  }

  public void setSkuCode(String skuCode) {
    this.skuCode = skuCode;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getBuyTime() {
    return buyTime;
  }

  public void setBuyTime(String buyTime) {
    this.buyTime = buyTime;
  }

  public Double getBuyPrice() {
    return buyPrice;
  }

  public void setBuyPrice(Double buyPrice) {
    this.buyPrice = buyPrice;
  }

  public Integer getProvinceId() {
    return provinceId;
  }

  public void setProvinceId(Integer provinceId) {
    this.provinceId = provinceId;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public Integer getCityId() {
    return cityId;
  }

  public void setCityId(Integer cityId) {
    this.cityId = cityId;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public Integer getDistrictId() {
    return districtId;
  }

  public void setDistrictId(Integer districtId) {
    this.districtId = districtId;
  }

  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Integer getChannelId() {
    return channelId;
  }

  public void setChannelId(Integer channelId) {
    this.channelId = channelId;
  }

  public String getChannelName() {
    return channelName;
  }

  public void setChannelName(String channelName) {
    this.channelName = channelName;
  }

  public Long getReferee() {
    return referee;
  }

  public void setReferee(Long referee) {
    this.referee = referee;
  }

  public Integer getSourceId() {
    return sourceId;
  }

  public void setSourceId(Integer sourceId) {
    this.sourceId = sourceId;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getMac() {
    return mac;
  }

  public void setMac(String mac) {
    this.mac = mac;
  }

  public String getBigClass() {
    return bigClass;
  }

  public void setBigClass(String bigClass) {
    this.bigClass = bigClass;
  }

  public String getSmallClass() {
    return smallClass;
  }

  public void setSmallClass(String smallClass) {
    this.smallClass = smallClass;
  }

  public String getMaterialCode() {
    return materialCode;
  }

  public void setMaterialCode(String materialCode) {
    this.materialCode = materialCode;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }
}
