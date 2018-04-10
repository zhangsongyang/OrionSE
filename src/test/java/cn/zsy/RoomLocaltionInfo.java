package cn.zsy;

import java.io.Serializable;

public class RoomLocaltionInfo implements Serializable {

  private static final long serialVersionUID = 8180451824824577915L;

  /**
   * 用户ID
   */
  private String userId;

  /**
   * 设备ID
   */
  private String deviceId;

  /**
   * 设备房间位置信息
   */
  private String room;

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getDeviceId() {
    return deviceId;
  }

  public void setDeviceId(String deviceId) {
    this.deviceId = deviceId;
  }

  public String getRoom() {
    return room;
  }

  public void setRoom(String room) {
    this.room = room;
  }

  @Override
  public String toString() {
    return "RoomLocaltionInfo{" +
        "userId='" + userId + '\'' +
        ", deviceId='" + deviceId + '\'' +
        ", room='" + room + '\'' +
        '}';
  }
}
